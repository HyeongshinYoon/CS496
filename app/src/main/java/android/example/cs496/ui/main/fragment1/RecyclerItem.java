package android.example.cs496.ui.main.fragment1;

import android.example.cs496.R;

public class RecyclerItem {
    private String name;
    private int img = R.drawable.ic_launcher_foreground;
    private String phone;

    public RecyclerItem (String name, int img, String phone){
        this.name = name;
        this.img = img;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }
    public int getImg() {
        return img;
    }
    public String getPhone() { return phone; }
}
