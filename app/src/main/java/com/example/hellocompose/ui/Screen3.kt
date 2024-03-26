import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.hellocompose.ui.theme.HelloComposeTheme

@Composable
fun ScreenThree(
    onScreenSelect: () -> Unit,
    onHomeButtonClick: ()-> Unit
){
    Column(modifier = Modifier
        .fillMaxSize()

    ){
        Text(
            text = "Screen 3 Page !!!",
            fontSize = 33.sp,
            modifier = Modifier
                .fillMaxWidth()
        )
        Button(
            onClick = {
                onHomeButtonClick()
            },
            content = {
                Icon(
                    Icons.Default.Face,
                    contentDescription = ""
                )
                Text(
                    " Go to Home"
                )
            },
            modifier = Modifier

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
                    " Go to Login"
                )
            },
            modifier = Modifier

        )
    }
}
@Preview(showBackground = true)
@Composable
fun ScreenThreePreview() {
    HelloComposeTheme {
        ScreenThree({},{})
    }
}