package com.example.notes.patientexaminationprotocol.fragments.personal

import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.notes.patientexaminationprotocol.R
import com.example.notes.patientexaminationprotocol.database.models.Doctor
import com.example.notes.patientexaminationprotocol.databinding.FragmentPersonalInfoBinding
import com.example.notes.patientexaminationprotocol.fragments.menu.MenuViewModel
import com.example.notes.patientexaminationprotocol.utils.CURRENT_USER_UID
import com.example.notes.patientexaminationprotocol.utils.DOCTOR_NODE
import com.example.notes.patientexaminationprotocol.utils.REF_DATABASE
import com.example.notes.patientexaminationprotocol.utils.showToast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.getValue
import kotlin.math.log


class PersonalInfoFragment : Fragment() {

    private lateinit var personalInfoViewModel: PersonalInfoViewModel
    private lateinit var binding: FragmentPersonalInfoBinding
    private val reference = REF_DATABASE.child(CURRENT_USER_UID).child(DOCTOR_NODE)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_personal_info, container, false)
        personalInfoViewModel = ViewModelProvider(this)[PersonalInfoViewModel::class.java]
        binding.personalVM = personalInfoViewModel
        personalInfoViewModel.context = requireContext()
        personalInfoViewModel.binding = binding
        //data listener
        reference.addValueEventListener(personalInfoViewModel.docListener)
        return binding.root
    }



    override fun onDestroy() {
        super.onDestroy()
        reference.removeEventListener(personalInfoViewModel.docListener)
    }


}