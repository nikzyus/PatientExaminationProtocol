package com.example.notes.patientexaminationprotocol.fragments.auth

import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.notes.patientexaminationprotocol.R
import com.example.notes.patientexaminationprotocol.databinding.FragmentAuthBinding
import com.example.notes.patientexaminationprotocol.utils.*

class AuthViewModel : ViewModel(){

    lateinit var context:Context
    lateinit var binding: FragmentAuthBinding

    /* Вход в аккаунт*/
    fun LogIn(view: View){

        EMAIL = binding.edInputEmail.text.toString()
        PASSWORD = binding.edInputPassword.text.toString()

        if (checkEmailAndPassword(EMAIL, PASSWORD)){
        REPOSITORY.signInDataBase {
            APP_ACTIVITY.navController.navigate(R.id.action_authFragment_to_menuFragment) }
        }
    }


    /*проверка логина и пароля true - гуд, false - плохо*/
    fun checkEmailAndPassword(email:String, password:String):Boolean{
        return email.isNotEmpty() && password.isNotEmpty()
    }

}