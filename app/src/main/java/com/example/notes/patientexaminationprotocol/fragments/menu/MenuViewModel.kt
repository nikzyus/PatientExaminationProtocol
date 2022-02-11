package com.example.notes.patientexaminationprotocol.fragments.menu

import android.content.Context
import android.view.View
import androidx.lifecycle.ViewModel
import com.example.notes.patientexaminationprotocol.R
import com.example.notes.patientexaminationprotocol.utils.APP_ACTIVITY
import com.example.notes.patientexaminationprotocol.utils.showToast

class MenuViewModel: ViewModel() {

    lateinit var context: Context


    fun onClickPatients(view: View){
        showToast("patients")}

    fun onClickProtocols(view: View){showToast("protocols")}

    fun onClickDiagnoses(view: View){ APP_ACTIVITY.navController.navigate(R.id.action_menuFragment_to_diagnosesFragment)}

    fun onClickSymptoms(view: View){ APP_ACTIVITY.navController.navigate(R.id.action_menuFragment_to_symptomsFragment)}

    fun onClickPersonalInfo(view:View){ APP_ACTIVITY.navController.navigate(R.id.action_menuFragment_to_personalInfoFragment) }

    fun onClickHospitalInfo(view: View){ APP_ACTIVITY.navController.navigate(R.id.action_menuFragment_to_hospitalInfoFragment)}


    /*fun insertDoc(doctor: Doctor, onSuccess:()->Unit)=
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.insertDoctor(doctor){
                onSuccess()
            }
        }*/


}