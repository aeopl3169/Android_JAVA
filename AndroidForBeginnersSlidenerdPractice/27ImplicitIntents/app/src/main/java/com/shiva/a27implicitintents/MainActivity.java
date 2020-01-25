package com.shiva.a27implicitintents;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.CalendarContract;
import android.provider.CalendarContract.Events;
import android.util.Log;
import android.view.View;

import java.io.File;
import java.util.Calendar;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void processMehtod(View view) {
        Intent intent = null;
        Intent chooser = null;
        if(view.getId()==R.id.buttonMap){
            // This "android.content.Intent.ACTION_VIEW" is a standard action to view predefined activities.
//            intent = new Intent(Intent.ACTION_VIEW);
//            intent.setData(Uri.parse("geo:17.471,78.480"));
//            // By using createChooser method, the application will not crash.
//            chooser = Intent.createChooser(intent,"Launch Shiva Home on Maps");
//            startActivity(chooser);

            /*intent = new Intent(android.content.Intent.ACTION_VIEW);
            intent.setData(Uri.parse("geo:17.471,78.480"));
            startActivity(intent);*/

            // Map point based on address
//            Uri location = Uri.parse("geo:0,0?q=1600+Amphitheatre+Parkway,+Mountain+View,+California");
            // Or map point based on latitude/longitude
             Uri location = Uri.parse("geo: 37.422219,-122.08364?z=14"); // z param is zoom level
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
            startActivity(mapIntent);
        }

        // Link to google play
        if (view.getId()==R.id.buttonMarket){
            intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.shiva.earningghost&hl=en"));
//            intent.setData(Uri.parse("market://https://play.google.com/store/apps/details?id=com.shiva.earningghost&hl=en"));
            // By using createChooser method, the application will not crash.
            chooser = Intent.createChooser(intent,"Launch App");
            startActivity(chooser);
        }

        // Send email
        if (view.getId()==R.id.buttonEmail){
            intent = new Intent(Intent.ACTION_SEND);
//            intent.setData(Uri.parse("mailto"));

//            String[] mailTo = {"shashishiva9@gmail.com","yes@gmail.com"};
//            intent.putExtra(Intent.EXTRA_EMAIL,mailTo);
            intent.putExtra(Intent.EXTRA_EMAIL,new String[]{"shashishiva9@gmail.com"});
            intent.putExtra(Intent.EXTRA_SUBJECT,"This is subject - Reg.");
            intent.putExtra(Intent.EXTRA_TEXT,"This is body.");
            // This "setType" mehtod will open the medium of sharing..
            intent.setType("message/rfc822");
            chooser = Intent.createChooser(intent,"Send Email to");
            startActivity(chooser);
        }

        // Send Image via email
        if (view.getId()==R.id.buttonImage){
            intent = new Intent(Intent.ACTION_SEND);
            Uri imageUri = Uri.parse("android.resource://com.shiva.a27implicitintents/drawable"+R.drawable.shiva);
            // This "setType" mehtod will open the medium of sharing..
            intent.setType("image/*");
            // Intent.EXTRA_STREAM - will carry on the binary image files.
            intent.putExtra(Intent.EXTRA_STREAM, imageUri);
            String[] mailTo = {"shashishiva9@gmail.com","yes@gmail.com"};
            intent.putExtra(Intent.EXTRA_EMAIL,mailTo);
            intent.putExtra(Intent.EXTRA_SUBJECT,"This is subject - Reg.");
            intent.putExtra(Intent.EXTRA_TEXT,"This is body.");
            chooser = Intent.createChooser(intent,"Send Image Email to");
            startActivity(chooser);
        }

        // Calender
        if(view.getId()==R.id.buttonCalendar){
            Intent calendarIntent = new Intent(Intent.ACTION_INSERT, Events.CONTENT_URI);

            Calendar beginTime = Calendar.getInstance();
            beginTime.set(2020, 7, 3, 7, 30);
            Calendar endTime = Calendar.getInstance();
            endTime.set(2020, 7, 3, 10, 30);

            calendarIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTime.getTimeInMillis());
            calendarIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime.getTimeInMillis());

            calendarIntent.putExtra(Events.TITLE, "This is Title");
            calendarIntent.putExtra(Events.EVENT_LOCATION, "I don't no the location.");
            startActivity(calendarIntent);
        }

        // Call a particular number
        if(view.getId()==R.id.buttonCall){
            Uri uriNumber = Uri.parse("tel:7093148874");
            Intent callIntent = new Intent(Intent.ACTION_DIAL, uriNumber);
            startActivity(callIntent);
        }

        // To verify there is an activity available that can respond to the intent.
        if(view.getId()==R.id.buttonVerify){
            Uri location = Uri.parse("geo:0,0?q=1600+Amphitheatre+Parkway,+Mountain+View,+California");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);

            // Verify it resolves
            PackageManager packageManager = getPackageManager();
            List<ResolveInfo> activities = packageManager.queryIntentActivities(mapIntent, 0);
            boolean isIntentSafe = activities.size() > 0;

            // Start an activity if it's safe
            if (isIntentSafe == true) {
                startActivity(mapIntent);
            }
        }

        if(view.getId() == R.id.buttonChooser){
            intent = new Intent(Intent.ACTION_SEND);

            // Always use string resources for UI text.
            // This says something like "Share this photo with"
            String title = getResources().getString(R.string.chooser_title);
            // Create intent to show chooser
            chooser = Intent.createChooser(intent, title);

            // Verify the intent will resolve to at least one activity
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(chooser);
            }
        }

        // If you have published an instant app using Google Play Instant, you can launch the app
        if (view.getId()==R.id.buttonInstance){
            intent = new Intent(Intent.ACTION_VIEW);
            Uri.Builder uriBuilder = Uri.parse("https://play.google.com/store/apps/details")
                    .buildUpon()
                    .appendQueryParameter("id", "com.shiva.earningghost")
                    .appendQueryParameter("launch", "true");

//            uriBuilder.appendQueryParameter("referrer", "exampleCampaignId");
            intent.setData(uriBuilder.build());
            startActivity(intent);
        }

        // Send SD card Image
        if(view.getId()==R.id.buttonImageSDCard){
            File picturesFile = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
            String[] listOfPictures = picturesFile.list();
            for(String pictures: listOfPictures){
//                Log.d("PIC","   "+pictures);
            }
        }
        if (view.getId() == R.id.buttonMessage){
            intent = new Intent(Intent.ACTION_SEND);
            // This "setType" mehtod will open the medium of sharing..
            intent.setType("text/plain");
            String message = "\n https://play.google.com/store/apps/details?id=com.shiva.earningghost \n";
            intent.putExtra(Intent.EXTRA_TEXT,"Let me recommend this gaming app: "+message);
            chooser = Intent.createChooser(intent,"Send via...");
            startActivity(chooser);
        }
    }
}
