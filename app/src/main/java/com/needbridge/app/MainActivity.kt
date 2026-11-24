package com.needbridge.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NeedBridgeApp()
        }
    }
}

@Composable
fun NeedBridgeApp() {
    var page by remember { mutableStateOf("Welcome") }

    val blue = Color(0xFF075985)
    val teal = Color(0xFF0D9488)

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFFF0F9FF)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(22.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("🌉 NeedBridge", fontSize = 34.sp,
                fontWeight = FontWeight.Bold, color = blue)

            Text("ASK • HELP • GROW TOGETHER",
                color = teal, fontSize = 13.sp)

            Spacer(Modifier.height(35.dp))

            Text(
                when(page) {
                    "Welcome" -> "Welcome to Our Community ❤️"
                    "Home" -> "How can we help you today?"
                    "Login" -> "Welcome Back"
                    "Help" -> "Ask for Help"
                    "Visa" -> "Visa Opportunities"
                    else -> page
                },
                fontSize = 23.sp,
                fontWeight = FontWeight.Bold,
                color = blue
            )

            Spacer(Modifier.height(25.dp))

            if (page == "Welcome") {
                AppButton("Let's Get Started!", teal) {
                    page = "Home"
                }
            } else {
                AppButton("Home", blue) { page = "Home" }
                AppButton("Login / Sign Up", teal) { page = "Login" }
                AppButton("Ask for Help", blue) { page = "Help" }
                AppButton("Visa Opportunities", teal) { page = "Visa" }
            }
        }
    }
}

@Composable
fun AppButton(
    title: String,
    color: Color,
    action: () -> Unit
) {
    Button(
        onClick = action,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
            .height(52.dp),
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = color
        )
    ) {
        Text(title, fontSize = 16.sp)
    }
}
