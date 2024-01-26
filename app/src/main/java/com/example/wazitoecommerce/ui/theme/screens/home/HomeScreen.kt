package com.example.wazitoecommerce.ui.theme.screens.home

import android.content.Intent
import android.provider.Settings
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.wazitoecommerce.R
import com.example.wazitoecommerce.navigation.ABOUT_URL
import com.example.wazitoecommerce.navigation.ADD_PRODUCTS_URL
import com.example.wazitoecommerce.navigation.VIEW_PRODUCTS_URL
import com.example.wazitoecommerce.ui.theme.WazitoECommerceTheme
import com.example.wazitoecommerce.ui.theme.blu

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController:NavHostController){
    var mContext = LocalContext.current
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //TopAppBar
        TopAppBar(
            title = { Text(text = "Home") },
            navigationIcon = {
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "arrowback"
                    )
                }
            },
            actions = {
                IconButton(onClick = {
                    val settingsIntent = Intent(ADD_PRODUCTS_URL)
                    mContext.startActivity(settingsIntent)
                }) {
                    Icon(
                        imageVector = Icons.Filled.Build,
                        contentDescription = "settings"
                    )
                }
            },
            colors = TopAppBarDefaults.largeTopAppBarColors(blu)
        )

        Spacer(modifier = Modifier.height(5.dp))

        //Text
        Text(text = "Qinetra Laundry & Dry Cleaning is a professional laundry mat that has been dedicated to providing high-quality laundry care & cleaning. We offer multiple services, from wash & fold to ironing & dry cleaning for your Household or Business.",
            fontSize = 15.sp)


        Spacer(modifier = Modifier.height(5.dp))

        Button(onClick = {
            navController.navigate(ABOUT_URL)
        },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp),
            colors = ButtonDefaults.buttonColors(blu),
            shape = RoundedCornerShape(5.dp),
        ) {
            Text(text = "Main Page")
        }

        Spacer(modifier = Modifier.height(5.dp))

        //Logo
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(250.dp),
            contentAlignment = Alignment.Center) {

            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                contentScale = ContentScale.Crop
            )
        }


        Spacer(modifier = Modifier.height(20.dp))


        //Buttons
        Button(onClick = {
            navController.navigate(ADD_PRODUCTS_URL)
        },
            colors = ButtonDefaults.buttonColors(blu),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp),
            shape = RoundedCornerShape(5.dp)) {
            Icon( imageVector = Icons.Default.Add,
                contentDescription = "",
                tint = Color.White)

            Spacer(modifier = Modifier.width(2.dp))

            Text(text = "Add Service")
        }

        Spacer(modifier = Modifier.height(30.dp))

        Button(onClick = {
            navController.navigate(VIEW_PRODUCTS_URL)
        },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp),
            colors = ButtonDefaults.buttonColors(blu),
            shape = RoundedCornerShape(5.dp),
            ) {
            Text(text = "View Services")
        }
    }
}

@Composable
@Preview(showBackground = true)
fun HomeScreenPreview(){
    WazitoECommerceTheme {
        HomeScreen(navController = rememberNavController())
    }
}