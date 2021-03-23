package br.com.bernardino.marvelcharacters.data.remote

import javax.inject.Inject

class CharacterRemoteDataSource @Inject constructor(
    private val characterService: CharacterService
) : BaseDataSource() {
    suspend fun getCharacters() = getResult { characterService.getAllCharacters() }
    suspend fun getCharacter(id: Int) = getResult { characterService.getCharacter(id) }

    companion object {
        const val BASE_ENDPOINT = "https://gateway.marvel.com:443"
    }
}