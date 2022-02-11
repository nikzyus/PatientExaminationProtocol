package com.example.notes.patientexaminationprotocol.database

import androidx.lifecycle.LiveData
import com.example.notes.patientexaminationprotocol.database.models.Doctor
import com.google.android.gms.tasks.Task
import com.google.firebase.database.DataSnapshot

interface DatabaseRepository {

    suspend fun insertDoctor(doctor: Doctor, onSuccess: () -> Unit)
    //suspend fun getCurrentDoctor()

    /* авторизация*/
    fun signInDataBase(onSuccess:()->Unit){}

    /* выход*/
    fun signOut(){}

}