package search

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import search.models.SearchEvent
import search.models.SearchViewState
import theme.Theme


@Composable
fun SearchView(viewState: SearchViewState, eventHandler: (SearchEvent) -> Unit) {
    Column {
        TextField(value = viewState.query, onValueChange = {
            eventHandler.invoke(SearchEvent.QueryChanged(it))
        }, enabled = true,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color(0xff1f2430),
                textColor = Theme.colors.hintTextColor,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                cursorColor = Theme.colors.highlightTextColor
            ), shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 16.dp)
                .fillMaxWidth()
                .height(56.dp),
            placeholder = {
                Text("Search Game", color = Theme.colors.hintTextColor,
                    fontSize = 14.sp)
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            viewState.game.forEach { game ->
                item {
                    Text(
                        text = game.title,
                        color = Theme.colors.secondaryTextColor,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier
                            .clickable { eventHandler.invoke(SearchEvent.GameClicked) }
                            .padding(start = 16.dp, top=16.dp, end=16.dp)
                    )
                }
            }
        }
    }
}