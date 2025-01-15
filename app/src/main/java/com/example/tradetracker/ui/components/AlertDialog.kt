import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable

@Composable
fun AlertDialog(
    onDismissRequest: () -> Unit,
    dialogTitle: String = "Invalid Input",
    dialogText: String = "Please enter a valid number or decimal number."
) {
    AlertDialog(
        onDismissRequest = { onDismissRequest() },
        title = {
            Text(text = dialogTitle)
        },
        text = {
            Text(text = dialogText)
        },
        confirmButton = {
            TextButton(
                onClick = { onDismissRequest() }
            ) {
                Text("OK")
            }
        }
    )
}
