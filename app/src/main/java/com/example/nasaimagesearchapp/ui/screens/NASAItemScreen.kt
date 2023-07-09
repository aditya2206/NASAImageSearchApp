package com.example.nasaimagesearchapp.ui.screens

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Divider
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import com.example.nasaimagesearchapp.R
import com.example.nasaimagesearchapp.data.model.ImageModel

    @Composable
    fun NASAItemScreen(imageModel: ImageModel, onNavIconPressed: () -> Unit = { }) {
        val scrollState = rememberScrollState()

        Column(modifier = Modifier.fillMaxSize()) {
            BoxWithConstraints(modifier = Modifier.weight(1f)) {
                Surface {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .verticalScroll(scrollState),
                    ) {
                        ImageHeader(
                            scrollState,
                            imageModel,
                            this@BoxWithConstraints.maxHeight
                        )
                        ProfileContent(imageModel, this@BoxWithConstraints.maxHeight)
                    }
                }
            }
        }
    }

    @Composable
    private fun ImageHeader(
        scrollState: ScrollState,
        imageModel: ImageModel,
        containerHeight: Dp
    ) {
        val offset = (scrollState.value / 2)
        val offsetDp = with(LocalDensity.current) { offset.toDp() }

        SubcomposeAsyncImage(
            modifier = Modifier
                .heightIn(max = containerHeight / 2)
                .fillMaxWidth()
                .padding(top = offsetDp),
            model = imageModel.imageUrl,
            contentScale = ContentScale.Crop,
            contentDescription = null
        )
    }

    @Composable
    private fun ProfileContent(imageModel: ImageModel, containerHeight: Dp) {
        Column {
            Spacer(modifier = Modifier.height(8.dp))

            ImageProperty(stringResource(R.string.title), imageModel.title)

            ImageProperty(stringResource(R.string.description), imageModel.description)

            ImageProperty(stringResource(R.string.creation_date), imageModel.date_created)

            Spacer(Modifier.height((containerHeight - 320.dp).coerceAtLeast(0.dp)))
        }
    }

    @Composable
    fun ImageProperty(label: String, value: String, isLink: Boolean = false) {
        Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp)) {
            Divider()
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                Text(
                    text = label,
                    style = MaterialTheme.typography.caption,
                )
            }
            val style = if (isLink) {
                MaterialTheme.typography.body1.copy(color = MaterialTheme.colors.primary)
            } else {
                MaterialTheme.typography.body1
            }
            Text(
                text = value,
                style = style
            )
        }
}