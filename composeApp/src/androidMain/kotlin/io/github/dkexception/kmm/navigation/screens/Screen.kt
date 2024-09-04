@file:OptIn(ExperimentalMaterial3Api::class)

package io.github.dkexception.kmm.navigation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.dkexception.kmm.navigation.screen.ScreenEvent
import kotlin.random.Random

@Composable
fun Screen(
    canGoBack: Boolean,
    onEvent: (ScreenEvent) -> Unit
) {

    val red = rememberSaveable {
        Random.nextInt(256)
    }

    val green = rememberSaveable {
        Random.nextInt(256)
    }

    val blue = rememberSaveable {
        Random.nextInt(256)
    }

    val randomColor = Color(red, green, blue)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(randomColor)
            .windowInsetsPadding(WindowInsets.statusBars)
    ) {

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {

            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Box(
                    modifier = Modifier
                        .fillMaxWidth(.8f)
                        .background(Color.White),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Screen with Color($red, $green, $blue)",
                        color = Color.Black,
                        modifier = Modifier.padding(16.dp)
                    )
                }

                Spacer(Modifier.height(36.dp))

                ElevatedButton(
                    onClick = { onEvent(ScreenEvent.LoadNewScreen) }
                ) {
                    Text("Launch next screen")
                }
            }
        }

        if (canGoBack) {
            Box(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(16.dp)
                    .clip(CircleShape)
                    .background(Color.White)
            ) {
                IconButton(
                    modifier = Modifier.padding(4.dp),
                    onClick = {
                        onEvent(ScreenEvent.OnBackAction)
                    }
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun ScreenPreview() = Screen(true) { }
