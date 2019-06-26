package android.example.cs496.ui.main;

import android.content.Context;
import android.example.cs496.R;
import android.example.cs496.ui.main.fragment1.RecyclerItem;
import android.example.cs496.ui.main.fragment1.RecyclerItemClickListener;
import android.example.cs496.ui.main.fragment1.Tab1Adapter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class TabFragment1 extends Fragment {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    private ArrayList<RecyclerItem> tap1Items = new ArrayList<>();

    private String[] textSet = {"Amy", "Olivia", "Hazel"};
    private int[] imgSet = {R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground};
    private String[] phoneSet = {"010-1234-5678", "010-2345-6789", "010-3456-7890"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final Context context = getActivity();
        View v = inflater.inflate(R.layout.tab_fragment1,container,false);

        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(context));


        adapter = new Tab1Adapter(textSet, imgSet, phoneSet);
        recyclerView.setAdapter(adapter);
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
}