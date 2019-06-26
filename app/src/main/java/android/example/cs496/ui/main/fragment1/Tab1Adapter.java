package android.example.cs496.ui.main.fragment1;

import android.example.cs496.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Tab1Adapter extends RecyclerView.Adapter<Tab1Adapter.MyViewHolder> {

    List<RecyclerItem> datas;

    public Tab1Adapter(List<RecyclerItem> datas){
        this.datas = datas;
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
        RecyclerItem data = datas.get(i);
        myViewHolder.textView.setText(data.getName());
        myViewHolder.imageView.setBackgroundResource(data.getImg());
        myViewHolder.phoneView.setText(data.getPhone());
    }

    @Override
    public int getItemCount() {
        return datas.size();
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
}
