package com.example.administrator.intentdemo;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.provider.AlarmClock;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //createAlarm("new AlarmClock",10,65);
        //startTimer("new",10);
        //Intent intent = new Intent(AlarmClock.ACTION_SHOW_ALARMS);
        //startActivity(intent);

        //addEvent("Title", "苏州", Calendar.getInstance(), Calendar.getInstance(),"xz2258@qq.com");
        //Uri geo = Uri.parse("geo:31.32,120.61");
        Uri geo = Uri.parse("geo:0,0?q=31.32,120.61(神仙之地)");
        //Uri geo = Uri.parse("geo:0,0?q=苏州大学东校区");
        showMap(geo);

        //searchWeb("孙悟空");
        //Uri geo = Uri.parse("/storage/emulated/0/Pictures/");
        //playMedia(geo);
    }

    public void createAlarm(String message, int hour, int minutes) {
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, message)
                .putExtra(AlarmClock.EXTRA_HOUR, hour)
                .putExtra(AlarmClock.EXTRA_MINUTES, minutes)
                .putExtra(AlarmClock.EXTRA_SKIP_UI, true);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void startTimer(String message, int seconds) {
        Intent intent = new Intent(AlarmClock.ACTION_SET_TIMER)
                .putExtra(AlarmClock.EXTRA_MESSAGE, message)
                .putExtra(AlarmClock.EXTRA_LENGTH, seconds)
                .putExtra(AlarmClock.EXTRA_SKIP_UI, true);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void addEvent(String title, String location, Calendar begin, Calendar end, String emails) {
        Intent intent = new Intent(Intent.ACTION_INSERT)
                .setData(CalendarContract.Events.CONTENT_URI)
                .putExtra(CalendarContract.Events.TITLE, title)
                .putExtra(CalendarContract.Events.EVENT_LOCATION, location)
                .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, begin)
                .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, end)
                .putExtra(Intent.EXTRA_EMAIL, emails);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void showMap(Uri geoLocation) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(geoLocation);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void searchWeb(String query) {
        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
        intent.putExtra(SearchManager.QUERY, query);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void playMedia(Uri file) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        //intent.setType("application/ogg");
        intent.setData(file);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
