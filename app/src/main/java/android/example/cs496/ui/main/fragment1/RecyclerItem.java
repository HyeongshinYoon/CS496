package android.example.cs496.ui.main.fragment1;

import android.example.cs496.R;

import java.util.Comparator;

public class RecyclerItem implements Comparator<RecyclerItem> {
    private String name;
    private int img = R.drawable.ic_launcher_foreground;
    private String phone;
    private String group;
    private String email;

    public RecyclerItem(String name, int img, String phone, String group, String email) {
        this.name = name;
        this.img = img;
        this.phone = phone;
        this.group = group;
        this.email = email;
    }

    public int compare(RecyclerItem a, RecyclerItem b) {
        return a.name.compareTo(b.name);
    }

    public String getName() {
        return name;
    }
    public int getImg() {
        return img;
    }
    public String getPhone() {
        return phone;
    }
    public String getGroup() { return group; }
    public String getEmail() { return email; }
}
