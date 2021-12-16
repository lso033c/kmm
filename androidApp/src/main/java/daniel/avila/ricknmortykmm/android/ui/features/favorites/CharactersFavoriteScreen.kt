package daniel.avila.ricknmortykmm.android.ui.features.favorites

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import coil.annotation.ExperimentalCoilApi
import daniel.avila.ricknmortykmm.android.ui.base.components.state.ManagementResourceState
import daniel.avila.ricknmortykmm.android.ui.features.characters.CharactersList
import daniel.avila.ricknmortykmm.shared.features.favorites.mvi.CharactersFavoritesContract
import daniel.avila.ricknmortykmm.shared.features.favorites.mvi.CharactersFavoritesViewModel

@ExperimentalCoilApi
@Composable
fun CharactersFavoriteScreen(
    onCharacterClick: (Int) -> Unit,
    onBackPressed: () -> Unit,
    viewModel: CharactersFavoritesViewModel
) {
    val state by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = { ActionBar(onBackPressed = onBackPressed) }
    ) { padding ->
        ManagementResourceState(
            resourceState = state.charactersFavorites,
            successView = { favorites ->
                checkNotNull(favorites)
                CharactersList(
                    characters = favorites,
                    onCharacterClick = onCharacterClick
                )
            },
            onTryAgain = { viewModel.setEvent(CharactersFavoritesContract.Event.OnGetCharactersFavorites) },
            onCheckAgain = { viewModel.setEvent(CharactersFavoritesContract.Event.OnGetCharactersFavorites) },
            modifier = Modifier.padding(padding)
        )
    }
}