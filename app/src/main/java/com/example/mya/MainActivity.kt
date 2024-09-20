package com.example.mya


import android.icu.text.ListFormatter.Width
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposableTarget
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.mya.ui.theme.MyATheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
//import com.example.mya.ui.screens.AppContent
import com.example.mya.ui.screens.HomeScreen
import com.example.mya.ui.screens.MenuScreen

//import androidx.navigation.compose.NavHostController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            AppContent()

            //ComposeMultiScreenApp()
           /* Column(
                modifier = Modifier.fillMaxSize()
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
            ){
                CustomText()
                Picture()
                Content1()
                //Text(text = "Simple Text")
                //ModifierExample()
                //ModifierExample2()
                //ModifierExample3()
            }*/
        }
    }
}
@Composable
fun AppContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(red =15 , green =15 , blue= 16))
    ) {
        TopBarMenu()
        Spacer(modifier = Modifier.height(16.dp))
        LiveChannelsSection()
        Spacer(modifier = Modifier.height(16.dp))
        FollowedCategoriesSection()
        Spacer(modifier = Modifier.height(16.dp))
        TextChannels()
        RecommendedChannelsSection()
    }
}

@Preview()
@Composable
fun TopBarMenu() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Icon(
            painter = painterResource(id = R.drawable.ic_user),
            contentDescription = "Perfil",
            tint = colorResource(id =R.color.userColor),
            modifier = Modifier.size(40.dp) // Ajusta el tamaño si es necesario
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(30.dp)
        ) {
            BadgedBox(badge = {
                Badge { Text("1") }
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_message),
                    contentDescription = "Primera notificación",
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )
            }


            BadgedBox(badge = {
                Badge { Text("2") }
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_notifications),
                    contentDescription = "Segunda notificación",
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )
            }

            Button(onClick = {  },
                colors = ButtonDefaults.buttonColors(Color(0xFF353535))) {
                Image(
                    painterResource(R.drawable.btn_crear),
                    contentDescription = "Boton crear",
                    modifier = Modifier
                        .wrapContentSize()
                )

            }
        }
    }
}

@Preview()
@Composable
fun LiveChannelsSection() {
    Column(
        modifier = Modifier
            .padding(16.dp)
    ) {
        Text(
            text = "Tus canales en vivo",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painterResource(R.drawable.r),
                contentDescription = "Imagen de canal",
                modifier = Modifier
                    .height(height = 80.dp)
                    .width(width = 150.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(15.dp))
            Column {
                Row {
                    Image(
                        painterResource(R.drawable.fro),
                        contentDescription = "Imagen de canal",
                        modifier = Modifier
                            .padding(end = 5.dp)
                            .height(height = 23.dp)
                            .width(width = 23.dp),
                        contentScale = ContentScale.Crop
                    )
                    Text(text = "RocketLeague", fontWeight = FontWeight.Bold, color = Color.White, fontSize = 17.sp, modifier = Modifier .padding(vertical = 4.dp))
                }

                Text(text = "Team BDS vs M8 Alpine | Roc....",color = Color.White, fontSize = 16.sp,modifier = Modifier .padding(vertical = 4.dp))
                Text(text = "Rocket League",color = Color.White, fontSize = 14.sp, modifier = Modifier .padding(vertical = 5.dp))
                Row {
                    Text(
                        text = "Esports",
                        color = Color.White,fontSize = 12.sp,
                        modifier = Modifier
                            .background(Color(0xFF2a292e), shape = RoundedCornerShape(10.dp)) // Fondo gris y esquinas redondeadas
                            .padding(4.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "English",
                        color = Color.White,fontSize = 12.sp,
                        modifier = Modifier
                            .background(Color(0xFF2a292e), shape = RoundedCornerShape(10.dp)) // Fondo gris y esquinas redondeadas
                            .padding(4.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "DropsEnabled",
                        color = Color.White,fontSize = 12.sp,
                        modifier = Modifier
                            .background(Color(0xFF2a292e), shape = RoundedCornerShape(10.dp)) // Fondo gris y esquinas redondeadas
                            .padding(4.dp)
                    )

                }
            }
        }
    }
}

@Preview()
@Composable
fun FollowedCategoriesSection() {
    Column(
        modifier = Modifier
            .background(Color(red = 15, green = 15, blue = 16))
            .padding(16.dp)
    ) {
        Text(
            text = "Categorías que sigues",
            fontSize = 20.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))

        // Lista de categorías con viewers
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(listOf(
                CategoryData("Overwatch 2", R.drawable.overwatch2, "14.9 K"),
                CategoryData("Fortnite", R.drawable.fort, "50.6 K"),
                CategoryData("Tom Clancy's R6", R.drawable.r6, "50.3 K")
            )) { category ->
                CategoryCard(category.title, category.imageRes, category.viewers)
            }
        }
    }
}

data class CategoryData(val title: String, val imageRes: Int, val viewers: String)

