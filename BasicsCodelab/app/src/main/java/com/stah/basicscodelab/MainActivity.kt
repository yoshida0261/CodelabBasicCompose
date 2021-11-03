package com.stah.basicscodelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stah.basicscodelab.ui.theme.BasicsCodelabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicsCodelabTheme {
                MyApp()
            }
        }
    }
}

@Composable
private fun MyApp() {

    var shouldShowOnboarding by remember {
        mutableStateOf(true)
    }
    if(shouldShowOnboarding) {
        OnboardingScreen( onContinuClicked = { shouldShowOnboarding = false})
    }else{
        Greetings()
    }
    /*
    Surface(color = MaterialTheme.colors.background) {
        // modifier = Modifier.padding(vertical = 4.dp)
        Column(modifier = Modifier.padding(vertical = 4.dp)) {
            for (name in names) {
                Greeting(name = name)
            }
        }

    }

     */
}

@Composable
fun Greetings(names: List<String> = listOf("World", "Compose")) {
    Column(modifier = Modifier.padding(vertical = 4.dp)) {
        for(name in names){
            Greeting(name = name)
        }
    }
}

@Composable
fun OnboardingScreen( onContinuClicked: ()-> Unit){
    Surface {
        Column (
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
                ){
            Text("welcome ")
            Button(
                modifier = Modifier.padding(vertical = 24.dp),
                onClick = onContinuClicked
            ){
                Text("Continue")
            }
        }
    }
}


@Composable
fun Greeting(name: String) {
    val expanded = remember {
        mutableStateOf(false)
    }
    val extraPadding = if (expanded.value) 48.dp else 0.dp


    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row(modifier = Modifier.padding(24.dp)) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = extraPadding)
            ) {
                Text(text = "Hello, ")
                Text(text = name)
            }
            OutlinedButton(
                onClick = { expanded.value = !expanded.value }
            ) {
                Text(if (expanded.value) "show less " else "show more")
            }
        }

    }
}


@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun OnboardingPreview(){
    BasicsCodelabTheme() {
        OnboardingScreen (
            onContinuClicked = {}
        )
    }
}

@Preview(showBackground = true, name = "Text preview", widthDp = 320)
@Composable
fun DefaultPreview() {
    BasicsCodelabTheme {
       // OnboardingScreen()
    //Greeting("Android")
    }
}


