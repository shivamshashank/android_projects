package com.example.dependency_injections1

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [MemoryCardModule::class, NickelCadmiumBatteryModule::class])
interface SmartPhoneComponent {
    fun inject(mainActivity: MainActivity)
}