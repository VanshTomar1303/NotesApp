package com.vansh.noteapp.feature_note.domain.util

sealed class NoteOrder(
    val orderType: OrderType
) {
    class Title(orderType: OrderType): NoteOrder(orderType)
    class Date(orderType: OrderType): NoteOrder(orderType)
    class Colors(orderType: OrderType): NoteOrder(orderType)

    fun copy(orderType: OrderType): NoteOrder{
        return when(this){
            is Title -> Title(orderType)
            is Date -> Date(orderType)
            is Colors -> Colors(orderType)
        }
    }
}