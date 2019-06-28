package android.example.cs496.ui.main;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.example.cs496.ui.main.fragment3.ForeCastManager;
import android.example.cs496.ui.main.fragment3.WeatherInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.example.cs496.R;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class TabFragment3 extends Fragment {

    ImageView imageView;

    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.tab_fragment3, container, false);
        imageView = view.findViewById(R.id.loading);
        imageView.setOnClickListener(new MyListener());
        return view;
    }

    class MyListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Context context = getActivity();
            Toast.makeText(context, "LOADING...", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(context, MainFragment3Activity.class);
//            intent.putExtra("position", position);
            startActivity(intent);
        }
    }

}