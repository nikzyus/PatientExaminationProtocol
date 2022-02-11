package com.example.notes.patientexaminationprotocol.fragments.symptoms

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.notes.patientexaminationprotocol.R
import com.example.notes.patientexaminationprotocol.database.models.Symptom

class SymptomAdapter:RecyclerView.Adapter<SymptomAdapter.SymptomHolder>() {

    private var mListSymptoms = emptyList<Symptom>()

    class SymptomHolder(view: View):RecyclerView.ViewHolder(view){
        val nameSymptom: TextView = view.findViewById(R.id.diagnosesName)
        val idSymptom: TextView = view.findViewById(R.id.diagnosesNumber)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SymptomHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.diagnoses_item,parent,false)
        return SymptomHolder(view)
    }

    override fun onBindViewHolder(holder: SymptomHolder, position: Int) {
        holder.idSymptom.text = "Номер симптома "+mListSymptoms[position].id.toString()
        holder.nameSymptom.text = mListSymptoms[position].name
    }

    override fun getItemCount(): Int = mListSymptoms.size

    fun setList(list: List<Symptom>){
        mListSymptoms = list
        notifyDataSetChanged()
    }

}