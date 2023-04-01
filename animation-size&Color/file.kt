package com.example.animationwithjp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.animationwithjp.ui.theme.AnimationWithJPTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var sizeState by remember { mutableStateOf(200.dp) }
            val size by animateDpAsState(
                targetValue = sizeState ,
                tween( 1000 )
            )
            val infiniteTransition = rememberInfiniteTransition()
            val color by infiniteTransition.animateColor(initialValue = Color.Black,
                targetValue = Color.Yellow ,
                animationSpec = InfiniteRepeatableSpec(
                    tween(2000 ) ,
                    RepeatMode.Reverse
                ))

            Box(
                modifier = Modifier
                    .background(color)
                    .size(size),
                contentAlignment = Alignment.Center
            ) {
                Column {
                    Button(onClick = {
                        sizeState += 100.dp
                    }) {
                        Text(text = "increase size ",
                            color = Color.White, fontStyle = FontStyle.Italic)
                    }
                    Button(onClick = { sizeState -= 100.dp }) {
                        Text(text = "decrease size ",
                            color = Color.White, fontStyle = FontStyle.Italic)
                    }
                }

            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AnimationWithJPTheme {
        Greeting("Android")
    }
}
