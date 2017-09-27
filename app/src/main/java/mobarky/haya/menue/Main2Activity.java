package mobarky.haya.menue;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener,DialogInterface.OnClickListener{
    private Button btnDate;
    private TextView tvShowdate;
    private Button btnTime;
    private TextView tvShowtime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnDate = (Button) findViewById(R.id.btnDate);
        tvShowdate = (TextView) findViewById(R.id.tvShowdate);
        btnTime = (Button) findViewById(R.id.btnTime);
        tvShowtime = (TextView) findViewById(R.id.tvShowtime);
        btnDate.setOnClickListener(this);
        btnTime.setOnClickListener(this);




    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mainactivity, menu);
        return true;
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mnItmGotpage1:
                Toast.makeText(getBaseContext(), "Hi..... Go to page 1", Toast.LENGTH_LONG).show();
                Intent intent1 = new Intent(getBaseContext(), Main2Activity.class);
                startActivity(intent1);
                break;
            case R.id.mnItmGotpage2:
                Toast.makeText(getBaseContext(), "Hi..... Go to page 2", Toast.LENGTH_LONG).show();
                Intent intent2 = new Intent(getBaseContext(), Main2Activity.class);
                startActivity(intent2);
                break;

            case R.id.mnItmGotpage3:
                Toast.makeText(getBaseContext(), "Hi..... Go to page 3", Toast.LENGTH_LONG).show();
                Intent intent3 = new Intent(getBaseContext(), Main3Activity.class);
                startActivity(intent3);
                break;

            case R.id.mnItmGotpage4:
                Toast.makeText(getBaseContext(), "Hi..... Go to page 4", Toast.LENGTH_LONG).show();
                Intent intent4 = new Intent(getBaseContext(), Main4Activity.class);
                startActivity(intent4);
                break;


        }
        return true;


    }




    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are yoy sure?");
        builder.setCancelable(false);
        builder.setPositiveButton("yes", this);
        builder.setNegativeButton("NO", this);
        AlertDialog dialog = builder.create();
        dialog.show();


    }

    @Override
    public void onClick(View v) {
        if (v == btnDate) {
            Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);

            int month = c.get(Calendar.MONTH);

            int day = c.get(Calendar.DAY_OF_MONTH);
            //
            DatePickerDialog.OnDateSetListener datelistener = new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int day) {
                    tvShowdate.setText(day + "/" + month + "/" + year);
                }
            };
            DatePickerDialog datePickerDialog = new DatePickerDialog(this, datelistener, year, month, day);
            datePickerDialog.show();            //DatePickerDialog datePickerDialog=new DatePickerDialog(this,);
            //datePickerDialog.set

        }


        if (v == btnTime) {
            Calendar c1 = Calendar.getInstance();
            final int hour = c1.get(Calendar.HOUR);

            final int minute = c1.get(Calendar.MINUTE);

            final int second = c1.get(Calendar.SECOND);
            //
            TimePickerDialog.OnTimeSetListener timelistener = new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    tvShowtime.setText(second + "/" + minute + "/" + hour);
                }
            };
            TimePickerDialog timePickerDialog = new TimePickerDialog(this, timelistener, hour, minute, true);
            timePickerDialog.show();
        }


    }

    @Override
    public void onClick(DialogInterface dialog, int which) {

    }
}
