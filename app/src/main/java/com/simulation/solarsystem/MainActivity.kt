package com.simulation.solarsystem

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.rememberTransformableState
import androidx.compose.foundation.gestures.transformable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.simulation.solarsystem.ui.components.Camera
import com.simulation.solarsystem.ui.theme.SolarSystemSimulationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SolarSystemSimulationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(
                        modifier = Modifier.fillMaxSize()
                            .background(Color.Black)
                    ) {
                        Field { camera ->

                        }
                        OutlinedIconButton(
                            modifier = Modifier
                                .align(Alignment.BottomEnd)
                                .padding(end = 12.dp, bottom = innerPadding.calculateBottomPadding() + 12.dp)
                                .width(64.dp).height(64.dp),
                            colors = IconButtonDefaults.iconButtonColors().copy(
                                containerColor = Color.DarkGray
                            ),
                            border = BorderStroke(1.dp, Color.Cyan),
                            onClick = {

                            }
                        ) {
                            Icon(
                                modifier = Modifier.size(48.dp),
                                imageVector = Icons.Filled.Add,
                                contentDescription = "Add space object",
                                tint = Color.White
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Field(
    @SuppressLint("ModifierParameter") modifier : Modifier = Modifier.fillMaxSize(),
    content : @Composable ((camera : Camera) -> Unit)
) {
    var camera by remember {
        mutableStateOf(
            Camera(
                scale = 1f,
                offsetX = 0f,
                offsetY = 0f,
                rotation = 0f
            )
        )
    }
    val state = rememberTransformableState { zoomChange, offsetChange, rotationChange ->
        camera = camera.updateWithRecreate(
            zoomChange,
            offsetChange.x,
            offsetChange.y
        )
    }

    Box(modifier = modifier
        .transformable(state = state)
        .clipToBounds()
    ) {
        content.invoke(camera)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SolarSystemSimulationTheme {
        Box(
            modifier = Modifier.fillMaxSize()
                .background(Color.Gray)
        ) {
            Box(
                modifier = Modifier.fillMaxSize()
                    .padding(4.dp)
                    .background(Color.Black, RoundedCornerShape(12.dp))
            ) {
                OutlinedIconButton(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(end = 8.dp, bottom = 8.dp)
                        .width(64.dp).height(64.dp),
                    colors = IconButtonDefaults.iconButtonColors().copy(
                        containerColor = Color.DarkGray
                    ),
                    border = BorderStroke(1.dp, Color.Cyan),
                    onClick = {

                    }
                ) {
                    Icon(
                        modifier = Modifier.size(48.dp),
                        imageVector = Icons.Filled.Add,
                        contentDescription = "Add space object",
                        tint = Color.White
                    )
                }
            }
        }
    }
}