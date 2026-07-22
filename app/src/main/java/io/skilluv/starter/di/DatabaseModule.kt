package io.skilluv.starter.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.skilluv.starter.data.database.AppDatabase
import io.skilluv.starter.data.database.NoteDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun db(@ApplicationContext ctx: Context): AppDatabase =
        Room.databaseBuilder(ctx, AppDatabase::class.java, "skilluv.db").build()

    @Provides
    fun noteDao(db: AppDatabase): NoteDao = db.noteDao()
}
