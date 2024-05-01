package fr.thegostsniperfr.android_basic_navigation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import fr.thegostsniperfr.android_basic_navigation.ui.theme.Android_Basic_Navigation_Theme


@Preview(showBackground = true)
@Composable
fun IteratorBtnScreen() {
    Android_Basic_Navigation_Theme {
        Column {
            Greeting("Android")
            HelloBtn()
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun HelloBtn() {
    var buttonText by remember { mutableStateOf(getNextMsg()) }

    Button(
        onClick = {
            buttonText = getNextMsg()
        }
    ) {
        Text(text = buttonText)
    }
}


val msgList = listOf("こんにちは！", "さよんなら。", "かわいいです");
var msgIterator = msgList.iterator();

fun getNextMsg() : String{
    if(!msgIterator.hasNext()) {
        msgIterator = msgList.iterator();
    }

    val msg = msgIterator.next()
    println("Next msg : $msg")
    return msg;
}


@Preview(showBackground = true)
@Composable
fun IteratorBtnScreenPreview() {
    IteratorBtnScreen()
}