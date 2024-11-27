
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pruebapractica.Navigation.AppScreen
import com.example.pruebapractica.Scenes.AppMostrarDatos
import com.example.pruebapractica.Scenes.AppPedirDatos

//App Navigation
@Composable
fun AppNavigation(){
    val navControlador= rememberNavController()
    NavHost(navController= navControlador,
        startDestination = AppScreen.PedirScreen.route){
        composable(AppScreen.PedirScreen.route) {
            AppPedirDatos(navControlador)
        }
        composable(
            AppScreen.MostrarScreen.route+"/{text}",
            arguments = listOf(navArgument(name = "text") {
                type = NavType.StringType
            })
        ) {
            it.arguments?.getString("text")?.let { it1 -> AppMostrarDatos(navControlador, it1) }
        }
    }
}
