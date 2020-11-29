package com.example.firstapp.ui.Contacts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.firstapp.R

class ContactAdapter : RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

   var array = mutableListOf<Contacts>()
   override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
      val view = LayoutInflater.from(parent.context).inflate(R.layout.item_contact, parent, false)
      return ContactViewHolder(view)
   }

   override fun getItemCount(): Int {
      return array.count()
   }

   override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
      val item = array[position]
      holder.bind(item)
   }

   fun addItems(item: MutableList<Contacts>) {
      array = item
      notifyDataSetChanged()
   }

   fun addItem(item: Contacts) {
      array.add(item)
      notifyItemInserted(array.lastIndex)
   }

   class ContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
      private val icon: ImageView = itemView.findViewById(R.id.icon)
      private val firstName: TextView = itemView.findViewById(R.id.firstName)
      private val lastName: TextView = itemView.findViewById(R.id.lastName)

      fun bind(item: Contacts) {
         Glide.with(icon.context)
            .load(item. image)
            .placeholder(R.drawable.ic_withoutcontact)
            .into(icon)

         firstName.text = item.firstName
         lastName.text = item.lastName
      }
   }
}

