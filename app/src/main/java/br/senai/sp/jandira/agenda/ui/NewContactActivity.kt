package br.senai.sp.jandira.agenda.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.senai.sp.jandira.agenda.R
import br.senai.sp.jandira.agenda.databinding.ActivityNewContactBinding
import br.senai.sp.jandira.agenda.model.Contact
import br.senai.sp.jandira.agenda.repository.ContactRepository
import java.time.LocalDate

class NewContactActivity : AppCompatActivity() {

    lateinit var binding: ActivityNewContactBinding;

    lateinit var contactRepository: ContactRepository;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNewContactBinding.inflate(layoutInflater);
        setContentView(binding.root);

        //ROOM começa a pensar na classe

        binding.ButtonNewContactSave.setOnClickListener {
            save()
        }
    }

    private fun save() {


        //Criar o objeto contato
        val contact = Contact();
        contact.dataNascimento = binding.textDataNasimento.text.toString();
        contact.email = binding.TextEmail.text.toString();
        contact.nome = binding.TextNome.text.toString();
        contact.telefone = binding.TextTelefone.text.toString();

        //Criar intância para o repositório
        contactRepository = ContactRepository(this);
        val id = contactRepository.save(contact);

        Toast.makeText(this, "ID: $id ", Toast.LENGTH_LONG).show()
    }
}