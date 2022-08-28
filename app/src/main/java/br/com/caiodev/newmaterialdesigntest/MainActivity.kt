package br.com.caiodev.newmaterialdesigntest

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import br.com.caiodev.newmaterialdesigntest.extensions.textSizeResource
import br.com.caiodev.newmaterialdesigntest.ui.theme.NewMaterialDesignTestTheme
import br.com.caiodev.newmaterialdesigntest.ui.theme.Purple500

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewMaterialDesignTestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ComposeWidgets()
                }
            }
        }
    }
}

private const val PREVIEW_NAME = "Dark Mode"

@Preview(name = PREVIEW_NAME, showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun DefaultPreview() {
    NewMaterialDesignTestTheme {
        ComposeWidgets()
    }
}

@Composable
fun ComposeWidgets() {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
            .padding(dimensionResource(id = R.dimen.padding_8dp))
    ) {
        Surface(
            shape = MaterialTheme.shapes.medium
                .copy(all = CornerSize(size = dimensionResource(id = R.dimen.radius_4dp))),
            elevation = dimensionResource(id = R.dimen.elevation_8dp),
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(dimensionResource(id = R.dimen.size_56dp))
        ) {
            val painter = painterResource(id = R.drawable.landscape)
            Image(
                painter = painter,
                contentDescription = stringResource(id = R.string.surface_image_content_description),
                modifier = Modifier
                    .fillMaxSize()
                    .aspectRatio(painter.intrinsicSize.width / painter.intrinsicSize.height)
                    .clickable(enabled = true, onClick = {}),
                contentScale = ContentScale.FillBounds
            )
        }

        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.size_8dp)))

        Button(
            enabled = true, onClick = {}, modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(backgroundColor = Purple500)
        ) {
            Text(
                text = stringResource(id = R.string.surface_image_button_text),
                color = Color.White,
                fontSize = textSizeResource(id = R.dimen.text_size_14sp)
            )
        }
    }
}
