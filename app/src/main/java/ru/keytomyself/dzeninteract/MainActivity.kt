package ru.keytomyself.dzeninteract

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.hilt.navigation.compose.hiltViewModel
import ru.keytomyself.dzeninteract.screens.pager.PagerScreen
import ru.keytomyself.dzeninteract.screens.pager.PagerViewModel
import ru.keytomyself.dzeninteract.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        // Handle the splash screen transition.
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                val pagerViewModel = hiltViewModel<PagerViewModel>()
                PagerScreen(
                    pagerViewModel = pagerViewModel
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AppTheme {
    }
}