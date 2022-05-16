package com.jimenez.enrique.finanzaspersonales

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_sincronizar_tarjeta.*

class SincronizarTarjeta : AppCompatActivity() {

    private lateinit var storage: FirebaseFirestore
    private lateinit var usuario: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sincronizar_tarjeta)

        storage = FirebaseFirestore.getInstance()

        usuario = FirebaseAuth.getInstance()

        btn_atras_pincipal.setOnClickListener{
            val intent = Intent(this, Pincipal::class.java)
            startActivity(intent)
            this.finish()
        }

        btn_agregar_tarjeta.setOnClickListener{
            guardarTarjeta()

        }

        btn_ver_tarjetas.setOnClickListener {
            val intent: Intent = Intent(this, TarjetasView::class.java)
            startActivity(intent)
        }
    }

    private fun guardarTarjeta(){
        var nombre = et_nombre_titular.text.toString()
        var numTarjeta = et_numero_tarjeta.text.toString()
        var mes = et_fecha.text.toString()
        var tipo = et_tipo_tarjeta.text.toString()


        val tarjeta = hashMapOf(

            "nombreTitular" to nombre,
            "fechaExp" to mes,
            "numeroTarjeta" to numTarjeta,
            "email" to usuario.currentUser?.email,
            "tipoTarjeta" to tipo)


        storage.collection("tarjetero").add(tarjeta).addOnSuccessListener {
            Toast.makeText(this,"Tarjeta agregada", Toast.LENGTH_LONG).show()
            et_nombre_titular.setText("")
            et_numero_tarjeta.setText("")
            et_fecha.setText("")
            et_tipo_tarjeta.setText("")

        }.addOnFailureListener {
            Toast.makeText(this,"Error: Intente de Nuevo", Toast.LENGTH_SHORT).show()
        }
    }
}