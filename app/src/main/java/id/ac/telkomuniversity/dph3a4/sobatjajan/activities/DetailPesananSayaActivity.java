package id.ac.telkomuniversity.dph3a4.sobatjajan.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import id.ac.telkomuniversity.dph3a4.sobatjajan.R;
import id.ac.telkomuniversity.dph3a4.sobatjajan.Utility;
import id.ac.telkomuniversity.dph3a4.sobatjajan.adapters.DetailPesananAdapter;
import id.ac.telkomuniversity.dph3a4.sobatjajan.model.Menu;
import id.ac.telkomuniversity.dph3a4.sobatjajan.model.Pesanan;

public class DetailPesananSayaActivity extends AppCompatActivity {

    ImageView ivMasak,siapDiambil,selesai,progres1,progres2;
    ListView lvMenu;
    TextView tvMasak,tvDiambil,tvSelesai,tvHargaMakanan,tvBiayaAntri,tvTotalHarga;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pesanan_saya);

        tvHargaMakanan = findViewById(R.id.pesanan_saya_hargaMakanan);
        tvBiayaAntri = findViewById(R.id.pesanan_saya_biayaAntri);
        tvTotalHarga = findViewById(R.id.pesanan_saya_total);

        progres1 = findViewById(R.id.pesanan_saya_progres1);
        progres2 = findViewById(R.id.pesanan_saya_progres2);
        siapDiambil = findViewById(R.id.pesanan_saya_ambil);
        selesai = findViewById(R.id.pesanan_saya_selesai);
        tvMasak = findViewById(R.id.pesanan_saya_textMasak);
        tvDiambil = findViewById(R.id.pesanan_saya_textAmbil);
        tvSelesai = findViewById(R.id.pesanan_saya_textSelesai);
        siapDiambil = findViewById(R.id.pesanan_saya_ambil);
        ivMasak = findViewById(R.id.pesanan_saya_masak);
        lvMenu = findViewById(R.id.pesanan_saya_listmenu);

        Pesanan pesanan = getIntent().getParcelableExtra("data_pesanan");
        DetailPesananAdapter adapter = new DetailPesananAdapter(this,pesanan.getMenuList());

        int hargaMakanan = 0;
        for (Menu m : pesanan.getMenuList()){
            hargaMakanan += m.getHarga();
        }

        tvHargaMakanan.setText("Rp."+hargaMakanan);
        tvBiayaAntri.setText("Rp.500");
        tvTotalHarga.setText("Rp."+(hargaMakanan+500));

        lvMenu.setAdapter(adapter);
        Utility.setListViewHeightBasedOnChildren(lvMenu);

        if (pesanan.getStatus().equalsIgnoreCase("Sedang Diproses")){
            diMasak();
        }else if (pesanan.getStatus().equalsIgnoreCase("Siap Diambil")){
            siapDiambil();
        }else if (pesanan.getStatus().equalsIgnoreCase("Selesai") || pesanan.getStatus().equalsIgnoreCase("Dibatalkan")){
            selesai();
        }

    }

    public void diMasak(){
        DrawableCompat.setTint(ivMasak.getDrawable(), ContextCompat.getColor(this, R.color.colorAccent));
        DrawableCompat.setTint(progres1.getDrawable(), ContextCompat.getColor(this, R.color.colorAccent));
        tvMasak.setTextColor(getResources().getColor(R.color.colorAccent));

        DrawableCompat.setTint(siapDiambil.getDrawable(), ContextCompat.getColor(this, R.color.hitam));
        DrawableCompat.setTint(progres2.getDrawable(), ContextCompat.getColor(this, R.color.hitam));

        DrawableCompat.setTint(selesai.getDrawable(), ContextCompat.getColor(this, R.color.hitam));
    }

    public void siapDiambil(){
        diMasak();
        DrawableCompat.setTint(siapDiambil.getDrawable(), ContextCompat.getColor(this, R.color.colorAccent));
        DrawableCompat.setTint(progres2.getDrawable(), ContextCompat.getColor(this, R.color.colorAccent));
        tvDiambil.setTextColor(getResources().getColor(R.color.colorAccent));

        DrawableCompat.setTint(selesai.getDrawable(), ContextCompat.getColor(this, R.color.hitam));
    }

    public void selesai(){
        siapDiambil();
        DrawableCompat.setTint(selesai.getDrawable(), ContextCompat.getColor(this, R.color.colorAccent));
        tvSelesai.setTextColor(getResources().getColor(R.color.colorAccent));
    }
}
