package com.example.bloodbank;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class homeFragment extends Fragment implements RecyclerViewInterface{
     View v;
RecyclerView rec;
DatabaseReference reference;
Adapter adapter;

ArrayList<user> list;
private Adapter.RecyclerViewClick listner;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_home, container, false);
        rec=v.findViewById(R.id.r);
        reference= FirebaseDatabase.getInstance().getReference().child("Donors");
        rec.setHasFixedSize(true);
        rec.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));

        list=new ArrayList<>();
        adapter=new Adapter(getActivity().getApplicationContext(),list,this);
        rec.setAdapter(adapter);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot:snapshot.getChildren())
                {
                    user user=dataSnapshot.getValue(com.example.bloodbank.user.class);
                    list.add(user);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });






        return v;

    }
    private void setAdapter(){





    }

    @Override
    public void onItemClick(int position) {

        user user=list.get(position);
        String name=user.getName();
        String email=user.getE_mail();
        String phno=user.getPhonenumber();
        String gender=user.getGender1();
        String bType=user.getBloodtype();
        Intent intent= new Intent(getActivity().getApplication(),Details.class);
        intent.putExtra("name",name);
        intent.putExtra("e_mail",email);
        intent.putExtra("phonenumber",phno);
        intent.putExtra("gender",gender);
        intent.putExtra("bType",bType);
        startActivity(intent);

    }
}