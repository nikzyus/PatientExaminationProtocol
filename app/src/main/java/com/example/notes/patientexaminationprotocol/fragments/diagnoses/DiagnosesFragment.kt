package com.example.notes.patientexaminationprotocol.fragments.diagnoses

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.notes.patientexaminationprotocol.R
import com.example.notes.patientexaminationprotocol.database.models.Diagnoses
import com.example.notes.patientexaminationprotocol.databinding.FragmentDiagnosesBinding
import com.example.notes.patientexaminationprotocol.utils.DIAGNOSES_NODE
import com.example.notes.patientexaminationprotocol.utils.REF_DATABASE
import com.example.notes.patientexaminationprotocol.utils.showToast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener


class DiagnosesFragment : Fragment() {

    private lateinit var diagnosesViewModel: DiagnosesViewModel
    private lateinit var binding: FragmentDiagnosesBinding
    private val reference = REF_DATABASE.child(DIAGNOSES_NODE)

    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mAdapter: DiagnosesAdapter

    val diagnosesList = arrayListOf<Diagnoses>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_diagnoses, container, false)
        diagnosesViewModel = ViewModelProvider(this)[DiagnosesViewModel::class.java]
        binding.diagnosesVM = diagnosesViewModel
        diagnosesViewModel.context = requireContext()
        reference.addValueEventListener(diagnosesListener)
        return binding.root
    }

    /*слушатель для списка диагнозов*/
    val diagnosesListener = object : ValueEventListener {
        override fun onDataChange(snapshot: DataSnapshot) {
            diagnosesList.clear()
            for (snp in snapshot.children) {
                val diagnos = Diagnoses(
                    id = snp.child("ID").value.toString().toInt(),
                    name = snp.child("NAME").value.toString()
                )
                diagnosesList.add(diagnos)
            }
            initialization()
        }

        override fun onCancelled(error: DatabaseError) {
            showToast(error.message)
        }

    }

    /*инициализация Adapter and Recycler*/
    private fun initialization() {
        mAdapter = DiagnosesAdapter()
        mRecyclerView = binding.recyclerDiagnoses
        mRecyclerView.adapter = mAdapter
        mAdapter.setList(diagnosesList)
    }

    override fun onDestroy() {
        super.onDestroy()
        reference.removeEventListener(diagnosesListener)
    }

}