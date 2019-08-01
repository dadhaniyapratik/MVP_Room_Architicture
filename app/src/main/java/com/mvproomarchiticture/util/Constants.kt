package com.mvproomarchiticture.util

import android.os.Environment

object Constants {

    val SDCARD = Environment.getExternalStorageDirectory().toString() + "/MVP Room/"
    const val SPLASH_DURATION = 3000L
    const val SUCCESS = 1
    const val ERROR = 0

    //    const val PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@$!%*?&])[A-Za-z\\d$@$!%*?&]{8,}"
    const val PASSWORD_PATTERN = "^(?=.*?[A-Z])(?=(.*[a-z]){1,})(?=(.*[\\d]){1,})(?=(.*[\\W]){1,})(?!.*\\s).{8,}\$"
//    const val POSTAL_CODE_PATTERN="^(?!.*[DFIOQU])[A-VXY][0-9][A-Z]●?[0-9][A-Z][0-9]\$"
    const val POSTAL_CODE_PATTERN="^(?!.*[DFIOQU])[A-VXY][0-9][A-Z] ?[0-9][A-Z][0-9]\$"


    const val CAMERA_CAPTURE = 100
    const val CROP_CODE = 203
    const val GALLERY = 101
    const val PERMISSION_FOR_CAMERA = 11


    object MANAGE_VIEW {
        const val SHOW_LAYOUT = 0
        const val SHOW_PROGRESS = 1
        const val SHOW_NO_INTERNET_CONNETCTION = 2
    }

    object IntentFilter{
        const val DATA = "data"
    }


    val REPORT_NUMBER : String = "REPORT_NUMBER"







}