package android.example.cs496.ui.main;

import android.content.Context;
import android.content.Intent;
import android.example.cs496.R;
import android.example.cs496.ui.main.fragment1.MainBackPressCloseHandler;
import android.example.cs496.ui.main.fragment1.PhoneBookActivity;
import android.example.cs496.ui.main.fragment1.RecyclerItem;
import android.example.cs496.ui.main.fragment1.RecyclerItemClickListener;
import android.example.cs496.ui.main.fragment1.Tab1Adapter;
import android.example.cs496.ui.main.fragment1.dummyData;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONException;

import java.util.List;


public class TabFragment1 extends Fragment {

    RecyclerView recyclerView;
    TextView textView;
    List<RecyclerItem> datas = null;
    private MainBackPressCloseHandler mainBackPressCloseHandler;
    //RecyclerView.Adapter adapter;
    //RecyclerView.LayoutManager layoutManager;

   // private ArrayList<RecyclerItem> tap1Items = new ArrayList<>();

    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final Context context = getActivity();
        mainBackPressCloseHandler = new MainBackPressCloseHandler(getActivity());
        View v = inflater.inflate(R.layout.tab_fragment1,container,false);

        try {
            new dummyData();
            datas = dummyData.getData(context);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Tab1Adapter adapter = new Tab1Adapter(datas);
        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(context.getApplicationContext(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Intent intent = new Intent(context, PhoneBookActivity.class);
                        intent.putExtra("name", datas.get(position).getName());
                        intent.putExtra("img", datas.get(position).getImg());
                        intent.putExtra("phone", datas.get(position).getPhone());
                        intent.putExtra("group", datas.get(position).getGroup());
                        intent.putExtra("email", datas.get(position).getEmail());
                        datas.get(position);
                        startActivity(intent);
                    }
                }));
        return v;
    }

    public void onBackPressed() {
        mainBackPressCloseHandler.onBackPressed();
    }
}