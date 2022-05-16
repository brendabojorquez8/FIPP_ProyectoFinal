package com.jimenez.enrique.finanzaspersonales

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_pincipal.*

class Pincipal : AppCompatActivity() {
    private lateinit var storage: FirebaseFirestore
    private lateinit var usuario: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pincipal)

        onBackPressed()

        //Instanciar Firebase
        //Conexion BD
        storage = FirebaseFirestore.getInstance()
        //Conexion al ususarioGmail
        usuario = FirebaseAuth.getInstance()

        btn_config.setOnClickListener {
            val intent: Intent = Intent(this, ConfiguracionPerfil::class.java)
            startActivity(intent)
        }

        btn_ingresos.setOnClickListener {
            val intent: Intent = Intent(this, Ingresar::class.java)
            startActivity(intent)
        }

        btn_egresos.setOnClickListener {
            val intent: Intent = Intent(this, Egresar::class.java)
            startActivity(intent)
        }


        btn_sena_pro.setOnClickListener {
            val intent: Intent = Intent(this, SincronizarTarjeta::class.java)
            startActivity(intent)
        }

        btn_perfil.setOnClickListener {
            val intent: Intent = Intent(this, PerfilProgreso::class.java)
            startActivity(intent)
        }

    }
     override fun onBackPressed() {
    }

}