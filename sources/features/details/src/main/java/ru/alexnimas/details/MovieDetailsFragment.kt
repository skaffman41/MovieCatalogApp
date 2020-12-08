package ru.alexnimas.details

import android.os.Bundle
import android.view.View
import ru.alexnimas.core_api.AppWithFacade
import ru.alexnimas.details.databinding.FragmentMovieDetailsBinding
import ru.alexnimas.details.di.DetailsComponent
import ru.alexnimas.sources.base.core.base.BaseFragment

class MovieDetailsFragment : BaseFragment<MovieDetailsViewModel, FragmentMovieDetailsBinding>() {
    override val viewModelType = MovieDetailsViewModel::class.java
    override val layoutResID = R.layout.fragment_movie_details
    override val viewModelBRVarId: Int = BR.viewModel

    override fun inject() {
        DetailsComponent.create((requireActivity().application as AppWithFacade).getFacade())
            .inject(this)
    }
}
