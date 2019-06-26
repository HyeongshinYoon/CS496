package android.example.cs496.ui.main;

import android.content.Context;
import android.example.cs496.ui.main.fragment2.Tab2Adapter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.example.cs496.R;

public class TabFragment2 extends Fragment {

    GridView gridView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        final Context context = getActivity();

        Bitmap bm0 = BitmapFactory.decodeResource(context.getResources(), R.drawable.cat);
        Bitmap bm1 = BitmapFactory.decodeResource(context.getResources(), R.drawable.beach);
        Bitmap bm2 = BitmapFactory.decodeResource(context.getResources(), R.drawable.bird);
        Bitmap bm3 = BitmapFactory.decodeResource(context.getResources(), R.drawable.chiba);
        Bitmap bm4 = BitmapFactory.decodeResource(context.getResources(), R.drawable.chiba2);
        Bitmap bm5 = BitmapFactory.decodeResource(context.getResources(), R.drawable.chiba3);
        Bitmap bm6 = BitmapFactory.decodeResource(context.getResources(), R.drawable.dog);
        Bitmap bm7 = BitmapFactory.decodeResource(context.getResources(), R.drawable.fruit);
        Bitmap bm8 = BitmapFactory.decodeResource(context.getResources(), R.drawable.girl);
        Bitmap bm9 = BitmapFactory.decodeResource(context.getResources(), R.drawable.google);
        Bitmap bm10 = BitmapFactory.decodeResource(context.getResources(), R.drawable.heart);
        Bitmap bm11 = BitmapFactory.decodeResource(context.getResources(), R.drawable.panda);
        Bitmap bm12 = BitmapFactory.decodeResource(context.getResources(), R.drawable.tree);
        Bitmap bm13 = BitmapFactory.decodeResource(context.getResources(), R.drawable.tiger);
        Bitmap bm14 = BitmapFactory.decodeResource(context.getResources(), R.drawable.sunflower);
        Bitmap bm15 = BitmapFactory.decodeResource(context.getResources(), R.drawable.rose);
        Bitmap bm16 = BitmapFactory.decodeResource(context.getResources(), R.drawable.iu);
        Bitmap bm17 = BitmapFactory.decodeResource(context.getResources(), R.drawable.yun2);
        Bitmap bm18 = BitmapFactory.decodeResource(context.getResources(), R.drawable.yun3);
        Bitmap bm19 = BitmapFactory.decodeResource(context.getResources(), R.drawable.yun4);
        Bitmap bm20 = BitmapFactory.decodeResource(context.getResources(), R.drawable.yun5);


        Bitmap[] picArr = {bm0, bm1, bm2, bm3, bm4, bm5, bm6, bm7, bm8, bm9, bm10, bm11, bm12, bm13, bm14, bm15, bm16, bm17, bm18, bm19, bm20};

        View view = inflater.inflate(R.layout.tab_fragment2, container, false);
        gridView = view.findViewById(R.id.gridView1);
        gridView.setAdapter(new Tab2Adapter(inflater, picArr));

        return view;
    }
}