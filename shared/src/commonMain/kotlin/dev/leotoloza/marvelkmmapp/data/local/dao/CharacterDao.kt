package dev.leotoloza.marvelkmmapp.data.local.dao

import dev.leotoloza.marvelkmmapp.chache.MarvelDatabase
import dev.leotoloza.marvelkmmapp.domain.model.Character

class CharacterDao(database: MarvelDatabase) {
    private val queries = database.marvelDatabaseQueries  // Objeto de consultas generado

    fun insertCharacter(character: Character) {
        queries.insertCharacter(
            character.id,
            character.name,
            character.description,
            character.thumbnailUrl
        )
    }

    fun getAllCharacters(): List<Character> {
        return queries.selectAllCharacters().executeAsList().map { entity ->
            Character(
                id = entity.id,
                name = entity.name,
                description = entity.description,
                thumbnailUrl = entity.thumbnailUrl
            )
        }
    }
}