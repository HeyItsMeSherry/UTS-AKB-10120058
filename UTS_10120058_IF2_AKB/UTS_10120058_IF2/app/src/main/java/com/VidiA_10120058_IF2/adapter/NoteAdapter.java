package com.VidiA_10120058_IF2.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.VidiA_10120058_IF2.R;
import com.VidiA_10120058_IF2.model.Note;
import com.VidiA_10120058_IF2.view.activity.AddNoteActivity;

import java.util.List;

/**
 * NAMA    : Vidi Anandisa Fortuna
 * NIM     : 10120077
 * Kelas   : IF-2
 * Mata Kuliah  : Aplikasi Komputasi Bergerak
 * Tugas Pengganti UTS AKB
 */
public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {

    private List<Note> notes;

    public NoteAdapter(List<Note> notes) {
        this.notes = notes;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_note, null, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(notes.get(position).getTitle());
        holder.category.setText(notes.get(position).getCategory());
        holder.desc.setText(notes.get(position).getDesc());
        holder.date.setText(notes.get(position).getDate());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(holder.itemView.getContext(), AddNoteActivity.class);
            intent.putExtra("Note", notes.get(position));
            holder.itemView.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView category;
        TextView desc;
        TextView date;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title_note);
            category = itemView.findViewById(R.id.category_note);
            desc = itemView.findViewById(R.id.desc_note);
            date = itemView.findViewById(R.id.date_note);
        }
    }
}

/**
 * NAMA    : Vidi Anandisa Fortuna
 * NIM     : 10120077
 * Kelas   : IF-2
 * Mata Kuliah  : Aplikasi Komputasi Bergerak
 * Tugas Pengganti UTS AKB
 */