package br.senai.sp.jandira.agenda.ui

import android.content.Intent
import android.media.CamcorderProfile.getAll
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.senai.sp.jandira.agenda.R
import br.senai.sp.jandira.agenda.adapter.ContactAdapter
import br.senai.sp.jandira.agenda.databinding.ActivityMainBinding
import br.senai.sp.jandira.agenda.repository.ContactRepository

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding;
    //Chamando o adapter e o repositorio
    lateinit var adapter: ContactAdapter;
    lateinit var repositorio: ContactRepository;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ButtonFloatingAdd.setOnClickListener {

            val abrirCadastro = Intent(this, NewContactActivity::class.java);

            startActivity(abrirCadastro)

        }

        carregarRecyperView();
    }

    private fun carregarRecyperView() {
        repositorio = ContactRepository(this)
        //Pegando o metodo (Tipo o controler) getall() da "model" ContactRepository
        val contatos = repositorio.getAll();
        //Chamando o método do adapter para criar um json com cada item pedo dos contatos
        adapter = ContactAdapter(contatos)
        //Pegando a view e colocando "todos" os contatos nela
        binding.RvContatos.adapter = adapter;
        //Como visualizar isso?
        binding.RvContatos.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
    }
}