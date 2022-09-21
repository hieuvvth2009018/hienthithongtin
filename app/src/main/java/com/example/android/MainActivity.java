package com.example.android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private NotificationManagerCompat notificationManagerCompat;
    private EditText editTextTitle;
    private EditText editTextMessage;
    private Button button1;
    private Button button2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.editTextTitle = (EditText) this.findViewById(R.id.title);
        this.editTextMessage = (EditText) this.findViewById(R.id.message);
        this.button1 = (Button) this.findViewById(R.id.send);
        this.button2 = (Button) this.findViewById(R.id.send2);

        this.notificationManagerCompat = NotificationManagerCompat.from(this);
        this.button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendOnChannel1();
            }
        });
        this.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendOnChannel2();
            }
        });

    }

    private void sendOnChannel1()  {

        String title = this.editTextTitle.getText().toString();
        String message = this.editTextMessage.getText().toString();

        Notification notification = new NotificationCompat.Builder(this, NotificationApp.CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

        int notificationId = 1;
        this.notificationManagerCompat.notify(notificationId, notification);
    }

    private void sendOnChannel2()  {
        String title = this.editTextTitle.getText().toString();
        String message = this.editTextMessage.getText().toString();

        Notification notification = new NotificationCompat.Builder(this, NotificationApp.CHANNEL_2_ID)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setCategory(NotificationCompat.CATEGORY_PROMO) // Promotion.
                .build();

        int notificationId = 2;
        this.notificationManagerCompat.notify(notificationId, notification);
    }
}