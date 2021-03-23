package br.com.bernardino.marvelcharacters.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.bernardino.marvelcharacters.data.remote.model.CharacterResponse
import br.com.bernardino.marvelcharacters.data.remote.model.Extension

@Entity(tableName = "characters")
data class Character(
    @PrimaryKey
    val id: Long,
    val image: String,
    val imageExt: Extension,
    val name: String,
    val description: String
)

fun CharacterResponse.toCharacter() = Character(
    id = id,
    image = thumbnail.path,
    imageExt = thumbnail.extension,
    name = name,
    description = description
)
