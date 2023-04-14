package com.example.unite7_veritabani;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Uyg1Activity extends AppCompatActivity {
    EditText txtGirilen; TextView lblGozuken; Button btnKaydet;
    private void tanimlamalar() {
        txtGirilen = findViewById(R.id.Uyg1KadiTxt);
        lblGozuken = findViewById(R.id.Uyg1KadiLbl);
        btnKaydet = findViewById(R.id.Uyg1KaydetBtn);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uyg1);
        tanimlamalar();
        SharedPreferences data = this.getPreferences(Context.MODE_PRIVATE);
        String kadi = data.getString("kadi","");
        if(!kadi.isEmpty()) lblGozuken.setText("Kullanıcı Adı: " + kadi);
    }

    public void isimKaydet(View view) {
        String kadi = txtGirilen.getText().toString();
        SharedPreferences data = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = data.edit();
        edit.putString("kadi",kadi); edit.apply();
        lblGozuken.setText("Kullanıcı Adı: " + kadi);
        Toast.makeText(this, "Başarıyla Kaydedildi.", Toast.LENGTH_SHORT).show();
    }
}