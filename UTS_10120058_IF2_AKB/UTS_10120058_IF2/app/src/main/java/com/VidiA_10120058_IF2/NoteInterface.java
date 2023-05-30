package com.VidiA_10120058_IF2;

import android.database.Cursor;

import com.VidiA_10120058_IF2.model.Note;

/**
 * NAMA    : Vidi Anandisa Fortuna
 * NIM     : 10120077
 * Kelas   : IF-2
 * Mata Kuliah  : Aplikasi Komputasi Bergerak
 * Tugas Pengganti UTS AKB
 */
public interface NoteInterface {

    public Cursor read();
    public boolean create(Note note);
    public boolean update(Note note);
    public boolean delete(String id);
}
