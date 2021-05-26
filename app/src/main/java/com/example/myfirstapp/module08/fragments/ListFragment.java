package com.example.myfirstapp.module08.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.myfirstapp.R;

public class ListFragment extends Fragment {

    private static String[] contacts = {
            "John",
            "Jack",
            "Mary",
            "Kate",
            "Andrew",
            "Mona",
            "Lisa"
    };
    private static String[] phones = {
            "+232312837",
            "+473824923",
            "+437429874",
            "+437849332",
            "+847985345",
            "+321994843",
            "+754894328"
    };

    private ListFragmentDataSender dataSender;

    public ListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        // class B | class A extends B
        // B b;
        // b = new A();

        // class TwoFragmentsActivity extends Context
        // Context context -> TwoFragmentsActivity object
        super.onAttach(context);
        dataSender = (ListFragmentDataSender) context;
        // dataSender -> TwoFragmentsActivity object
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        ListView contactsListView = view.findViewById(R.id.fragment_listview);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                getContext(),
                android.R.layout.simple_list_item_1,
                contacts
        );
        contactsListView.setAdapter(adapter);

        contactsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedContact = contacts[position];
                String phone = phones[position];
                dataSender.sendData(selectedContact, phone);
            }
        });
        return view;
    }
}