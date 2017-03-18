package app.french.Translations;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import app.french.R;
import app.french.Translations.Lesson1.Lesson1;
import app.french.Translations.Lesson10.Lesson10;
import app.french.Translations.Lesson11.Lesson11;
import app.french.Translations.Lesson12.Lesson12;
import app.french.Translations.Lesson2.Lesson2;
import app.french.Translations.Lesson3.Lesson3;
import app.french.Translations.Lesson4.Lesson4;
import app.french.Translations.Lesson5.Lesson5;
import app.french.Translations.Lesson6.Lesson6;
import app.french.Translations.Lesson7.Lesson7;
import app.french.Translations.Lesson8.Lesson8;
import app.french.Translations.Lesson9.Lesson9;
import app.french.common_adapters.indexAdapter;
import app.french.common_classes.indexclass;


public class Translations extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.index);

        //retrieving intent data
        Intent gi = getIntent();

        //get title to set label in lesson activity
        final String title = getTitle().toString();

        //set index heading
        TextView ttl = (TextView)findViewById(R.id.index_heading);
        ttl.setText(title);

        //set menu list adapter

        final ArrayList<indexclass> list = new ArrayList<indexclass>();

        list.add(new indexclass(R.string.tran1,1, Lesson1.class));
        list.add(new indexclass(R.string.tran2,2, Lesson2.class));
        list.add(new indexclass(R.string.tran3,3, Lesson3.class));
        list.add(new indexclass(R.string.tran4,4, Lesson4.class));
        list.add(new indexclass(R.string.tran5,5, Lesson5.class));
        list.add(new indexclass(R.string.tran6,6, Lesson6.class));
        list.add(new indexclass(R.string.tran7,7, Lesson7.class));
        list.add(new indexclass(R.string.tran8,8, Lesson8.class));
        list.add(new indexclass(R.string.tran9,9, Lesson9.class));
        list.add(new indexclass(R.string.tran10,10, Lesson10.class));
        list.add(new indexclass(R.string.tran11,11, Lesson11.class));
        list.add(new indexclass(R.string.tran12,12, Lesson12.class));

        indexAdapter adapter = new indexAdapter(this,list);
        ListView section = (ListView) findViewById(R.id.menu_list_section);
        section.setAdapter(adapter);

        //opening new activity for every item on menu list

        section.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                indexclass w = list.get(position);
                Intent intent = new Intent(getApplicationContext(), w.getmCls());
                intent.putExtra("lname",w.getmLsnName());
                intent.putExtra("title",title);
                startActivity(intent);

            }
        });
    }
}