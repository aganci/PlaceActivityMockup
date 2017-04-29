package com.langhetour.placeactivitymockup;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Osteria Langhet");

/*
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        TextView placeTitle = (TextView) findViewById(R.id.place_title);
        placeTitle.setText(
                "xdpi=" + String.valueOf(metrics.xdpi) + "\n" +
                "ydpi=" + String.valueOf(metrics.ydpi) + "\n" +
                "density=" + String.valueOf(metrics.density) + "\n" +
                "widthPixels=" + String.valueOf(metrics.widthPixels) + "\n" +
                "heightPixels=" + String.valueOf(metrics.heightPixels) + "\n" +
                "densityDpi=" + String.valueOf(metrics.densityDpi) + "\n" +
                "scaledDensity=" + String.valueOf(metrics.scaledDensity) + "\n"
        );
*/
    /* La Cucina delle Langhe (sapientemente) rivisitata */

    /* Orario di oggi */
    /* solo su prenotazione */

    /* Indirizzo */
    /* Località Valdea, 1 - 12074 Bergolo (CN) */

    /* Contatti */
    /*
       3336399022 - info@langhet.com
       http://www.langhet.com/menu-della-settimana.html
    */

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        String msg = "";

        switch (item.getItemId()) {

            case R.id.discard:
                msg = getString(R.string.delete);
                break;

            case R.id.search:
                msg = getString(R.string.search);
                break;

            case R.id.edit:
                msg = getString(R.string.edit);
                break;

            case R.id.settings:
                msg = getString(R.string.settings);
                break;

            case R.id.Exit:
                msg = getString(R.string.exit);
                break;
        }

        Toast.makeText(this, msg + " clicked !", Toast.LENGTH_SHORT).show();

        return super.onOptionsItemSelected(item);
    }

    public void onClickBook(View view) {
        Uri uri = Uri.parse("smsto:" + "+393336399022");
        Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
        intent.putExtra("sms_body", "Vorrei prenotare per il giorno");
        //intent.setPackage("com.whatsapp");
        startActivity(intent);
    }

    public void onClickSendEmail(View view) {
        String[] addresses = new String[] {"info@langhet.com"};

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, "Prenotazione");
        intent.putExtra(Intent.EXTRA_TEXT, "Buongiorno,\nVorrei prenotare un tavolo per il giorno");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void onClickGetDirections(View view) {
        Uri gmmIntentUri = Uri.parse("google.navigation:q=Langhet,+Bergolo");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }
}
