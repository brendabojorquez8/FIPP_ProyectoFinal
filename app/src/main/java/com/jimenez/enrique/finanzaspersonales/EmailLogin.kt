package com.jimenez.enrique.finanzaspersonales

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_email_login.*


class EmailLogin : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_email_login)

        auth = FirebaseAuth.getInstance()

        btn_ingresarsesion.setOnClickListener {
            valida_ingreso()
        }

        btn_recuperar_contra.setOnClickListener {
            val intent: Intent = Intent(this, Recuperacion::class.java)
            startActivity(intent)
        }

        btn_registrarsel.setOnClickListener {
            val intent: Intent = Intent(this, CrearCuenta::class.java)
            startActivity(intent)
        }

    }

    private fun valida_ingreso() {
        var correo: String = et_correo1.text.toString()
        var contra: String = et_contra1.text.toString()

        if (!correo.isNullOrBlank() && !contra.isNullOrBlank()) {
            ingresarFirebase(correo, contra)

        } else {
            Toast.makeText(
                this, "Ingresar datos",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun ingresarFirebase(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    // Log.d(TAG, "signInWithEmail:success")
                    val user = auth.currentUser
                    //updateUI(user)

                    Toast.makeText(
                        baseContext, "Authentication successful.",
                        Toast.LENGTH_SHORT
                    ).show()
                    val intent: Intent = Intent(this, Pincipal::class.java)
                    startActivity(intent)
                } else {
                    // If sign in fails, display a message to the user.
                    //Log.w(TAG, "signInWithEmail:failure", task.exception)
                    Toast.makeText(
                        baseContext, "Correo y/o contraseña incorrecta.",
                        Toast.LENGTH_SHORT
                    ).show()
                    //updateUI(null)
                }
            }

    }
}