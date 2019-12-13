package com.data.sqliteandroid.mvvm

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel(application: Application) : AndroidViewModel(application) {


    var gitRepoRepository: GitRepoRepository = GitRepoRepository(NetManager(getApplication()))

    val text = ObservableField("old data")
    val isLoading = ObservableField(false)
    var list = MutableLiveData<ArrayList<User>>()
    fun loadUserList() {
        isLoading.set(true)
        gitRepoRepository.getRepositories(object : GitRepoRepository.OnRepositoryReadyCallback {
            override fun onDataReady(data: ArrayList<User>) {
                isLoading.set(false)
                list.value = data
            }
        })
    }
}
