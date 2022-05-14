package com.example.firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val database = Firebase.database
        val myRef = database.reference

        myRef.child("ejemplo").child("1").setValue(Card("1", "rojo", "corazones"))
        myRef.child("ejemplo").child("2").setValue(Card("2", "rojo", "diamantes"))
        myRef.child("ejemplo").child("3").setValue(Card("3", "negro", "treboles"))
        myRef.child("ejemplo").child("4").setValue(Card("4", "negro", "aces"))

        myRef.child("ejemplo").get().addOnSuccessListener { response ->
          Log.d("firebaseResponse", response.value.toString())
        }.addOnFailureListener{
          Log.e("firebaseResponse", "Error getting data", it)
        }

        myRef.child("user").child("1").setValue(User("Manuel", "Ramirez", "maklsjbls@dasdf.com", "1234233"))
        myRef.child("user").child("2").setValue(User("Jorge", "Huerta", "jorge.slasof@asfa.com", "ffwqsda"))
        myRef.child("user").child("3").setValue(User("Teresa", "Rodriguez", "tere12@dasfsa.com", "123412e"))

        myRef.child("user").child("1").get().addOnSuccessListener { response ->
            Log.d("firebaseResponse", response.value.toString())
        }.addOnFailureListener {
            Log.e("firebaseResponse", "Error getting data", it)
        }
    }
}