import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.SemanticsProperties.ToggleableState
import androidx.compose.ui.unit.dp


@Composable
    fun TriStateCheckBoxSample(){
        Column( horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()) {
            Column {
               
                val (state, onStateChange) = remember { mutableStateOf(true) }
                val (state2, onStateChange2) = remember { mutableStateOf(true) }

               
                val parentState = remember(state, state2) {
                    if (state && state2) androidx.compose.ui.state.ToggleableState.On
                    else if (!state && !state2) androidx.compose.ui.state.ToggleableState.Off
                    else androidx.compose.ui.state.ToggleableState.Indeterminate
                }
           
                val onParentClick = {
                    val s = parentState != androidx.compose.ui.state.ToggleableState.On
                    onStateChange(s)
                    onStateChange2(s)
                }

                TriStateCheckbox(
                    state = parentState,
                    onClick = onParentClick,
                    colors = CheckboxDefaults.colors(
                        checkedColor = MaterialTheme.colors.primary
                    )
                )
                Spacer(Modifier.size(25.dp))
                Column(Modifier.padding(10.dp, 0.dp, 0.dp, 0.dp)) {
                    Checkbox(state, onStateChange)
                    Spacer(Modifier.size(25.dp))
                    Checkbox(state2, onStateChange2)
                }
            }
        }
    }
