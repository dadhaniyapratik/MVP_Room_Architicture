package com.mvproomarchiticture.ui.country

import android.annotation.SuppressLint
import android.database.Observable
import com.mvproomarchiticture.R
import com.mvproomarchiticture.application.MVPArchitictureApplication
import com.mvproomarchiticture.data.exceptions.ExceptionManager
import com.mvproomarchiticture.database.SampleDatabase
import com.mvproomarchiticture.ui.common.base.listeners.NetworkListener
import com.mvproomarchiticture.ui.common.base.mvp.presenter.BasePresenterImpl
import com.mvproomarchiticture.util.CommonUtils
import com.mvproomarchiticture.util.extensions.applySchedulers
import com.mvproomarchiticture.util.rest.RestWebCaller


@SuppressLint("CheckResult")
class CountryPresenter : BasePresenterImpl<CountryView>() {

    fun getCountryList(sampleDatabase: SampleDatabase) {

        CommonUtils.checkInternetConnection(MVPArchitictureApplication.instance)
                .subscribe { isInternetOn ->
                    if (isInternetOn) {
                        RestWebCaller.getCountry()
                                .applySchedulers()
                                .doOnSubscribe {
                                    onShowProgress()
                                }
                                .doFinally {
                                    onHideProgress()
                                }
                                .subscribe({
                                    sampleDatabase.daoAccess().deleteCountryList()
                                    sampleDatabase.daoAccess().insertCountryList(it)
                                    mvpView?.onCountryReceived(it)
                                }, {
                                    ExceptionManager.consumerThrowable({ mvpView }).accept(it)
                                })
                    } else {
                        if (sampleDatabase.daoAccess().getCountryList().isNotEmpty()) {
                            mvpView?.onCountryReceived(sampleDatabase.daoAccess().getCountryList())
                        } else {
                            mvpView?.showNetworkError(null,
                                    R.string.base_info_error,
                                    R.string.error_no_internet_connection,
                                    object : NetworkListener {
                                        override fun onRetry() {
                                            getCountryList(sampleDatabase)
                                        }
                                    })
                        }
                    }
                }

    }

}