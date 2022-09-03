/*
 * Copyright (C) 2018 The LineageOS Project
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

package org.aospextended.device.misc;

import android.content.Context;
import android.os.Bundle;
import androidx.preference.Preference;
import androidx.preference.Preference.OnPreferenceChangeListener;
import androidx.preference.PreferenceFragment;
import androidx.preference.SwitchPreference;

import org.aospextended.device.R;
import org.aospextended.device.utils.FileUtils;

public class MiscSettingsFragment extends PreferenceFragment implements
        OnPreferenceChangeListener {

    private SwitchPreference mOTG;
    private static final String PREF_OTG = "otg";
    private static final String OTG_PATH = "/sys/class/power_supply/usb/otg_switch";
    private SwitchPreference mGameSwitchPreference;
    private static final String GAMESWITCH_ENABLE_KEY = "game_switch";
    private static final String GAMESWITCH_NODE = "/proc/touchpanel/game_switch_enable";

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.misc_settings);
        mOTG = (SwitchPreference) findPreference(PREF_OTG);
        if (FileUtils.fileExists(OTG_PATH)) {
            mOTG.setEnabled(true);
            mOTG.setOnPreferenceChangeListener(this);
        } else {
            mOTG.setSummary(R.string.otg_enable_summary_not_supported);
            mOTG.setEnabled(false);
        }
        mGameSwitchPreference = (SwitchPreference) findPreference(GAMESWITCH_ENABLE_KEY);
        if (FileUtils.fileExists(GAMESWITCH_NODE)) {
            mGameSwitchPreference.setEnabled(true);
            mGameSwitchPreference.setOnPreferenceChangeListener(this);
        } else {
            mGameSwitchPreference.setSummary(R.string.gameswitch_enable_summary_not_supported);
            mGameSwitchPreference.setEnabled(false);
        }
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        if (PREF_OTG.equals(preference.getKey())) {
            FileUtils.writeLine(OTG_PATH, (Boolean) newValue ? "1":"0");
        }
        if (GAMESWITCH_ENABLE_KEY.equals(preference.getKey())) {
            FileUtils.writeLine(GAMESWITCH_NODE, (Boolean) newValue ? "1" : "0");
        }
        return true;
    }

}
