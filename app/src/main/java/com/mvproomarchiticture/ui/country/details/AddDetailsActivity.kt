package com.mvproomarchiticture.ui.country.details

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.util.Log
import com.artemkopan.utils.router.ActivityBuilder
import com.artemkopan.utils.router.Router
import com.artemkopan.utils.rx.RxViewsClick
import com.bumptech.glide.Glide
import com.mvproomarchiticture.R
import com.mvproomarchiticture.data.entity.CountryItem
import com.mvproomarchiticture.ui.AppBaseActivity
import com.mvproomarchiticture.ui.common.base.mvp.presenter.BasePresenter
import com.mvproomarchiticture.ui.common.base.mvp.presenter.lifecycle.PresenterProvider
import com.mvproomarchiticture.ui.common.base.mvp.presenter.lifecycle.PresentersProvider
import com.mvproomarchiticture.ui.common.base.mvp.view.BaseView
import com.mvproomarchiticture.ui.common.widgets.TakePicture
import com.mvproomarchiticture.util.Constants
import kotlinx.android.synthetic.main.activity_add_details.*

@SuppressLint("CheckResult")
class AddDetailsActivity : AppBaseActivity<DetailsPresenter, DetailsView>(), DetailsView {
    private var SELECTED_PATH = ""
    lateinit var mTakePicture: TakePicture

    companion object {
        fun route(): ActivityBuilder<*> {
            return Router.activity(AddDetailsActivity::class.java)
        }
    }

    override fun onInflateLayout() = R.layout.activity_add_details


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onToolbarInit(R.id.toolbar)
        setPresenter(PresentersProvider.of(this, object : PresenterProvider.Factory {
            override fun <T : BasePresenter<out BaseView>> create(modelClass: Class<T>): T {
                return DetailsPresenter() as T
            }
        }).get(DetailsPresenter::class.java), true)
        mTakePicture = TakePicture(this)

        RxViewsClick.create(ivProfilePic, btnSave).subscribe {
            when (it.id) {
                R.id.ivProfilePic -> {
                    if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
                        checkPermision()
//                        selectProfilePic()
                    } else {
                        selectProfilePic()
                    }
                }

                R.id.btnSave -> {
                    val intent = intent.putExtra(Constants.IntentFilter.DATA, CountryItem(0, edtCountryname.text.toString(), SELECTED_PATH))
                    setResult(Activity.RESULT_OK, intent)
                    finish()
                }

            }
        }
    }


    private fun checkPermision() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            if (!ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), Constants.PERMISSION_FOR_CAMERA)
            } else {
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), Constants.PERMISSION_FOR_CAMERA)
            }
        } else {
            selectProfilePic()
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        try {
            SELECTED_PATH = mTakePicture!!.onActivityResult(requestCode, resultCode, data)
            Log.e("Tag", "Path: $SELECTED_PATH")
            Glide.with(this).load(SELECTED_PATH).into(ivProfilePic)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun selectProfilePic() {
        try {
            mTakePicture?.selectImage()
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }
}