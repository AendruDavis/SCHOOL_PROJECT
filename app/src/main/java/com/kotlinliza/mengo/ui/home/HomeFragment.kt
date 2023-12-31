package com.kotlinliza.mengo.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.kotlinliza.mengo.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

       binding.home.apply {
           loadUrl("https://mengoss.sc.ug/")
           settings.allowContentAccess = true
           settings.useWideViewPort = true
           settings.domStorageEnabled = true
           settings.javaScriptEnabled = true
           webViewClient= WebViewClient()
       }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}