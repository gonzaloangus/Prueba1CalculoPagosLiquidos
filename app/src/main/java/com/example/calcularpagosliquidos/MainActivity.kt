package com.example.calcularpagosliquidos

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calcularpagosliquidos.ui.theme.CalcularPagosLiquidosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PantallaPrincipal()
        }
    }
}

@Composable
fun PantallaPrincipal() {
    val contexto = LocalContext.current
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Calculo sueldo liquido",
            style = TextStyle(fontSize = 30.sp, fontWeight = FontWeight.Bold)
        )
        Spacer(modifier = Modifier.height(30.dp))

        Button(onClick = {
            val intent = Intent(contexto, PantallaHonorariosActivity::class.java)
            contexto.startActivity(intent)
        }) {
            Text(
                text= "Empleado a Honorarios",
                style = TextStyle(fontSize = 30.sp, fontWeight = FontWeight.Bold)
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {
            val intent = Intent(contexto, PantallaRegularActivity::class.java)
            contexto.startActivity(intent)
        }) {
            Text(
                text= "Empleado con Contrato",
                style = TextStyle(fontSize = 30.sp, fontWeight = FontWeight.Bold)
            )
        }
    }
}