package computerized.com.clubbuddy;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

public class Settings extends Activity {
    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

    }

    /*
      TODO: Implement this
    */

    private void resetHome() {
        // ARE YOU SURE YOU WANT TO DO THIS BRO?
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Change Home Location");
        alert.setMessage("Are you sure you want to set the current location as your home?").setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int d) {
                /* Yes
                *   FINISH THIS
                *   Makes current location "home"
                 */
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
