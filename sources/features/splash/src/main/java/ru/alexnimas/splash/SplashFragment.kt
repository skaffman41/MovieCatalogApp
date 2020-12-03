package ru.alexnimas.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import ru.alexnimas.core_api.AppWithFacade
import ru.alexnimas.sources.base.core.base.BaseFragment
import ru.alexnimas.splash.databinding.FragmentSplashBinding
import ru.alexnimas.splash.di.SplashComponent

class SplashFragment : BaseFragment<SplashViewModel, FragmentSplashBinding>() {

    override val viewModelType = SplashViewModel::class.java
    override val layoutResID = R.layout.fragment_splash
    override val viewModelBRVarId: Int = BR.viewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Handler(Looper.getMainLooper()).postDelayed({
            viewModel.toMainScreen()
        }, 2000)
    }

    override fun inject() {
        SplashComponent.create((requireActivity().application as AppWithFacade).getFacade())
            .inject(this)
    }
}