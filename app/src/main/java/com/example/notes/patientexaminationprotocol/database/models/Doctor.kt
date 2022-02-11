package com.example.notes.patientexaminationprotocol.database.models

import java.io.Serializable


data class Doctor(
    val id:Int = 0,
    val name:String = "",
    val lastName:String = "",
    val patronymic:String = "",
    val dateBegin:String = "",
    val dateEnd:String = "",
    val jobTitle:String = ""
) : Serializable