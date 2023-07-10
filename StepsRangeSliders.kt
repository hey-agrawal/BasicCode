import androidx.compose.foundation.layout.Column
import androidx.navigation.NavHostController
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RangeSlider
import androidx.compose.material.Slider
import androidx.compose.material.SliderDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun StepRangeSliderSample(){
    Column() {
        var sliderPosition by remember { mutableStateOf(0f..100f) }
        Text(text = sliderPosition.toString())
        RangeSlider(
            steps = 5,
            values = sliderPosition,
            onValueChange = {newValue-> sliderPosition = newValue},
            valueRange = 0f..100f,
            onValueChangeFinished = {
            },
            colors = SliderDefaults.colors(
                thumbColor = MaterialTheme.colors.secondary,
                activeTrackColor = MaterialTheme.colors.secondary
            )
        )
    }
}
