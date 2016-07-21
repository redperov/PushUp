package com.example.danny.myapplication;

import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.graphics.Color;
import android.widget.RelativeLayout;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ResolveInfo;



public class MainActivity extends ActionBarActivity {

    private void TestUpload() {
        int i = 1;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent=new Intent(this,MyIntentService.class);
        startService(intent);
        Intent i=new Intent(this,MyService.class);
        startService(i);

    }

    public void SwitchPage(View view){
        Intent i=new Intent(this,SecondaryPage.class);

        final EditText input=(EditText)findViewById(R.id.input);
        String message=input.getText().toString();
        i.putExtra("mainMessage",message);

        startActivity(i);
    }

    private  boolean retVal=true;

    public void ShareClicked(View view){
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        String shareBody = "recipe-app://recipes/grilled-potato-salad";
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Check out this post");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(sharingIntent, "Share via"));
    }

    public void sendEmail(View view) {

        Log.i("Send email", "");
        String[] TO = {""};
        String[] CC = {""};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message goes here");

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
           // Log.i("Finished sending email...", "");
        }
        catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(MainActivity.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
        /*
        String to = "reportidk@gmail.com";
        String subject = "Report";
        String message = "Report has been made";

        Intent email = new Intent(Intent.ACTION_SEND);
        email.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
        email.putExtra(Intent.EXTRA_SUBJECT, subject);
        email.putExtra(Intent.EXTRA_TEXT, message);
        email.setType("message/rfc822");
        startActivity(Intent.createChooser(email, "Select Email Client"));
*/
    }

    public void DoStuff(View view) {
        RelativeLayout myLayout=(RelativeLayout)findViewById(R.id.layoutId);
        TextView text = (TextView) findViewById(R.id.label);
        if (retVal) {
            text.setText("Hello World");
            retVal = false;
            myLayout.setBackgroundColor(Color.RED);
        } else {
            text.setText("hi there");
            retVal = true;
            myLayout.setBackgroundColor(Color.GREEN);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
      RelativeLayout mainItem=(RelativeLayout)findViewById(R.id.layoutId);
        switch(item.getItemId()){
            case R.id.item1:
                if (item.isChecked()){
                    item.setChecked(false);
                }
                else{
                    item.setChecked(true);
                }
                mainItem.setBackgroundColor(Color.RED);
               return  true;

            case R.id.item2:
                if (item.isChecked()){
                    item.setChecked(false);
                }
                else{
                    item.setChecked(true);
                }
                mainItem.setBackgroundColor(Color.GREEN);
                return  true;

            case R.id.item3:
                if (item.isChecked()){
                    item.setChecked(false);
                }
                else{
                    item.setChecked(true);
                }
                mainItem.setBackgroundColor(Color.BLUE);
                return  true;
            default:
               return super.onOptionsItemSelected(item);

        }
    }



}


