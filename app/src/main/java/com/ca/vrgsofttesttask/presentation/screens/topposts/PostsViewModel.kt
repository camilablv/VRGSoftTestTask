package com.ca.vrgsofttesttask.presentation.screens.topposts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ca.vrgsofttesttask.domain.repository.PostsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostsViewModel @Inject constructor(
    private val repository: PostsRepository
) : ViewModel() {

    private val _viewState = MutableStateFlow(TopPostsScreenState())
    val viewState: StateFlow<TopPostsScreenState> = _viewState

    init {
        loadTopPosts()
    }

    private fun loadTopPosts() {
        viewModelScope.launch {
            val posts = repository.posts()
            _viewState.update { it.copy(posts = posts) }
        }
    }
}