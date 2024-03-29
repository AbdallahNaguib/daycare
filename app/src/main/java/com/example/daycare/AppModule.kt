package com.example.daycare

import com.example.daycare.data.network.APIs.*
import com.example.daycare.data.preferences.Preferences
import com.example.daycare.data.reporsitories.*
import com.example.daycare.domain.models.*
import com.example.daycare.domain.models.Unknown
import com.example.daycare.domain.repositories.*
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

    @Singleton
    @Provides
    fun adapterFactory() = ResourceAdapterFactory.builder()
        .add(Parent::class.java,
        Unknown::class.java,
        Child::class.java,
        Group::class.java,
        Absence::class.java,
        ActivityType::class.java,
        Activity::class.java,
        ManyParent::class.java)
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

    @Singleton
    @Provides
    fun childrenApi(retrofit: Retrofit) =  retrofit.create(ChildrenApi::class.java)

    @Singleton
    @Provides
    fun activitesApi(retrofit: Retrofit) =  retrofit.create(ActivitiesApi::class.java)

    @Singleton
    @Provides
    fun sessionsApi(retrofit: Retrofit) =  retrofit.create(SessionsApi::class.java)

    @Singleton
    @Provides
    fun absencesApi(retrofit: Retrofit) =  retrofit.create(AbsencesApi::class.java)

    @Singleton
    @Provides
    fun materialsApi(retrofit: Retrofit) =  retrofit.create(MaterialsApi::class.java)

    @Singleton
    @Provides
    fun profileRepository(preferences: Preferences,profileApi: ProfileApi): ProfileRepository{
        return ProfileRepositoryImpl(profileApi,preferences)
    }

    @Singleton
    @Provides
    fun activitiesRepository(preferences: Preferences,activitiesApi: ActivitiesApi): ActivitesRepository{
        return ActivitesRepositoryImpl(activitiesApi,preferences)
    }

    @Singleton
    @Provides
    fun absencesRepository(preferences: Preferences,absencesApi: AbsencesApi): AbsencesRepository{
        return AbsencesRepositoryImpl(absencesApi,preferences)
    }

    @Singleton
    @Provides
    fun materialsRepository(preferences: Preferences,materialsApi: MaterialsApi): MaterialsRepository{
        return MaterialsRepositoryImpl(materialsApi,preferences)
    }

    @Singleton
    @Provides
    fun childrenRepository(preferences: Preferences,childrenApi: ChildrenApi): ChildrenRepository{
        return ChildrenRepositoryImpl(childrenApi,preferences)
    }
}