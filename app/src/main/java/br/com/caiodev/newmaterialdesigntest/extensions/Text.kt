package br.com.caiodev.newmaterialdesigntest.extensions

import androidx.annotation.DimenRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.*

private fun Int.textDp(density: Density): TextUnit = with(density) {
    this@textDp.dp.toSp()
}

val Int.textDp: TextUnit
    @Composable get() =  this.textDp(density = LocalDensity.current)

@OptIn(ExperimentalUnitApi::class)
@Composable
@ReadOnlyComposable
fun textSizeResource(@DimenRes id: Int): TextUnit {
    val context = LocalContext.current
    val density = LocalDensity.current
    val pxValue = context.resources.getDimension(id)
    return TextUnit(pxValue / density.density, TextUnitType.Sp)
}
