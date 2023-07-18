package com.sadri.composemovie.search.presentation

import androidx.compose.animation.core.Animatable
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.sadri.composemovie.designsystem.R
import com.sadri.composemovie.designsystem.animation.AnimationState
import com.sadri.composemovie.designsystem.animation.shakeKeyframes
import com.sadri.composemovie.designsystem.component.ContentDescription
import com.sadri.composemovie.designsystem.theme.space
import kotlinx.coroutines.launch

@Composable
fun SearchBar(
  modifier: Modifier = Modifier,
  hint: String,
  onValueChanged: (String) -> Unit,
  onSubmitSearchClicked: (String) -> Unit,
  defaultText: String = ""
) {

  Row(
    modifier = Modifier
      .fillMaxWidth()
      .padding(horizontal = MaterialTheme.space.medium),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.spacedBy(MaterialTheme.space.medium)
  ) {
    SearchBox(
      modifier = modifier,
      defaultText = defaultText,
      editable = true,
      textHint = hint,
      onValueChanged = onValueChanged,
      onSubmitSearchClicked = onSubmitSearchClicked
    )
  }
}

@Composable
private fun SearchBox(
  modifier: Modifier = Modifier,
  editable: Boolean,
  defaultText: String = "",
  textHint: String = "",
  onValueChanged: (String) -> Unit = {},
  onSubmitSearchClicked: (String) -> Unit = {},
  onBoxClicked: ((String) -> Unit)? = null,
  animationState: AnimationState = AnimationState()
) {

  val textFieldState = rememberSaveable(stateSaver = TextFieldValue.Saver) {
    mutableStateOf(
      TextFieldValue(
        text = defaultText,
        selection = TextRange(defaultText.length)
      )
    )
  }

  val onSubmitClickHandler = remember {
    {
      onSubmitSearchClicked.invoke(textFieldState.value.text)
    }
  }

  Row(
    modifier = boxModifier(onBoxClicked, textFieldState),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.spacedBy(MaterialTheme.space.small)
  ) {
    Icon(
      modifier = Modifier
        .clickable { onSubmitClickHandler.invoke() }
        .padding(MaterialTheme.space.xSmall),
      painter = painterResource(id = R.drawable.ic_search),
      tint = MaterialTheme.colorScheme.onBackground,
      contentDescription = ContentDescription.SEARCH,
    )

    Box {
      BasicTextField(
        modifier = modifier.fillMaxWidth(),
        value = textFieldState.value,
        onValueChange = {
          textFieldState.value = it
          onValueChanged(it.text)
        },
        textStyle = MaterialTheme.typography.labelLarge.copy(
          color = MaterialTheme.colorScheme.onBackground
        ),
        cursorBrush = SolidColor(MaterialTheme.colorScheme.onBackground),
        enabled = editable,
        keyboardOptions = KeyboardOptions(
          keyboardType = KeyboardType.Text,
          imeAction = ImeAction.Search
        ),
        keyboardActions = KeyboardActions {
          onSubmitClickHandler.invoke()
        }
      )

      if (textFieldState.value.text.isEmpty()) {
        HintText(textHint, animationState)
      }
    }
  }
}

@Composable
private fun HintText(textHint: String, animationState: AnimationState) {

  val runAnimationState = animationState.runAnimationState.collectAsState()
  val coroutineScope = rememberCoroutineScope()
  val offsetX = remember { Animatable(0f) }

  LaunchedEffect(key1 = runAnimationState.value) {
    if (runAnimationState.value) {
      coroutineScope.launch {
        offsetX.animateTo(
          targetValue = 0f,
          animationSpec = shakeKeyframes
        )
        animationState.onAnimationEnd()
      }
    }
  }

  Text(
    modifier = Modifier
      .padding(horizontal = MaterialTheme.space.tiny)
      .offset { IntOffset(offsetX.value.toInt(), 0) },
    text = textHint,
    style = MaterialTheme.typography.labelLarge,
    color = MaterialTheme.colorScheme.onSurface
  )
}

@Composable
private fun boxModifier(
  onBoxClicked: ((String) -> Unit)?,
  textFieldState: State<TextFieldValue>
): Modifier {

  val clickModifier = onBoxClicked?.let {
    Modifier.clickable {
      onBoxClicked.invoke(textFieldState.value.text)
    }
  } ?: run { Modifier }

  return Modifier
    .padding(vertical = MaterialTheme.space.xSmall)
    .fillMaxWidth()
    .height(48.dp)
    .clip(MaterialTheme.shapes.large)
    .then(clickModifier)
    .background(MaterialTheme.colorScheme.surface)
    .padding(MaterialTheme.space.small)
}