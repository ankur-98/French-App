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
import app.french.common_adapters.indexAdapter;
import app.french.common_classes.indexclass;
import app.french.lessonActivity;


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

        list.add(new indexclass(R.string.tran1,1));
        list.add(new indexclass(R.string.tran2,2));
        list.add(new indexclass(R.string.tran3,3));
        list.add(new indexclass(R.string.tran4,4));
        list.add(new indexclass(R.string.tran5,5));
        list.add(new indexclass(R.string.tran6,6));
        list.add(new indexclass(R.string.tran7,7));
        list.add(new indexclass(R.string.tran8,8));
        list.add(new indexclass(R.string.tran9,9));
        list.add(new indexclass(R.string.tran10,10));
        list.add(new indexclass(R.string.tran11,11));
        list.add(new indexclass(R.string.tran12,12));

        indexAdapter adapter = new indexAdapter(this,list);
        ListView section = (ListView) findViewById(R.id.menu_list_section);
        section.setAdapter(adapter);

        //opening new activity for every item on menu list

        section.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                indexclass w = list.get(position);
                Intent intent = new Intent(getApplicationContext(), lessonActivity.class);
                intent.putExtra("lname",w.getmLsnName());
                intent.putExtra("title",title);
                startActivity(intent);

            }
        });
    }
}