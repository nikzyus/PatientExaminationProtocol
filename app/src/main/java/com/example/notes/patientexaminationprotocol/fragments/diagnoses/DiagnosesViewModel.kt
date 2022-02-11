package com.example.notes.patientexaminationprotocol.fragments.diagnoses

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.notes.patientexaminationprotocol.database.models.Diagnoses
import com.example.notes.patientexaminationprotocol.utils.DIAGNOSES_NODE
import com.example.notes.patientexaminationprotocol.utils.showToast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class DiagnosesViewModel : ViewModel() {

    lateinit var context: Context

}