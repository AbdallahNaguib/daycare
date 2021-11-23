package com.example.daycare

import com.example.daycare.data.network.APIs.ProfileApi
import com.example.daycare.data.preferences.Preferences
import com.example.daycare.data.reporsitories.ProfileRepositoryImpl
import com.example.daycare.domain.repositories.ProfileRepository
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    fun retrofit() = Retrofit.Builder()
        .baseUrl(Constants.API_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()

    @Singleton
    @Provides
    fun profileApi(retrofit: Retrofit) =  retrofit.create(ProfileApi::class.java)

    @Provides
    fun profileRepository(preferences: Preferences,profileApi: ProfileApi): ProfileRepository{
        return ProfileRepositoryImpl(profileApi,preferences)
    }
}