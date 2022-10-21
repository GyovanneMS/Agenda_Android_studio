package br.senai.sp.jandira.agenda.DAO

import androidx.room.*
import br.senai.sp.jandira.agenda.model.Contact

@Dao
interface ContactDao {
    // Kotlin class/File - inteface

    @Insert
    fun save(contact: Contact): Long //

    @Delete
    fun delete(contact: Contact): Int //Quantidade de registros apagados

    @Update
    fun update(contact: Contact): Int  //Quantidade de atualizações feitas com sucesso

    @Query("SELECT * FROM tbl_contact ORDER by nome ASC")
    fun getAll(): List<Contact>

    @Query("SELECT * FROM tbl_contact where id = :id")
    fun getContactById(id: Int): Contact
}