package com.kotlinliza.mengo.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.kotlinliza.mengo.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root
binding.navigationDashboard.apply {
    loadUrl("https://mengoss.sc.ug/gallery")
    settings.javaScriptEnabled = true
    settings.allowContentAccess = true
    settings.domStorageEnabled = true
    settings.useWideViewPort = true
    webViewClient= WebViewClient()
}
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}