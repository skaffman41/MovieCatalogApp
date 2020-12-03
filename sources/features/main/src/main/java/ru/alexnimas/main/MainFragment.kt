package ru.alexnimas.main

import android.os.Bundle
import android.view.View
import ru.alexnimas.core_api.AppWithFacade
import ru.alexnimas.core_api.dto.Movie
import ru.alexnimas.main.databinding.FragmentMoviesListBinding
import ru.alexnimas.main.di.MainComponent
import ru.alexnimas.core_api.adapter.SimpleBindingRVAdapter
import ru.alexnimas.sources.base.core.base.BaseFragment

class MainFragment : BaseFragment<MainViewModel, FragmentMoviesListBinding>() {
    override val viewModelType = MainViewModel::class.java
    override val layoutResID = R.layout.fragment_movies_list
    override val viewModelBRVarId: Int = BR.viewModel


    override fun inject() {
        MainComponent.create((requireActivity().application as AppWithFacade).getFacade())
            .inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setAdapters()
        binding.layoutNowPlaying
        binding.rvNowPlaying.adapter =
            SimpleBindingRVAdapter<Movie>(R.layout.item_movie, BR.data) { movie, _ ->
                viewModel.onMovieClicked(movie)
            }
        super.onViewCreated(view, savedInstanceState)
    }

    private fun setAdapters() {
        if (binding.rvNowPlaying.adapter == null || binding.rvOnTheAir.adapter == null || binding.rvPopular.adapter == null || binding.rvTopRated.adapter == null) {
//            val shimmerAdapter = SimpleBindingRVAdapter<Movie>(R.layout.shimmer_movie, BR.data)
//            rv_shimmer_now_playing.adapter = shimmerAdapter
//            rv_shimmer_on_the_air.adapter = shimmerAdapter
//            rv_shimmer_popular.adapter = shimmerAdapter
//            rv_shimmer_top_rated.adapter = shimmerAdapter
            binding.rvNowPlaying.adapter =
                SimpleBindingRVAdapter<Movie>(R.layout.item_movie, BR.data) { item, _ ->
                    viewModel.onMovieClicked(item)
                }
            binding.rvOnTheAir.adapter =
                SimpleBindingRVAdapter<Movie>(R.layout.item_movie, BR.data) { item, _ ->
                    viewModel.onMovieClicked(item)
                }
            binding.rvPopular.adapter =
                SimpleBindingRVAdapter<Movie>(R.layout.item_movie, BR.data) { item, _ ->
                    viewModel.onMovieClicked(item)
                }
            binding.rvTopRated.adapter =
                SimpleBindingRVAdapter<Movie>(R.layout.item_movie, BR.data) { item, _ ->
                    viewModel.onMovieClicked(item)
                }
        }
    }
}
