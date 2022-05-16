package com.jimenez.enrique.finanzaspersonales

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.*
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_crear_cuenta.*
import java.util.regex.Pattern

class CrearCuenta : AppCompatActivity() {

    private lateinit var storage: FirebaseFirestore
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {

        storage = FirebaseFirestore.getInstance()
        auth = FirebaseAuth.getInstance()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_cuenta)

        btn_back_login2.setOnClickListener{
            this.finish()
        }

        btn_crear_cuenta.setOnClickListener {
            valida_registro()
        }

    }

    private fun valida_registro(){

        var username: String = et_nombre_usuario.text.toString()
        var correo: String = et_correo_usuario.text.toString()
        var contra1: String = et_contras1.text.toString()
        var contra2: String = et_contras2.text.toString()

        if(!correo.isNullOrBlank() && !contra1.isNullOrBlank() &&
            !contra2.isNullOrBlank()){
            if(contra1 == contra2 && contra1.length > 5){
                if (!verifyEmail(correo)){
                    registrarFirebase(correo, contra1)
                    val intent: Intent = Intent(this, PrincipalSaludo::class.java)
                    startActivity(intent)
                    this.finish()
                }

            }else{
                Toast.makeText(this, "Las contraseña no coinciden o es menor a 6 caracteres",
                    Toast.LENGTH_SHORT).show()
            }

        }else{
            Toast.makeText(this, "Ingresar datos",
                Toast.LENGTH_SHORT).show()
        }
    }

    private fun registrarFirebase(email: String, password: String){
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    // Log.d(TAG, "createUserWithEmail:success")
                    val user = auth.currentUser
                    Toast.makeText(this,"  Authentication passed.",
                        Toast.LENGTH_SHORT).show()
                    // updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.
                    // Log.w(TAG, "createUserWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                    //updateUI(null)
                }
            }
    }


    private fun verifyEmail(email: String): Boolean{ //falso no pasa
        return Pattern.compile("@\"^([\\w.-]+)@(\\[(\\d{1,3}\\.){3}|(?!hotmail|gmail|yahoo)(([a-zA-Z\\d-]+\\.)+))([a-zA-Z]{2,4}|\\d{1,3})(\\]?)\$\"").matcher(email).matches()
    }
}



