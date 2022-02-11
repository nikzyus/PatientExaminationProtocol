package com.example.notes.patientexaminationprotocol.fragments.hospital

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.notes.patientexaminationprotocol.databinding.FragmentHospitalInfoBinding
import com.example.notes.patientexaminationprotocol.utils.showToast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class HospitalInfoViewModel:ViewModel() {

    lateinit var context: Context
    lateinit var binding: FragmentHospitalInfoBinding

    val hospitalInfoListener = object : ValueEventListener{
        override fun onDataChange(snapshot: DataSnapshot) {
            binding.edInputHospitalName.setText(snapshot.child("HOSPITAL_NAME").value.toString())
            binding.edInputDepartmentName.setText(snapshot.child("DEPARTMENT_NAME").value.toString())
        }

        override fun onCancelled(error: DatabaseError) {
            showToast(error.message.toString())
        }

    }

}