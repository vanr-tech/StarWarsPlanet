package com.vanr.starwarsplanet.base.util

import android.text.Spanned
import androidx.core.text.HtmlCompat
import javax.inject.Inject

class TextUtil @Inject constructor() {
    fun stringToHtml(title: String, value: String): Spanned {
        return HtmlCompat.fromHtml("<strong>${title} </strong> ${value}", HtmlCompat.FROM_HTML_MODE_LEGACY)
    }
    fun getIdFromUrl(url: String): Int {
        return url.replace("http://private-84e428-starwars2.apiary-mock.com/residents/", "").toInt()
    }
}