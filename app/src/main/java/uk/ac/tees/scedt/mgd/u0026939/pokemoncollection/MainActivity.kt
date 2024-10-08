package uk.ac.tees.scedt.mgd.u0026939.pokemoncollection

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uk.ac.tees.mgd.u0026939.recompose.ui.theme.RecomposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HelloScreen()
        }
    }
}

@Composable
fun HelloScreen() {
    var name by rememberSaveable {
        mutableStateOf("")
    }
    Hello(name) {it -> name = it}
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Hello(name: String, onNameChange : (String) -> Unit) {
    Column {
        if (name.isNotEmpty()) {
            Text(
                text = "Hi $name",
                modifier = Modifier.padding(bottom = 8.dp),
                style = MaterialTheme.typography.headlineMedium
            )
        }
        OutlinedTextField(
            value = name,
            onValueChange = onNameChange,
            label = { Text(text = "name") },
            modifier = Modifier.padding(8.dp)
        )
        Button(
            onClick = { onNameChange("") },
            modifier = Modifier.padding(8.dp)
        ) {
            Text(text = "Clear!")
        }
    }
}

