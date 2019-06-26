package android.example.cs496.ui.main;

import android.content.Context;
import android.example.cs496.R;
import android.example.cs496.ui.main.fragment1.MainBackPressCloseHandler;
import android.example.cs496.ui.main.fragment1.RecyclerItem;
import android.example.cs496.ui.main.fragment1.RecyclerItemClickListener;
import android.example.cs496.ui.main.fragment1.Tab1Adapter;
import android.example.cs496.ui.main.fragment1.dummyData;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONException;

import java.util.List;


public class TabFragment1 extends Fragment {

    RecyclerView recyclerView;
    TextView textView;
    private MainBackPressCloseHandler mainBackPressCloseHandler;
    //RecyclerView.Adapter adapter;
    //RecyclerView.LayoutManager layoutManager;

   // private ArrayList<RecyclerItem> tap1Items = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final Context context = getActivity();
        mainBackPressCloseHandler = new MainBackPressCloseHandler(getActivity());
        View v = inflater.inflate(R.layout.tab_fragment1,container,false);

        List<RecyclerItem> datas = null;
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

        //adapter = new Tab1Adapter(textSet, imgSet, phoneSet);
        DividerItemDecoration dividerItemDecoration =
                new DividerItemDecoration(context.getApplicationContext(),new LinearLayoutManager(context).getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(context.getApplicationContext(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Toast.makeText(context.getApplicationContext(),position+"번 째 아이템 클릭",Toast.LENGTH_SHORT).show();
                    }
                }));
        return v;
    }

    public void onBackPressed() {
        mainBackPressCloseHandler.onBackPressed();
    }
}