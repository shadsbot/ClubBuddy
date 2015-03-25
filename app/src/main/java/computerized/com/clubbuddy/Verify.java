package computerized.com.clubbuddy;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.support.annotation.Nullable;
import android.telephony.TelephonyManager;
import android.view.Display;
import android.widget.EditText;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Colin on 3/21/2015.
 */
 public class Verify extends Activity {
    /*PROCESS
     *  Get phone number
     *  send to /check
     *      if returns false:
     *          Welcome and ask for pin
     *          send "phone_number/pin"
     *          run verify md5(phone_number+pin) <-- concat
     *          if returns true:
     *               run verify md5(phone_number+pin) <-- concat
     */


    // Get from site

    // Get phone number
    //TelephonyManager tMgr = (TelephonyManager)mAppContext.getSystemService(Context.TELEPHONY_SERVICE);
    TelephonyManager tMgr = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
    String mPhoneNumber = tMgr.getLine1Number();

    public int mPhone() {
        if (mPhoneNumber == null) {
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            final EditText input = new EditText(this);
            alert.setView(input);
            alert.setMessage("We can't find your phone number! We use this as a method of identifying you. Please enter in your phone number below to help us help you!").setPositiveButton("Okay!", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int d) {
                    mPhoneNumber = String.valueOf(input.getText());
                }
            }).create().show();
        }
        return Integer.getInteger(mPhoneNumber);
    }
    public boolean doesNumberExist() {
        InternetStuff internet = new InternetStuff();
        mPhoneNumber = "5555555555";
        String numberExists = internet.query("/check/"+mPhoneNumber);
            if (numberExists == "{\"registered\":\"0\"}")
            {
                return false;
            }
            else { return true; }
    }
}