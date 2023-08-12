package com.example.calcularpagosliquidos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class PantallaRegularActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_regular)

        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)
        val etSueldoBruto = findViewById<EditText>(R.id.etSueldoBruto)

        btnCalcular.setOnClickListener {
            val sueldoBruto = etSueldoBruto.text.toString().toDoubleOrNull() ?: 0.0
            val empleado = EmpleadoRegular(sueldoBruto)
            val liquido = empleado.calcularLiquido()
            tvResultado.text = "Pago Líquido: $liquido"
        }
    }

    fun volverAtras(view: View) {
        finish()
    }
}