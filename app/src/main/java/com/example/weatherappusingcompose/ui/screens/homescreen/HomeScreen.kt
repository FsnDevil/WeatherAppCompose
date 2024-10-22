package com.example.weatherappusingcompose.ui.screens.homescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cloud
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.weatherappusingcompose.ui.theme.BackGroundColor
import com.example.weatherappusingcompose.ui.theme.CardBackgroundColor
import com.example.weatherappusingcompose.ui.theme.WhiteColor
import com.example.weatherappusingcompose.ui.components.ToolbarForApp

@Preview
@Composable
fun HomeScreen() {
    val homeViewModel:HomeViewModel = hiltViewModel()
    val forecastDataModel = homeViewModel.forecastDataModel.collectAsStateWithLifecycle()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackGroundColor)
    ) {
        ToolbarForApp("Weather App")
        Spacer(modifier = Modifier.padding(15.dp))
        MainCard(forecastDataModel.value.list?.get(0)?.main?.temp?:0.0)
    }

}

@Composable
fun MainCard(temp: Double) {
    ElevatedCard(
        colors = CardColors(
            containerColor = CardBackgroundColor,
            contentColor = WhiteColor,
            disabledContainerColor = CardBackgroundColor,
            disabledContentColor = WhiteColor
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier
            .heightIn()
            .padding(15.dp)
            .clickable {

            }
    ) {
        Box(modifier = Modifier.fillMaxWidth().padding(15.dp)){
            Column(modifier = Modifier.fillMaxWidth(),horizontalAlignment = Alignment.CenterHorizontally) {
                Text("$temp K", style = TextStyle(fontSize = 35.sp, fontWeight = FontWeight.Bold))
                Spacer(modifier = Modifier.padding(15.dp))
                Icon(Icons.Filled.Cloud, contentDescription = "Cloud", modifier = Modifier.size(48.dp), tint = WhiteColor)
                Spacer(modifier = Modifier.padding(15.dp))
                Text("Rain", style = TextStyle(fontSize = 25.sp, fontWeight = FontWeight.Normal))
            }
        }
    }
}