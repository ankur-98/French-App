package app.french.common_adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import app.french.R;
import app.french.common_classes.indexclass;

public class indexAdapter extends ArrayAdapter<indexclass> {

    public indexAdapter(Activity context, ArrayList<indexclass> index) {
        super(context, 0, index);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.index_list, parent, false);
        }

        indexclass currentWord = getItem(position);


        TextView mtxt = (TextView) listItemView.findViewById(R.id.index_item);
        if(currentWord.getmLessonName()!=null)
            mtxt.setText(currentWord.getmLessonName());
        else
            mtxt.setText(currentWord.getmLsnName());

        return listItemView;
    }

}
