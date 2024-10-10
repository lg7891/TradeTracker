import HomeScreenBtn
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.dp
import com.example.tradetracker.R
import com.example.tradetracker.ui.theme.bg
import com.example.tradetracker.components.NavigationBar

@Composable
fun HomeScreen() {
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
                    onClick = { /* handle click */ },
                    iconResId = R.drawable.baseline_account_circle_24
                )
                Spacer(modifier = Modifier.width(16.dp))
                HomeScreenBtn(
                    text = "ASSETS",
                    onClick = { /* handle click */ },
                    iconResId = R.drawable.finance_24dp_e8eaed_fill0_wght400_grad0_opsz24
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                HomeScreenBtn(
                    text = "ADD",
                    onClick = { /* handle click */ },
                    iconResId = R.drawable.baseline_add_24
                )
                Spacer(modifier = Modifier.width(16.dp))
                HomeScreenBtn(
                    text = "SETTINGS",
                    onClick = { /* handle click */ },
                    iconResId = R.drawable.baseline_build_24
                )
            }
        }

        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
        ) {
            NavigationBar()
        }
    }
}
