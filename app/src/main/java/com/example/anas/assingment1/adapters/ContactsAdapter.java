package com.example.anas.assingment1.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.anas.assingment1.models.Contacts;
import com.example.anas.assingment1.R;
import com.example.anas.assingment1.models.Contacts;

import java.util.List;

import static java.security.AccessController.getContext;

/**
 * Created by Anas on 29/09/2017.
 */

public class ContactsAdapter extends ArrayAdapter<Contacts> {

    class ViewHolder {
        TextView Name;
        TextView Phone;
        TextView Gender;
    }

    public ContactsAdapter(@NonNull Context context, @NonNull List<Contacts> objects) {

        super(context,0,objects);
    }


    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){

        View view = convertView;
        ViewHolder viewHolder = new ViewHolder();
        Contacts contacts= getItem(position);


        if(view==null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.contact_item_list, parent, false);

            TextView Name = (TextView) view.findViewById(R.id.Name);
            TextView Phone = (TextView) view.findViewById(R.id.Phone);
            TextView Gender = (TextView) view.findViewById(R.id.Gender);
            viewHolder.Name=Name;
            viewHolder.Phone=Phone;
            viewHolder.Gender=Gender;
            view.setTag(viewHolder);
        }
        viewHolder = (ViewHolder) view.getTag();

        viewHolder.Name.setText(contacts.getName());
        viewHolder.Phone.setText(contacts.getPhone());
        viewHolder.Gender.setText(contacts.getGender());
        return view;
    }
}
