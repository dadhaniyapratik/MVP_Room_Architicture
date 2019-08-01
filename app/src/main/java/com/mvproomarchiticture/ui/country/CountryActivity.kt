package com.mvproomarchiticture.ui.country

import android.Manifest
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.webkit.PermissionRequest
import android.widget.SearchView
import android.widget.Toast
import com.artemkopan.utils.router.ActivityBuilder
import com.artemkopan.utils.router.Router
import com.artemkopan.utils.rx.RxViewsClick
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import com.mvproomarchiticture.R
import com.mvproomarchiticture.application.MVPArchitictureApplication
import com.mvproomarchiticture.data.entity.CountryItem
import com.mvproomarchiticture.database.SampleDatabase
import com.mvproomarchiticture.ui.AppBaseActivity
import com.mvproomarchiticture.ui.common.base.mvp.presenter.BasePresenter
import com.mvproomarchiticture.ui.common.base.mvp.presenter.lifecycle.PresenterProvider
import com.mvproomarchiticture.ui.common.base.mvp.presenter.lifecycle.PresentersProvider
import com.mvproomarchiticture.ui.common.base.mvp.view.BaseView
import com.mvproomarchiticture.ui.country.details.AddDetailsActivity
import com.mvproomarchiticture.ui.country.details.DetailsActivity
import com.mvproomarchiticture.util.Constants
import com.mvproomarchiticture.util.extensions.gone
import com.mvproomarchiticture.util.extensions.visible
import kotlinx.android.synthetic.main.activity_country.*
import kotlinx.android.synthetic.main.layout_toolbar.*
import java.util.ArrayList


class CountryActivity : AppBaseActivity<CountryPresenter, CountryView>(), CountryView {
   lateinit var sampleDatabase: SampleDatabase

    private var mArrayPermissions: ArrayList<String>? = null
    override fun onRefresh() {
        Toast.makeText(this, "Refresh", Toast.LENGTH_SHORT).show()
        Handler().postDelayed(Runnable {
            swiperefresh.isRefreshing = false
        }, 4000) // Delay in millis

        presenter?.getCountryList(sampleDatabase)
    }

    private lateinit var countryAdapter: CountryAdapter
    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var countryItemList: List<CountryItem>

    override fun onCountryReceived(countryItem: List<CountryItem>) {
        swiperefresh.isRefreshing = false
        countryItemList = countryItem
        setAdapter(countryItemList)
    }


    companion object {
        fun route(reportId: Int): ActivityBuilder<*> {
            return Router.activity(CountryActivity::class.java).putExtra(Constants.REPORT_NUMBER, reportId)
        }
    }

    override fun onInflateLayout() = R.layout.activity_country


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onToolbarInit(R.id.toolbar)
        manageToolbar(false,true,resources.getString(R.string.app_name),false,false,"",false)

        mArrayPermissions = ArrayList()
        mArrayPermissions!!.add(Manifest.permission.CAMERA)
        mArrayPermissions!!.add(Manifest.permission.CALL_PHONE)
        mArrayPermissions!!.add(Manifest.permission.ACCESS_COARSE_LOCATION)
        mArrayPermissions!!.add(Manifest.permission.ACCESS_FINE_LOCATION)
        mArrayPermissions!!.add(Manifest.permission.READ_EXTERNAL_STORAGE)
        mArrayPermissions!!.add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
        checkPermission(mArrayPermissions!!)


        sampleDatabase =  SampleDatabase.getDatabase(this)!!
        setPresenter(PresentersProvider.of(this, object : PresenterProvider.Factory {
            override fun <T : BasePresenter<out BaseView>> create(modelClass: Class<T>): T {
                return CountryPresenter() as T
            }
        }).get(CountryPresenter::class.java), true)
        presenter?.getCountryList(sampleDatabase)


        etSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {

            }

            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                //                if (charSequence.length() > 0)
                if (countryItemList.isNotEmpty()) {
                    countryAdapter.filter.filter(etSearch.text.toString().trim())
                }
            }

            override fun afterTextChanged(editable: Editable) {

            }
        })


        RxViewsClick.create(fab).subscribe {
            when (it.id) {
                R.id.fab -> {
                    AddDetailsActivity.route().returnResult(101).start(this)
                }

            }
        }
    }


    private fun checkPermission(mArrayPermissions: ArrayList<String>) {
        Dexter.withActivity(this).withPermissions(mArrayPermissions).withListener(object : MultiplePermissionsListener {
            override fun onPermissionsChecked(report: MultiplePermissionsReport) {
                if (report.areAllPermissionsGranted()) {
//                    hideSplashScreen()
                } else {
                    val mArrayPermissions = ArrayList<String>()
                    val mDeniedPermission = report.deniedPermissionResponses
                    for (deniedResponse in mDeniedPermission) {
                        mArrayPermissions.add(deniedResponse.permissionName)
                    }
//                    hideSplashScreen()
                }
            }

            override fun onPermissionRationaleShouldBeShown(permissions: List<com.karumi.dexter.listener.PermissionRequest>, token: PermissionToken) {
                token.continuePermissionRequest()
            }
        }).check()
    }

    private fun setAdapter(countryList: List<CountryItem>) {

        if (countryList.isNotEmpty()) {
            countryAdapter = CountryAdapter(countryList as MutableList<CountryItem>, this)
            countryAdapter.setList(countryItemList, true)
            rvCountry.adapter = countryAdapter
            layoutManager = LinearLayoutManager(this@CountryActivity, LinearLayoutManager.VERTICAL, false)
            rvCountry.layoutManager = layoutManager
            rvCountry.isNestedScrollingEnabled = false
            countryAdapter.setOnItemClickListener { view, pos, item, transactionViews ->
                when (view.id) {
                    R.id.tvname -> {
//                        DetailsActivity.route(item).start(this)
//                        Toast.makeText(this, "" + item.name, Toast.LENGTH_SHORT).show()
                    }
                }
            }
            rvCountry.itemAnimator = DefaultItemAnimator()
            rvCountry.visibility = View.VISIBLE
            tvNodata.visibility = View.GONE
        } else {
            rvCountry.visibility = View.GONE
            tvNodata.visibility = View.VISIBLE
        }
    }

    fun handelDisplayView(mArrayInboxDisplay: ArrayList<CountryItem>) {

        if (mArrayInboxDisplay.size > 0) {
            rvCountry.visibility = View.VISIBLE
            tvNodata.visibility = View.GONE
        } else {
            rvCountry.visibility = View.GONE
            tvNodata.visibility = View.VISIBLE
        }

    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val countryItem = data?.getParcelableExtra<CountryItem>(Constants.IntentFilter.DATA)
        if (countryItem != null) {
            sampleDatabase.daoAccess().insertSingleCountry(countryItem)
            countryItemList = sampleDatabase.daoAccess().getCountryList()

            setAdapter(countryItemList)

//            countryAdapter.setList(countryItemList, true)

        }
    }
}