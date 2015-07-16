package com.example.test;

import android.support.v4.app.NotificationCompat;
import android.support.v7.app.ActionBarActivity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    
    public void login(View arg0){
    			//Dati in ingresso all'index
            	Intent i=new Intent(arg0.getContext(),IndexActivity.class);
            	EditText etFName = (EditText) findViewById(R.id.usernameText);
            	i.putExtra("username", etFName.getText().toString());
            	//Dati in ingresso alla message
            	Uri sound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            	Intent mess=new Intent(this,MessageActivity.class);
            	PendingIntent pi=PendingIntent.getActivity(this, 0, mess, 0);
            	
            	
            	NotificationCompat.Builder n  = new NotificationCompat.Builder(this)
            	.setContentTitle("Arancino's")
            	.setContentText("Login effettuata")
            	.setSmallIcon(android.R.drawable.ic_dialog_info)
            	.setContentIntent(pi)
            	.setAutoCancel(true)
            	.setSound(sound);
            	 
            	NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            	        notificationManager.notify(0, n.build());
            	        
            	
            	
            	startActivity(i);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    
}
