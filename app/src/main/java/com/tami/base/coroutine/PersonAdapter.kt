package com.tami.base.coroutine

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.tami.adapter.SingleAdapter

class PersonAdapter : SingleAdapter<PersonHolder, Person>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonHolder {
        val context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.person_row, parent, false)
        return PersonHolder(view)

    }

    override fun onBind(holder: PersonHolder, item: Person) {
        holder.nameText.text = item.name
        holder.ageText.text = item.age.toString()
    }

}


class PersonHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val nameText = itemView.findViewById<AppCompatTextView>(R.id.name)
    val ageText = itemView.findViewById<AppCompatTextView>(R.id.age)
}