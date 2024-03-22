package com.example.hellocompose

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import com.example.hellocompose.ui.theme.HelloComposeTheme

const val TAG: String = "My App Tag"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HelloComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                    //ScreenTwo()
                }
            }
        }
    }
}
@Composable
fun Greeting(modifier: Modifier = Modifier, screenNumber: Int = 0) {
    var screenSelector by remember { mutableIntStateOf(screenNumber) }
    when (screenSelector){
        1 ->
            LoginView(onScreenSelect = {screenSelector = 0}, modifier)
        0 ->
            ScreenTwo{screenSelector = 1}
    }
}

@Composable
fun ScreenTwo(
    onScreenSelect: () -> Unit
){
    Row(){
        Text(
            text = "Home Page !!!",
            fontSize = 33.sp,
            modifier = Modifier
                .align(
                    Alignment.CenterVertically
                )
                .fillMaxHeight()
        )
        Button(
            onClick = {
                onScreenSelect()
            },
            content = {
                Icon(
                    Icons.Default.Face,
                    contentDescription = ""
                )
                Text(
                    " Go to login"
                )
            },
            modifier = Modifier
                .align(
                    Alignment.CenterVertically
                )
        )
    }
}

@Composable
fun LoginView(onScreenSelect: () -> Unit, modifier: Modifier = Modifier){
    val context = LocalContext.current
    var username by remember {mutableStateOf("")}
    var secret by remember {mutableStateOf("")}
    var welcomeMessage by remember {mutableStateOf("")}

    Column(
        modifier = Modifier
            .fillMaxSize()
    ){
        Text(
            text = "Welcome $welcomeMessage !!!!",
            fontSize = 33.sp,
            modifier = Modifier
                .align(
                    Alignment.CenterHorizontally
                )
                .padding(50.dp)
        )
        TextField(
            value = username,
            onValueChange = {
                username = it
            },
            placeholder = {
                Text(
                    text = "Username!",
                    fontSize = 13.sp,
                    modifier = Modifier
                        .align(
                            Alignment.CenterHorizontally
                        )
                        .padding(30.dp)
                )
            },
            modifier = Modifier
                .align(
                    Alignment.CenterHorizontally
                )
                .padding(54.dp)
        )
        TextField(
            value = secret,
            onValueChange = {
                secret = it
            },
            visualTransformation = PasswordVisualTransformation(),
            placeholder = {
                Text(
                    text = "Password!",
                    fontSize = 13.sp,
                    modifier = Modifier
                        .align(
                            Alignment.CenterHorizontally
                        )
                        .padding(30.dp)
                )
            },
            modifier = Modifier
                .align(
                    Alignment.CenterHorizontally
                )
                .padding(54.dp)
        )
        Button(
            onClick = {
                if(secret == "1234"){
                    onScreenSelect()
                    Toast.makeText(context, "Welcome, $username", Toast.LENGTH_SHORT).show()
                    welcomeMessage = username
                    Log.d(TAG,"Zvashanda")
                    println("$TAG, Pedza masports")
                }
                else{
                    Toast.makeText(context, "Zvarambaaaaaaaaaaaaaaaaaaaaaaaaa", Toast.LENGTH_LONG).show()
                    Log.d(TAG,"Zvaita here?, Ha zvinenge zvaramba")
                    println("$TAG, Zvaramaba")
                }
            },
            content = {
                Text(
                    "Login"

                )
            },
            modifier = Modifier
                .align(
                    Alignment.CenterHorizontally
                )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HelloComposeTheme {
        Greeting()
        //ScreenTwo()
    }
}
