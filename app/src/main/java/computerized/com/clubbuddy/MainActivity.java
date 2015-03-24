package computerized.com.clubbuddy;

import android.app.AlertDialog;
import android.bluetooth.BluetoothAdapter;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


import java.util.Locale;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //InternetStuff fetchContent = new InternetStuff();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void blueToothCheck(View view) {
        // This is what is going to happen when you push the button for "Pair Up"
        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (mBluetoothAdapter == null) {
            // Device does not support Bluetooth
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setMessage("Your device does not support Bluetooth. We're sorry, but you can't use this feature without it.").setNegativeButton(":(", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int d) {
                    // Yes
                    dialog.cancel();
                }
            }).create().show();
        } else {
            if (!mBluetoothAdapter.isEnabled()) {
                AlertDialog.Builder alert = new AlertDialog.Builder(this);
                alert.setMessage("Bluetooth isn't enabled. Enable it?").setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int d) {
                        // Yes
                        dialog.cancel();
                    }
                })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int d) {
                                dialog.cancel();
                            }
                        })
                        .create().show();
            }
        }
    }

    public void toSettingsPage(MenuItem item) {
        // Dis dank little fella takes you to the settings page

        Intent i = new Intent(this, Settings.class);
        startActivity(i);


    }

    public void changeToContacts(View view) {
        Intent i = new Intent(this, Contacts.class);
        startActivity(i);
    }

    public void goToMainDisplay(View view) {
        Intent i = new Intent(this, Go.class);
        startActivity(i);
    }
    public void openGMaps() {
        String uri = String.format(Locale.ENGLISH, "http://maps.google.com/maps?saddr=%f,%f(%s)&daddr=%f,%f (%s)", 30.441878, -84.298489, "Home", 30.4422398,-84.3767868, "Where the party is at");
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
        startActivity(intent);
//                Uri.parse("http://maps.google.com/maps?saddr=30.441878,-84.298489"));

    }
}
