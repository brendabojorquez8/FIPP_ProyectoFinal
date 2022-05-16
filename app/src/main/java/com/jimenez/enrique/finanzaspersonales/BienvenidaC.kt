package com.jimenez.enrique.finanzaspersonales

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_bienvenida_c.*

class BienvenidaC : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bienvenida_c)

        btn_back_b.setOnClickListener{
            val intent = Intent(this, BienvenidaB::class.java)
            startActivity(intent)
            this.finish()
        }

        btn_ahorremos.setOnClickListener {
            val intent = Intent(this, Motivacion::class.java)
            startActivity(intent)
            this.finish()
        }
    }
}