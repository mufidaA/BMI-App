package com.example.bmi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bmi.ui.theme.BmiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BmiTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background)
                {
                    Bmi()
                }
            }
        }
    }
}

@Composable
fun Bmi (bmiViewModel: BmiViewModel= viewModel()) {
    Column {
        Text (
            text = "Body mass index",
            fontSize = 24.sp,
            color = MaterialTheme.colors.primary,
            textAlign = TextAlign.Center,
            modifier = Modifier.run { fillMaxWidth().padding(top = 16.dp,bottom= 16.dp) }
        )
        OutlinedTextField  (
            value = bmiViewModel.heightInput,
            onValueChange = {bmiViewModel.heightInput = it.replace(  ',',    '.' )},
            label = { Text ("Height" )},
            singleLine= true,
            keyboardOptions =  KeyboardOptions (keyboardType = KeyboardType.Number)
        )
        OutlinedTextField (
            value = bmiViewModel.weightInput,
            onValueChange = {bmiViewModel.weightInput = it.replace(   ',',  '.')},
            label = {Text( "Weight")},
            singleLine = true,
            keyboardOptions = KeyboardOptions (keyboardType =
            KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        Text ( text = stringResource(R.string.body_mass_index))

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BmiTheme {
        Bmi()
    }
}