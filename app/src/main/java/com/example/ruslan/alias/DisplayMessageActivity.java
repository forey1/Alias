package com.example.ruslan.alias;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DisplayMessageActivity extends AppCompatActivity {

    TextView tvOut;
    TextView tvOut1;
    Button yes;
    Button no;
    int yesClicks = 0;
    int noClicks1 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        tvOut = (TextView) findViewById(R.id.tvOut);
        tvOut1 = (TextView) findViewById(R.id.tvOut1);
        View yes = (Button) findViewById(R.id.yes);
        View no = (Button) findViewById(R.id.no);


        Button topButton = yes.findViewById(R.id.yes);
        Button bottomButton = no.findViewById(R.id.no);

        topButton.setText("Отгадал");
        bottomButton.setText("Не отгадал");

        topButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yesClicks++;
                tvOut.setText(yesClicks + " Отгадал");
            }
        });
        bottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                noClicks1++;
                tvOut1.setText(noClicks1 + " Не отгадал");
            }
        });
    }

    public void onClick(View view){

        Button topButton1 = yes.findViewById(R.id.yes);
        Button bottomButton1 = no.findViewById(R.id.no);

        SQLiteDatabase db = getBaseContext().openOrCreateDatabase("app.db", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS users (name TEXT)");
        db.execSQL("INSERT INTO users VALUES ('мафия');");
        db.execSQL("INSERT INTO users VALUES ('заяц');");
        db.execSQL("INSERT INTO users VALUES ('ринг');");
        db.execSQL("INSERT INTO users VALUES ('самолет');");
        db.execSQL("INSERT INTO users VALUES ('монитор');");
        db.execSQL("INSERT INTO users VALUES ('стол');");
        db.execSQL("INSERT INTO users VALUES ('телефон');");
        db.execSQL("INSERT INTO users VALUES ('отчет');");
        db.execSQL("INSERT INTO users VALUES ('компьютер');");

        Cursor query = db.rawQuery("SELECT * FROM users;", null);
        TextView textView = (TextView) findViewById(R.id.textView123);


        if(query.moveToFirst()){
            do{
                String text = query.getString(0);
                textView.append("Name: " + text);
            }
            while(query.moveToNext());
        }
        query.close();
        db.close();
    }
}


