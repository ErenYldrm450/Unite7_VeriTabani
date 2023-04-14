package com.example.unite7_veritabani;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class Uyg2Activity extends AppCompatActivity {
RadioButton radioAcik,radioKaranlik;

SharedPreferences sharedPreferences;
SharedPreferences.Editor editor;
int veri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uyg2);
        radioAcik = findViewById(R.id.radioAcik);
        radioKaranlik = findViewById(R.id.radioKaranlik);

        sharedPreferences = this.getPreferences(Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        if(veri == AppCompatDelegate.MODE_NIGHT_NO) {
            radioAcik.setChecked(true);
            radioKaranlik.setChecked(false);
        }
        else{
            radioAcik.setChecked(false);
            radioKaranlik.setChecked(true);
        }
    }
    public void onRadioClicked(View view){
        boolean checked = ((RadioButton)view).isChecked();

        switch (view.getId()){
            case R.id.radioAcik:
                if (checked){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    editor.putInt("tema",AppCompatDelegate.MODE_NIGHT_NO);
                    editor.apply();
                    radioAcik.setChecked(true);
                    radioKaranlik.setChecked(false);
                }
                break;
            case R.id.radioKaranlik:
                if (checked){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    editor.putInt("tema",AppCompatDelegate.MODE_NIGHT_YES);
                    editor.apply();
                    radioAcik.setChecked(false);
                    radioKaranlik.setChecked(true);
                }
                break;
        }
    }
    @Override
    protected void onDestroy(){
        sharedPreferences = null;
        super.onDestroy();
    }

    public void rbClicked(View view) {

    }
}