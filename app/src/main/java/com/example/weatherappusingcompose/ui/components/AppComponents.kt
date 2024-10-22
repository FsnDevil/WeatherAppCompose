package com.example.weatherappusingcompose.ui.components

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.weatherappusingcompose.R
import com.example.weatherappusingcompose.ui.theme.BackGroundColor
import com.example.weatherappusingcompose.ui.theme.WhiteColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToolbarForApp(title: String) {
    TopAppBar(
        colors = TopAppBarColors(
            containerColor = BackGroundColor,
            scrolledContainerColor = BackGroundColor,
            navigationIconContentColor = BackGroundColor,
            titleContentColor = WhiteColor,
            actionIconContentColor = WhiteColor,
        ),
        title = { Text(title, modifier = Modifier.fillMaxWidth(),textAlign = TextAlign.Center) },
        actions = {
            IconButton(onClick = {}) {
                Icon(imageVector = Icons.Filled.Refresh, contentDescription = "")
            }
        }
    )
}

@Composable
fun RotatingLoader(isVisible: Boolean) {
    val infiniteTransition = rememberInfiniteTransition(label = "")

    val rotation by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1000,
                easing = LinearEasing
            )
        ),
        label = ""
    )

    if (isVisible) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Transparent),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.loadingicon),
                contentDescription = "Loading",
                modifier = Modifier
                    .size(60.dp)
                    .rotate(degrees = rotation)
            )
        }
    }
}