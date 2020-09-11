package com.vanr.starwarsplanet.ui.main.residentDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.observe
import com.bumptech.glide.Glide
import com.vanr.starwarsplanet.R
import com.vanr.starwarsplanet.base.util.TextUtil
import com.vanr.starwarsplanet.domain.repositories.model.resident.Resident
import com.vanr.starwarsplanet.ui.main.RESIDENT_DETAIL_BUNDLE_KEY

import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_resident_details.*
import javax.inject.Inject

class ResidentDetailsFragment : DaggerFragment() {

    @Inject
    lateinit var viewModel: ResidentDetailsViewModel

    @Inject
    lateinit var textUtil: TextUtil

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_resident_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservers();
        val residentUrl = arguments?.getString(RESIDENT_DETAIL_BUNDLE_KEY)
        viewModel.getResidentDetails(textUtil.getIdFromUrl(residentUrl!!));
        activity?.title = "Resident Details"
    }

    fun initObservers() {
        viewModel.residentLiveData.observe(viewLifecycleOwner, this::loadResident)
    }

    fun loadResident(resident: Resident) {
        Glide.with(this)
            .load(resident.imageUrl)
            .into(residentImage)
        resName.text = textUtil.stringToHtml("Name:",resident.name)
        mass.text = textUtil.stringToHtml("Mass:",resident.mass)
        height.text = textUtil.stringToHtml("Height:", resident.height)
        hairColor.text = textUtil.stringToHtml("Hair color: ", resident.hairColor)
        skinColor.text = textUtil.stringToHtml("Skin color:", resident.skinColor)
        eyeColor.text = textUtil.stringToHtml("Eye color:", resident.eyeColor)
        birthYear.text = textUtil.stringToHtml("Birth year:", resident.birthYear)
        gender.text = textUtil.stringToHtml("Gender:", resident.gender)
        homeworld.text = textUtil.stringToHtml("Homeworld:", resident.homeworld)

    }
}