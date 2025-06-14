package dev.leotoloza.marvelkmmapp.domain.repository

import dev.leotoloza.marvelkmmapp.domain.model.Character

interface CharacterRepository {
    suspend fun getCharacters(): List<Character>
}