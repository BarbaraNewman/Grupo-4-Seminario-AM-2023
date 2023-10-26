package com.example.prueba

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import android.widget.Toast
import android.content.Context


class PersonajeHolder(var personajes: MutableList<Personaje>, var context: Context) : RecyclerView.Adapter<PersonajeHolder.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)

        return ViewHolder(view)
    }

    /*override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val PersonajeHolder = mList[position]

        Glide.with(holder.itemView)
            .load(PersonajeHolder.image)
            .into(holder.imageView)

        holder.textView.text = PersonajeHolder.name

    }*/

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = personajes.get(position)
        holder.textView.text = item.name

        Glide.with(holder.itemView)
            .load(item.image)
            .into(holder.imageView)

        holder.itemView.setOnClickListener( View.OnClickListener {
            Toast.makeText(context, item.name, Toast.LENGTH_SHORT).show()
        })
    }


    override fun getItemCount(): Int {
        return personajes.size
    }

    class ViewHolder(PersonajeHolder: View) : RecyclerView.ViewHolder(PersonajeHolder) {
        val imageView: ImageView = itemView.findViewById(R.id.imageview)
        val textView: TextView = itemView.findViewById(R.id.textView)
    }
}