@Composable
fun CategoryCard(title: String, imageRes: Int, viewers: String) {
    Card(
        shape = RectangleShape,
        modifier = Modifier
            .wrapContentHeight()
            .width(130.dp)
            .padding(vertical = 8.dp)
            .background(Color(red = 15, green = 15, blue = 16))
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .background(Color(red = 15, green = 15, blue = 16))
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = title,
                modifier = Modifier.height(150.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                color = Color.White,
                modifier = Modifier
                    .background(Color(red = 15, green = 15, blue = 16))
                    .padding(top = 6.dp),
                textAlign = TextAlign.Left
            )
            Row(horizontalArrangement = Arrangement.Start) {
                Icon(
                    painter = painterResource(id = R.drawable.viwers),
                    contentDescription = "viewers",
                    tint = Color.Red,
                    modifier = Modifier.size(16.dp).align(Alignment.CenterVertically).padding(top = 4.dp)
                )
                Text(
                    text = viewers,
                    fontSize = 12.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .background(Color(red = 15, green = 15, blue = 16))
                        .padding(top = 4.dp)
                )
            }
        }
    }
}





@Preview
@Composable
fun TextChannels(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(
            text = "Canales recomendados para ti",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
    }
}
@Preview
@Composable
fun RecommendedChannelsSection() {
    Box(modifier = Modifier.fillMaxSize()
        .padding(horizontal = 16.dp)) {

        // Contenido desplazable
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 20.dp)
                .verticalScroll(rememberScrollState()) // Habilitar el desplazamiento vertical
        ) {
            Spacer(modifier = Modifier.height(3.dp))


            val channels = listOf(
                ChannelData("Aspen", R.drawable.v1, R.drawable.p1, "TOP 50 SUPPORT WO...", "Overwatch 2", listOf( "English")),
                ChannelData("Jay3", R.drawable.v2, R.drawable.p2, "BONUS BITS START T...", "Overwatch 2", listOf("FPS", "Shooter", "Multiplayer")),
                ChannelData("RocketLeague", R.drawable.r, R.drawable.fro, "Team BDS vs M8 Alpine | Roc....", "Rocket League", listOf("Esports", "English", "DropsEnabled")),

                )

            channels.forEach { channel ->
                LiveChannelCard(channel)
                Spacer(modifier = Modifier.height(16.dp))
            }
        }

        // Menú fijo en la parte inferior
        BottomMenu(modifier = Modifier.align(Alignment.BottomCenter))
    }
}

data class ChannelData(
    val channelName: String,
    val channelImage: Int,
    val logoImage: Int,
    val title: String,
    val game: String,
    val tags: List<String>
)

@Composable
fun LiveChannelCard(channel: ChannelData) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(channel.channelImage),
            contentDescription = "Imagen de canal",
            modifier = Modifier
                .height(80.dp)
                .width(150.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(15.dp))
        Column {
            Row {
                Image(
                    painter = painterResource(channel.logoImage),
                    contentDescription = "Imagen de canal",
                    modifier = Modifier
                        .padding(end = 5.dp)
                        .height(23.dp)
                        .width(23.dp),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = channel.channelName,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 17.sp,
                    modifier = Modifier.padding(vertical = 4.dp)
                )
            }
            Text(text = channel.title, color = Color.White, fontSize = 16.sp, modifier = Modifier.padding(vertical = 4.dp))
            Text(text = channel.game, color = Color.White, fontSize = 14.sp, modifier = Modifier.padding(vertical = 5.dp))
            Row {
                channel.tags.forEach { tag ->
                    Text(
                        text = tag,
                        color = Color.White,
                        fontSize = 12.sp,
                        modifier = Modifier
                            .background(Color(0xFF2a292e), shape = RoundedCornerShape(10.dp))
                            .padding(4.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                }
            }
        }
    }
}

