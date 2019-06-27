package android.example.cs496.ui.main.fragment1;

import android.content.Intent;
import android.example.cs496.R;
import android.example.cs496.ui.main.fragment1.phonebook.PersonInformation;
import android.example.cs496.ui.main.fragment1.phonebook.PhoneBookPagerAdapter;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;


public class PhoneBookActivity extends AppCompatActivity {

    String name;
    int img;
    static String phone;
    static String group;
    static String email;

    private ViewPager viewPager;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        PhoneBookPagerAdapter PhoneBookPagerAdapter = new PhoneBookPagerAdapter(getSupportFragmentManager());
        setContentView(R.layout.sub_fragment1);
        //Initializing ViewPager

        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        img = intent.getIntExtra("img", 0);
        phone = intent.getStringExtra("phone");
        group = intent.getStringExtra("group");
        email = intent.getStringExtra("email");
        ImageView imageView = findViewById(R.id.iv_sub_img);
        imageView.setImageResource(img);
        TextView textView1 = findViewById(R.id.tv_sub_name);
        textView1.setText(name);
        TextView textView2 = findViewById(R.id.tv_sub_group);
        textView2.setText(group);

        viewPager = findViewById(R.id.sub_view_pager);
        PhoneBookPagerAdapter.add(new PersonInformation());
        viewPager.setAdapter(PhoneBookPagerAdapter);
    }
    public static String getPhone(){
        return phone;
    }
    public static String getGroup(){
        return group;
    }
    public static String getEmail(){
        return email;
    }

}