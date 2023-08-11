package com.example.calcularpagosliquidos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class EmpleadoRegularActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_empleado_regular)

        val btnVolver = findViewById<Button>(R.id.btnVolver)
        val btnCalcular = findViewById<Button>(R.id.calcular)
        val txtResultado = findViewById<TextView>(R.id.resultado)

        btnVolver.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        btnCalcular.setOnClickListener {
            val horasTrabajadas = findViewById<EditText>(R.id.horasTrabajadas).text.toString().toDoubleOrNull() ?: 0.0
            val valorHora = findViewById<EditText>(R.id.valorHora).text.toString().toDoubleOrNull() ?: 0.0

            val sueldoBruto = horasTrabajadas * valorHora
            val descuento = sueldoBruto * 0.20
            val sueldoLiquido = (sueldoBruto - descuento).toInt()

            txtResultado.text = "El sueldo líquido es $sueldoLiquido pesos"
        }
    }
}