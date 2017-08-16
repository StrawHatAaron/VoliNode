package com.aaronjeromemiller.volinode;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    private Button button_red;
    private Button button_green;
    private Button button_blue;
    private TextView textView;
    private String url_holder;
    private int url_hold;

    String ip_address = "http://172.16.0.137/";

    String dir_red= "gpio/1";
    String dir_red_off= "gpio/0";
    String dir_green = "gpio1/1";
    String dir_green_off = "gpio1/0";
    String dir_blue = "gpio2/1";
    String dir_blue_off = "gpio2/0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_red = (Button) findViewById(R.id.button_red);
        button_green = (Button) findViewById(R.id.button_green);
        button_blue = (Button) findViewById(R.id.button_blue);
        textView = (TextView) findViewById(R.id.text_view);
        url_holder=" ";
        url_hold = 0;

        button_red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
                //Log.d("red button click: ", ip_address+dir_red_off);
                if (url_hold==0){
                    //turn on
                    url_hold=1;
                    url_holder=ip_address+dir_red;
                }
                else{
                    //turn off
                    url_hold=0;
                    url_holder=ip_address+dir_red_off;
                }
                StringRequest stringRequest = new StringRequest(Request.Method.POST, url_holder,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                textView.setText(response);
                                requestQueue.stop();
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        textView.setText("Something went wrong...");
                        error.printStackTrace();
                    }
                });
                requestQueue.add(stringRequest);
            }
        });

        button_green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
                if (url_hold==0){
                    //turn on
                    url_hold=1;
                    url_holder=ip_address+dir_green;
                }
                else{
                    //turn off
                    url_hold=0;
                    url_holder=ip_address+dir_green_off;
                }
                StringRequest stringRequest = new StringRequest(Request.Method.POST, url_holder,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                textView.setText(response);
                                requestQueue.stop();
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        textView.setText("Something went wrong...");
                        error.printStackTrace();
                    }
                });
                requestQueue.add(stringRequest);
            }
        });

        button_blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
                if (url_hold==0){
                    //turn on
                    url_hold=1;
                    url_holder=ip_address+dir_blue;
                }
                else{
                    //turn off
                    url_hold=0;
                    url_holder=ip_address+dir_blue_off;
                }
                StringRequest stringRequest = new StringRequest(Request.Method.POST, url_holder,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                textView.setText(response);
                                requestQueue.stop();
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        textView.setText("Something went wrong...");
                        error.printStackTrace();
                    }
                });
                requestQueue.add(stringRequest);
            }
        });
        /*button_green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);

                StringRequest stringRequest = new StringRequest(Request.Method.POST, server_url_off,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                textView.setText(response);
                                requestQueue.stop();
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        textView.setText("Something went wrong...");
                        error.printStackTrace();
                    }
                });
                requestQueue.add(stringRequest);
            }
        });*/
    }
}

