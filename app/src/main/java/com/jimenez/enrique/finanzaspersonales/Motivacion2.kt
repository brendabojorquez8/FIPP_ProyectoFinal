package com.jimenez.enrique.finanzaspersonales

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_motivacion2.*


class Motivacion2 : AppCompatActivity() {

    private lateinit var storage: FirebaseFirestore
    private lateinit var usuario: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_motivacion2)

        btn_back_m1.setOnClickListener{
            val intent = Intent(this, Motivacion::class.java)
            startActivity(intent)
            this.finish()
        }

        btn_ahorremos3.setOnClickListener {
           val motivo = et_motivacion_personalizada.text.toString()
            guardarMotivo(motivo)
        }

    }

    private fun guardarMotivo(motivo: String){
        val motivacion = hashMapOf(
            "meta" to motivo,
            "email" to usuario.currentUser?.email
        )

        storage.collection("metas").add(motivacion).addOnSuccessListener {
            Toast.makeText(this,"Motivacion agregada", Toast.LENGTH_SHORT).show()
            val intent: Intent = Intent(this, Pincipal::class.java)
            startActivity(intent)
            this.finish()
        }.addOnFailureListener {
            Toast.makeText(this,"Error: Intente de Nuevo", Toast.LENGTH_SHORT).show()
        }
    }

}