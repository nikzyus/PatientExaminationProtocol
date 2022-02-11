package com.example.notes.patientexaminationprotocol.utils

import android.widget.Toast
import com.example.notes.patientexaminationprotocol.MainActivity
import com.example.notes.patientexaminationprotocol.database.FirebaseRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference

lateinit var APP_ACTIVITY:MainActivity
lateinit var REPOSITORY:FirebaseRepository

/*Firebase constants*/
lateinit var AUTH: FirebaseAuth
lateinit var CURRENT_USER_UID:String
lateinit var EMAIL:String
lateinit var PASSWORD:String
lateinit var REF_DATABASE: DatabaseReference

const val DOCTOR_NODE = "Doctor"
const val HOSPITAL_NODE = "HospitalInfo"
const val DIAGNOSES_NODE = "Diagnoses"
const val SYMPTOMS_NODE = "Symptoms"

fun showToast(message:String){
    Toast.makeText(APP_ACTIVITY,message, Toast.LENGTH_SHORT).show()
}