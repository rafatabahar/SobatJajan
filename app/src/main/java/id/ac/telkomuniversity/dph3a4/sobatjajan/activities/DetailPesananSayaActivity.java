package id.ac.telkomuniversity.dph3a4.sobatjajan.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;

import id.ac.telkomuniversity.dph3a4.sobatjajan.R;
import id.ac.telkomuniversity.dph3a4.sobatjajan.Utility;
import id.ac.telkomuniversity.dph3a4.sobatjajan.adapters.DetailPesananAdapter;

public class DetailPesananSayaActivity extends AppCompatActivity {

    ImageView ivMasak;
    ListView lvMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pesanan_saya);

        ivMasak = findViewById(R.id.pesanan_saya_masak);
        lvMenu = findViewById(R.id.pesanan_saya_listmenu);

        DetailPesananAdapter adapter = new DetailPesananAdapter(this);

//        lvMenu.setEnabled(false);
        lvMenu.setAdapter(adapter);
        Utility.setListViewHeightBasedOnChildren(lvMenu);

//        DrawableCompat.setTint(ivMasak.getDrawable(), ContextCompat.getColor(this, R.color.colorAccent));
    }
}
