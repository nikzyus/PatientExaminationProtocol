package com.example.notes.patientexaminationprotocol.database

import com.example.notes.patientexaminationprotocol.database.models.Doctor
import com.example.notes.patientexaminationprotocol.utils.*
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class FirebaseRepository : DatabaseRepository {

    init {
        AUTH = FirebaseAuth.getInstance()
    }

    override suspend fun insertDoctor(doctor: Doctor, onSuccess: () -> Unit) {
        val mapDoctor = hashMapOf<String, Any>()
        mapDoctor["ID"] = doctor.id
        mapDoctor["NAME"] = doctor.name
        mapDoctor["LASTNAME"] = doctor.lastName
        mapDoctor["PATRON"] = doctor.patronymic
        mapDoctor["DATE_BEGIN"] = doctor.dateBegin
        mapDoctor["DATE_END"] = doctor.dateEnd
        mapDoctor["JOB_TITLE"] = doctor.jobTitle

        REF_DATABASE.child(CURRENT_USER_UID).child(DOCTOR_NODE).updateChildren(mapDoctor)
            .addOnSuccessListener { onSuccess() }
            .addOnFailureListener { showToast(it.message.toString()) }
    }


    /*вход в аккаунт*/
    override fun signInDataBase(onSuccess: () -> Unit) {
        AUTH.signInWithEmailAndPassword(EMAIL, PASSWORD)
            .addOnSuccessListener {
                CURRENT_USER_UID = AUTH.currentUser?.uid.toString()
                onSuccess()
            }
            .addOnFailureListener { showToast("Не удается авторизоваться, обратитесь к администратору") }
    }

    /*выход из аккаунта*/
    override fun signOut() {
        AUTH.signOut()
    }
}