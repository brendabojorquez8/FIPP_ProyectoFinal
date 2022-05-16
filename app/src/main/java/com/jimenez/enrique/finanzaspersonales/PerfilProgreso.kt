package com.jimenez.enrique.finanzaspersonales

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_perfil_progreso.*
import kotlinx.android.synthetic.main.activity_pincipal.btn_egresos
import kotlinx.android.synthetic.main.activity_pincipal.btn_ingresos
import kotlinx.android.synthetic.main.activity_pincipal.btn_sena_pro

class PerfilProgreso : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil_progreso)

        btn_ingresos.setOnClickListener {
            val intent: Intent = Intent(this, Ingresar::class.java)
            startActivity(intent)
            this.finish()
        }

        btn_egresos.setOnClickListener {
            val intent: Intent = Intent(this, Egresar::class.java)
            startActivity(intent)
            this.finish()
        }


        btn_sena_pro.setOnClickListener {
            val intent: Intent = Intent(this, SincronizarTarjeta::class.java)
            startActivity(intent)
            this.finish()
        }

        btn_volver.setOnClickListener {
            val intent: Intent = Intent(this, Pincipal::class.java)
            startActivity(intent)
            this.finish()
        }
    }
}