/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.stalktracker

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.content.Context
import android.content.IntentFilter
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.android.stalktracker.databinding.FragmentAfterloginBinding
import com.google.firebase.auth.FirebaseAuth

import android.content.Intent

import android.content.BroadcastReceiver

import android.location.LocationManager
import android.provider.Settings
import androidx.core.content.ContextCompat

import androidx.core.content.ContextCompat.getSystemService
import androidx.core.app.ActivityCompat.startActivityForResult

import androidx.core.content.ContextCompat.getSystemService








class AfterLoginFragment : Fragment() {
    private lateinit var auth: FirebaseAuth
    private var m_bluetoothAdapter: BluetoothAdapter? = null
    private lateinit var m_pairedDevices: Set<BluetoothDevice>
    private var m_devices: ArrayList<BluetoothDevice> = ArrayList()

    companion object {
        val EXTRA_ADDRESS: String = "Device_address"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        auth = FirebaseAuth.getInstance()

        val binding: FragmentAfterloginBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_afterlogin, container, false
        )

        val locationManager = context?.getSystemService(Context.LOCATION_SERVICE) as LocationManager?
        val isGpsEnabled = locationManager!!.isProviderEnabled(LocationManager.GPS_PROVIDER)
        if (!isGpsEnabled) {
            startActivityForResult(
                Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS),
                2
            )
        }

        m_bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        discoverDevices()

//        val locationManager = getSystemService(context.LOCATION_SERVICE) as LocationManager?
//        val isGpsEnabled = locationManager!!.isProviderEnabled(LocationManager.GPS_PROVIDER)
//        if (!isGpsEnabled) {
//            startActivityForResult(
//                Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS),
//                MY_REQUEST_CODE
//            )
//        }


        binding.textView3.setText(auth.currentUser?.email)

        binding.searchButton.setOnClickListener {
            Log.println(Log.DEBUG, String(), "Carregou")
            Log.println(Log.DEBUG, String(), "" + m_devices)

            if (!m_bluetoothAdapter!!.isEnabled) {
                val enableBT = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
                startActivityForResult(enableBT, 1)
            } else {
            discoverDevices()
//            search()
            }
        }

        setHasOptionsMenu(true)

        return binding.root
    }

    private fun search() {
        m_pairedDevices = m_bluetoothAdapter!!.bondedDevices
        val list: ArrayList<BluetoothDevice> = ArrayList()

        if (!m_pairedDevices.isEmpty()) {
            for (device: BluetoothDevice in m_pairedDevices) {
                list.add(device)
                Log.println(Log.DEBUG, String(), "" + device)
            }
        }


    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

    private val mReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            Log.println(Log.DEBUG, String(), "Carregou aqui")
            val action = intent.action
            if (BluetoothDevice.ACTION_FOUND == action) {
                Log.println(Log.DEBUG, String(), "Carregou aqui tbem")

                val device = intent
                    .getParcelableExtra<BluetoothDevice>(BluetoothDevice.EXTRA_DEVICE)
                if (device != null) {
                    m_devices.add(device)
                    Log.println(Log.DEBUG, String(), device.address)
                }
              }
        }
    }

    private fun discoverDevices(){
//        if (m_bluetoothAdapter!!.isDiscovering) {
//            // Bluetooth is already in mode discovery mode, we cancel to restart it again
//            m_bluetoothAdapter!!.cancelDiscovery()
//        }
        val filter = IntentFilter(BluetoothDevice.ACTION_FOUND)
        activity?.registerReceiver(mReceiver, filter)
        val bool = m_bluetoothAdapter?.startDiscovery()
        Log.i("", bool.toString())

    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if(requestCode == REQUEST_ENABLE_BLUETOOTH){
//
//        }
//    }
}
