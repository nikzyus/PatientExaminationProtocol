package com.example.notes.patientexaminationprotocol.database

interface DatabaseRepository {

    fun signInDataBase(onSuccess:()->Unit){}

    fun signOut(){}

}