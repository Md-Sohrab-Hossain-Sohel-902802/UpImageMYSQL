package com.example.upimagemysql;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ProductShowerActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private List<ProductValue> productValues=new ArrayList<>();
    String url="http://192.168.43.59/project/getproduct.php";
    private  MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_shower);


        loadData();


        recyclerView=findViewById(R.id.productShowerRecyclerviewid);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    adapter=new MyAdapter(this,productValues);
    recyclerView.setAdapter(adapter);


    adapter.setOnItemClickListener(new MyAdapter.OnItemClickListner() {
        @Override
        public void OnItemClick(int position) {
                ProductValue value=productValues.get(position);
            Toast.makeText(ProductShowerActivity.this, ""+value.getId(), Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onDelete(int position) {

        }
    });



    }



    public void loadData(){
        StringRequest stringRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


                try {


                    JSONObject jsonObject=new JSONObject(response);
                    JSONArray array=jsonObject.getJSONArray("Data");

                    for (int i=0; i<array.length(); i++){
                        JSONObject recive=array.getJSONObject(i);
                        String name=recive.getString("ProductName");
                        String dis= recive.getString("ProductDiscription");
                        String image= recive.getString("Image");
                        String id= recive.getString("Id");

                        ProductValue productValue=new ProductValue(name,dis,image,id);
                        productValues.add(productValue);
                        adapter.notifyDataSetChanged();
                    }





                }catch (JSONException e){
                    e.printStackTrace();
                }





            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ProductShowerActivity.this, "Server Error", Toast.LENGTH_SHORT).show();
            }
        });


        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);










    }






}
