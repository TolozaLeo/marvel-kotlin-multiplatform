package dev.leotoloza.marvelkmmapp.android.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import dev.leotoloza.marvelkmmapp.android.R

@Composable
fun CharacterImage(imageUrl: String?) {
    val painter = rememberAsyncImagePainter(
        model = imageUrl,
        error = painterResource(id = R.drawable.image_not_found),
        placeholder = painterResource(id = R.drawable.place_holder_marvel)
    )

    Image(
        painter = painter,
        contentDescription = null,
        modifier = Modifier
            .size(80.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Color.LightGray),
        contentScale = ContentScale.Crop
    )
}