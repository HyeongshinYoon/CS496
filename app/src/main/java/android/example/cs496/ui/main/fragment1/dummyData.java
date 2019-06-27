package android.example.cs496.ui.main.fragment1;

import android.content.Context;
import android.example.cs496.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class dummyData {

    static JSONArray personArray;

    public dummyData () throws JSONException {
        //person의 한명 정보가 들어갈 JSONObject 선언
        personArray = new JSONArray();
        JSONObject personInfo = new JSONObject();

        //정보 입력
        personInfo.put("name", "Amy");
        personInfo.put("img", R.drawable.ic_launcher_foreground);
        personInfo.put("phone", "010-1234-5678");
        personArray.put(personInfo);

        personInfo = new JSONObject();
        personInfo.put("name", "Olivia");
        personInfo.put("img", R.drawable.ic_launcher_foreground);
        personInfo.put("phone", "010-2345-6789");
        personArray.put(personInfo);

        personInfo = new JSONObject();
        personInfo.put("name", "Hazel");
        personInfo.put("img", R.drawable.ic_launcher_foreground);
        personInfo.put("phone", "010-3456-7890");
        personArray.put(personInfo);
        System.out.println("bye");
    }


    public static List<RecyclerItem> getData(Context context) throws JSONException {
        System.out.println(personArray.toString());
        List<RecyclerItem> datas = new ArrayList<>();

        for (int i = 0 ; i < personArray.length() ; i++) {
            JSONObject jObject = personArray.getJSONObject(i);
            String name = jObject.getString("name");
            int img = jObject.getInt("img");
            String phone = jObject.getString("phone");
            RecyclerItem data = new RecyclerItem(name, img, phone);
            datas.add(data);
        }
        System.out.println("Hello");
        System.out.println(datas);
        return datas;
    }
}