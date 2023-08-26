package com.example.prueba

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class PersonajeHolder(private val mList: List<Personaje>) : RecyclerView.Adapter<PersonajeHolder.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val PersonajeHolder = mList[position]

        // sets the image to the imageview from our itemHolder class
        //holder.imageView.setImageResource(PersonajeHolder.imagen)
        Glide.with(holder.itemView)
            .load(PersonajeHolder.imagen)
           .into(holder.imageView)

        // sets the text to the textview from our itemHolder class
        holder.textView.text = PersonajeHolder.personaje

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(PersonajeHolder: View) : RecyclerView.ViewHolder(PersonajeHolder) {
        val imageView: ImageView = itemView.findViewById(R.id.imageview)
        val textView: TextView = itemView.findViewById(R.id.textView)
    }
}