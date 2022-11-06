package theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class PlayzoneColors(
    val primaryBackground: Color = Color(0xFF050B18),
    val primaryAction: Color = Color(0xFFF4D144),
    val primaryTextColor: Color = Color(0xFF050B18),
    val hintTextColor: Color = Color(0xFF696C75),
    val highlightTextColor: Color = Color(0xFFF4D144),
    val secondaryTextColor: Color = Color(0xFFFFFFFF),
    val thirdTextColor: Color = Color(0xFFEEF2FB),
    val tagColor: Color = Color(0x1844A9F4),
    val tagTextColor: Color = Color(0xFF44A9F4)
)

val palette = PlayzoneColors(
    primaryBackground = Color(0xFF050B18),
    primaryAction = Color(0xFFF4D144),
    primaryTextColor = Color(0xFF050B18),
    hintTextColor = Color(0xFF696C75),
    highlightTextColor = Color(0xFFF4D144),
    secondaryTextColor = Color(0xFFFFFFFF),
    thirdTextColor = Color(0xFFEEF2FB),
    tagColor = Color(0x1844A9F4),
    tagTextColor = Color(0xFF44A9F4)
)

val LocalColorProvider = staticCompositionLocalOf<PlayzoneColors> { error("No default implementation") }