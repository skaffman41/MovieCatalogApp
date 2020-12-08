package ru.alexnimas.details

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.MutableLiveData
import io.reactivex.rxkotlin.addTo
import ru.alexnimas.details.repo.DetailsRepository
import ru.alexnimas.sources.base.core.base.BaseViewModel
import ru.alexnimas.sources.base.core.extensions.applyNetworkSchedulers
import javax.inject.Inject

class MovieDetailsViewModel @Inject constructor(
    private val repository: DetailsRepository
) : BaseViewModel() {

    val url: MutableLiveData<String> = MutableLiveData()

    override fun reInit(args: Bundle?) {
        val movieId = args?.getInt("id")
        repository.getMovieDetails(movieId)
            .applyNetworkSchedulers()
            .subscribe({
                url.value = "https://image.tmdb.org/t/p/w400/${it.backdropPath ?: it.posterPath}"
            }, {
                Log.d("TAGF", "Error")
            })
            .addTo(compositeDisposable)
    }
}