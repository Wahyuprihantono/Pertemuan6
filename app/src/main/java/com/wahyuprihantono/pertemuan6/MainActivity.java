package com.wahyuprihantono.pertemuan6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnMove = findViewById(R.id.startNewActivity);
        btnMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MainActivity2.class));
            }
        });

        Toast.makeText(this, "Activity: onCreate()", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onStart(){
        super.onStart();

        Toast.makeText(this, "Activity: onStart()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume(){
        super.onResume();
        Toast.makeText(this, "Activity: onResume()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause(){
        super.onPause();
        Toast.makeText(this, "Activity: onPause()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop(){
        super.onStop();
        Toast.makeText(this, "Activity: onStop()", Toast.LENGTH_SHORT).show();
    }

    public void process(View view) {
        Intent intent = null, chooser = null;


        if (view.getId() == R.id.launchMap) {
            intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("geo:28.704, 77.102"));
            chooser = Intent.createChooser(intent, "Buka Maps");
            startActivity(chooser);
        }
        if (view.getId() == R.id.launchMarket) {
            intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("market://details?id=com.android.chrome&hl=en"));
            chooser = Intent.createChooser(intent, "Buka Market");
            startActivity(chooser);
        }
        if (view.getId() == R.id.sendMail) {
            intent = new Intent(Intent.ACTION_SEND);
            intent.setData(Uri.parse("mailto:"));
            String[] to = {"emailAddress1", "emailAddress2"};
            intent.putExtra(Intent.EXTRA_EMAIL, to);
            intent.putExtra(Intent.EXTRA_SUBJECT, "Email test");
            intent.putExtra(Intent.EXTRA_TEXT, "Hi there. Testing the mail app");
            intent.setType("message/rfc822");
            chooser = Intent.createChooser(intent, "Send Email");
            startActivity(chooser);
        }

        if (view.getId() == R.id.makeToast) {
            Toast toast = new Toast(this);
            toast.setDuration(Toast.LENGTH_LONG);
            toast.setGravity(Gravity.BOTTOM, 0, 0);
            LayoutInflater inflater = getLayoutInflater();
            View appearance = inflater.inflate(R.layout.custom_toast, (ViewGroup) findViewById(R.id.llToast));
            toast.setView(appearance);
            toast.show();
        }
    }
}