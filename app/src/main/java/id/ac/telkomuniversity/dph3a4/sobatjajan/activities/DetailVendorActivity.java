package id.ac.telkomuniversity.dph3a4.sobatjajan.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import id.ac.telkomuniversity.dph3a4.sobatjajan.R;
import id.ac.telkomuniversity.dph3a4.sobatjajan.adapters.MenuVendorAdapter;
import id.ac.telkomuniversity.dph3a4.sobatjajan.model.Menu;
import id.ac.telkomuniversity.dph3a4.sobatjajan.model.Vendor;

public class DetailVendorActivity extends AppCompatActivity {

    RecyclerView listMenu;
    ImageView ivFotoVendpr;
    TextView tvNama,tvKategori,tvJarak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_vendor);

        listMenu = findViewById(R.id.list_view_menu_vendor);
        ivFotoVendpr = findViewById(R.id.detail_vendor_foto);
        tvNama = findViewById(R.id.detail_vendor_nama);
        tvKategori = findViewById(R.id.detail_vendor_kategori);
        tvJarak = findViewById(R.id.detail_vendor_jarak);

        Vendor vendor = getIntent().getParcelableExtra("data_vendor");

        tvKategori.setText(vendor.getKategori());
        tvJarak.setText(vendor.getJarak());
        tvNama.setText(vendor.getNama());

        MenuVendorAdapter adapter = new MenuVendorAdapter(getDataMenu());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        listMenu.setLayoutManager(layoutManager);
        listMenu.setAdapter(adapter);
    }

    private List<Menu> getDataMenu(){
        List<Menu> list= new ArrayList<>();
        list.add(new Menu(1,"Ayam Geprek","Ayam grprek enak","",12000));
        list.add(new Menu(2,"Ayam Geprek","Ayam grprek enak","",12000));
        list.add(new Menu(3,"Ayam Geprek","Ayam grprek enak","",14000));
        list.add(new Menu(4,"Ayam Geprek","Ayam grprek enak","",15000));

        return list;

    }
}
