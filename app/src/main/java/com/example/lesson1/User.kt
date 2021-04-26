package com.example.lesson1

import android.R.attr.name
import android.R.id
import android.os.Parcel
import android.os.Parcelable


class User(_email: String, _password: String, _name: String, _second_name: String) : Parcelable {
    var email: String = _email
    var password: String = _password
    var name: String = _name
    var secondName: String = _second_name


    constructor(parcel: Parcel) : this(
        parcel.readString().toString(), parcel.readString().toString(),
        parcel.readString().toString(), parcel.readString().toString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(email)
        parcel.writeString(password)
        parcel.writeString(name)
        parcel.writeString(secondName)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }



}