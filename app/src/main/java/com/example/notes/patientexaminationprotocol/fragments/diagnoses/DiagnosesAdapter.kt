package com.example.notes.patientexaminationprotocol.fragments.diagnoses

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.notes.patientexaminationprotocol.R
import com.example.notes.patientexaminationprotocol.database.models.Diagnoses

class DiagnosesAdapter : RecyclerView.Adapter<DiagnosesAdapter.DiagnosesHolder>() {

    private var mListDiagnoses = emptyList<Diagnoses>()

    class DiagnosesHolder(view: View):RecyclerView.ViewHolder(view){
        val nameDiagnoses: TextView = view.findViewById(R.id.diagnosesName)
        val idDiagnoses:TextView = view.findViewById(R.id.diagnosesNumber)
        val symptomsDiagnoses:TextView = view.findViewById(R.id.diagnosesListSymptoms)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiagnosesHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.diagnoses_item,parent,false)
        return DiagnosesHolder(view)
    }

    override fun onBindViewHolder(holder: DiagnosesHolder, position: Int) {
        holder.nameDiagnoses.text = mListDiagnoses[position].name
        holder.idDiagnoses.text = "Номер диагноза " + mListDiagnoses[position].id.toString()
        holder.symptomsDiagnoses.text = "Перечень симптомов"
    }

    override fun getItemCount(): Int = mListDiagnoses.size

    fun setList(list: List<Diagnoses>){
        mListDiagnoses = list
        notifyDataSetChanged()
    }
}