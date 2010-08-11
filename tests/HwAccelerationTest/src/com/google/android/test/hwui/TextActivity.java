/*
 * Copyright (C) 2010 The Android Open Source Project
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

package com.google.android.test.hwui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

@SuppressWarnings({"UnusedDeclaration"})
public class TextActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(new CustomTextView(this));
    }

    static class CustomTextView extends View {
        private final Paint mMediumPaint;
        private final Paint mLargePaint;
        private final Paint mStrikePaint;

        CustomTextView(Context c) {
            super(c);

            mMediumPaint = new Paint();
            mMediumPaint.setAntiAlias(true);
            mMediumPaint.setColor(0xffff0000);
            mLargePaint = new Paint();
            mLargePaint.setAntiAlias(true);
            mLargePaint.setTextSize(36.0f);
            mStrikePaint = new Paint();
            mStrikePaint.setAntiAlias(true);
            mStrikePaint.setTextSize(16.0f);
            mStrikePaint.setUnderlineText(true);
            
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawRGB(255, 255, 255);

            canvas.drawText("Hello OpenGL renderer!", 100, 20, mMediumPaint);
            mMediumPaint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText("Hello OpenGL renderer!", 100, 40, mMediumPaint);
            mMediumPaint.setTextAlign(Paint.Align.RIGHT);
            canvas.drawText("Hello OpenGL renderer!", 100, 60, mMediumPaint);
            mMediumPaint.setTextAlign(Paint.Align.LEFT);
            canvas.drawText("Hello OpenGL renderer!", 100, 100, mMediumPaint);
            canvas.drawText("Hello OpenGL renderer!", 100, 200, mLargePaint);
            
            
            canvas.drawText("Hello OpenGL renderer!", 500, 40, mStrikePaint);
            mStrikePaint.setStrikeThruText(true);
            canvas.drawText("Hello OpenGL renderer!", 500, 70, mStrikePaint);
            mStrikePaint.setUnderlineText(false);
            canvas.drawText("Hello OpenGL renderer!", 500, 100, mStrikePaint);
            mStrikePaint.setStrikeThruText(false);
            mStrikePaint.setUnderlineText(true);
            
            canvas.save();
            canvas.clipRect(150.0f, 220.0f, 450.0f, 320.0f);
            canvas.drawText("Hello OpenGL renderer!", 100, 300, mLargePaint);
            canvas.restore();
        }
    }
}