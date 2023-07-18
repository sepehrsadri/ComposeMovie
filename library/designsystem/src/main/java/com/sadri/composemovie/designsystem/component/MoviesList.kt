package com.sadri.composemovie.designsystem.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.sadri.composemovie.core.model.MovieItemEntity
import com.sadri.composemovie.designsystem.theme.space

@Composable
fun MoviesList(
  modifier: Modifier = Modifier,
  movies: List<MovieItemEntity>
) {
  LazyVerticalGrid(
    contentPadding = PaddingValues(horizontal = MaterialTheme.space.large),
    verticalArrangement = Arrangement.spacedBy(MaterialTheme.space.large),
    horizontalArrangement = Arrangement.spacedBy(MaterialTheme.space.large),
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
        ImageLoader(
          imageUrl = movie.picture.url,
          modifier = Modifier
            .width(MaterialTheme.space.giant)
            .height(MaterialTheme.space.giant)
        )
        Spacer(modifier = Modifier.height(MaterialTheme.space.small))
        Text(
          text = movie.title,
          style = MaterialTheme.typography.bodyMedium
        )
      }
    }
  }
}