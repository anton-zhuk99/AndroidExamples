package com.example.myfirstapp.module07.notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.myfirstapp.R;
import com.example.myfirstapp.activities.MainActivity;

public class NotificationActivity extends AppCompatActivity {

    private static int notificationId;
    private static String chanelId;

    static {
        notificationId = 111;
        chanelId = "CHANNEL_ID";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        createNotificationChannel();

        Button notificationButton = findViewById(R.id.show_notification_button);
        notificationButton.setOnClickListener(v -> {
            Log.d("MyLog", "In OnClickListener (notificationButton).");

            Intent notifyIntent = new Intent(this, NotificationSelectedActivity.class);
            // Set the Activity to start in a new, empty task
            // task stack
            notifyIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                                | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            // Create the PendingIntent
            PendingIntent notifyPendingIntent = PendingIntent.getActivity(
                    this, 0, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT
            );

            NotificationCompat.Builder builder =
                    new NotificationCompat.Builder(
                            NotificationActivity.this, // this
                            chanelId);
            builder
                    .setColor(getResources().getColor(R.color.purple_500))
                    .setSmallIcon(R.drawable.notification_icon)
                    .setContentTitle("Notification Title")
                    .setContentText("You need to do some actions")
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                    .setContentIntent(notifyPendingIntent)
                    .setAutoCancel(true);

            NotificationManagerCompat.from(this).notify(notificationId, builder.build());
            notificationId++;
        });
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.channel_name);
            String description = getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(chanelId, name, importance);
            channel.setDescription(description);
            // регистрация канала уведомлений
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}