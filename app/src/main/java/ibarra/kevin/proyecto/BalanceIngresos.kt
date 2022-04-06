package ibarra.kevin.proyecto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class BalanceIngresos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_balance_ingresos)
    }

    fun clickFijos(){
        val btnFijos= findViewById<Button>(R.id.btnFijos)
        btnFijos.setOnClickListener {
            val pantallaFijos = Intent(this, Fijos::class.java)
            startActivity(pantallaFijos)
            finish()
        }
    }

    fun clickClasificacion(){
        val btnClasificacion= findViewById<Button>(R.id.btnClasificacion)
        btnClasificacion.setOnClickListener {
            val pantallaClasificacion = Intent(this, Clasificacion::class.java)
            startActivity(pantallaClasificacion)
            finish()
        }
    }
}