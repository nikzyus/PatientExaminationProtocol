package com.example.notes.patientexaminationprotocol.fragments.menu

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.notes.patientexaminationprotocol.R
import com.example.notes.patientexaminationprotocol.database.models.Doctor
import com.example.notes.patientexaminationprotocol.databinding.FragmentMenuBinding
import com.example.notes.patientexaminationprotocol.utils.CURRENT_USER_UID
import com.example.notes.patientexaminationprotocol.utils.REF_DATABASE
import com.example.notes.patientexaminationprotocol.utils.showToast
import com.google.android.material.navigation.NavigationView

/* Фрагмент главного меню */

class MenuFragment : Fragment() {

    private lateinit var menuViewModel: MenuViewModel
    private lateinit var binding: FragmentMenuBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_menu, container, false)
        menuViewModel = ViewModelProvider(this)[MenuViewModel::class.java]
        binding.menuVM = menuViewModel
        menuViewModel.context = requireContext()
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initMenuButtons()
        /*menuViewModel.insertDoc(Doctor(123,"Иван","Абрамов","Васильевич","10-01-2000","21-01-2021","Гастроентеролог"))
        { showToast("Успешно")}*/
    }



    /* инициализация кнопок меню*/
    private fun initMenuButtons(){
        /*Images*/
        binding.btnProtocols.findViewById<ImageView>(R.id.menu_button_image).setImageResource(R.drawable.ic_menu_protocols)
        binding.btnSymptoms.findViewById<ImageView>(R.id.menu_button_image).setImageResource(R.drawable.ic_menu_symptoms)
        binding.btnDiagnoses.findViewById<ImageView>(R.id.menu_button_image).setImageResource(R.drawable.ic_menu_diagnoses)
        binding.btnPersonalInfo.findViewById<ImageView>(R.id.menu_button_image).setImageResource(R.drawable.ic_menu_doctor)
        binding.btnHospitalInfo.findViewById<ImageView>(R.id.menu_button_image).setImageResource(R.drawable.ic_menu_hospital)

        binding.btnPatients.layoutParams.height = binding.btnSymptoms.layoutParams.width

        /*Text*/
        binding.btnProtocols.findViewById<TextView>(R.id.menu_button_text).text = "Протоколы"
        binding.btnDiagnoses.findViewById<TextView>(R.id.menu_button_text).text = "Диагнозы"
        binding.btnSymptoms.findViewById<TextView>(R.id.menu_button_text).text = "Симптомы"
        binding.btnPersonalInfo.findViewById<TextView>(R.id.menu_button_text).text = "Личная информация"
        binding.btnHospitalInfo.findViewById<TextView>(R.id.menu_button_text).text = "Больница и отделение"
    }

}