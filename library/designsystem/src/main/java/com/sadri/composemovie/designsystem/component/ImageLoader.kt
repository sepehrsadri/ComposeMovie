package com.sadri.composemovie.designsystem.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.bumptech.glide.request.RequestOptions
import com.sadri.composemovie.designsystem.R
import com.skydoves.landscapist.components.imageComponent
import com.skydoves.landscapist.glide.GlideImage
import com.skydoves.landscapist.placeholder.placeholder.PlaceholderPlugin

@Composable
fun ImageLoader(
  modifier: Modifier = Modifier,
  imageUrl: String,
  scaleType: ScaleType = ScaleType.CENTER_CROP,
  placeHolderRes: Int = R.drawable.ic_place_holder,
  loadingImageRes: Int = R.drawable.ic_place_holder,
  failureImageRes: Int = R.drawable.ic_place_holder
) {
  GlideImage(
    modifier = modifier,
    imageModel = imageUrl,
    requestOptions = {
      scaleTypeTransform(scaleType)
    },
    previewPlaceholder = placeHolderRes,
    component = imageComponent {
      +PlaceholderPlugin.Loading(painterResource(id = loadingImageRes))
      +PlaceholderPlugin.Failure(painterResource(id = failureImageRes))
    }
  )
}

private fun scaleTypeTransform(scaleType: ScaleType): RequestOptions {
  return when (scaleType) {
    ScaleType.FIX_CENTER -> RequestOptions.fitCenterTransform()
    ScaleType.CENTER_CROP -> RequestOptions.centerCropTransform()
    ScaleType.CENTER_INSIDE -> RequestOptions.centerInsideTransform()
  }
}

enum class ScaleType {
  CENTER_CROP,
  FIX_CENTER,
  CENTER_INSIDE
}