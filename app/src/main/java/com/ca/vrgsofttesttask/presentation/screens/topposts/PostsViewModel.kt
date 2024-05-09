package com.ca.vrgsofttesttask.presentation.screens.topposts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.ca.vrgsofttesttask.domain.model.Post
import com.ca.vrgsofttesttask.domain.repository.PostsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class PostsViewModel @Inject constructor(
    private val repository: PostsRepository
) : ViewModel() {

    private val _viewState = MutableStateFlow(TopPostsScreenState())
    val viewState: StateFlow<TopPostsScreenState> = _viewState

    fun posts(): Flow<PagingData<Post>> {
        return runBlocking { repository.posts() }.cachedIn(viewModelScope)
    }
}