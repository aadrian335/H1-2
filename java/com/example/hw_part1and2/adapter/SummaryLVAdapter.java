package com.example.hw_part1and2.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.hw_part1and2.R;
import com.example.hw_part1and2.StudentDetailActivity;
import com.example.hw_part1and2.model.Student;
import com.example.hw_part1and2.model.StudentDB;

public class SummaryLVAdapter extends BaseAdapter {
    @Override
    public int getCount() { return StudentDB.getInstance().getmStudents().size(); }

    @Override
    public Object getItem(int i) { return StudentDB.getInstance().getmStudents().get(i); }

    @Override
    public long getItemId(int i) { return i; }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View row_view;

        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
            row_view = inflater.inflate(R.layout.student_row, viewGroup, false);
        } else row_view = view;

        Student p = StudentDB.getInstance().getmStudents().get(i);

        TextView firstNameView = (TextView) row_view.findViewById(R.id.first_name);
        firstNameView.setText(p.getmFirstName());
        TextView lastNameView = (TextView) row_view.findViewById(R.id.last_name);
        lastNameView.setText(p.getmLastName());
        TextView cwidView = (TextView) row_view.findViewById(R.id.cwid);
        cwidView.setText(Integer.toString(p.getmCwid()));
        row_view.setTag(new Integer(i));

        row_view.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(view.getContext(), StudentDetailActivity.class);
                        intent.putExtra("StudentIndex", ((Integer)view.getTag()).intValue());
                        view.getContext().startActivity(intent);
                    }
                }
        );

        return row_view;
    }
}
