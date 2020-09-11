package com.vanr.starwarsplanet.ui.main.planetDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.vanr.starwarsplanet.R
import com.vanr.starwarsplanet.base.util.TextUtil
import com.vanr.starwarsplanet.domain.repositories.model.planet.Planet
import com.vanr.starwarsplanet.ui.main.RESIDENTS_BUNDLE_KEY
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_planet_details.*
import javax.inject.Inject

class PlanetDetailsFragment : DaggerFragment() {

    @Inject
    lateinit var viewModel: PlanetDetailsViewModel
    @Inject
    lateinit var textUtil: TextUtil

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_planet_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservers();
        viewModel.getPlanetDetails();
        activity?.title = "Planet Details"

    }

    private fun initObservers() {
        viewModel.planetLiveData.observe(viewLifecycleOwner, this::loadPlanet)
    }

    private fun loadPlanet(planet: Planet) {
        Glide.with(this)
            .load(planet.imageUrl)
            .into(planetImage)

        name.text = textUtil.stringToHtml("Planet name:", planet.name)
        rotationPeriod.text = textUtil.stringToHtml("Rotation period:", planet.rotationPeriod)
        orbitalPeriod.text = textUtil.stringToHtml("Orbital period:", planet.orbitalPeriod)
        diameter.text = textUtil.stringToHtml("Diameter:", planet.diameter)
        gravity.text = textUtil.stringToHtml("Gravity:", planet.gravity)
        terain.text = textUtil.stringToHtml("Terain:", planet.terrain)
        surfaceWater.text = textUtil.stringToHtml("Surface water:", planet.surfaceWater)
        population.text = textUtil.stringToHtml("Population:", planet.population)
        likes.text = textUtil.stringToHtml("Likes:", planet.liked)

        planetImage.setOnClickListener {
            showBigImage(planet.imageUrl)
        }

        residents.setOnClickListener {
            val bundle = Bundle();
            bundle.putStringArray(RESIDENTS_BUNDLE_KEY, planet.residents)
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment, bundle)
        }
    }

    private fun showBigImage(imageUrl: String) {
        val viewInflated = LayoutInflater.from(activity)
            .inflate(R.layout.full_screen_layout, null)
        val image = viewInflated.findViewById(R.id.fullSizeImage) as ImageView
        Glide.with(this)
            .load(imageUrl)
            .into(image)
        val builder = activity?.let { AlertDialog.Builder(it) }
        builder?.setView(viewInflated)
        builder?.setCancelable(false)
        builder?.setPositiveButton("OK") { dialog, which ->
            dialog.dismiss()
        }
        builder?.create()
        builder?.show()
    }

}