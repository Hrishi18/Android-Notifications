package com.example.android.notifications;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationBuilderWithBuilderAccessor;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class ActivityA extends AppCompatActivity {
    String contentText = "Hey I am watching the android videos of Smartherd" + " I am enjoying alot."+ " It is amazing.";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
    }

    public void showNotification(View view) {
        switch(view.getId()){
            case R.id.button1:
                showNormalViewNotification();
                break;
            case R.id.button2:
                showBigTextNotification();
                break;
            case R.id.button3:
                showBigPictureNotification();
                break;
            case R.id.button4:
                showInboxStyleNotification();
                break;
        }
    }

    private void showInboxStyleNotification() {
        //Assign Inbox style notification
        NotificationCompat.InboxStyle style = new NotificationCompat.InboxStyle();
        style.setBigContentTitle("Inbox Style Regular Notification");
        style.addLine("Line 1");
        style.addLine("Line 2");
        style.addLine("Line 3");
        style.addLine("Line 4");

        //Build the content of the notification
        NotificationCompat.Builder builder = new NotificationCompat.Builder(ActivityA.this);
        builder.setContentTitle("Inbox Style Regular Notification");
        builder.setContentText(contentText);
        builder.setSmallIcon(R.drawable.ic_launcher_background);
        builder.setTicker("Hey, This is a ticker!!!!!!");
        builder.setAutoCancel(true);
        builder.setStyle(style);


        //Provide explicit intents for notification
        Intent i = new Intent(ActivityA.this,ActivityB.class);
        //Add a back stack  using task using stack builder and set the intent to pending intent
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(ActivityB.class);
        stackBuilder.addNextIntent(i);
        PendingIntent pi_main =stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);

        //Provide explicit intents Add a back stack  using task using stack builder and set the intent to pending intent for settings
        Intent j = new Intent(ActivityA.this,Settings.class);
        TaskStackBuilder stackBuilder_settings = TaskStackBuilder.create(this);
        stackBuilder_settings.addParentStack(Settings.class);
        stackBuilder_settings.addNextIntent(j);
        PendingIntent pi_settings =stackBuilder_settings.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);


        //Provide explicit intents Add a back stack  using task using stack builder and set the intent to pending intent for help
        Intent k = new Intent(ActivityA.this,Help.class);
        TaskStackBuilder stackBuilder_help = TaskStackBuilder.create(this);
        stackBuilder_help.addParentStack(Help.class);
        stackBuilder_help.addNextIntent(k);
        PendingIntent pi_help =stackBuilder_help.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);

        builder.setContentIntent(pi_main);
        builder.addAction(R.drawable.settings,"Settings",pi_settings);
        builder.addAction(R.drawable.help,"Help",pi_help);

        //Notifications through notification manager
        Notification notification = builder.build();
        NotificationManager manager = (NotificationManager) this.getSystemService(NOTIFICATION_SERVICE);
        manager.notify(29,notification);
    }

    private void showBigPictureNotification() {
        //Assign Big picture notification
        Bitmap bmp = BitmapFactory.decodeResource(this.getResources(),R.drawable.food);
        NotificationCompat.BigPictureStyle style = new NotificationCompat.BigPictureStyle();
        style.setBigContentTitle("Big pictures regular notification");
        style.bigPicture(bmp);



        //Build the content of the notification
        NotificationCompat.Builder builder = new NotificationCompat.Builder(ActivityA.this);
        builder.setContentTitle("Big Picture Regular Notification");
        builder.setContentText(contentText);
        builder.setSmallIcon(R.drawable.ic_launcher_background);
        builder.setTicker("Hey, This is a ticker!!!!!!");
        builder.setAutoCancel(true);
        builder.setStyle(style);


        //Provide explicit intents for notification
        Intent i = new Intent(ActivityA.this,ActivityB.class);
        //Add a back stack  using task using stack builder and set the intent to pending intent
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(ActivityB.class);
        stackBuilder.addNextIntent(i);
        PendingIntent pi_main =stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);

        //Provide explicit intents Add a back stack  using task using stack builder and set the intent to pending intent for settings
        Intent j = new Intent(ActivityA.this,Settings.class);
        TaskStackBuilder stackBuilder_settings = TaskStackBuilder.create(this);
        stackBuilder_settings.addParentStack(Settings.class);
        stackBuilder_settings.addNextIntent(j);
        PendingIntent pi_settings =stackBuilder_settings.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);


        //Provide explicit intents Add a back stack  using task using stack builder and set the intent to pending intent for help
        Intent k = new Intent(ActivityA.this,Help.class);
        TaskStackBuilder stackBuilder_help = TaskStackBuilder.create(this);
        stackBuilder_help.addParentStack(Help.class);
        stackBuilder_help.addNextIntent(k);
        PendingIntent pi_help =stackBuilder_help.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);

        builder.setContentIntent(pi_main);
        builder.addAction(R.drawable.settings,"Settings",pi_settings);
        builder.addAction(R.drawable.help,"Help",pi_help);

        //Notifications through notification manager
        Notification notification = builder.build();
        NotificationManager manager = (NotificationManager) this.getSystemService(NOTIFICATION_SERVICE);
        manager.notify(9127,notification);
    }

    private void showBigTextNotification() {
        //Assign a style of big text
        NotificationCompat.BigTextStyle style = new NotificationCompat.BigTextStyle();
        style.setBigContentTitle("BigText Regular Notification");
        style.bigText(contentText);

        //Build the content of the notification
        NotificationCompat.Builder builder = new NotificationCompat.Builder(ActivityA.this);
        builder.setContentTitle("Big Text Regular Notification");
        builder.setContentText(contentText);
        builder.setSmallIcon(R.drawable.ic_launcher_background);
        builder.setTicker("Hey, This is a ticker!!!!!!");
        builder.setAutoCancel(true);


        //Provide explicit intents for notification
        Intent i = new Intent(ActivityA.this,ActivityB.class);
        //Add a back stack  using task using stack builder and set the intent to pending intent
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(ActivityB.class);
        stackBuilder.addNextIntent(i);
        PendingIntent pi_main =stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);

        //Provide explicit intents Add a back stack  using task using stack builder and set the intent to pending intent for settings
        Intent j = new Intent(ActivityA.this,Settings.class);
        TaskStackBuilder stackBuilder_settings = TaskStackBuilder.create(this);
        stackBuilder_settings.addParentStack(Settings.class);
        stackBuilder_settings.addNextIntent(j);
        PendingIntent pi_settings =stackBuilder_settings.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);


        //Provide explicit intents Add a back stack  using task using stack builder and set the intent to pending intent for help
        Intent k = new Intent(ActivityA.this,Help.class);
        TaskStackBuilder stackBuilder_help = TaskStackBuilder.create(this);
        stackBuilder_help.addParentStack(Help.class);
        stackBuilder_help.addNextIntent(k);
        PendingIntent pi_help =stackBuilder_help.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);

        builder.setContentIntent(pi_main);
        builder.addAction(R.drawable.settings,"Settings",pi_settings);
        builder.addAction(R.drawable.help,"Help",pi_help);

        builder.setStyle(style);
        //Notifications through notification manager
        Notification notification = builder.build();
        NotificationManager manager = (NotificationManager) this.getSystemService(NOTIFICATION_SERVICE);
        manager.notify(987,notification);
    }

    public void showNormalViewNotification(){
        //Build the content of the notification
        NotificationCompat.Builder builder = new NotificationCompat.Builder(ActivityA.this);
        builder.setContentTitle("Normal Regular Notification");
        builder.setContentText(contentText);
        builder.setSmallIcon(R.drawable.ic_launcher_background);
        builder.setTicker("Hey, This is a ticker!!!!!!");
        builder.setAutoCancel(true);



        //Provide explicit intents for notification
        Intent i = new Intent(ActivityA.this,ActivityB.class);
        //Add a back stack  using task using stack builder and set the intent to pending intent
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(ActivityB.class);
        stackBuilder.addNextIntent(i);
        PendingIntent pi_main =stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);

        //Provide explicit intents Add a back stack  using task using stack builder and set the intent to pending intent for settings
        Intent j = new Intent(ActivityA.this,Settings.class);
        TaskStackBuilder stackBuilder_settings = TaskStackBuilder.create(this);
        stackBuilder_settings.addParentStack(Settings.class);
        stackBuilder_settings.addNextIntent(j);
        PendingIntent pi_settings =stackBuilder_settings.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);


        //Provide explicit intents Add a back stack  using task using stack builder and set the intent to pending intent for help
        Intent k = new Intent(ActivityA.this,Help.class);
        TaskStackBuilder stackBuilder_help = TaskStackBuilder.create(this);
        stackBuilder_help.addParentStack(Help.class);
        stackBuilder_help.addNextIntent(k);
        PendingIntent pi_help =stackBuilder_help.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);

        builder.setContentIntent(pi_main);
        builder.addAction(R.drawable.settings,"Settings",pi_settings);
        builder.addAction(R.drawable.help,"Help",pi_help);





        //Notifications through notification manager
        Notification notification = builder.build();
        NotificationManager manager = (NotificationManager) this.getSystemService(NOTIFICATION_SERVICE);
        manager.notify(1234,notification);
    }
}
