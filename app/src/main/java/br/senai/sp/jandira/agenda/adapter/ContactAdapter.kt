package br.senai.sp.jandira.agenda.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import br.senai.sp.jandira.agenda.R
import br.senai.sp.jandira.agenda.model.Contact
import br.senai.sp.jandira.agenda.ui.NewContactActivity

class ContactAdapter(var contactList: List<Contact>, var context: Context): RecyclerView.Adapter<ContactAdapter.ContactHolder>() {

    fun updateContactList(newContactList: List<Contact>){
        this.contactList = newContactList;
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_layout, parent, false);
        return ContactHolder(view);
    }

    override fun onBindViewHolder(holder: ContactHolder, position: Int) {
        val contact = contactList[position]

        holder.textName.text = contact.nome;
        holder.textPhone.text = contact.telefone;
        holder.textEmail.text = contact.email;
        holder.textImage.text = contact.nome.substring(0, 1);

        holder.cardView.setOnClickListener{
            val intent = Intent(context, NewContactActivity::class.java)
            intent.putExtra("id", contact.id)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return contactList.size;
    }


    class ContactHolder(view: View): RecyclerView.ViewHolder(view){
        val textName = view.findViewById<TextView>(R.id.text_Name);
        val textPhone = view.findViewById<TextView>(R.id.text_telephone);
        val textEmail = view.findViewById<TextView>(R.id.text_email);
        val textImage = view.findViewById<TextView>(R.id.firstLetter);
        val cardView = view.findViewById<CardView>(R.id.cardViewContact);
    }
}