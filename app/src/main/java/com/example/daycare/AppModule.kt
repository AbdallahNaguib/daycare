package com.example.daycare

import com.example.daycare.data.network.APIs.ProfileApi
import com.example.daycare.data.preferences.Preferences
import com.example.daycare.data.reporsitories.ProfileRepositoryImpl
import com.example.daycare.domain.models.Parent
import com.example.daycare.domain.repositories.ProfileRepository
import com.example.daycare.moshiJsonapi.core.ResourceAdapterFactory
import com.example.daycare.moshiJsonapi.retrofitConverter.JsonApiConverterFactory
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    //    JsonAdapter.Factory jsonApiAdapterFactory =
//    // ...
//    .build();
//    Moshi moshi = new Moshi.Builder()
//    .add(jsonApiAdapterFactory)
//    // ...
//    .build();
    @Singleton
    @Provides
    fun adapterFactory() = ResourceAdapterFactory.builder()
        .add(Parent::class.java)
        .build()

    @Singleton
    @Provides
    fun moshi(adapterFactory:ResourceAdapterFactory) = Moshi.Builder()
        .add(adapterFactory)
        .build()

    @Singleton
    @Provides
    fun retrofit(moshi:Moshi) = Retrofit.Builder()
        .baseUrl(Constants.API_URL)
        .addConverterFactory(JsonApiConverterFactory.create(moshi))
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