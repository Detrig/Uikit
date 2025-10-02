package github.detrig.composetutorial.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.LocalActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import github.detrig.composetutorial.di.ProvideViewModel

class MainActivity : ComponentActivity() {
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = (application as ProvideViewModel).viewModel(MainViewModel::class.java)
        viewModel.init(savedInstanceState == null)
        setContent {
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .systemBarsPadding(),
                color = MaterialTheme.colorScheme.background
            ) {

                Container(viewModel)

            }
        }
    }
}

@Composable
fun Container(viewModel: MainViewModel) {
    val state by viewModel.screen().collectAsState()
    val activity = LocalActivity.current

    BackHandler {
        if (!viewModel.comeback()) {
            activity?.finish()
        }
    }
    state.Show()
}


//@Composable
//fun ServersList(servers: List<ServerInfo>) {
//    LazyColumn(
//        verticalArrangement = Arrangement.spacedBy(8.dp),
//    ) {
//        item {
//            ArtistCardRow()
//        }
//        items(servers) { server ->
//            ServerItem(server)
//        }
//    }
//}
//
//
//@Composable
//fun ServerItem(server: ServerInfo) {
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(8.dp),
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//        Image(
//            painter = painterResource(getFlagResource(server.country)),
//            contentDescription = "Flag of ${server.country}",
//            modifier = Modifier.size(40.dp)
//        )
//
//        Text(
//            text = server.country,
//            fontSize = 20.sp,
//            color = Color.Black,
//            modifier = Modifier
//                .weight(1f)
//                .padding(horizontal = 8.dp)
//        )
//
//        Image(
//            painter = painterResource(R.drawable.internet_l_3),
//            contentDescription = "Connection fine",
//            modifier = Modifier.size(40.dp)
//        )
//    }
//}
//
//@Composable
//fun ArtistCardRow() {
//    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier) {
//        Image(
//            painter = painterResource(R.drawable.ic_launcher_background),
//            contentDescription = "Artist image"
//        )
//        Column {
//            Text("artist.name")
//            Text("artist.lastSeenOnline")
//        }
//    }
//}
//
//fun getFlagResource(country: String): Int {
//    return when (country) {
//        "FINLAND" -> R.drawable.finland
//        "RUSSIA" -> R.drawable.russia
//        else -> R.drawable.ic_launcher_foreground
//    }
//}
//
//data class ServerInfo(
//    val id: String = "FUCK",
//    val country: String = "FINLAND",
//    val city: String = "XELSINKI",
//    val key: String = "1isjfjksdf89opweufjui3e4g="
//)