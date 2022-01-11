package com.example.android.navigation

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.android.navigation.databinding.FragmentTitleBinding
import com.example.android.navigation.databinding.FragmentTitleBindingLandImpl
import com.example.android.navigation.databinding.InfoBinding
import com.example.android.navigation.databinding.InfoBindingLandImpl
import com.google.gson.Gson
import okhttp3.*
import pt.ua.nextweather.datamodel.CallResponse
import java.io.IOException

class InfoFragment : Fragment()  {
    private val client = OkHttpClient()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<InfoBinding>(inflater, R.layout.info, container, false)

//        if(getResources().getConfiguration().orientation==Configuration .ORIENTATION_LANDSCAPE)
//            binding=DataBindingUtil.inflate<FragmentTitleBindingLandImpl>(inflater, R.layout.fragment_title, container, false)
//            DataBindingUtil.setContentView<FragmentTitleBindingLandImpl>(this, R.layout.fragment_title)

        val act = activity as MainActivity
        binding.lista.adapter = act.adapter



        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.
        onNavDestinationSelected(item,requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

    fun callApi(city: String): List<CallResponse.Weather>{
        val request = Request.Builder()
            .url("https://api.ipma.pt/open-data/forecast/meteorology/cities/daily/"+city+".json")
            .build()

        var ret= listOf<CallResponse.Weather>()

        var response= client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {}

            override fun onResponse(call: Call, response: Response){

//                println(response.body()?.string())
                var gson= Gson()
                var mCAll=gson?.fromJson(
                    response.body()?.string(),
                    CallResponse.City::class.java
                )

                ret=mCAll.data.toList()
            }

        })
        Thread.sleep(2000)
        Log.println(Log.DEBUG, String(), ret.toString())
        return ret
    }

//    override fun onConfigurationChanged(newConfig: Configuration) {
//        super.onConfigurationChanged(newConfig)
//        val act= activity as MainActivity
//        // Checks the orientation of the screen
//        if (newConfig.orientation === Configuration.ORIENTATION_LANDSCAPE ) {
//            val binding = DataBindingUtil.setContentView<InfoBindingLandImpl>(act, R.layout.info)
//        } else if (newConfig.orientation === Configuration.ORIENTATION_PORTRAIT) {
//            val binding = DataBindingUtil.setContentView<InfoBindingLandImpl>(act, R.layout.info)
//        }
//    }
}