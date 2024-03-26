import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.hellocompose.ui.Greeting
import com.example.hellocompose.ui.theme.HelloComposeTheme

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
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HelloComposeTheme {
        ScreenTwo({})
    }
}