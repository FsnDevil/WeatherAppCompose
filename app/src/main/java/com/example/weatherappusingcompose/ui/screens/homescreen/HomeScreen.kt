package com.example.weatherappusingcompose.ui.screens.homescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cloud
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.weatherappusingcompose.ui.theme.BackGroundColor
import com.example.weatherappusingcompose.ui.theme.CardBackgroundColor
import com.example.weatherappusingcompose.ui.theme.WhiteColor
import com.example.weatherappusingcompose.ui.components.ToolbarForApp
import com.example.weatherappusingcompose.ui.data.models.WeatherModel
import com.example.weatherappusingcompose.ui.data.models.WeatherResponse

@Preview
@Composable
fun HomeScreen() {
    val homeViewModel:HomeViewModel = hiltViewModel()
    val weatherResponse = homeViewModel.weatherResponse.collectAsStateWithLifecycle()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackGroundColor)
    ) {
        ToolbarForApp("Weather App")
        Spacer(modifier = Modifier.padding(15.dp))
        MainCard(weatherResponse.value)
        Spacer(modifier = Modifier.padding(15.dp))
        Text("Weather Forecast", style = TextStyle(fontSize = 14.sp, color = Color.White, fontStyle = FontStyle.Normal))
        Spacer(modifier = Modifier.padding(15.dp))
        weatherResponse.value.list?.let { WeatherForecastCards(it) }
    }

}

@Composable
fun MainCard(forecastDataModel: WeatherResponse) {
    val skyData = forecastDataModel.list?.get(0)?.weather?.get(0)?.main
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
        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)){
            Column(modifier = Modifier.fillMaxWidth(),horizontalAlignment = Alignment.CenterHorizontally) {
                Text("${forecastDataModel.list?.get(0)?.main?.temp?:0.0} K", style = TextStyle(fontSize = 35.sp, fontWeight = FontWeight.Bold))
                Spacer(modifier = Modifier.padding(15.dp))
                if (skyData == "Clouds"||skyData == "Rain") {
                    Icon(Icons.Filled.Cloud, contentDescription = "Cloud", modifier = Modifier.size(48.dp), tint = WhiteColor)
                }else{
                    Icon(Icons.Filled.WbSunny, contentDescription = "Cloud", modifier = Modifier.size(48.dp), tint = WhiteColor)
                }
                Spacer(modifier = Modifier.padding(15.dp))
                Text("$skyData", style = TextStyle(fontSize = 25.sp, fontWeight = FontWeight.Normal))
            }
        }
    }
}

@Composable
fun WeatherForecastCards(weatherList: List<WeatherModel>) {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(16.dp)// Add spacing between items
    ) {
        items(weatherList) { weatherModel -> // Directly iterate over the list
            WeatherForecastListItem(weatherModel = weatherModel)
        }
    }
}

@Composable
fun WeatherForecastListItem(weatherModel: WeatherModel) {
    val skyData = weatherModel.weather[0].main
    ElevatedCard(
        colors = CardColors(
            containerColor = CardBackgroundColor,
            contentColor = WhiteColor,
            disabledContainerColor = CardBackgroundColor,
            disabledContentColor = WhiteColor
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 3.dp
        ),
        modifier = Modifier
            .width(150.dp)
            .heightIn()
            .padding(15.dp)
            .clickable {

            }
    ) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)){
            Column(modifier = Modifier.fillMaxWidth(),horizontalAlignment = Alignment.CenterHorizontally) {
                weatherModel.dt_txt?.let { Text(it, style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)) }
                Spacer(modifier = Modifier.padding(15.dp))
                if (skyData == "Clouds"||skyData == "Rain") {
                    Icon(Icons.Filled.Cloud, contentDescription = "Cloud", modifier = Modifier.size(48.dp), tint = WhiteColor)
                }else{
                    Icon(Icons.Filled.WbSunny, contentDescription = "Cloud", modifier = Modifier.size(48.dp), tint = WhiteColor)
                }
                Spacer(modifier = Modifier.padding(15.dp))
                weatherModel.main?.temp?.let { Text("$it", style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Normal)) }
            }
        }
    }
}