package ru.alexnimas.sources.base.core.base

import android.os.Bundle
import androidx.lifecycle.*
import androidx.navigation.NavDirections
import io.reactivex.disposables.CompositeDisposable
import ru.alexnimas.core_api.NavigationCommand
import ru.alexnimas.core_api.utils.SingleLiveEvent

abstract class BaseViewModel : ViewModel(), LifecycleObserver {
    val compositeDisposable = CompositeDisposable()
    val navigationCommands = SingleLiveEvent<NavigationCommand>()

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    open fun reInit(args: Bundle?) {
    }

    fun navigate(directions: NavDirections) {
        navigationCommands.postValue(NavigationCommand.To(directions))
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    open fun onCreate() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    open fun onStart() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    open fun onStop() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    open fun onDestroy() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    open fun onResume() {
    }

    open fun onCreateView() {}
}