package com.jimenez.enrique.finanzaspersonales

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_bienvenida.btn_next
import kotlinx.android.synthetic.main.activity_bienvenida_b.*

class BienvenidaB : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bienvenida_b)

        btn_back_a.setOnClickListener{
            val intent = Intent(this, BienvenidaA::class.java)
            startActivity(intent)
            this.finish()
        }

        btn_next.setOnClickListener {
            val intent = Intent(this, BienvenidaC::class.java)
            startActivity(intent)
            this.finish()
        }

    }
}