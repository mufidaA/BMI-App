package com.example.bmi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel

class BmiViewModel: ViewModel() { var heightInput by mutableStateOf("" )
    var weightInput by mutableStateOf("" )
    private var weight: Int = 0
    get() {return weightInput.toIntOrNull() ?: 0}
    private var height: Float = 0.0F
    get() { return heightInput.toFloatOrNull() ?: 0.0f}
    fun changeHeightInput(value: String ) { heightInput = value}
    fun changeWeightInput(value: String) {weightInput = value}
    private fun bmi() : Float {
        return if  (weight > 0 && height >0) weight / (height *height) else 0.0f}}