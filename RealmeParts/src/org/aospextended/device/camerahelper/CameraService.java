/*
 * Copyright (C) 2019 The LineageOS Project
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

package org.aospextended.device.camerahelper;

import android.annotation.NonNull;
import android.app.KeyguardManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.hardware.camera2.CameraManager;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.view.Gravity;
import android.util.Slog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.annotation.Nullable;

import org.aospextended.device.R;
import org.aospextended.device.util.Utils;

public class CameraService extends Service {
    private static final boolean DEBUG = Utils.DEBUG;
    private static final String TAG = "CameraService";

    public static final String FRONT_CAMERA_ID = "1";

    private View mFloatingView;
    private ProgressBar progressBar;
    private ImageView imageView;
    private WindowManager windowManager;

    private CameraManager.AvailabilityCallback mAvailabilityCallback =
            new CameraManager.AvailabilityCallback() {
                @Override
                public void onCameraOpened(@NonNull String cameraId, @NonNull String packageId) {
                    super.onCameraOpened(cameraId, packageId);
                    if (cameraId.equals(FRONT_CAMERA_ID)) {
                        show();
                    }
                }

                @Override
                public void onCameraClosed(@NonNull String cameraId) {
                    super.onCameraClosed(cameraId);
                    if (cameraId.equals(FRONT_CAMERA_ID)) {
                        hide();
                    }
                }
            };

    @Override
    public void onCreate() {
        CameraManager cameraManager = getSystemService(CameraManager.class);
        cameraManager.registerAvailabilityCallback(mAvailabilityCallback, null);

        mFloatingView = LayoutInflater.from(this).inflate(R.layout.notch, null);
        imageView = mFloatingView.findViewById(R.id.imageViewCircle);
        progressBar = mFloatingView.findViewById(R.id.progress_circular);

        windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
    }

    public void show() {
        if (DEBUG) Slog.d(TAG, "show");
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                PixelFormat.TRANSPARENT);
        layoutParams.gravity = Gravity.TOP | Gravity.START;
        layoutParams.x = 58;
        layoutParams.y = -84;
        try {
            windowManager.addView(mFloatingView, layoutParams);
        } catch (RuntimeException e) {
        }

        mFloatingView.setVisibility(View.VISIBLE);

        progressBar.setVisibility(View.VISIBLE);
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            imageView.animate().alpha(1f).setDuration(500);
            imageView.setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.GONE);
        }, 1000);
    }

    public void hide() {
        if (DEBUG) Slog.d(TAG, "hide");
        windowManager.removeView(mFloatingView);
        imageView.setVisibility(View.GONE);
        progressBar.setVisibility(View.GONE);
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (DEBUG) Slog.d(TAG, "Starting service");
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        if (DEBUG) Slog.d(TAG, "Destroying service");
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
