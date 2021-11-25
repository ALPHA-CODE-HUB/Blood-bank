package com.example.bloodbank;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.Myviewholder> {
    private final RecyclerViewInterface recyclerViewInterface;
    Context context;
    ArrayList<user> list;


    public Adapter(Context context, ArrayList<user> list, RecyclerViewInterface recyclerViewInterface) {
        this.context = context;
        this.list = list;
        this.recyclerViewInterface = recyclerViewInterface;

    }

    @NonNull
    @Override
    public Myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new Myviewholder(v, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull Myviewholder holder, int position) {
        user user = list.get(position);
        holder.name.setText(user.getName());
        holder.bloodtype.setText(user.getBloodtype());
        holder.gender.setText(user.getGender1());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class Myviewholder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView name, bloodtype, gender;
        TextView dname, dbt, dgender, dphone, demail;

        public Myviewholder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);
            dname = itemView.findViewById(R.id.ddname);
            dbt = itemView.findViewById(R.id.ddbt);
            dgender = itemView.findViewById(R.id.ddgen);
            dphone = itemView.findViewById(R.id.ddnum);
            demail = itemView.findViewById(R.id.ddmail);
            name = itemView.findViewById(R.id.fname);
            bloodtype = itemView.findViewById(R.id.bloodtype);
            gender = itemView.findViewById(R.id.gender);
            itemView.setOnClickListener(this);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (recyclerViewInterface != null) {
                        int pos = getAdapterPosition();
                        if (pos != RecyclerView.NO_POSITION) {
                            recyclerViewInterface.onItemClick(pos);
                        }
                    }
                }
            });
        }

        @Override
        public void onClick(View view) {


        }
    }

    public interface RecyclerViewClick {
        void onClick(View v, int position);


    }


}
