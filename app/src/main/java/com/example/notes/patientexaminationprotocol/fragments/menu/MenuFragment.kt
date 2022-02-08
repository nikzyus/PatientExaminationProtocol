package com.example.notes.patientexaminationprotocol.fragments.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.notes.patientexaminationprotocol.R
import com.example.notes.patientexaminationprotocol.databinding.FragmentMenuBinding

/* Фрагмент главного меню */

class MenuFragment : Fragment() {

    private lateinit var menuViewModel: MenuViewModel
    private lateinit var binding: FragmentMenuBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_menu, container, false)
        menuViewModel = ViewModelProvider(this)[MenuViewModel::class.java]
        binding.menuVM = menuViewModel
        menuViewModel.context = requireContext()
        return binding.root
    }

}