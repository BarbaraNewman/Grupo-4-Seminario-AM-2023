package com.example.prueba

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import android.widget.Toast
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.content.ContextCompat.startActivity


class PersonajeHolder(var personajes: MutableList<Personaje>, var context: Context) : RecyclerView.Adapter<PersonajeHolder.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = personajes.get(position)
        holder.textView.text = item.name
        //holder.txGenero.text = item.physicalDescription.gender
        //holder.txColorOjos.text = item.physicalDescription.eyeColor
        //holder.txColorPelo.text = item.physicalDescription.hairColor


        Glide.with(holder.itemView)
            .load(item.image)
            .into(holder.imageView)

        /*holder.itemView.setOnClickListener( View.OnClickListener {
            Toast.makeText(context, item.name, Toast.LENGTH_SHORT).show()
        })*/
        /*holder.itemView.setOnClickListener{
            val intentPersonaje = Intent(context, PersonajeActivity::class.java)
            context.startActivity(intentPersonaje)
        }*/
        holder.itemView.setOnClickListener {
            val intentPersonaje = Intent(context, PersonajeActivity::class.java)
            val position = holder.adapterPosition
            val personaje = personajes[position]
            intentPersonaje.putExtra("nombre", personaje.name)
            intentPersonaje.putExtra("imagen", personaje.image)
            intentPersonaje.putExtra("genero", personaje.physicalDescription.gender)
            intentPersonaje.putExtra("colorOjos", personaje.physicalDescription.eyeColor)
             intentPersonaje.putExtra("colorPelo", personaje.physicalDescription.hairColor)

            context.startActivity(intentPersonaje)
        }

    }


    override fun getItemCount(): Int {
        return personajes.size
    }

    class ViewHolder(PersonajeHolder: View) : RecyclerView.ViewHolder(PersonajeHolder) {
        val imageView: ImageView = itemView.findViewById(R.id.imageview)
        val textView: TextView = itemView.findViewById(R.id.textView)
        //val txGenero: TextView = itemView.findViewById(R.id.txtGenero)
        //val txColorOjos: TextView = itemView.findViewById(R.id.txtEyeColor)
        //val txColorPelo: TextView = itemView.findViewById(R.id.txtHairColor)

    }
}