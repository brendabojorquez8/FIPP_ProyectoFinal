package ibarra.kevin.proyecto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }

    fun clickIngresos(){
        val btnBalanceIngresos= findViewById<TextView>(R.id.txtIngresos)
        btnBalanceIngresos.setOnClickListener {
            val pantallaBalanceIngresos = Intent(this, BalanceIngresos::class.java)
            startActivity(pantallaBalanceIngresos)
            finish()
        }
    }
}