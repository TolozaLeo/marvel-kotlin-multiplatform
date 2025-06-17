package dev.leotoloza.marvelkmmapp.data.repository

import dev.leotoloza.marvelkmmapp.domain.model.Character
import dev.leotoloza.marvelkmmapp.domain.model.CharacterResult
import dev.leotoloza.marvelkmmapp.domain.network.MarvelCharactersClient
import dev.leotoloza.marvelkmmapp.domain.repository.CharacterRepository
import dev.leotoloza.marvelkmmapp.util.getMarvelPrivateKey
import dev.leotoloza.marvelkmmapp.util.getMarvelPublicKey
import dev.leotoloza.marvelkmmapp.util.md5
import io.ktor.util.date.getTimeMillis

class CharacterRepositoryImpl(
    private val api: MarvelCharactersClient
) : CharacterRepository {

    override suspend fun getCharacters(): List<Character> {
        val timestamp = getTimeMillis()
        val publicKey = getMarvelPublicKey()
        val privateKey = getMarvelPrivateKey()
        val hash = ("$timestamp$privateKey$publicKey").md5()

        val response = api.getAllCharacters(
            timestamp = timestamp, md5 = hash, publicKey = publicKey
        )
        val charactersList = response.characters.list.map { it.toDomain() }
        return sort(charactersList)
    }

    private fun sort(characters: List<Character>): List<Character> {
        return characters.sortedWith(CharacterComparator())
    }

    private class CharacterComparator : Comparator<Character> {
        override fun compare(a: Character, b: Character): Int {
            if (a.description.isEmpty() && b.description.isEmpty()) {
                return b.id.compareTo(a.id)
            }
            if (a.description.isNotEmpty() && b.description.isNotEmpty()) {
                return a.id.compareTo(b.id)
            }
            if (a.description.isNotEmpty() && b.description.isEmpty()) {
                return -1
            }
            return 1
        }
    }

    private fun CharacterResult.toDomain(): Character {
        return Character(
            id = id, name = name, description = description, thumbnailUrl = thumbnail.url
        )
    }
}