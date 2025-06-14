package dev.leotoloza.marvelkmmapp.data.repository

import dev.leotoloza.marvelkmmapp.domain.model.Character
import dev.leotoloza.marvelkmmapp.domain.model.CharacterResult
import dev.leotoloza.marvelkmmapp.domain.network.MarvelCharactersClient
import dev.leotoloza.marvelkmmapp.domain.repository.CharacterRepository
import dev.leotoloza.marvelkmmapp.util.md5
import io.ktor.util.date.getTimeMillis

class CharacterRepositoryImpl(
    private val api: MarvelCharactersClient
) : CharacterRepository {

    override suspend fun getCharacters(): List<Character> {
        println("CharacterRepositoryImpl -> getCharacters() called")

        val timestamp = getTimeMillis()
        val publicKey = "TU_PUBLIC_KEY"
        val privateKey = "TU_PRIVATE_KEY"
        val hash = ("$timestamp$privateKey$publicKey").md5()

        val response = api.getAllCharacters(
            timestamp = timestamp, md5 = hash, publicKey = publicKey
        )
        return response.characters.list.map { it.toDomain() }
    }

    private fun CharacterResult.toDomain(): Character {
        return Character(
            id = id, name = name, description = description, thumbnailUrl = thumbnail.url
        )
    }
}