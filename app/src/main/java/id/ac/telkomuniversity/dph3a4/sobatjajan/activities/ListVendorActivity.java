package id.ac.telkomuniversity.dph3a4.sobatjajan.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import id.ac.telkomuniversity.dph3a4.sobatjajan.HttpRequest;
import id.ac.telkomuniversity.dph3a4.sobatjajan.R;
import id.ac.telkomuniversity.dph3a4.sobatjajan.Utility;
import id.ac.telkomuniversity.dph3a4.sobatjajan.adapters.VendorAdapter;
import id.ac.telkomuniversity.dph3a4.sobatjajan.model.Vendor;

public class ListVendorActivity extends AppCompatActivity {

    ListView listView;
    List<Vendor> vendorList;
    VendorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_vendor);

        listView = findViewById(R.id.list_view_vendor);
        vendorList = new ArrayList<>();

//        adapter = new VendorAdapter(this,vendorList);
//
//        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d("VENDOR DIPILIH",vendorList.get(i).getNama());
                Intent intent = new Intent(ListVendorActivity.this,DetailVendorActivity.class);
                intent.putExtra("data_vendor",vendorList.get(i));
                startActivity(intent);
            }
        });

        GetVendorTask task = new GetVendorTask();
        task.execute(Utility.BASE_URL+"Vendor/getAll");
    }

    private List<Vendor> getDataVendor(){
        List<Vendor> list = new ArrayList<>();

        list.add(new Vendor(1,"Bu yuyun","","Makanan & minuman","0.9"));
        list.add(new Vendor(2,"Podomoro","","Makanan & minuman","0.9"));
        list.add(new Vendor(3,"Thai Tea THailand","","Makanan & minuman","0.9"));
        list.add(new Vendor(4,"Geprek Pangeran","","Makanan & minuman","0.9"));
        list.add(new Vendor(5,"Mc Doen","","Makanan & minuman","0.9"));

        return list;
    }

    private class GetVendorTask extends AsyncTask<String,Void, List<Vendor>> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected List<Vendor> doInBackground(String... strings) {
            List<Vendor> output = null;
            try {
                HttpRequest request = HttpRequest.get(strings[0]);
                request.acceptJson();
                if (request.ok()){
                    String result = request.body();
                    output = parse(result);
                }
            }catch (HttpRequest.HttpRequestException e){
                Log.e("TASK","Gagal melakukan koneksi "+e);
            }
            return output;
        }

        @Override
        protected void onPostExecute(List<Vendor> vendors) {
            super.onPostExecute(vendors);
            vendorList = vendors;
//            adapter.notifyDataSetChanged();

            adapter = new VendorAdapter(ListVendorActivity.this,vendorList);

            listView.setAdapter(adapter);
        }

        private List<Vendor> parse(String response){
            List<Vendor> list = new ArrayList<>();

            try {
                JSONArray array = new JSONArray(response);
                for (int i=0; i<array.length(); i++){
                    Vendor u = new Vendor();
                    JSONObject o = array.getJSONObject(i);
                    u.setId(o.getInt("Id_Vendor"));
                    u.setKategori("Makanan dan Minuman");
                    u.setNama(o.getString("Nama Vendor"));
                    u.setJarak("0.9");
                    list.add(u);
                }
            }catch (JSONException e){
                Log.e("Parse","Gagal melakukan parse "+e);
            }

            return list;
        }


    }
}
