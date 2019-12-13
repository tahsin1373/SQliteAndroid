package com.data.sqliteandroid.mvvm

import android.os.Handler

class GitRepoRemoteDataSource {

    fun getRepositories(onRepositoryReadyCallback: OnRepoRemoteReadyCallback) {
        var arrayList = ArrayList<User>()
        arrayList.add(User("First From Local", "Owner 1", 100, false))
        arrayList.add(User("Second From Local", "Owner 2", 30, true))
        arrayList.add(User("Third From Local", "Owner 3", 430, false))
        Handler().postDelayed({ onRepositoryReadyCallback.onRemoteDataReady(arrayList) }, 2000)
    }

    interface OnRepoRemoteReadyCallback {
        fun onRemoteDataReady(data: ArrayList<User>)

    }
}