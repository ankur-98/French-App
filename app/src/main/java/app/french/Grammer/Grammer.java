package app.french.Grammer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import app.french.Grammer.Definite_Articles.Definite_Articles;
import app.french.Grammer.Demostratives.Demostratives;
import app.french.Grammer.Indefinite_Articles.Indefinite_Articles;
import app.french.Grammer.Negetive_Sentences.Negetive_Sentences;
import app.french.Grammer.Possessive_Adjectives.Possessive_Adjectives;
import app.french.Grammer.Preposition_Of_Places.Preposition_Of_Places;
import app.french.Grammer.Preposition_Of_Time.Preposition_Of_Time;
import app.french.Grammer.Pronouns.Pronouns;
import app.french.Grammer.Tonics.Tonics;
import app.french.Grammer.Verb.Verb;
import app.french.R;
import app.french.common_adapters.indexAdapter;
import app.french.common_classes.indexclass;


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

        list.add(new indexclass(R.string.gramlt1,1, Pronouns.class));
        list.add(new indexclass(R.string.gramlt2,2, Definite_Articles.class));
        list.add(new indexclass(R.string.gramlt3,3, Verb.class));
        list.add(new indexclass(R.string.gramlt4,4, Indefinite_Articles.class));
        list.add(new indexclass(R.string.gramlt5,5, Possessive_Adjectives.class));
        list.add(new indexclass(R.string.gramlt6,6, Tonics.class));
        list.add(new indexclass(R.string.gramlt7,7, Negetive_Sentences.class));
        list.add(new indexclass(R.string.gramlt8,8, Preposition_Of_Places.class));
        list.add(new indexclass(R.string.gramlt9,9, Preposition_Of_Time.class));
        list.add(new indexclass(R.string.gramlt10,10, Demostratives.class));

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
