package com.jimenez.enrique.finanzaspersonales

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jimenez.enrique.finanzaspersonales.Adaptadores.TarjetaAdapter
import com.jimenez.enrique.finanzaspersonales.Objetos.Tarjeta
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_configuracion_perfil.*

class ConfiguracionPerfil : AppCompatActivity() {

    var adaptador: TarjetaAdapter? = null
    var tarjeta =  ArrayList<Tarjeta>()

    private lateinit var storage: FirebaseFirestore
    private lateinit var usuario: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configuracion_perfil)

        storage = FirebaseFirestore.getInstance()
        //Conexion al ususarioGmail
        usuario = FirebaseAuth.getInstance()

        crearTarjeta.setOnClickListener{
            val intent: Intent = Intent(this, SincronizarTarjeta::class.java)
            startActivity(intent)
        }

        fillTarjetasPerfil()
        if(!tarjeta.isEmpty()) {
            adaptador = TarjetaAdapter(this, tarjeta)
            gridTarjetasConfig.adapter = adaptador
        }

        personName.hint = usuario.currentUser?.email
    }

    fun fillTarjetasPerfil(){
        var fecha = ArrayList<String>()
        var nombre = ArrayList<String>()
        var tipo = ArrayList<String>()
        var numero = ArrayList<String>()

        storage.collection("tarjetero").whereEqualTo("email", usuario.currentUser?.email)
            .get()
            .addOnSuccessListener {
                it.forEach {

                    if(!it.getString("nombreTitular").isNullOrEmpty()){
                        fecha.add("${it.getString("fechaExp")!!}")
                        nombre.add("${it.getString("nombreTitular")!!}")
                        tipo.add("${it.getString("tipoTarjeta")!!}")
                        numero.add("${it.getString("numeroTarjeta")!!}")
                    }
                    tarjeta!!.add(Tarjeta(fecha!!,nombre!!,tipo!!,numero!!))
                }
                adaptador = TarjetaAdapter(this, tarjeta)
                gridTarjetasConfig.adapter = adaptador
            }
    }
}