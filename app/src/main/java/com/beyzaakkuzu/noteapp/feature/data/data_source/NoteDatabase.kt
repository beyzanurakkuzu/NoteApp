package com.beyzaakkuzu.noteapp.feature.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.beyzaakkuzu.noteapp.feature.domain.model.Note

@Database(entities = [Note:: class], version=1)
abstract class NoteDatabase():RoomDatabase() { //Soyut sınıf
    abstract val noteDao:NoteDao
    companion object{
        const val  DATABASE_NAME= "notes_dp"
    }
}