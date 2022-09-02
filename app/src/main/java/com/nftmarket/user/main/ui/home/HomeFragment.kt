package com.nftmarket.user.main.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.nftmarket.database.getUser
import com.nftmarket.databinding.FragmentHomeBinding
import com.nftmarket.model.ApplicationUser
import com.nftmarket.model.DataUtil
import com.nftmarket.user.login.LoginActivity
import com.nftmarket.user.main.ui.home.add.AddActivity

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.addNFT.setOnClickListener {
            val intent = Intent(requireActivity(), AddActivity::class.java)
            startActivity(intent)
            activity?.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }
    }
}