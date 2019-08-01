package com.mvproomarchiticture.ui.country.details

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import com.mvproomarchiticture.R
import com.mvproomarchiticture.data.entity.CountryItem
import com.mvproomarchiticture.ui.AppBaseFragment
import com.mvproomarchiticture.ui.common.base.mvp.presenter.BasePresenter
import com.mvproomarchiticture.ui.common.base.mvp.presenter.lifecycle.PresenterProvider
import com.mvproomarchiticture.ui.common.base.mvp.presenter.lifecycle.PresentersProvider
import com.mvproomarchiticture.ui.common.base.mvp.view.BaseView
import com.mvproomarchiticture.ui.country.CountryPresenter
import com.mvproomarchiticture.ui.country.CountryView
import com.mvproomarchiticture.util.Constants
import kotlinx.android.synthetic.main.fragment_name.*

@SuppressLint("CheckResult")
class NameFragment :AppBaseFragment<CountryPresenter, CountryView>(), CountryView {

    var countryItem = CountryItem()

    override fun onCountryReceived(countryItem: List<CountryItem>) {
    }

    companion object {
        @JvmStatic
        fun newInstance(countryItem: CountryItem) = NameFragment().apply {
            arguments = Bundle().apply {
                putParcelable(Constants.IntentFilter.DATA, countryItem)
            }
        }
    }

    override fun onInflateLayout() = R.layout.fragment_name


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setPresenter(PresentersProvider.of(
                this,
                object : PresenterProvider.Factory {
                    override fun <T : BasePresenter<out BaseView>> create(modelClass: Class<T>): T {
                        return CountryPresenter() as T
                    }
                }
        ).get(CountryPresenter::class.java), true)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setPresenter(PresentersProvider.of(this, object : PresenterProvider.Factory {
            override fun <T : BasePresenter<out BaseView>> create(modelClass: Class<T>): T {
                return CountryPresenter() as T
            }
        }).get(CountryPresenter::class.java), true)
        countryItem = arguments?.getParcelable(Constants.IntentFilter.DATA)!!
        (context as DetailsActivity).manageToolbar(true, true, countryItem.name, true, false, "", false)
        tvName.text = countryItem.name
//
//        RxViewClick.create(llBuildVehicle_fHome).subscribe {
//            BuildVehicleActivity.route(false).start(this)
        }
}