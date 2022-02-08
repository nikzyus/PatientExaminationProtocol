package com.example.notes.patientexaminationprotocol.database

import com.example.notes.patientexaminationprotocol.utils.AUTH
import com.example.notes.patientexaminationprotocol.utils.EMAIL
import com.example.notes.patientexaminationprotocol.utils.PASSWORD
import com.example.notes.patientexaminationprotocol.utils.showToast
import com.google.firebase.auth.FirebaseAuth

class FirebaseRepository:DatabaseRepository {

    init {
        AUTH = FirebaseAuth.getInstance()
    }

    /*вход в аккаунт*/
    override fun signInDataBase(onSuccess: () -> Unit) {
       AUTH.signInWithEmailAndPassword(EMAIL, PASSWORD)
           .addOnSuccessListener {  onSuccess() }
           .addOnFailureListener { showToast("Не удается авторизоваться, обратитесь к администратору") }
    }

    /*выход из аккаунта*/
    override fun signOut() {
        AUTH.signOut()
    }
}