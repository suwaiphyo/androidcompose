package com.example.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.DefaultTintColor
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthday.ui.theme.HappyBirthdayTheme

class BusinessCardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthdayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        NameInformation(
            logo = R.drawable.android_logo,
            name = "Su Wai Phyo",
            title = "Android Software Engineer",
            modifier = Modifier
                .wrapContentSize()
                .align(Alignment.Center)
        )
        ContactInformation(
            phone = "+66648989278",
            social = "@motor_pasat",
            email = "suwaiphyo1985@gmail.com",
            modifier = Modifier
                .wrapContentSize()
                .align(Alignment.BottomCenter)
        )
    }
}

@Composable
fun NameInformation(
    logo: Int, name: String, title: String, modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .width(100.dp)
                .height(100.dp)
                .background(
                    colorResource(id = R.color.dark_grey),
                    shape = RectangleShape
                )
        ) {
            Image(
                painter = painterResource(logo),
                contentDescription = null
            )
        }
        Text(
            text = name,
            color = colorResource(id = R.color.teal_200),
            fontSize = 34.sp,
            fontFamily = FontFamily.Monospace
        )
        Text(
            text = title,
            color = colorResource(id = R.color.black),
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Cursive
        )
    }
}

@Composable
fun ContactInformation(
    phone: String, social: String, email: String, modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Row {
            Icon(
                imageVector = Icons.Filled.Phone,
                tint = colorResource(id = R.color.teal_200),
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(20.dp))
            Text(text = phone, color = colorResource(id = R.color.grey))
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row {
            Icon(
                imageVector = Icons.Filled.Share,
                tint = colorResource(id = R.color.teal_200),
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(20.dp))
            Text(text = social, color = colorResource(id = R.color.grey))
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row {
            Icon(
                imageVector = Icons.Filled.Email,
                tint = colorResource(id = R.color.teal_200),
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(20.dp))
            Text(text = email, color = colorResource(id = R.color.grey))
        }
        Spacer(modifier = Modifier.height(40.dp))
    }
}

@Composable
fun NamePreview() {
    HappyBirthdayTheme {
        NameInformation(
            logo = R.drawable.android_logo, name = "Su Wai", title = "Android Developer"
        )
    }
}

@Composable
fun ContactInfoPreview() {
    ContactInformation(phone = "+66648989278", social = "@motor_pasat", email = "suwaiphyo1985@gmail.com")
}

@Preview(showSystemUi = true, showBackground = false)
@Composable
fun BusinessPreview() {
    BusinessCard()
}