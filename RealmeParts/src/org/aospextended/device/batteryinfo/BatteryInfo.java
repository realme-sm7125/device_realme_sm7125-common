/*
 * Copyright (C) 2023 The Evolution X Project
 * SPDX-License-Identifier: Apache-2.0
 */

package org.aospextended.device.batteryinfo;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import androidx.preference.PreferenceFragment;
import androidx.preference.PreferenceManager;
import androidx.preference.Preference;

// import org.aospextended.device.misc.Constants;
import org.aospextended.device.R;
import org.aospextended.device.util.Utils;

public class BatteryInfo extends PreferenceFragment
        implements Preference.OnPreferenceChangeListener {

    public static final String KEY_CAPACITY = "capacity";
    public static final String KEY_CYCLE_COUNT = "cycle_count";
    public static final String KEY_HEALTH = "health";
    public static final String KEY_STATUS = "status";
    public static final String NODE_CAPACITY = "/sys/class/power_supply/battery/capacity";
    public static final String NODE_CYCLE_COUNT = "/sys/class/power_supply/battery/cycle_count";
    public static final String NODE_HEALTH = "/sys/class/power_supply/battery/health";
    public static final String NODE_STATUS = "/sys/class/power_supply/battery/status";

    private static final String TAG = BatteryInfo.class.getSimpleName();

    // Battery info
    private Preference mCapacityPreference;
    private Preference mCycleCountPreference;
    private Preference mHealthPreference;
    private Preference mStatusPreference;

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.batteryinfo);
        SharedPreferences prefs = getActivity().getSharedPreferences("batteryinfo",
                Activity.MODE_PRIVATE);

        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(getContext());
        Context context = getContext();

        // Capacity preference
        mCapacityPreference = (Preference) findPreference(KEY_CAPACITY);
        if (Utils.isFileReadable(NODE_CYCLE_COUNT)) {
            String fileValue = Utils.getFileValue(NODE_CAPACITY, null);
            mCapacityPreference.setSummary(fileValue + "%");
        } else {
            mCapacityPreference.setSummary(getString(R.string.node_not_readable_error));
            mCapacityPreference.setEnabled(false);
        }

        // Cycle count preference
        mCycleCountPreference = (Preference) findPreference(KEY_CYCLE_COUNT);
        if (Utils.isFileReadable(NODE_CYCLE_COUNT)) {
            String fileValue = Utils.getFileValue(NODE_CYCLE_COUNT, null);
            mCycleCountPreference.setSummary(fileValue);
        } else {
            mCycleCountPreference.setSummary(getString(R.string.node_not_readable_error));
            mCycleCountPreference.setEnabled(false);
        }

        // Health preference
        mHealthPreference = (Preference) findPreference(KEY_HEALTH);
        if (Utils.isFileReadable(NODE_HEALTH)) {
            String fileValue = Utils.getFileValue(NODE_HEALTH, null);
            mHealthPreference.setSummary(fileValue);
        } else {
            mHealthPreference.setSummary(getString(R.string.node_not_readable_error));
            mHealthPreference.setEnabled(false);
        }

        // Status preference
        mStatusPreference = (Preference) findPreference(KEY_STATUS);
        if (Utils.isFileReadable(NODE_STATUS)) {
            String fileValue = Utils.getFileValue(NODE_STATUS, null);
            mStatusPreference.setSummary(fileValue);
        } else {
            mStatusPreference.setSummary(getString(R.string.node_not_readable_error));
            mStatusPreference.setEnabled(false);
        }
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        return false;
    }
}
