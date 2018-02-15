/*
 * Copyright (C) 2018 The Dirty Unicorns Project
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

package com.android.settings.display;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.om.IOverlayManager;
import android.content.om.OverlayInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.UserHandle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;

import com.android.internal.logging.nano.MetricsProto;

import com.android.settings.R;
import com.android.settings.core.instrumentation.InstrumentedDialogFragment;

public class AccentPicker extends InstrumentedDialogFragment implements OnClickListener {

    private static final String TAG_ACCENT_PICKER = "accent_picker";

    private View mView;
    private int mUserId;

    private IOverlayManager mOverlayManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUserId = UserHandle.myUserId();
        mOverlayManager = IOverlayManager.Stub.asInterface(
                ServiceManager.getService(Context.OVERLAY_SERVICE));
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        mView = LayoutInflater.from(getActivity()).inflate(R.layout.accent_picker, null);
        initView();

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(mView)
                .setNegativeButton(R.string.cancel, this)
                .setNeutralButton(R.string.theme_accent_picker_default, this)
                .setCancelable(false);

        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(true);
        return dialog;
    }

    private void initView() {
        ContentResolver resolver = getActivity().getContentResolver();

        Button BubblegumPinkAccent = null;
        if (mView != null) {
            BubblegumPinkAccent = mView.findViewById(R.id.BubblegumPinkAccent);
        }
        if (BubblegumPinkAccent != null) {
            BubblegumPinkAccent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Settings.System.putIntForUser(resolver,
                            Settings.System.ACCENT_PICKER, 2, UserHandle.USER_CURRENT);
                    dismiss();
                }
            });
        }

        Button CyanAccent = null;
        if (mView != null) {
            CyanAccent = mView.findViewById(R.id.CyanAccent);
        }
        if (CyanAccent != null) {
            CyanAccent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Settings.System.putIntForUser(resolver,
                            Settings.System.ACCENT_PICKER, 3, UserHandle.USER_CURRENT);
                    dismiss();
                }
            });
        }

        Button FlareAccent = null;
        if (mView != null) {
            FlareAccent = mView.findViewById(R.id.FlareAccent);
        }
        if (FlareAccent != null) {
            FlareAccent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Settings.System.putIntForUser(resolver,
                            Settings.System.ACCENT_PICKER, 4, UserHandle.USER_CURRENT);
                    dismiss();
                }
            });
        }

        Button PurpinkAccent = null;
        if (mView != null) {
            PurpinkAccent = mView.findViewById(R.id.PurpinkAccent);
        }
        if (PurpinkAccent != null) {
            PurpinkAccent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Settings.System.putIntForUser(resolver,
                            Settings.System.ACCENT_PICKER, 5, UserHandle.USER_CURRENT);
                    dismiss();
                }
            });
        }

        Button QuepalAccent = null;
        if (mView != null) {
            QuepalAccent = mView.findViewById(R.id.QuepalAccent);
        }
        if (QuepalAccent != null) {
            QuepalAccent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Settings.System.putIntForUser(resolver,
                            Settings.System.ACCENT_PICKER, 1, UserHandle.USER_CURRENT);
                    dismiss();
                }
            });
        }

        Button StockAccent = null;
        if (mView != null) {
            aospAccent = mView.findViewById(R.id.StockAccent);
        }
        if (StockAccent != null) {
            StockAccent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Settings.System.putIntForUser(resolver,
                            Settings.System.ACCENT_PICKER, 6, UserHandle.USER_CURRENT);
                    dismiss();
                }
            });
        }

        Button SunsetAccent = null;
        if (mView != null) {
            SunsetAccent = mView.findViewById(R.id.SunsetAccent);
        }
        if (SunsetAccent != null) {
            SunsetAccent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Settings.System.putIntForUser(resolver,
                            Settings.System.ACCENT_PICKER, 7, UserHandle.USER_CURRENT);
                    dismiss();
                }
            });
        }

        Button VeryBlueAccent = null;
        if (mView != null) {
            VeryBlueAccent = mView.findViewById(R.id.VeryBlueAccent);
        }
        if (VeryBlueAccent != null) {
            VeryBlueAccent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Settings.System.putIntForUser(resolver,
                            Settings.System.ACCENT_PICKER, 7, UserHandle.USER_CURRENT);
                    dismiss();
                }
            });
        }

        GridLayout gridlayout;
        if (mView != null) {

            int intOrientation = getResources().getConfiguration().orientation;
            gridlayout = mView.findViewById(R.id.Gridlayout);
            // Lets split this up instead of creating two different layouts
            // just so we can change the columns
            if (intOrientation == Configuration.ORIENTATION_PORTRAIT) {
                gridlayout.setColumnCount(5);
            } else {
                gridlayout.setColumnCount(8);
            }
        }
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        ContentResolver resolver = getActivity().getContentResolver();

        if (which == AlertDialog.BUTTON_NEGATIVE) {
           dismiss();
        }
        if (which == AlertDialog.BUTTON_NEUTRAL) {
           Settings.System.putIntForUser(resolver,
                   Settings.System.ACCENT_PICKER, 0, UserHandle.USER_CURRENT);
           dismiss();
        }
    }

    public static void show(Fragment parent) {
        if (!parent.isAdded()) return;

        final AccentPicker dialog = new AccentPicker();
        dialog.setTargetFragment(parent, 0);
        dialog.show(parent.getFragmentManager(), TAG_ACCENT_PICKER);
    }

    @Override
    public int getMetricsCategory() {
        return MetricsProto.MetricsEvent.CUSTOM_SETTINGS;
    }
}
