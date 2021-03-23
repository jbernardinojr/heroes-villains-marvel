package br.com.bernardino.marvelcharacters.data.repository

import br.com.bernardino.marvelcharacters.data.local.CharacterDao
import br.com.bernardino.marvelcharacters.data.remote.CharacterRemoteDataSource
import javax.inject.Inject

class CharacterRepository @Inject constructor(
    private val remoteDataSource: CharacterRemoteDataSource,
    private val localDataSource: CharacterDao
) {
    //...
}