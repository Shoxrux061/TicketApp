package uz.isystem.data.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import uz.isystem.data.data.network.OffersService
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Service {

    @[Provides Singleton]
    fun provideHomeService(retrofit: Retrofit):OffersService {
        return retrofit.create(OffersService::class.java)
    }
}