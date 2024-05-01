package com.example.lab4_hello_world.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lab4_hello_world.ui.theme.Lab4_Hello_worldTheme


@Preview(showBackground = true)
@Composable
fun IteratorBtnScreen() {
    Lab4_Hello_worldTheme {
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