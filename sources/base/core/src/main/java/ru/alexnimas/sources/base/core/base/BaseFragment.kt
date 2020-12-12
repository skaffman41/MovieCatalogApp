package ru.alexnimas.sources.base.core.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import ru.alexnimas.core_api.NavigationCommand
import ru.alexnimas.sources.base.core.di.ViewModelFactory
import javax.inject.Inject

abstract class BaseFragment<VM : BaseViewModel, B : ViewDataBinding> : Fragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory<VM>

    protected val viewModel: VM by lazy {
        getViewModelInstance()
    }

    private var realBinding: B? = null
    val binding: B
        get() = realBinding
            ?: throw IllegalStateException("Trying to access the binding outside of the view lifecycle.")

    abstract val viewModelType: Class<VM>
    abstract val layoutResID: Int
    abstract val viewModelBRVarId: Int

    abstract fun inject()

    override fun onAttach(context: Context) {
        inject()
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        observeViewModel()

        if (realBinding == null) {
            realBinding = DataBindingUtil.inflate(inflater, layoutResID, container, false)
        }
        binding.lifecycleOwner = viewLifecycleOwner

        viewModel.onCreateView()

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.navigationCommands.observe(viewLifecycleOwner, { command ->
            when (command) {
                is NavigationCommand.To -> {
                    findNavController().navigate(command.directions)
                }
                is NavigationCommand.Back -> {
                    findNavController().popBackStack()
                }
            }
        })
        val args = arguments
        viewModel.reInit(args)
        configureBinding()
    }

    private fun getViewModelInstance(): VM {
        return ViewModelProvider(this as Fragment, viewModelFactory).get(viewModelType)
    }

    override fun onDestroyView() {
        arguments?.clear()
        realBinding = null
        super.onDestroyView()
    }

    protected open fun observeViewModel() {
        lifecycle.addObserver(viewModel as LifecycleObserver)
    }

    protected open fun configureBinding() {
        if (viewModelBRVarId > 0)
            binding.setVariable(viewModelBRVarId, viewModel)
    }
}