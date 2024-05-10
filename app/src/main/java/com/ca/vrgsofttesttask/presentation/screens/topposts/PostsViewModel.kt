package com.ca.vrgsofttesttask.presentation.screens.topposts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.ca.vrgsofttesttask.domain.repository.PostsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class PostsViewModel @Inject constructor(
    private val repository: PostsRepository
) : ViewModel() {

    private val _viewState = MutableStateFlow(TopPostsScreenState(
        posts = repository.posts().cachedIn(viewModelScope)
    ))
    val viewState: StateFlow<TopPostsScreenState> = _viewState
}