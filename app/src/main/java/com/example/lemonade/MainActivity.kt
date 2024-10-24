package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LemonadeApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LemonadeApp() {
    Scaffold(
        topBar = {
            // Utilisation de CenterAlignedTopAppBar pour centrer le texte
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Lemonade",
                        fontWeight = FontWeight.Bold,
                        color = Color.Black, // Définition du texte en noir
                        textAlign = TextAlign.Center, // Centrage du texte
                        modifier = Modifier.fillMaxWidth() // Assure que le texte occupe toute la largeur disponible
                    )
                },
                // Définition de la couleur de la barre d'action en jaune
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.Yellow
                )
            )
        }
    ) { innerPadding ->
        // Contenu principal de l'application, avec gestion des marges internes
        LemonadeProcess(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding) // Application du padding interne
                .wrapContentSize(Alignment.Center) // Centrage du contenu principal
        )
    }
}

@Composable
fun LemonadeProcess(modifier: Modifier = Modifier) {
    var currentStep by remember { mutableStateOf(1) }
    var squeezeCount by remember { mutableStateOf(0) }

    // Détermination des ressources d'image et de texte en fonction de l'étape actuelle
    val (imageResource, textResource) = when (currentStep) {
        1 -> Pair(R.drawable.lemon_tree, R.string.lemonTree)
        2 -> Pair(R.drawable.lemon_squeeze, R.string.lemon)
        3 -> Pair(R.drawable.lemon_drink, R.string.glassOfLemon)
        else -> Pair(R.drawable.lemon_restart, R.string.emptyGlass)
    }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Image cliquable avec gestion des étapes
        Image(
            painter = painterResource(id = imageResource),
            contentDescription = stringResource(id = textResource),
            modifier = Modifier
                .clickable {
                    when (currentStep) {
                        1 -> {
                            currentStep = 2
                            squeezeCount = (2..4).random()
                        }
                        2 -> {
                            squeezeCount--
                            if (squeezeCount == 0) {
                                currentStep = 3
                            }
                        }
                        3 -> {
                            currentStep = 4
                        }
                        4 -> {
                            currentStep = 1
                        }
                    }
                }
                .padding(16.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        // Texte décrivant l'étape actuelle
        Text(
            text = stringResource(id = textResource),
            color = Color.Green,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            textDecoration = TextDecoration.None,
            modifier = Modifier.padding(top = 16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LemonadeAppPreview() {
    LemonadeTheme {
        LemonadeApp()
    }
}
