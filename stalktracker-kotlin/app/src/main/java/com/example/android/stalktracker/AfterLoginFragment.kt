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

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.android.stalktracker.databinding.FragmentAfterloginBinding
import com.example.android.stalktracker.databinding.FragmentGameWonBinding
import com.example.android.stalktracker.databinding.FragmentLoginBinding
import com.google.firebase.auth.FirebaseAuth


class AfterLoginFragment : Fragment() {
    private lateinit var  auth: FirebaseAuth

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        auth=FirebaseAuth.getInstance()

        val binding: FragmentAfterloginBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_afterlogin, container, false)

        binding.textView3.setText(auth.currentUser?.email)


        return binding.root
    }
}
