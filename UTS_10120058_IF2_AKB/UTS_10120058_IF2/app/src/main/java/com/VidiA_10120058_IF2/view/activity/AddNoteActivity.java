package com.VidiA_10120058_IF2.view.activity;

import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.VidiA_10120058_IF2.NoteInterface;
import com.VidiA_10120058_IF2.R;
import com.VidiA_10120058_IF2.database.DatabaseHelper;
import com.VidiA_10120058_IF2.model.Note;

import java.util.Date;

/**
 * NAMA    : Vidi Anandisa Fortuna
 * NIM     : 10120077
 * Kelas   : IF-2
 * Mata Kuliah  : Aplikasi Komputasi Bergerak
 * Tugas Pengganti UTS AKB
 */
public class AddNoteActivity extends AppCompatActivity {

    ImageButton button;
    EditText editTitle;
    EditText editCategory;
    EditText editDesc;
    Button addButton;
    Button deleteButton;
    TextView titleAdd;

    private NoteInterface noteInterface;
    Note note = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        note = (Note) getIntent().getSerializableExtra("Note");
        button = findViewById(R.id.back);
        editTitle = findViewById(R.id.title);
        editCategory = findViewById(R.id.category);
        editDesc = findViewById(R.id.txt_desc);
        addButton = findViewById(R.id.buttonAdd);
        deleteButton = findViewById(R.id.buttonDelete);
        titleAdd = findViewById(R.id.txt_add);
        noteInterface = new DatabaseHelper(this);

        button.setOnClickListener(v -> {
            finish();
        });

        if (note == null){
            deleteButton.setVisibility(View.GONE);

            addButton.setOnClickListener(v -> {
                if (editTitle.getText().toString().isEmpty()) {
                    Toast.makeText(this, "Title Notes Cannot Be Empty !", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (editCategory.getText().toString().isEmpty()) {
                    Toast.makeText(this, "Title Notes Cannot Be Empty !", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (editDesc.getText().toString().isEmpty()) {
                    Toast.makeText(this, "Note Content Cannot Be Empty", Toast.LENGTH_SHORT).show();
                }
                Date d = new Date();
                CharSequence date = DateFormat.format("EEEE, d MMM yyyy HH:mm", d.getTime());
                Note n = new Note(
                        d.getTime() + "",
                        editTitle.getText().toString(),
                        editCategory.getText().toString(),
                        editDesc.getText().toString() ,
                        "dibuat pada " + date + ""
                );

                noteInterface.create(n);
                finish();
                Toast.makeText(this, "Notes Succesfully Added", Toast.LENGTH_SHORT).show();
            });
        } else {
            editTitle.setText(note.getTitle());
            editCategory.setText(note.getCategory());
            editDesc.setText(note.getDesc());

            deleteButton.setVisibility(View.VISIBLE);
            titleAdd.setText("Edit Note");

            addButton.setOnClickListener(v -> {
                if (editTitle.getText().toString().isEmpty()) {
                    Toast.makeText(this, "Title Notes Cannot Be Empty !", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (editCategory.getText().toString().isEmpty()) {
                    Toast.makeText(this, "Notes Category Cannot Be Empty !", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (editDesc.getText().toString().isEmpty()) {
                    Toast.makeText(this, "Note Content Cannot Be Empty", Toast.LENGTH_SHORT).show();
                }

                Date d = new Date();
                CharSequence date = DateFormat.format("EEEE, d MMMM yyyy HH:mm",d.getTime());

                note.setTitle(editTitle.getText().toString());
                note.setCategory(editCategory.getText().toString());
                note.setDesc(editDesc.getText().toString());
                note.setDate("terakhir diedit " + date + "");
                noteInterface.update(note);
                finish();
                Toast.makeText(this, "Succesfully Edited", Toast.LENGTH_SHORT).show();
            });
        }

        deleteButton.setOnClickListener(v-> {
            noteInterface.delete(note.getId());
            finish();
            Toast.makeText(this, "Succesfully Deleted", Toast.LENGTH_SHORT).show();
        });
    }
}

/**
 * NAMA    : Vidi Anandisa Fortuna
 * NIM     : 10120077
 * Kelas   : IF-2
 * Mata Kuliah  : Aplikasi Komputasi Bergerak
 * Tugas Pengganti UTS AKB
 */