package com.example.prueba

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class PersonajeHolder(private val mList: List<Personaje>) : RecyclerView.Adapter<PersonajeHolder.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val PersonajeHolder = mList[position]

        Glide.with(holder.itemView)
            .load(PersonajeHolder.image)
            .into(holder.imageView)

        holder.textView.text = PersonajeHolder.name

    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(PersonajeHolder: View) : RecyclerView.ViewHolder(PersonajeHolder) {
        val imageView: ImageView = itemView.findViewById(R.id.imageview)
        val textView: TextView = itemView.findViewById(R.id.textView)
    }
}