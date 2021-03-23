package br.com.bernardino.marvelcharacters.data.remote.model

data class Thumbnail(
    val path: String,
    val extension: Extension
)

enum class Extension {
    GIF,
    Jpg
}