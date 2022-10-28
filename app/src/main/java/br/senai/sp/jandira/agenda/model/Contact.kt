package br.senai.sp.jandira.agenda.model

import android.graphics.drawable.Drawable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

//Vem do ROOM que criamos, o @Entity vai "Criar o banco e as tabelas"
@Entity(tableName = "tbl_contact")
class Contact {

    //faz o id virar chave primaria
    @PrimaryKey(autoGenerate = true)
    var id = 0;

    var nome = "";
    var telefone = "";
    var email = "";

    @ColumnInfo(name = "data_nascimento")
    var dataNascimento = "";

    var foto = "";


}