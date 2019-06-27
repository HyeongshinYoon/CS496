package android.example.cs496.ui.main;

import android.content.Context;
import android.content.Intent;
import android.example.cs496.R;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class DetailTabFragment2 extends Fragment {

    ImageView imageView;
    int position;
    final int[] picArr = {R.drawable.cat, R.drawable.tree, R.drawable.sunflower, R.drawable.rose, R.drawable.panda, R.drawable.heart, R.drawable.google};

    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        Intent intent = getActivity().getIntent();
        intent.getIntExtra("position", position);

        View view = inflater.inflate(R.layout.tab_fragment2_enlarge, container, false);
        imageView = view.findViewById(R.id.imageView0);
        imageView.setImageResource(picArr[position]);

        return inflater.inflate(R.layout.tab_fragment2_enlarge,container,false);

    }
}
