package app.french.common_adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import app.french.R;
import app.french.common_classes.wordclass;

public class wordAdapter extends ArrayAdapter<wordclass> {

    public wordAdapter(Activity context, ArrayList<wordclass> words) {
        super(context, 0, words);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        wordclass currentWord = getItem(position);


        TextView mItem = (TextView) listItemView.findViewById(R.id.item);
        mItem.setText(currentWord.getmItemName());

        TextView bgcolor = (TextView) listItemView.findViewById(R.id.item);
        bgcolor.setBackgroundResource(currentWord.getmBg());


        return listItemView;
    }

}
