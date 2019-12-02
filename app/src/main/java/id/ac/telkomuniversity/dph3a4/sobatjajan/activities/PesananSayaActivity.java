package id.ac.telkomuniversity.dph3a4.sobatjajan.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import id.ac.telkomuniversity.dph3a4.sobatjajan.R;
import id.ac.telkomuniversity.dph3a4.sobatjajan.adapters.PesananSayaAdapter;

public class PesananSayaActivity extends AppCompatActivity {

    ListView lvPesananSaya;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesanan_saya);

        getSupportActionBar().setTitle("Pesanan Saya");

        lvPesananSaya = findViewById(R.id.pesanan_saya_listview);
        PesananSayaAdapter adapter = new PesananSayaAdapter(this);

        lvPesananSaya.setAdapter(adapter);
    }
}
