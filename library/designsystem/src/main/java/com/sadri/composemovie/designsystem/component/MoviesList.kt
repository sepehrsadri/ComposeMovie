package com.sadri.composemovie.designsystem.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import com.sadri.composemovie.core.model.MovieItemEntity
import com.sadri.composemovie.designsystem.theme.space

@Composable
fun MoviesList(
  modifier: Modifier = Modifier,
  movies: List<MovieItemEntity>
) {
  LazyVerticalGrid(
    verticalArrangement = Arrangement.spacedBy(MaterialTheme.space.small),
    contentPadding = PaddingValues(horizontal = MaterialTheme.space.small),
    horizontalArrangement = Arrangement.spacedBy(MaterialTheme.space.small),
    columns = GridCells.Fixed(2)
  ) {
    items(
      count = movies.size,
      key = { index -> movies[index].id }
    ) { index ->
      val movie = movies[index]
      Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
      ) {
        Card(
          shape = MaterialTheme.shapes.extraLarge,
          colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.onSurface),
        ) {
          ImageLoader(
            imageUrl = movie.picture.url,
            modifier = Modifier
              .width(MaterialTheme.space.xGiant)
              .height(MaterialTheme.space.xGiant)
              .padding(MaterialTheme.space.medium)
              .align(Alignment.CenterHorizontally)
          )
          Spacer(modifier = Modifier.height(MaterialTheme.space.small))
          Text(
            text = movie.title,
            style = MaterialTheme.typography.bodyMedium,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
              .padding(MaterialTheme.space.small)
              .align(Alignment.CenterHorizontally)
          )
        }
      }
    }
  }
}