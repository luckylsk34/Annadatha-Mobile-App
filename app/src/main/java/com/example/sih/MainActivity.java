package com.example.sih;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

//import static android.provider.AlarmClock.EXTRA_MESSAGE;


public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private SlideAdapter myadapter;



    public final static String EXTRA_MESSAGE = "com.example.sih.MESSAGE";

    String[] Crop_names = {"Corn","Rice","Wheat","Maize","Barley"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        viewPager=(ViewPager)findViewById(R.id.viewpager);
        myadapter=new SlideAdapter(this);
        viewPager.setAdapter(myadapter);

        ListView listView = (ListView)findViewById(R.id.listView);

        CustomAdapter customAdapter = new CustomAdapter();

        listView.setAdapter(customAdapter);
    }


    class CustomAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return Crop_names.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = getLayoutInflater().inflate(R.layout.customlayout,null);
            TextView textView_name = (TextView) convertView.findViewById(R.id.textView2);
            textView_name.setText(Crop_names[position]);
            return convertView;
        }
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        String rice = "Rice Details";
        String message = rice;
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}
