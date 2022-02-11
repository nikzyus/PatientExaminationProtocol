package com.example.notes.patientexaminationprotocol.fragments.symptoms

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.notes.patientexaminationprotocol.R
import com.example.notes.patientexaminationprotocol.database.models.Diagnoses
import com.example.notes.patientexaminationprotocol.database.models.Symptom
import com.example.notes.patientexaminationprotocol.databinding.FragmentDiagnosesBinding
import com.example.notes.patientexaminationprotocol.databinding.FragmentSymptomsBinding
import com.example.notes.patientexaminationprotocol.fragments.diagnoses.DiagnosesAdapter
import com.example.notes.patientexaminationprotocol.fragments.diagnoses.DiagnosesViewModel
import com.example.notes.patientexaminationprotocol.utils.DIAGNOSES_NODE
import com.example.notes.patientexaminationprotocol.utils.REF_DATABASE
import com.example.notes.patientexaminationprotocol.utils.SYMPTOMS_NODE
import com.example.notes.patientexaminationprotocol.utils.showToast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener


class SymptomsFragment : Fragment() {

    private lateinit var symptomsViewModel: SymptomsViewModel
    private lateinit var binding: FragmentSymptomsBinding
    private val reference = REF_DATABASE.child(SYMPTOMS_NODE)

    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mAdapter: SymptomAdapter

    val symptomList = arrayListOf<Symptom>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_symptoms, container, false)
        symptomsViewModel = ViewModelProvider(this)[SymptomsViewModel::class.java]
        binding.symptomsVM = symptomsViewModel
        symptomsViewModel.context = requireContext()
        reference.addValueEventListener(symptomListener)
        return binding.root
    }


    /* слушатель для списка симптомов */
    val symptomListener = object : ValueEventListener {

        override fun onDataChange(snapshot: DataSnapshot) {
            symptomList.clear()
            for(snp in snapshot.children){
                val symptom = Symptom(
                    id = snp.child("ID").value.toString().toInt(),
                    name = snp.child("NAME").value.toString()
                )
                symptomList.add(symptom)
            }
            initialization()
        }

        override fun onCancelled(error: DatabaseError) {
            showToast(error.message)
        }

    }

    /*инициализация adapter and recycler*/
    private fun initialization(){
        mAdapter = SymptomAdapter()
        mRecyclerView = binding.recyclerSymptoms
        mRecyclerView.adapter = mAdapter
        mAdapter.setList(symptomList)
    }

    override fun onDestroy() {
        super.onDestroy()
        reference.removeEventListener(symptomListener)
    }
}