package com.beyzaakkuzu.noteapp.feature.domain.util

sealed class OrderType{
    object Ascending: OrderType()
    object Descending: OrderType()

}
