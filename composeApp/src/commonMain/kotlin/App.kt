import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview

data class Address(val cep: String, val json: String = "")

class Components() {
    companion object {

        @Composable
        fun Render(text: String, show: Boolean) {
            if (text.isNotEmpty() && show) {
                Text(text)
            }
        }
    }
}

@Composable
@Preview
fun App() {
    MaterialTheme {
        var showContent by remember { mutableStateOf(false) }
        var cep by remember { mutableStateOf("Hello") }
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            TextField(
                value = cep,
                onValueChange = { cep = it },
                label = { Text("Informe seu CEP") }
            )
            Divider()
            Button(onClick = { showContent = !showContent }) {
                val greeting = Greeting()
                Text(greeting.hello())
            }
            Divider()
            Components.Render(cep, showContent)
        }
    }
}