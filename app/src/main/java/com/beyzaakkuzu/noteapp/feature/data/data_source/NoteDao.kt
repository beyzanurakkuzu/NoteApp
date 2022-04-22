package com.beyzaakkuzu.noteapp.feature.data.data_source


import androidx.room.*
import com.beyzaakkuzu.noteapp.feature.domain.model.Note
import kotlinx.coroutines.flow.Flow

@Dao //sql sorgular buraya yazılır
interface NoteDao {
    @Query("SELECT * FROM Note ") //kayıtlı notlar getirilir
    fun getNotes(): Flow<List<Note>>

    @Query("SELECT * FROM Note WHERE id = :id")
    suspend fun getNoteById(id:Int): Note? //suspend: durdurulup, yeniden başlatılabilen fonksiyonlardır. coroutine içerisinde çalışmak zorundadır

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: Note)

    @Delete
    suspend fun deleteNote(note:Note)
}