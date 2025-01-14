/*
 * Copyright (C) 2021-2023 The LineageOS Project
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
package org.lineageos.recorder.task;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;

import androidx.annotation.NonNull;

public final class DeleteRecordingTask implements Runnable {
    private static final String TAG = "DeleteRecordingTask";

    @NonNull
    private final ContentResolver cr;
    @NonNull
    private final Uri uri;

    public DeleteRecordingTask(@NonNull ContentResolver cr, @NonNull Uri uri) {
        this.cr = cr;
        this.uri = uri;
    }

    @Override
    public void run() {
        try {
            cr.delete(uri, null, null);
        } catch (SecurityException e) {
            Log.e(TAG, "Failed to delete recording", e);
        }
    }
}
