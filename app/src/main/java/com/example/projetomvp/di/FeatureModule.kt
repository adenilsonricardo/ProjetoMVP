package com.example.projetomvp.di

import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module

abstract class FeatureModule {

    protected open val instance: Module = module {  }

    protected open val additionalModule: List<Module> = emptyList()

    fun load() {
        val defaultModule = listOf(
            instance
        )
        loadKoinModules(defaultModule + additionalModule)
    }
}