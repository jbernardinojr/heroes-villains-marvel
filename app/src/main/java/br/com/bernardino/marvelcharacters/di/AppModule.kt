package br.com.bernardino.marvelcharacters.di

import android.content.Context
import br.com.bernardino.marvelcharacters.data.local.AppDatabase
import br.com.bernardino.marvelcharacters.data.local.CharacterDao
import br.com.bernardino.marvelcharacters.data.remote.CharacterRemoteDataSource
import br.com.bernardino.marvelcharacters.data.remote.CharacterRemoteDataSource.Companion.BASE_ENDPOINT
import br.com.bernardino.marvelcharacters.data.remote.CharacterService
import br.com.bernardino.marvelcharacters.data.repository.CharacterRepository
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient, mosh: Moshi) = Retrofit.Builder()
        .client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create(mosh))
        .baseUrl(BASE_ENDPOINT)
        .build()

    @Provides
    fun provideMoshi(): Moshi = Moshi.Builder().build()

    @Provides
    fun provideCharacterService(retrofit: Retrofit): CharacterService =
        retrofit.create(CharacterService::class.java)

    @Singleton
    @Provides
    fun provideCharacterRemoteDataSource(characterService: CharacterService) =
        CharacterRemoteDataSource(characterService)

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context) =
        AppDatabase.getDatabase(appContext)

    @Singleton
    @Provides
    fun provideCharacterDao(db: AppDatabase) = db.characterDao()

    @Singleton
    @Provides
    fun provideRepository(
        remoteDataSource: CharacterRemoteDataSource,
        localDataSource: CharacterDao
    ) =
        CharacterRepository(remoteDataSource, localDataSource)
}