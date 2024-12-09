import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tradetracker.R
import com.example.tradetracker.ui.theme.bg
import com.example.tradetracker.ui.components.NavigationBar
import com.example.tradetracker.ui.components.buttons.HomeScreenBtn

@Composable
fun HomeScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(bg),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                HomeScreenBtn(
                    text = "PROFILE",
                    iconResId = R.drawable.baseline_account_circle_24,
                    destination = "home",
                    navController = navController
                )
                Spacer(modifier = Modifier.width(16.dp))
                HomeScreenBtn(
                    text = "ASSETS",
                    iconResId = R.drawable.finance_24dp_e8eaed_fill0_wght400_grad0_opsz24,
                    destination = "assets",
                    navController = navController
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                HomeScreenBtn(
                    text = "ADD",
                    iconResId = R.drawable.baseline_add_24,
                    destination = "add",
                    navController = navController
                )
                Spacer(modifier = Modifier.width(16.dp))
                HomeScreenBtn(
                    text = "SETTINGS",
                    iconResId = R.drawable.baseline_build_24,
                    destination = "settings",
                    navController = navController
                )
            }
        }

        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
        ) {
            NavigationBar(navController = navController)
        }
    }
}
