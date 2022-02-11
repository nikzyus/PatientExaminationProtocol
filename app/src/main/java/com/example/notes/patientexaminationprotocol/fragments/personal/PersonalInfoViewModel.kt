package com.example.notes.patientexaminationprotocol.fragments.personal

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notes.patientexaminationprotocol.database.models.Doctor
import com.example.notes.patientexaminationprotocol.databinding.FragmentPersonalInfoBinding
import com.example.notes.patientexaminationprotocol.utils.CURRENT_USER_UID
import com.example.notes.patientexaminationprotocol.utils.DOCTOR_NODE
import com.example.notes.patientexaminationprotocol.utils.REF_DATABASE
import com.example.notes.patientexaminationprotocol.utils.showToast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.getValue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.math.log

class PersonalInfoViewModel : ViewModel() {

    lateinit var context: Context
    lateinit var binding: FragmentPersonalInfoBinding

    val docListener = object : ValueEventListener {

        override fun onDataChange(snapshot: DataSnapshot) {
            binding.edInputDocNumber.setText(snapshot.child("ID").value.toString())
            binding.edInputDocName.setText(snapshot.child("NAME").value.toString())
            binding.edInputDocLastName.setText(snapshot.child("LASTNAME").value.toString())
            binding.edInputDocPatronymic.setText(snapshot.child("PATRON").value.toString())
            binding.edInputDocBeginJob.setText(snapshot.child("DATE_BEGIN").value.toString())
            binding.edInputDocEndJob.setText(snapshot.child("DATE_END").value.toString())
            binding.edInputDocJobTitle.setText(snapshot.child("JOB_TITLE").value.toString())
            //Log.i("firebase", snapshot.child("PATRON").value.toString())
        }

        override fun onCancelled(error: DatabaseError) {
            showToast(error.message.toString())
        }
    }

}