package br.com.bernardino.marvelcharacters.data.remote.model

data class CharacterResponse(
    val id: Long,
    val name: String,
    val description: String,
    val thumbnail: Thumbnail
)