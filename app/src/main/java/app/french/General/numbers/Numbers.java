package app.french.General.Numbers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import app.french.General.Numbers.Cardinal_Numbers.Cardinal_Numbers;
import app.french.General.Numbers.Ordinal_Numbers.Ordinal_Numbers;
import app.french.R;
import app.french.common_adapters.indexAdapter;
import app.french.common_classes.indexclass;


public class Numbers extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.index);

        //retrieving intent data
        Intent gi = getIntent();
        String lname = gi.getStringExtra("lname");
        String lbl = gi.getStringExtra("title");

        //get title to set label in lesson activity
        final String title = getTitle().toString();

        //setting activity label with previous activity label
        setTitle(lbl);

        //set index heading
        TextView ttl = (TextView)findViewById(R.id.index_heading);
        ttl.setText(title);

        //set menu list adapter

        final ArrayList<indexclass> list = new ArrayList<indexclass>();

        list.add(new indexclass(R.string.numlt1,1, Ordinal_Numbers.class));
        list.add(new indexclass(R.string.numlt2,2, Cardinal_Numbers.class));

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