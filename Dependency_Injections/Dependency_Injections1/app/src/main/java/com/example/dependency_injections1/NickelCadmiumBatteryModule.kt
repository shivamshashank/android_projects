package com.example.dependency_injections1

import dagger.Binds
import dagger.Module

@Module
abstract class NickelCadmiumBatteryModule {

    @Binds
    abstract fun providesNickelCadmiumBattery(nickelCadmiumBattery: NickelCadmiumBattery): Battery
}