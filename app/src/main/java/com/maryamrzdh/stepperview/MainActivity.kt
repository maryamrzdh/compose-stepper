package com.maryamrzdh.stepperview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.maryamrzdh.stepper.Stepper
import com.maryamrzdh.stepperview.ui.theme.StepperViewTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StepperViewTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier=Modifier){

    Column(modifier = modifier
        .fillMaxSize()
        .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {

        val numberStep = 4

        var currentStep by rememberSaveable { mutableStateOf(1) }

        val titleList= arrayListOf("Step 1","Step 2","Step 3","Step 4")

        Stepper(
            modifier = Modifier.fillMaxWidth(),
            numberOfSteps = numberStep,
            currentStep = currentStep,
            stepDescriptionList = titleList,
//            unSelectedColor= Color.LightGray,
//            selectedColor = Color.Magenta,
//            isRainbow = true
        )

        Box(
            modifier = modifier
                .fillMaxWidth()
                .weight(1f)) {
            Text(text = "Step $currentStep" , modifier.align(Alignment.Center) , fontSize = 26.sp)
        }

        Row(horizontalArrangement = Arrangement.SpaceBetween ,
            modifier = Modifier.fillMaxWidth()) {

            Button(
                onClick = { if (currentStep >1) currentStep-- },
                enabled = currentStep >1 ) {
                Text(text = "previous")
            }

            Button(
                onClick = { if (currentStep < numberStep) currentStep++ } ,
                enabled = currentStep < numberStep) {
                Text(text = "next")
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    StepperViewTheme {
        MainScreen()
    }
}