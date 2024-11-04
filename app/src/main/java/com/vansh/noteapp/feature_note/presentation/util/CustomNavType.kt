package com.vansh.noteapp.feature_note.presentation.util

import android.net.Uri
import android.os.Bundle
import androidx.navigation.NavType
import kotlinx.serialization.*
import kotlinx.serialization.json.Json

object CustomNavType {
    val AddEdit = object : NavType<Screens.AddEditNotes>(isNullableAllowed = false) {

        override fun get(bundle: Bundle, key: String): Screens.AddEditNotes? {
            return bundle.getParcelable<Screens.AddEditNotes>(key)
        }

        override fun parseValue(value: String): Screens.AddEditNotes {
            return Json.decodeFromString(Uri.decode(value))
        }

        override fun serializeAsValue(value: Screens.AddEditNotes): String {
            return Uri.encode(Json.encodeToString(value))
        }

        override fun put(bundle: Bundle, key: String, value: Screens.AddEditNotes) {
            bundle.putParcelable(key, value)
        }
    }
}