@Composable
fun BottomMenu(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .background(Color(red =15 , green =15 , blue= 16))
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 5.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                imageVector = Icons.Default.Favorite, // Cambia por tu ícono morado
                contentDescription = "Siguiendo",
                tint = Color(0xFF9B59B6) // Morado
            )
            Text(text = "Siguiendo", color = Color(0xFF9B59B6), fontSize = 12.sp)
        }

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_queue_play_next_24), // Cambia por tu ícono de pantalla
                contentDescription = "Feed",
                tint = Color.White
            )
            Text(text = "Feed", color = Color.White, fontSize = 12.sp)
        }

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_explore_24),
                contentDescription = "Descubrir",
                tint = Color.White
            )
            Text(text = "Descubrir", color = Color.White, fontSize = 12.sp)
        }

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_content_copy_24),
                contentDescription = "Explorar",
                tint = Color.White
            )
            Text(text = "Explorar", color = Color.White, fontSize = 12.sp)
        }

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                imageVector = Icons.Default.Search, // Cambia por tu ícono de lupa
                contentDescription = "Buscar",
                tint = Color.White
            )
            Text(text = "Buscar", color = Color.White, fontSize = 12.sp)
        }
    }
}
/*
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

//@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyATheme {
        Greeting("Cristian")
    }
}

//@Preview(showBackground = true)
@Composable
fun ModifierExample(){
    Column (
        modifier = Modifier
            .padding(24.dp)
    ){
        Text(text = "Hello World")
    }
}

//@Preview(showBackground = true)
@Composable
fun ModifierExample2(){
    Column (
        modifier = Modifier
            .padding(24.dp)
            .fillMaxWidth()
            .clickable (onClick = {clickAction()})
    ){
        Text(text = "Hello World")
    }
}

//@Preview(showBackground = true)
@Composable
fun ModifierExample3(){
    Column (
        modifier = Modifier
            .fillMaxHeight()
            .padding(16.dp)
            .background(Color.Cyan)
            .border(width = 2.dp, color= Color.Green)
            .width(200.dp ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ){
        Text(text = "Item 1")
        Text(text = "Item 2")
        Text(text = "Item 3")
        Text(text = "Item 4")
    }
}

//@Preview(showBackground = true)
@Composable
fun CustomText(){
    Column{
        Text(
            stringResource(R.string.hello_world_text),
            color= colorResource(R.color.purple_700),
            fontSize = 28.sp,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.ExtraBold
        )
        val gradientColors = listOf(Color.Cyan,Color.Blue)
        Text(
            stringResource(R.string.hello_world_text),
            style = TextStyle(brush = Brush.linearGradient(colors = gradientColors))
        )
    }
}

//@Preview(showBackground = true)
@Composable
fun Picture(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth(),
            painter = painterResource(R.drawable.a) ,
            contentDescription ="Logo Android",
            contentScale = ContentScale.Crop
        )
    }
}

//@Preview(showBackground = true)
@Composable
fun Content1(){
    Card(
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxWidth()
            .padding(5.dp)
    ){
        Text(text="This is a title",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(10.dp)
        )
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(height = 200.dp),
            painter = painterResource(id = R.drawable.a),
            contentDescription = "Android Logo",
            contentScale = ContentScale.Crop
        )
        Text(stringResource(R.string.text_card),
            textAlign = TextAlign.Justify,
            lineHeight = 18.sp,
            modifier = Modifier
                .padding(10.dp)
        )
    }
}

//@Preview(showBackground = true)
@Composable
fun Content2(){
    Card(
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxWidth()
            .padding(5.dp)
    ){
     Row{
         Image(
             modifier = Modifier
                 .width(width = 150.dp)
                 .height(height = 150.dp),
             painter = painterResource(id = R.drawable.a),
             contentDescription = "Android Logo",
             contentScale = ContentScale.Crop
         )

         Column {
             Text(text="This is a title",
                 fontSize = 16.sp,
                 fontWeight = FontWeight.Bold,
                 modifier = Modifier
                     .padding(10.dp)
             )
             Text(stringResource(R.string.text_card),
                 textAlign = TextAlign.Justify,
                 maxLines = 7,
                 lineHeight = 16.sp,
                 modifier = Modifier
                     .padding(10.dp)
             )
         }
     }
    }
}

@Preview(showBackground = true)
@Composable
fun BoxExample1(){
    Box(
        modifier = Modifier
            .background(Color.DarkGray)
            .fillMaxWidth()
            .padding(5.dp)
    ){
        Image(painterResource(R.drawable.a),
            contentDescription = "Android Logo",
            contentScale = ContentScale.FillBounds
            )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp,150.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                Icons.Filled.AccountCircle,
                contentDescription = "Icon"
            )
            Text(text = "Text")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BoxExample2(){
    Box(
        modifier = Modifier
            .background(Color.Magenta)
            .padding(5.dp)
            .size(250.dp)
    ) {
        Text(text = "TopStart", Modifier.align(Alignment.TopStart))
        Text(text = "TopEnd", Modifier.align(Alignment.TopEnd))
        Text(text = "CenterStart", Modifier.align(Alignment.CenterStart))
        Text(text = "Center", Modifier.align(Alignment.Center))
        Text(text = "CenterEnd", Modifier.align(Alignment.CenterEnd))
        Text(text = "BottomStart", Modifier.align(Alignment.BottomStart))
        Text(text = "BottomEnd", Modifier.align(Alignment.BottomEnd))
    }
}

fun clickAction(){
    println("Column Clicked")
}


@Composable
fun ComposeMultiScreenApp(){
    val navController = rememberNavController()
    Surface(color = Color.White) {
        SetupNavGraph(navController = navController)
    }
}

@Composable
fun SetupNavGraph(navController: NavHostController){
    NavHost(navController = navController, startDestination = "menu"){
        composable("menu"){ MenuScreen(navController)}
        composable("home"){ HomeScreen(navController) }
    }
}
*/



