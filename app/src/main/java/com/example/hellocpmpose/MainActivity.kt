package com.example.hellocpmpose

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hellocpmpose.ui.theme.HelloCpmposeTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            HelloCpmposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val navController = rememberNavController()
                    NavGraph(navController)

                    //Loginview(navController)
                }
            }
        }
    }
}


@Composable

fun LoginView(navController: NavHostController) {
    var context = LocalContext.current
    var pinnumber by remember {
        mutableStateOf(TextFieldValue())
    }
    var welcome by remember {
        mutableStateOf(TextFieldValue())
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Text(
            text = "welcome to Zesa app",
            fontSize = 20.sp,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(40.dp)
        )

        OutlinedTextField(
            value = pinnumber,
            onValueChange = { pinnumber=it},
            label = { Text("pin number") },
            modifier = Modifier
                .align(
                    Alignment.CenterHorizontally
                )
                .padding(40.dp)
        )

        Button(
            onClick = {
                if (pinnumber.text=="1234") {
                    //Toast.makeText(context, "hello", Toast.LENGTH_SHORT).show()
//                    welcome=username

//                    BuyEletricity()
                    navController.navigate(Screens.Choose.route)
                }
                else{
                    Toast.makeText(context, "wrong pin", Toast.LENGTH_SHORT).show()
                    //Log.d("Friends", "log in clicked")

                }

            },
            content = {
                Text(
                    text = "login"
                )
            },
            modifier = Modifier
                .align(
                    Alignment.CenterHorizontally
                )
        )


    }
}
@Composable
fun Choose(navController: NavHostController) {
    var context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Text(
            text = "Select an option",
            fontSize = 18.sp,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(40.dp)
        )

        Button(
            onClick = {
                  navController.navigate(Screens.BuyElectricity.route)
            },
            content = {
                Text(
                    text = "Buy Eletricity Token"
                )
            },
            modifier = Modifier
                .align(
                    Alignment.CenterHorizontally
                )
        )
        Button(
            onClick = {
                navController.navigate(Screens.BuyAirtime.route)
            },
            content = {
                Text(
                    text = "Buy airtime"
                )
            },
            modifier = Modifier
                .align(
                    Alignment.CenterHorizontally
                )
        )
        Button(
            onClick = {
                navController.navigate(Screens.CashOut.route)
            },
            content = {
                Text(
                    text = "Cash Out"
                )
            },
            modifier = Modifier
                .align(
                    Alignment.CenterHorizontally
                )
        )




    }
}

@Composable
fun BuyEletricity( ) {
    var context = LocalContext.current
    var meter by remember {
        mutableStateOf(TextFieldValue())
    }
    var amount by remember {
        mutableStateOf(TextFieldValue())
    }
    var showDialog by remember { mutableStateOf(false) }


    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        OutlinedTextField(
            value = meter,
            onValueChange = { meter=it},
            label = { Text("Enter Meter Number") },
            modifier = Modifier
                .align(
                    Alignment.CenterHorizontally
                )
                .padding(40.dp)
        )
        OutlinedTextField(
            value = amount,
            onValueChange ={ input ->
                amount = input

            },
            label = { Text("Enter Amount") },


            modifier = Modifier
                .align(
                    Alignment.CenterHorizontally
                )
                .padding(40.dp)
        )

        Button(
            onClick = {
                val inputAmount = amount.text.toDoubleOrNull()

                if (meter.text=="1234567" && inputAmount != null){
                    showDialog = true
                }
                else{
                    Toast.makeText(context, "the meter number does not exit", Toast.LENGTH_SHORT).show()
                    Log.d("Friends", "log in clicked")

                }
            },

            content = {
                Text(
                    text = "Buy eletricity"
                )
            },
            modifier = Modifier
                .align(
                    Alignment.CenterHorizontally
                )
        )
        if (showDialog) {
            AlertDialog(
                onDismissRequest = {
                    showDialog = false
                },
                title = {
                    Text("Conformation")
                },
                text = {
                    Text("Confirm you want to buy a Zesa token for meter Number ${meter.text} with amount ${amount.text}")
                },
                confirmButton = {
                    Button(
                        onClick = {
                            showDialog = false
                            Toast.makeText(context, "Your token number is 1234 5678 9101", Toast.LENGTH_SHORT).show()
                        }
                    ) {
                        Text("Confirm")
                    }
                },
                dismissButton = {
                    Button(
                        onClick = {
                            showDialog = false
                            Toast.makeText(context, "You cancelle your token payment", Toast.LENGTH_SHORT).show()
                        }
                    ) {
                        Text("Cancel")
                    }
                }
            )
        }




    }
}

