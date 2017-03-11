package app.french;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


public class lessonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lesson);

        //retrieving intent data
        Intent gi = getIntent();
        int lname = gi.getIntExtra("lname",0);
        String title = gi.getStringExtra("title");


        //setting activity label
        setTitle(title);

        //setting lesson number
        TextView textView_Lno = (TextView) findViewById(R.id.lesson_number);
        textView_Lno.setText(lname);

        //setting lesson content
        TextView textView_Lcontent = (TextView) findViewById(R.id.lesson_content);
        textView_Lcontent.setText(R.string.para_placeholder);
    }

}
