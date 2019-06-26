package android.example.cs496.ui.main.fragment1;

import android.example.cs496.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Tab1Adapter extends RecyclerView.Adapter<Tab1Adapter.MyViewHolder> {
    private String[] textSet;
    private int[] imgSet;
    private String[] phoneSet;

    public Tab1Adapter(String[] textSet, int[] imgSet, String[] phoneSet){
        this.textSet = textSet;
        this.imgSet = imgSet;
        this.phoneSet = phoneSet;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView;
        public TextView phoneView;

        public MyViewHolder(View view){
            super(view);
            this.imageView = view.findViewById(R.id.iv_pic);
            this.textView = view.findViewById(R.id.tv_text);
            this.phoneView = view.findViewById(R.id.tv_phone);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i){
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View holderView = inflater.inflate(R.layout.fragment1_holder_view, viewGroup, false);
        MyViewHolder myViewHolder = new MyViewHolder(holderView);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i){
        myViewHolder.textView.setText(this.textSet[i]);
        myViewHolder.imageView.setBackgroundResource(this.imgSet[i]);
        myViewHolder.phoneView.setText(this.phoneSet[i]);
    }

    @Override
    public int getItemCount() {
        return textSet.length > imgSet.length ? textSet.length : imgSet.length;
    }
}
