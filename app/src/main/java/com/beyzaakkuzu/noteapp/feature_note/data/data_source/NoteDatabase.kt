package com.beyzaakkuzu.noteapp.feature_note.data.data_source

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Database
import androidx.room.RoomDatabase
import com.beyzaakkuzu.noteapp.feature_note.domain.model.Note

@Database(entities = [Note:: class], version=1)
abstract class NoteDatabase():RoomDatabase() { //Soyut sınıf
    abstract val noteDao:NoteDao
    companion object{
        const val  DATABASE_NAME= "notes_dp"
    }
}