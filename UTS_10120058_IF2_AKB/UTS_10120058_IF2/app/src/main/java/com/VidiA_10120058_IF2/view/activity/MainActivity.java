package com.VidiA_10120058_IF2.view.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.VidiA_10120058_IF2.R;
import com.VidiA_10120058_IF2.view.fragment.NoteFragment;
import com.VidiA_10120058_IF2.view.fragment.ProfileFragment;
import com.VidiA_10120058_IF2.view.fragment.InfoFragment;

/**
 * NAMA    : Vidi Anandisa Fortuna
 * NIM     : 10120077
 * Kelas   : IF-2
 * Mata Kuliah  : Aplikasi Komputasi Bergerak
 * Tugas Pengganti UTS AKB
 */
public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);

        //menampilkan halaman yang pertama muncul
        getFragmentPage(new InfoFragment());

        //insialisasi bottom nav
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;

                switch (item.getItemId()){
                    case
                            R.id.info:
                        fragment = new InfoFragment();
                        break;
                    case
                            R.id.note:
                        fragment = new NoteFragment();
                        break;
                    case
                            R.id.profile:
                        fragment = new ProfileFragment();
                        break;
                }
                return getFragmentPage(fragment);
            }
        });
    }

    private boolean getFragmentPage(Fragment fragment){
        if (fragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.page_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}

/**
 * NAMA    : Vidi Anandisa Fortuna
 * NIM     : 10120077
 * Kelas   : IF-2
 * Mata Kuliah  : Aplikasi Komputasi Bergerak
 * Tugas Pengganti UTS AKB
 */