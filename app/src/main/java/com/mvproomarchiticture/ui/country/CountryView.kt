package com.mvproomarchiticture.ui.country

import com.mvproomarchiticture.data.entity.CountryItem
import com.mvproomarchiticture.ui.common.base.mvp.view.BaseView

interface CountryView : BaseView {
    fun onCountryReceived(countryItem: List<CountryItem> )
}