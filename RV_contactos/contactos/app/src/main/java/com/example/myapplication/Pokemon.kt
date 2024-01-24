package com.example.myapplication

import android.os.Parcel
import android.os.Parcelable

data class Pokemon(
    val imagen: Int?,
    val nombre: String = "Desconocido",
    val correo: String = "Desconocido",
    val telefono: String = "Desconocido"
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString() ?: "Desconocido",
        parcel.readString() ?: "Desconocido",
        parcel.readString() ?: "Desconocido"
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(imagen)
        parcel.writeString(nombre)
        parcel.writeString(correo)
        parcel.writeString(telefono)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Pokemon> {
        override fun createFromParcel(parcel: Parcel): Pokemon {
            return Pokemon(parcel)
        }

        override fun newArray(size: Int): Array<Pokemon?> {
            return arrayOfNulls(size)
        }
    }
}

