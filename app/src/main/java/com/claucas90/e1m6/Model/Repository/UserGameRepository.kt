package com.claucas90.e1m6.Model.Repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.claucas90.e1m6.Model.UserGame
import com.claucas90.e1m6.Model.UserGameDao

class UserGameRepository(private val userGameDao: UserGameDao) {

    val allDatos: LiveData<List<UserGame>> = userGameDao.getAllDatos()

    @WorkerThread
    suspend fun insert(userGame: UserGame) {
        userGameDao.insert(userGame)
    }
    @WorkerThread
    suspend fun deleteAll() {
        userGameDao.deleteAll()
    }
    @WorkerThread
    suspend fun deleteUno(id:Int) {
        userGameDao.deleteUno(id)
    }


}