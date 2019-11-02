package di

import android.app.Application
import com.example.gitrepositoryhub.TodoApplication
import com.example.gitrepositoryhub.di.module.*
import com.example.todocreator.di.module.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/*
All the dagger modules needed for DI.
 */
@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityBindingModule::class,
        AppModule::class,
        ViewModelModule::class,
        NetworkModule::class,
        RepositoryModule::class,
        TodoDbModule::class
    ]
)
interface AppComponent : AndroidInjector<TodoApplication> {
    override fun inject(tvMazeApplication: TodoApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }
}

