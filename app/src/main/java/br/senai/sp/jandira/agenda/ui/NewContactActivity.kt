package br.senai.sp.jandira.agenda.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import br.senai.sp.jandira.agenda.R
import br.senai.sp.jandira.agenda.databinding.ActivityNewContactBinding
import br.senai.sp.jandira.agenda.model.Contact
import br.senai.sp.jandira.agenda.repository.ContactRepository
import java.time.LocalDate

class NewContactActivity : AppCompatActivity() {

    lateinit var binding: ActivityNewContactBinding;

    lateinit var contactRepository: ContactRepository;

    lateinit var contact: Contact;

    private var id = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNewContactBinding.inflate(layoutInflater);
        setContentView(binding.root);

        //ROOM começa a pensar na classe

        binding.deleteButton.setOnClickListener {
            deletar();
        }



        id = intent.getIntExtra("id", 0);

        if (id > 0 ){
            binding.deleteButton.visibility = View.VISIBLE;
            binding.ButtonNewContactSave.text = "Atualizar";
            carregarContato();
            binding.ButtonNewContactSave.setOnClickListener {
                    atualizar()
                }
        } else if (id == 0) {
                binding.ButtonNewContactSave.setOnClickListener {
                    save()
                }
        }
    }

    private fun atualizar() {
        val contact = Contact();
        contact.dataNascimento = binding.textDataNasimento.text.toString();
        contact.email = binding.TextEmail.text.toString();
        contact.nome = binding.TextNome.text.toString();
        contact.telefone = binding.TextTelefone.text.toString();
        contact.id = id;
        contactRepository = ContactRepository(this);
        val update = contactRepository.update(contact);

        Toast.makeText(this, "Contato atualizado ", Toast.LENGTH_LONG).show()

        finish()
    }

    private fun deletar() {
        val confirmacao = AlertDialog.Builder(this)

        confirmacao.setTitle("Exclusão");
        confirmacao.setMessage("Tu quer mesmo excluir o(a) ${contact.nome}?");

        confirmacao.setPositiveButton("Of course!"){ _, _ ->
            contactRepository.delete(contact);
            finish();
        }
        confirmacao.setNegativeButton("OMAGA EU ERREI APAGA NÃO PELO AMOR DE TUDO QUE VOCE AMA"){_, _ ->}
        confirmacao.show();
    }

    private fun carregarContato() {
        contactRepository = ContactRepository(this);
        contact = contactRepository.getContactById(id);

        binding.TextNome.setText(contact.nome);
        binding.TextEmail.setText(contact.email);
        binding.TextTelefone.setText(contact.telefone);
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
//        if(id > 0){
//            contact.id = id;
//            contactRepository.update(contact)
//        } else {
//
//        }


        Toast.makeText(this, "ID: $id ", Toast.LENGTH_LONG).show()

        finish()
    }
}