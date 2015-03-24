package computerized.com.clubbuddy;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Contacts extends Activity {
    public static final int PICK_CONTACT    = 1;
    private Button btnContacts;
    private TextView                txtContacts1;
    private TextView txtContacts2;
    int xyz = 0;

    /*
    Todo:   Rewrite deprecated code, rewrite display to allow more than two contacts
     */

    // Change the view
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contacts);

        btnContacts = (Button) findViewById(R.id.btn_contacts);
        txtContacts1 = (TextView) findViewById(R.id.txt_contacts_name);
        txtContacts2 = (TextView) findViewById(R.id.txt_contacts_number);
        btnContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(Intent.ACTION_PICK, android.provider.Contacts.People.CONTENT_URI);
                startActivityForResult(intent, PICK_CONTACT);
            }
        });
    }

        @Override
        public void onActivityResult(int reqCode, int resultCode, Intent data) {
            super.onActivityResult(reqCode, resultCode, data);
            switch (reqCode) {
                case (PICK_CONTACT):
                    if (resultCode == Activity.RESULT_OK) {
                        Uri contactData = data.getData();
                        Cursor c = managedQuery(contactData, null, null, null, null);
                        if (c.moveToFirst()) {
                            String name = c.getString(c.getColumnIndexOrThrow(android.provider.Contacts.People.NAME))+": "+c.getColumnIndexOrThrow(android.provider.Contacts.People.NUMBER);
                            //
                            if (xyz == 1)
                            {
                                txtContacts2.setText(name);
                            }
                            else {
                                txtContacts1.setText(name);
                                xyz = 1;    // Expand this to allow for more people to connect to each other
                            }
                        }
                    }
                    break;
            }
        }
    }
