package id.ac.telkomuniversity.dph3a4.sobatjajan.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import id.ac.telkomuniversity.dph3a4.sobatjajan.R;
import id.ac.telkomuniversity.dph3a4.sobatjajan.adapters.VendorAdapter;

public class ListVendorActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_vendor);

        listView = findViewById(R.id.list_view_vendor);

        VendorAdapter adapter = new VendorAdapter(this);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(ListVendorActivity.this,DetailVendorActivity.class));
            }
        });
    }
}
