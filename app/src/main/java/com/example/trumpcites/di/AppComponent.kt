package com.example.trumpcites.di

import android.app.Application
import com.example.trumpcites.presenter.HomeFragment.HomeFragment
import com.example.trumpcites.presenter.ShowFragment.ShowPhotosFragment
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import javax.inject.Singleton

@Component(
    modules = [
        AppModule::class,
    ]
)
@Singleton
interface AppComponent {
    fun inject(fragment: HomeFragment)
    fun inject(fragment: ShowPhotosFragment)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: Application): Builder

        fun build(): AppComponent
    }
}

@Module(
    includes = [
        NetworkModule::class,
        ViewModelModule::class,
        AppBindsModule::class,
        DataBaseModule::class,
    ]
)
class AppModule
