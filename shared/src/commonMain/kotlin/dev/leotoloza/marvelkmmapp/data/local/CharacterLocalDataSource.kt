package dev.leotoloza.marvelkmmapp.data.local

import dev.leotoloza.marvelkmmapp.cache.MarvelDatabase
import dev.leotoloza.marvelkmmapp.domain.model.Character

class CharacterLocalDataSource(database: MarvelDatabase) {
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