@Composable
fun BuyAirtime( modifier: Modifier = Modifier) {
    var context = LocalContext.current
    var phonenumber by remember {
        mutableStateOf(TextFieldValue())
    }
    var amount by remember {
        mutableStateOf(TextFieldValue())
    }
    var showDialog by remember { mutableStateOf(false) }


    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        OutlinedTextField(
            value = phonenumber,
            onValueChange = { phonenumber=it},
            label = { Text("Enter Phone Number") },
            modifier = Modifier
                .align(
                    Alignment.CenterHorizontally
                )
                .padding(40.dp)
        )
        OutlinedTextField(
            value = amount,
            onValueChange ={ input ->
                amount = input

            },
            label = { Text("Enter Amount") },


            modifier = Modifier
                .align(
                    Alignment.CenterHorizontally
                )
                .padding(40.dp)
        )

        Button(
            onClick = {
                val inputAmount = amount.text.toDoubleOrNull()

                if (phonenumber.text=="1234567" && inputAmount != null){
                    showDialog = true
                }
                else{
                    Toast.makeText(context, "the phone number does not exit", Toast.LENGTH_SHORT).show()


                }
            },

            content = {
                Text(
                    text = "Buy Airtime"
                )
            },
            modifier = Modifier
                .align(
                    Alignment.CenterHorizontally
                )
        )
        if (showDialog) {
            AlertDialog(
                onDismissRequest = {
                    showDialog = false
                },
                title = {
                    Text("Conformation")
                },
                text = {
                    Text("Confirm you want to buy airtime for Phone Number ${phonenumber.text} with amount ${amount.text}")
                },
                confirmButton = {
                    Button(
                        onClick = {
                            showDialog = false
                            Toast.makeText(context, "your transaction was successful", Toast.LENGTH_SHORT).show()
                        }
                    ) {
                        Text("Confirm")
                    }
                },
                dismissButton = {
                    Button(
                        onClick = {
                            showDialog = false
                            Toast.makeText(context, "You cancelle your airtime payment", Toast.LENGTH_SHORT).show()
                        }
                    ) {
                        Text("Cancel")
                    }
                }
            )
        }




    }
}
@Composable
fun CashOut( modifier: Modifier = Modifier) {
    var context = LocalContext.current

    var amount by remember {
        mutableStateOf(TextFieldValue())
    }
    var showDialog by remember { mutableStateOf(false) }


    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        OutlinedTextField(
            value = amount,
            onValueChange ={ input ->
                amount = input

            },
            label = { Text("Enter Amount") },


            modifier = Modifier
                .align(
                    Alignment.CenterHorizontally
                )
                .padding(40.dp)
        )

        Button(
            onClick = {
                val inputAmount = amount.text.toDoubleOrNull()

                if (inputAmount != null){
                    showDialog = true
                }
                else{
                    Toast.makeText(context, "mount cn not be null", Toast.LENGTH_SHORT).show()


                }
            },

            content = {
                Text(
                    text = "Cash Out"
                )
            },
            modifier = Modifier
                .align(
                    Alignment.CenterHorizontally
                )
        )
        if (showDialog) {
            AlertDialog(
                onDismissRequest = {
                    showDialog = false
                },
                title = {
                    Text("Conformation")
                },
                text = {
                    Text("Confirm you want make a cash out for ${amount.text} ")
                },
                confirmButton = {
                    Button(
                        onClick = {
                            showDialog = false
                            Toast.makeText(context, "your transaction was successfull", Toast.LENGTH_SHORT).show()
                        }
                    ) {
                        Text("Confirm")
                    }
                },
                dismissButton = {
                    Button(
                        onClick = {
                            showDialog = false
                            Toast.makeText(context, "You cancelled your cashout", Toast.LENGTH_SHORT).show()
                        }
                    ) {
                        Text("Cancel")
                    }
                }
            )
        }




    }
}
@Composable
fun NavGraph(navController: NavHostController) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screens.Login.route
    ){
    composable(Screens.Login.route) {
        LoginView(navController)
    }
        composable(Screens.BuyElectricity.route) {
            BuyEletricity()
        }
        composable(Screens.BuyAirtime.route) {
            BuyAirtime()
        }
        composable(Screens.Choose.route) {
            Choose(navController)
        }
        composable(Screens.CashOut.route) {
            CashOut()
        }
        // Other screens
    }
}


sealed class Screens(val route: String) {
    object Login : Screens("login")
    object BuyElectricity : Screens("buyElectricity")
    object BuyAirtime : Screens("buyAirtime")
    object CashOut : Screens("cashout")
    object Choose : Screens("choose")

}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    val navController = rememberNavController()
    HelloCpmposeTheme {
        LoginView(navController = navController)
    }
}