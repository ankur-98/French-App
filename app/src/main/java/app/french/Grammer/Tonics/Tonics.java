package app.french.Grammer.Tonics;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.widget.TextView;

import app.french.R;

public class Tonics extends AppCompatActivity {
//    private WebView webView;


    //	inside this goes our pdf viewer, just a toy for this test. Requires  more work to make it production ready
//    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weblesson);

        Intent gi = getIntent();
        int lname = gi.getIntExtra("lname",0);
        String lbl = gi.getStringExtra("title");

        //setting activity label with previous activity label
        setTitle(lbl);

        //set heading
        TextView textView_Lno = (TextView) findViewById(R.id.lesson_number);
        textView_Lno.setText(lname);

        WebView wv;
        wv = (WebView) findViewById(R.id.weblesson_content);
        wv.loadUrl("file:///android_asset/temp1.htm");
        wv.getSettings().setBuiltInZoomControls(true);
    }


}