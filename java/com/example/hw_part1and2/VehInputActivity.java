package com.example.hw_part1and2;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hw_part1and2.model.Course;
import com.example.hw_part1and2.model.Student;
import com.example.hw_part1and2.model.StudentDB;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class VehInputActivity extends AppCompatActivity {

    EditText fN;
    EditText lN;
    EditText cWid;
    Button bt;
    Button addCoursebt;
    ListView lv;
    ArrayList<String> arrayList;
    ArrayAdapter<String> adapter;
    protected int studentIndex;

    private LinearLayout mLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veh_input);

        final int studentIndex = getIntent().getIntExtra("StudentIndex", 0);


        fN = (EditText) findViewById(R.id.editText); // First Name
        lN = (EditText) findViewById(R.id.editText2); // Last Name
        cWid = (EditText) findViewById(R.id.editText3); // CWID


        fN.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                StudentDB.getInstance().getmStudents().get(studentIndex).setmFirstName(fN.getText().toString());

            }
        });

        lN.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                StudentDB.getInstance().getmStudents().get(studentIndex).setmLastName(lN.getText().toString());


            }
        });

        cWid.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                StudentDB.getInstance().getmStudents().get(studentIndex).setmCwid(Integer.parseInt(cWid.getText().toString()));


            }
        });

        bt = (Button) findViewById(R.id.button);
        lv = (ListView) findViewById(R.id.lv_added);
        addCoursebt = (Button) findViewById(R.id.addCbutton);

        arrayList = new ArrayList<String>();

        adapter = new ArrayAdapter<>(VehInputActivity.this, android.R.layout.simple_list_item_1, arrayList);
        //StudentDB.getInstance().getmStudents().get(studentIndex).setmFirstName(fN.getText().toString());


        lv.setAdapter(adapter);

        onBtnClick();

        onAddCBtnClick();
    }

    public void onBtnClick() {
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstName = fN.getText().toString();
                String lastName = lN.getText().toString();
                String text = cWid.getText().toString();
                int cwid = Integer.parseInt(text);

                StudentDB.setStudentObjects(firstName, lastName, cwid);

                //arrayList.add(firstName);
                adapter.notifyDataSetChanged();
                openSummActivity();
            }
        });
    }

    public void openSummActivity() {
        Intent intent = new Intent(this, SummaryLVActivity.class);
        startActivity(intent);
    }

    public void onAddCBtnClick() {
        addCoursebt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });
    }

    public void addET(){
        EditText et = new EditText(this);
        et.setText("Course Name");
    }
}
