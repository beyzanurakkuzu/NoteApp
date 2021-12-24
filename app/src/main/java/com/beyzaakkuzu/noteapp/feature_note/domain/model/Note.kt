package com.beyzaakkuzu.noteapp.feature_note.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.beyzaakkuzu.noteapp.ui.theme.*

@Entity //veritabanındaki bir tabloyu temsil eder
data class Note(val title: String, //columns
                val content: String,
                val timestamp:Long,
               val color: Int,@PrimaryKey val id: Int? =null ){
    companion object {
        val noteColors= listOf(RedOrange, LightGreen, RedPink, BabyBlue, Violet)
    }
}
