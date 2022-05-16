package com.jimenez.enrique.finanzaspersonales

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Perfil : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)

        onBackPressed(){
        }

    }

    private fun onBackPressed(function: () -> Unit) {
    }
}