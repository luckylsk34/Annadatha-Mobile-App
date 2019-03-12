package com.example.sih;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SlideAdapter extends PagerAdapter{
    Context context;
    LayoutInflater inflater;

    public String[] first_title={
            "first",
            "second",
            "third"
    };

    public SlideAdapter(Context context){
        this.context=context;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view==(LinearLayout)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        inflater= (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.slide,container,false);
        LinearLayout layoutslide = view.findViewById(R.id.slidelinearlayout);
        TextView txttitle=(TextView) view.findViewById(R.id.txttitle);
        txttitle.setText(first_title[position]);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
       container.removeView((LinearLayout)object);
    }
}
