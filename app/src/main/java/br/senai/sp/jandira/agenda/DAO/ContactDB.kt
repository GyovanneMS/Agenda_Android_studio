package br.senai.sp.jandira.agenda.DAO

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.senai.sp.jandira.agenda.model.Contact

@Database(entities = [Contact::class], version = 1)
abstract class ContactDB: RoomDatabase() {

    abstract fun contactDao(): ContactDao

    companion object {
        private lateinit var instance: ContactDB //uma das ultimas coisas a acontecer

        fun getDataBase(context: Context): ContactDB{
             if(/*:: Permite ver os métodos para ver se já existem*/!::instance.isInitialized){
                 instance = Room.databaseBuilder(context, ContactDB::class.java, "db_agenda").allowMainThreadQueries().build();
             }
            return instance
        }
    }
}