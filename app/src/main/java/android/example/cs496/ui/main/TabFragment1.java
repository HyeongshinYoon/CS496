package android.example.cs496.ui.main;

import android.content.Context;
import android.content.Intent;
import android.example.cs496.R;
import android.example.cs496.ui.main.fragment1.MainBackPressCloseHandler;
import android.example.cs496.ui.main.fragment1.PhoneBookActivity;
import android.example.cs496.ui.main.fragment1.RecyclerItem;
import android.example.cs496.ui.main.fragment1.RecyclerItemClickListener;
import android.example.cs496.ui.main.fragment1.Tab1Adapter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import static android.example.cs496.ui.main.fragment1.dummyData.refreshData;


public class TabFragment1 extends Fragment {

    private static Context context;
    RecyclerView recyclerView;
    static List<RecyclerItem> datas = null;
    private MainBackPressCloseHandler mainBackPressCloseHandler;
    Tab1Adapter adapter;
    //RecyclerView.Adapter adapter;
    //RecyclerView.LayoutManager layoutManager;

   // private ArrayList<RecyclerItem> tap1Items = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        context = getActivity();
        mainBackPressCloseHandler = new MainBackPressCloseHandler(getActivity());
        View v = inflater.inflate(R.layout.tab_fragment1,container,false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        resetData();
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(context.getApplicationContext(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Intent intent = new Intent(context, PhoneBookActivity.class);
                        RecyclerItem item = datas.get(position);
                        intent.putExtra("select", item);
                        startActivityForResult(intent, 0);
                    }
                }));
        return v;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        resetData();
    }

    public void resetData(){
        datas = refreshData();
        adapter = new Tab1Adapter(context, datas);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
    }
}