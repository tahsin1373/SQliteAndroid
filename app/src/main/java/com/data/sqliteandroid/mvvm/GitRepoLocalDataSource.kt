package com.data.sqliteandroid.mvvm

import android.os.Handler

class GitRepoLocalDataSource {

    fun getRepositories(onRepositoryReadyCallback: OnRepoLocalReadyCallback) {
        var arrayList = ArrayList<User>()
        arrayList.add(User("First From Local", "Owner 1", 100, false))
        arrayList.add(User("Second From Local", "Owner 2", 30, true))
        arrayList.add(User("Third From Local", "Owner 3", 430, false))
        Handler().postDelayed({ onRepositoryReadyCallback.onLocalDataReady(arrayList) }, 2000)
    }

    fun saveRepositories(arrayList: ArrayList<User>) {
//todo save repositories in DB
    }

    interface OnRepoLocalReadyCallback {
        fun onLocalDataReady(data: ArrayList<User>)
    }

}