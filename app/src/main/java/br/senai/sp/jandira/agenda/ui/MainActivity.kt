package br.senai.sp.jandira.agenda.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.senai.sp.jandira.agenda.R
import br.senai.sp.jandira.agenda.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ButtonFloatingAdd.setOnClickListener {

            val abrirCadastro = Intent(this, NewContactActivity::class.java);

            startActivity(abrirCadastro)

        }

        //DAO - Objeto de acesso de dados
    }
}