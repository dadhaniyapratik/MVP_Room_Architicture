/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mvproomarchiticture.ui.common.base.mvp.presenter.lifecycle;

import android.support.annotation.MainThread;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import static com.mvproomarchiticture.ui.common.base.mvp.presenter.lifecycle.PresenterHolderFragment.holderFragmentFor;

/**
 * Factory methods for {@link PresenterStore} class.
 */
@SuppressWarnings("WeakerAccess")
public class PresentersStore {

    private PresentersStore() {
    }

    /**
     * Returns the {@link PresenterStore} of the given activity.
     *
     * @param activity an activity whose {@code PresenterStore} is requested
     * @return a {@code PresenterStore}
     */
    @MainThread
    public static PresenterStore of(FragmentActivity activity) {
        return holderFragmentFor(activity).getPresenterStore();
    }

    /**
     * Returns the {@link PresenterStore} of the given fragment.
     *
     * @param fragment a fragment whose {@code PresenterStore} is requested
     * @return a {@code PresenterStore}
     */
    @MainThread
    public static PresenterStore of(Fragment fragment) {
        return holderFragmentFor(fragment).getPresenterStore();
    }
}
