package android.example.cs496.ui.main;

import android.content.Intent;
import android.example.cs496.R;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import com.github.chrisbanes.photoview.PhotoView;
import static android.app.PendingIntent.getActivity;

public class Fragment2SubActivity extends AppCompatActivity {

    int position;
    final int[] picArr = {R.drawable.cat, R.drawable.tree, R.drawable.sunflower, R.drawable.rose, R.drawable.panda,
            R.drawable.heart, R.drawable.google, R.drawable.tiger, R.drawable.dog, R.drawable.chiba3, R.drawable.chiba,
            R.drawable.girl, R.drawable.fruit, R.drawable.beach, R.drawable.bird, R.drawable.chiba2, R.drawable.yun2,
            R.drawable.yun3, R.drawable.yun4, R.drawable.yun5, R.drawable.iu, R.drawable.view};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.tab_fragment2_zoominout);

        Intent intent = getIntent();
        position = intent.getIntExtra("position", 0);

        PhotoView photoView = findViewById(R.id.photoView);
        photoView.setImageResource(picArr[position]);
    }
}

