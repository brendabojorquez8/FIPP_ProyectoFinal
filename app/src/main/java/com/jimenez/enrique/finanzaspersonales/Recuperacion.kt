package com.jimenez.enrique.finanzaspersonales

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_recuperacion.*
import java.util.regex.Pattern

class Recuperacion : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recuperacion)

        auth = FirebaseAuth.getInstance()

        btn_back_login.setOnClickListener{
            this.finish()
        }

        btn_nexto.setOnClickListener {
            var correoin: String = et_email_recupe.text.toString()
            if (!correoin.isNullOrBlank()){
                if (!verifyEmail(correoin)){
                    auth!!.sendPasswordResetEmail(correoin).addOnCompleteListener{ task ->
                        if(task.isSuccessful){
                            Toast.makeText(
                                this, "Correo de reestablecimiento enviado",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                }
                    this.finish()
            }
        }else {
                Toast.makeText(
                    this, "Ingrese un correo electronico valido",
                    Toast.LENGTH_SHORT
                ).show()
            }
       }
    }
    private fun verifyEmail(email: String): Boolean{ //falso no pasa
        return Pattern.compile("@\"^([\\w.-]+)@(\\[(\\d{1,3}\\.){3}|(?!hotmail|gmail|yahoo)(([a-zA-Z\\d-]+\\.)+))([a-zA-Z]{2,4}|\\d{1,3})(\\]?)\$\"").matcher(email).matches()
    }

}

