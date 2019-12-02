package id.ac.telkomuniversity.dph3a4.sobatjajan.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import id.ac.telkomuniversity.dph3a4.sobatjajan.R;
import id.ac.telkomuniversity.dph3a4.sobatjajan.adapters.MenuAdapter;

public class DetailVendorActivity extends AppCompatActivity {

    ListView listMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_vendor);

        listMenu = findViewById(R.id.list_view_menu_vendor);

        MenuAdapter adapter = new MenuAdapter(this);

        listMenu.setAdapter(adapter);
    }
}
