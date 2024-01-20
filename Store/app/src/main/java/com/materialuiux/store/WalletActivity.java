package com.materialuiux.store;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;


import com.materialuiux.store.utility.linechart.Line;
import com.materialuiux.store.utility.linechart.LineChartView;
import com.materialuiux.store.utility.linechart.LinePoint;

import java.util.Calendar;

import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;

public class WalletActivity extends AppCompatActivity {

    private LineChartView chart;
    private String title;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        chart = (LineChartView) findViewById(R.id.chart);
        chart.setViewPort(0, 0, 100, 120);
        chart.setGridSize(10, 0, 20, 0);
        chart.addLine(generateLine(0, 360, 8, 80, 30).setFilled(true).smoothLine(4));

        /* starts before 1 month from now */
        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.MONTH, -1);

        /* ends after 1 month from now */
        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.MONTH, 1);
        HorizontalCalendar horizontalCalendar  = new HorizontalCalendar.Builder(this, R.id.calendarView).range(startDate, endDate).datesNumberOnScreen(5).build();

        horizontalCalendar.setCalendarListener(new HorizontalCalendarListener() {
            @Override
            public void onDateSelected(Calendar date, int position) {

            }
        });
    }

    private Line generateLine(int startX, int endX, int step, int minY, int maxY) {
        Line line = new Line(this);
        for (int i = startX; i <= endX; i += step) {
            line.addPoint(new LinePoint(this, i, (int) (Math.random() * (maxY - minY) + minY)));
        }
        return line;
    }
}
