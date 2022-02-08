package com.example.notes.patientexaminationprotocol.fragments

import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModel

class AuthViewModel : ViewModel(){

    lateinit var context:Context

    fun onClickb(view: View){
     Toast.makeText(context,"1212", Toast.LENGTH_SHORT).show()
    }

}