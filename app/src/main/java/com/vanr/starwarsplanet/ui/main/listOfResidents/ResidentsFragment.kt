package com.vanr.starwarsplanet.ui.main.listOfResidents

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.vanr.starwarsplanet.R
import com.vanr.starwarsplanet.ui.main.RESIDENTS_BUNDLE_KEY
import com.vanr.starwarsplanet.ui.main.RESIDENT_DETAIL_BUNDLE_KEY
import kotlinx.android.synthetic.main.fragment_second.*

class ResidentsFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.title = "Residents"
        val items: Array<String> = arguments?.getStringArray(RESIDENTS_BUNDLE_KEY) as Array<String>;
        val adapter = ResidentsAdapter()
        residentList.layoutManager = LinearLayoutManager(activity)
        residentList.adapter = adapter
        adapter.setData(items)
        adapter.showResidentDetails.subscribe(this::showResidentDetail)
    }

    private fun showResidentDetail(url: String) {
        val bundle = Bundle()
        bundle.putString(RESIDENT_DETAIL_BUNDLE_KEY, url)
        findNavController().navigate(R.id.action_SecondFragment_to_residentDetailsFragment, bundle)
    }
}