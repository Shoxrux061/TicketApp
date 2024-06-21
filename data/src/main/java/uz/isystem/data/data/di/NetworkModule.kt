package uz.isystem.data.data.di

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.chuckerteam.chucker.api.RetentionManager
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.isystem.core.Constants
import uz.isystem.data.data.models.MusicalOffersResponse
import uz.isystem.data.data.network.OffersService
import uz.isystem.data.data.repo.RepositoryImpl
import uz.isystem.domain.TicketsRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @[Provides Singleton]
    fun provideTicketsRepository(service: OffersService): TicketsRepository<MusicalOffersResponse?> {
        return RepositoryImpl(service)
    }

    @[Provides Singleton]
    fun provideRetrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @[Provides Singleton]
    fun provideOkHttp(chuckerInterceptor: ChuckerInterceptor): OkHttpClient {
        return OkHttpClient
            .Builder()
            .addInterceptor(chuckerInterceptor)
            .build()
    }

    @[Provides Singleton]
    fun provideChuckerInterceptor(
        collector: ChuckerCollector,
        @ApplicationContext context: Context
    ): ChuckerInterceptor {

        return ChuckerInterceptor.Builder(context)
            .collector(collector)
            .maxContentLength(250_000L)
            .redactHeaders("Auth-Token", "Bearer")
            .alwaysReadResponseBody(true)
            .build()
    }

    @[Provides Singleton]
    fun provideChuckerCollector(@ApplicationContext context: Context): ChuckerCollector {
        return ChuckerCollector(
            context = context,
            showNotification = true,
            retentionPeriod = RetentionManager.Period.ONE_HOUR
        )
    }

    @[Provides Singleton]
    fun provideGson(): Gson {
        return GsonBuilder().setLenient().create()
    }
}