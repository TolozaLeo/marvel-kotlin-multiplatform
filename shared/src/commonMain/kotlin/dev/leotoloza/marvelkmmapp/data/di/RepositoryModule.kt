package dev.leotoloza.marvelkmmapp.data.di

import dev.leotoloza.marvelkmmapp.data.repository.CharacterRepositoryImpl
import dev.leotoloza.marvelkmmapp.data.network.MarvelCharactersClient
import dev.leotoloza.marvelkmmapp.domain.repository.CharacterRepository
import org.koin.core.module.Module
import org.koin.dsl.module

val repositoryModule: Module = module {

    // Cliente de red
    single { MarvelCharactersClient(get()) }

    // Repositorio
    single<CharacterRepository> { CharacterRepositoryImpl(get(), get()) }
}