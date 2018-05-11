package com.whatthefar.fungjaihw.di

import android.app.Application
import com.whatthefar.fungjaihw.feature.App
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 * Created by Far on 20/3/2018 AD.
 */

interface ComponentBuilder<out C> {
    fun build(): C
}

@Singleton
@Component(modules = [(AndroidInjectionModule::class), (AppModule::class), (BuildersModule::class), (ViewModelModule::class)])
interface AppComponent {
    fun inject(app: App)

    @Component.Builder
    interface Builder : ComponentBuilder<AppComponent> {

        /**
         * will allow clients of this builder to pass their own instances,
         * and those instances can be injected within the component
         */
        @BindsInstance
        fun application(application: Application): Builder
    }
}