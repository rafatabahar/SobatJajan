package id.ac.telkomuniversity.dph3a4.sobatjajan.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import id.ac.telkomuniversity.dph3a4.sobatjajan.R;
import id.ac.telkomuniversity.dph3a4.sobatjajan.Utility;
import id.ac.telkomuniversity.dph3a4.sobatjajan.adapters.CartAdapter;

public class CartActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        listView = findViewById(R.id.listmenucart);

        CartAdapter adapter = new CartAdapter(this);
        listView.setAdapter(adapter);
        Utility.setListViewHeightBasedOnChildren(listView);
//        listView.setEnabled(false);
    }
}
