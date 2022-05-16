package com.jimenez.enrique.finanzaspersonales

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_egresar.*

class Egresar : AppCompatActivity() {

    private lateinit var storage: FirebaseFirestore
    private lateinit var usuario: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_egresar)

        //Instanciar Firebase
        //Conexion BD
        storage = FirebaseFirestore.getInstance()
        //Conexion al ususarioGmail
        usuario = FirebaseAuth.getInstance()

        btn_egresos.setOnClickListener {
            guardarEgresos()

        }
        btn_vistaEgresos.setOnClickListener {
            val intent: Intent = Intent(this, EgresosView::class.java)
            startActivity(intent)
        }
    }

    private fun guardarEgresos(){
        var tipoegreso = edit_egreso.text.toString()
        var cantidad = egreso_cantidad.text.toString()
        var nota = egr_nota.text.toString()

        val egreso = hashMapOf(

            "cantidad" to cantidad,
            "nota" to nota,
            "tipo" to tipoegreso,
            "email" to usuario.currentUser?.email)


        storage.collection("egresos").add(egreso).addOnSuccessListener {
            Toast.makeText(this,"Egreso agregado", Toast.LENGTH_LONG).show()
            edit_egreso.setText("")
            egreso_cantidad.setText("")
            egr_nota.setText("")

        }.addOnFailureListener {
            Toast.makeText(this,"Error: Intente de nuevo", Toast.LENGTH_SHORT).show()
        }
    }
}