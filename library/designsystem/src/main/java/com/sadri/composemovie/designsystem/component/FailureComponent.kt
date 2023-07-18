package com.sadri.composemovie.designsystem.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import com.sadri.composemovie.core.extension.getUiMessage
import com.sadri.composemovie.core.extension.toNetworkException
import com.sadri.composemovie.designsystem.R
import com.sadri.composemovie.designsystem.theme.space

@Composable
fun FailureComponent(
  error: Throwable,
  modifier: Modifier = Modifier,
  color: Color = MaterialTheme.colorScheme.onBackground,
  onRetryClick: () -> Unit = {}
) {
  val context = LocalContext.current
  FailureComponent(
    modifier,
    title = "",
    description = error.toNetworkException().getUiMessage(context),
    onRetryClick = onRetryClick,
    color = color
  )
}

@Composable
fun FailureComponent(
  modifier: Modifier = Modifier,
  title: String,
  description: String? = null,
  color: Color = MaterialTheme.colorScheme.onBackground,
  onRetryClick: () -> Unit = {},
) {

  Column(
    modifier = modifier,
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Icon(
      tint = color,
      painter = painterResource(id = R.drawable.ic_retry),
      contentDescription = description ?: title,
      modifier = Modifier.clickable { onRetryClick() }
    )
    Text(
      text = title,
      style = MaterialTheme.typography.headlineSmall,
      color = color
    )

    description?.let {
      Text(
        modifier = Modifier.padding(
          horizontal = MaterialTheme.space.medium,
          vertical = MaterialTheme.space.small
        ),
        text = it,
        style = MaterialTheme.typography.bodyMedium,
        color = color
      )
    }
  }
}