package com.example.notes.patientexaminationprotocol.fragments.hospital

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.notes.patientexaminationprotocol.R
import com.example.notes.patientexaminationprotocol.databinding.FragmentHospitalInfoBinding
import com.example.notes.patientexaminationprotocol.databinding.FragmentPersonalInfoBinding
import com.example.notes.patientexaminationprotocol.fragments.personal.PersonalInfoViewModel
import com.example.notes.patientexaminationprotocol.utils.CURRENT_USER_UID
import com.example.notes.patientexaminationprotocol.utils.HOSPITAL_NODE
import com.example.notes.patientexaminationprotocol.utils.REF_DATABASE


class HospitalInfoFragment : Fragment() {

    private lateinit var hospitalInfoViewModel: HospitalInfoViewModel
    private lateinit var binding: FragmentHospitalInfoBinding
    private val reference = REF_DATABASE.child(CURRENT_USER_UID).child(HOSPITAL_NODE)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_hospital_info, container, false)
        hospitalInfoViewModel = ViewModelProvider(this)[HospitalInfoViewModel::class.java]
        binding.hospitalVM = hospitalInfoViewModel
        hospitalInfoViewModel.context = requireContext()
        hospitalInfoViewModel.binding = binding
        reference.addValueEventListener(hospitalInfoViewModel.hospitalInfoListener)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        reference.removeEventListener(hospitalInfoViewModel.hospitalInfoListener)
    }

}