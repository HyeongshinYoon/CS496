package android.example.cs496.ui.main.fragment2;

import android.example.cs496.R;
import android.graphics.Bitmap;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Intent;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import static androidx.core.content.ContextCompat.startActivity;

public class Tab2Adapter extends BaseAdapter {
    //private Bitmap[] picArr;
    private int[] picArr;
    private LayoutInflater inf;

//    public Tab2Adapter(LayoutInflater inflater, Bitmap[] picArr) {
    public Tab2Adapter(LayoutInflater inflater, int[] picArr) {
        this.picArr = picArr;
        this.inf = inflater;
    }

    @Override
    public int getCount() {return picArr.length;}

    @Override
    public Object getItem(int position) {return picArr[position];}

    @Override
    public long getItemId(int position) {return position;}

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final GridViewHolder viewHolder;

        // 캐시된 뷰가 없을 경우 새로 생성하고 뷰홀더를 생성한다.
        if (convertView==null) {
            convertView = inf.inflate(R.layout.griditem, parent, false);
            viewHolder = new GridViewHolder();
            viewHolder.img = convertView.findViewById(R.id.imageView1);
            convertView.setTag(viewHolder);
        }
        // 캐시된 뷰가 있을 경우 저장된 뷰홀더를 사용한다.
        else{
            viewHolder = (GridViewHolder) convertView.getTag();
        }
        //viewHolder.img.setImageBitmap(picArr[position]);
        viewHolder.img.setImageResource(picArr[position]);
        return convertView;
    }
}
