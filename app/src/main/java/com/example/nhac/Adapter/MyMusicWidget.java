package com.example.nhac.Adapter;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.widget.RemoteViews;

import com.example.nhac.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MyMusicWidget extends AppWidgetProvider {
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgerIds){
        DateFormat format = SimpleDateFormat.getDateInstance(SimpleDateFormat.MEDIUM, Locale.getDefault());
        RemoteViews remoteView = new RemoteViews(context.getPackageName(), R.layout.widgets_layout);
        ComponentName musicWidget = new ComponentName(context, MyMusicWidget.class);
        remoteView.setTextViewText(R.id.textview01, "Time =" + format.format(new Date()));
        appWidgetManager.updateAppWidget(musicWidget,remoteView);
    }
}
