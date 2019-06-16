package com.example.calorieassistant.main.account

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.calorieassistant.R
import com.example.calorieassistant.main.MainFragment
import kotlinx.android.synthetic.main.fragment_main.*

class AccountFragment: Fragment(){

    private lateinit var binding: com.example.calorieassistant.databinding.FragmentAccountBinding
    private lateinit var viewModel: AccountViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupViewModel()
    }

    private fun setupViewModel(){
        viewModel = ViewModelProviders.of(this).get(AccountViewModel::class.java)
        subscribeLogOut()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_account, container, false)
        binding.viewModel = viewModel
        return binding.root
    }

    private fun subscribeLogOut(){
        viewModel.logOutLiveData.observe(this, Observer {status: Boolean? ->
            status?.let {
                if(it) Navigation.findNavController(requireActivity(), R.id.activity_main_nav_host_fragment)
                    .navigate(R.id.signInFragment)
            }
        })
    }


}
