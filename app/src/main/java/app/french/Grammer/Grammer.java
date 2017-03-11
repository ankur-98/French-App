package app.french.Grammer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import app.french.Grammer.Verb.Verb;
import app.french.R;
import app.french.common_adapters.indexAdapter;
import app.french.common_classes.indexclass;
import app.french.lessonActivity;


public class Grammer extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index);

        //get title to set label in lesson activity
        final String title = getTitle().toString();

        //set index heading
        TextView ttl = (TextView)findViewById(R.id.index_heading);
        ttl.setText(title);

        //set menu list adapter

        final ArrayList<indexclass> list = new ArrayList<indexclass>();

        list.add(new indexclass(R.string.gramlt1,1));
        list.add(new indexclass(R.string.gramlt2,2));
        list.add(new indexclass(R.string.gramlt3,3, Verb.class));
        list.add(new indexclass(R.string.gramlt4,4));
        list.add(new indexclass(R.string.gramlt5,5));
        list.add(new indexclass(R.string.gramlt6,6));
        list.add(new indexclass(R.string.gramlt7,7));
        list.add(new indexclass(R.string.gramlt8,8));
        list.add(new indexclass(R.string.gramlt9,9));
        list.add(new indexclass(R.string.gramlt10,10));

        indexAdapter adapter = new indexAdapter(this,list);
        ListView section = (ListView) findViewById(R.id.menu_list_section);
        section.setAdapter(adapter);

        //opening new activity for every item on menu list

        section.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                indexclass w = list.get(position);
                Intent intent;

                //open index layout if sub-category available
                if(w.getmLessonNum()==3){
                    intent = new Intent(getApplicationContext(), w.getmCls());
                }
                //else open lesson
                else {
                    intent = new Intent(getApplicationContext(),lessonActivity.class);
                }
                intent.putExtra("lname",w.getmLsnName());
                intent.putExtra("title",title);
                startActivity(intent);

            }
        });
    }
}
