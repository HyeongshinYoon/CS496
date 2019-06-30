package android.example.cs496.ui.main.fragment2;

import android.example.cs496.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.viewpager.widget.PagerAdapter;

import com.github.chrisbanes.photoview.PhotoView;

public class SubFragment2Adapter extends PagerAdapter {
    LayoutInflater inflater;
    final int[] picArr = {R.drawable.cat, R.drawable.tree, R.drawable.sunflower, R.drawable.rose, R.drawable.panda, R.drawable.heart, R.drawable.google};
    public SubFragment2Adapter(LayoutInflater inflater) {
        this.inflater=inflater;
    }

    @Override
    public int getCount() {
        return picArr.length;
    }

    @Override
    public Object instantiateItem(ViewGroup viewGroup, int position) {
        inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.sub_fragment2_view_pager, null);
        PhotoView photoView = view.findViewById(R.id.photoView);
        photoView.setImageResource(picArr[position]);

        viewGroup.addView(view);
        return view;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }

    @Override
    public boolean isViewFromObject(View v, Object obj) {
        return v == obj;
    }
}