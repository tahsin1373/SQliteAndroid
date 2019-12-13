package com.data.sqliteandroid.mvvm

class GitRepoRepository(val netManager: NetManager) {
    val localDataSource = GitRepoLocalDataSource()
    val remoteDataSource = GitRepoRemoteDataSource()
    fun getRepositories(onRepositoryReadyCallback: OnRepositoryReadyCallback) {
        netManager.isConnectedToInternet?.let {
            if (it) {
                remoteDataSource.getRepositories(object :
                    GitRepoRemoteDataSource.OnRepoRemoteReadyCallback {
                    override fun onRemoteDataReady(data: ArrayList<User>) {
                        localDataSource.saveRepositories(data)
                        onRepositoryReadyCallback.onDataReady(data)
                    }
                })
            } else {
                localDataSource.getRepositories(object :
                    GitRepoLocalDataSource.OnRepoLocalReadyCallback {
                    override fun onLocalDataReady(data: ArrayList<User>) {
                        onRepositoryReadyCallback.onDataReady(data)
                    }
                })
            }
        }
    }

interface OnRepositoryReadyCallback {
    fun onDataReady(data: ArrayList<User>)
}
}