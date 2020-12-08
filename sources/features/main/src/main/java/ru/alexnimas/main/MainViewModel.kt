package ru.alexnimas.main

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.MutableLiveData
import io.reactivex.Single
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import ru.alexnimas.core_api.coordinator.MainCoordinator
import ru.alexnimas.core_api.dto.Movie
import ru.alexnimas.main.dto.MoviesData
import ru.alexnimas.main.repo.MainRepository
import ru.alexnimas.sources.base.core.base.BaseViewModel
import ru.alexnimas.sources.base.core.extensions.applyNetworkSchedulers
import javax.inject.Inject


class MainViewModel @Inject constructor(
    private val repository: MainRepository,
    private val mainCoordinator: MainCoordinator
) : BaseViewModel() {
    val moviesData = MutableLiveData<MoviesData>()

    fun onMovieClicked(movie: Movie) {
        movie.id?.let { id ->
            mainCoordinator.toDetailsScreen(id)
        }
    }

    override fun reInit(args: Bundle?) {
        super.reInit(args)
        initLists()
    }

    private fun initLists() {
        Single.zip(
            getNowPlayingMovies(),
            getOnTheAirShows(),
            getPopular(),
            getTopRated(),
            { nowPlaying, onTheAir, popular, topRated ->
                MoviesData(nowPlaying, onTheAir, popular, topRated)
            }).applyNetworkSchedulers()
            .subscribe({
                moviesData.value = it
            }, {
                Log.d("TAGF", it.localizedMessage)
            }).addTo(compositeDisposable)
    }

    private fun getNowPlayingMovies(): Single<List<Movie>> {
        return repository.getNowPlayingMovies(1)
            .subscribeOn(Schedulers.io())
    }

    private fun getOnTheAirShows(): Single<List<Movie>> {
        return repository.getOnTheAirShows(1)
            .subscribeOn(Schedulers.io())
    }

    private fun getPopular(): Single<List<Movie>> {
        return repository.getPopularMovies(1)
            .subscribeOn(Schedulers.io())
    }

    private fun getTopRated(): Single<List<Movie>> {
        return repository.getTopRatedMovies(1)
            .subscribeOn(Schedulers.io())
    }
}