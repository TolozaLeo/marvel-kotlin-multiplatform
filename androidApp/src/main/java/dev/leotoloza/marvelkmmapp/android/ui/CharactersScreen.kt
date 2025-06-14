package dev.leotoloza.marvelkmmapp.android.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.leotoloza.marvelkmmapp.domain.model.Character
import dev.leotoloza.marvelkmmapp.android.ui.components.CharacterCard

@Composable
fun CharactersScreen (
    modifier: Modifier = Modifier
){
//    val viewModel : CharactersViewModel() = hiltViewModel()
//    val characterList = viewModel.getCharacters()
    val characterList = listOf(
        Character(1, "Iron Man", "Millonario, genio e inventor. Usa una armadura de alta tecnología.", "https://th.bing.com/th/id/OIP.51MFf4byP_XzU4ywKQioGgHaNH?r=0&rs=1&pid=ImgDetMain"),
        Character(2, "Spider-Man", "Joven con poderes arácnidos que lucha contra el crimen."),
        Character(3, "Captain Marvel", "Piloto con poderes cósmicos y fuerza sobrehumana."),
        Character(4, "Black Panther", "Rey de Wakanda, experto en combate y tecnología."),
        Character(5, "Doctor Strange", "Hechicero Supremo y protector del multiverso.")
    )

    LazyColumn(
        modifier = modifier.fillMaxSize().background(color = Color.Gray),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ){
        items(characterList){
            CharacterCard(character = it)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCharacterScreen(){
    CharactersScreen()
}