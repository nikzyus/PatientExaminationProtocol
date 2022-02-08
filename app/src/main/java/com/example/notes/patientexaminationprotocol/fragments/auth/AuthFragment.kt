package com.example.notes.patientexaminationprotocol.fragments.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.notes.patientexaminationprotocol.R
import com.example.notes.patientexaminationprotocol.databinding.FragmentAuthBinding

/*Фрагмент авторизации*/

class AuthFragment : Fragment() {

    private lateinit var authViewModel: AuthViewModel
    private lateinit var binding: FragmentAuthBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_auth, container, false)
        authViewModel = ViewModelProvider(this)[AuthViewModel::class.java]
        binding.authVM = authViewModel
        authViewModel.context = requireContext()
        authViewModel.binding = binding
        return binding.root
    }


}