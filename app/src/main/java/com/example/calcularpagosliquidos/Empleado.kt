package com.example.calcularpagosliquidos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.calcularpagosliquidos.ui.theme.CalcularPagosLiquidosTheme


abstract class Empleado(val sueldoBruto: Double) {
    abstract fun calcularLiquido(): Int
}

class EmpleadoHonorarios(sueldoBruto: Double) : Empleado(sueldoBruto) {
    override fun calcularLiquido(): Int {
        val retencion = (sueldoBruto * 0.13).toInt()
        return (sueldoBruto - retencion).toInt()
    }
}

class EmpleadoRegular(sueldoBruto: Double) : Empleado(sueldoBruto) {
    override fun calcularLiquido(): Int {
        val retencion = (sueldoBruto * 0.20).toInt()
        return (sueldoBruto - retencion).toInt()
    }
}