package com.example.calcularpagosliquidos

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.example.calcularpagosliquidos.ui.theme.CalcularPagosLiquidosTheme

class EmpleadoHonorariosActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EmpleadoHonorarios()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun EmpleadoHonorarios() {
    val contexto = LocalContext.current
    var horas by remember { mutableStateOf("") }
    var valorHora by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }

    Column (
        modifier = Modifier.fillMaxSize().background(Color.Cyan)
    ){
        Button(onClick = {
            Log.v("EmpleadoHonorarios", "volviendo al home")
            val intent = Intent(contexto, MainActivity::class.java )
            contexto.startActivity(intent)
        }) {
            Text(text="<- Volver")
        }

        Column {
            Text("Cálculo de Sueldo Líquido")
            TextField(
                value = horas,
                onValueChange = { horas = it },
                label = { Text("Horas Trabajadas") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                )
            )
            TextField(
                value = valorHora,
                onValueChange = { valorHora = it },
                label = { Text("Valor Hora") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                )
            )
            Button(onClick = {
                val horasNumero = horas.toIntOrNull() ?: 0
                val valorHoraNumero = valorHora.toDoubleOrNull() ?: 0.0
                val sueldoBruto = horasNumero * valorHoraNumero
                val descuento = sueldoBruto * 0.13
                val sueldoLiquido = (sueldoBruto - descuento).toInt()
                resultado = "El sueldo líquido es $sueldoLiquido pesos"
            }) {
                Text("Calcular Sueldo Líquido")
            }
            Text(resultado)
        }
    }
}
