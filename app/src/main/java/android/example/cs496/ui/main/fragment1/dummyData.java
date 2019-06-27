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
        personInfo.put("group", "KAIST");
        personInfo.put("email", "helloworld@kaist.ac.kr");
        personArray.put(personInfo);

        personInfo = new JSONObject();
        personInfo.put("name", "Olivia");
        personInfo.put("img", R.drawable.ic_launcher_foreground);
        personInfo.put("phone", "010-2345-6789");
        personInfo.put("group", "DGIST");
        personInfo.put("email", "freedom@dgist.ac.kr");
        personArray.put(personInfo);

        personInfo = new JSONObject();
        personInfo.put("name", "Hazel");
        personInfo.put("img", R.drawable.ic_launcher_foreground);
        personInfo.put("phone", "010-3456-7890");
        personInfo.put("group", "UNIST");
        personInfo.put("email", "vacation@unist.ac.kr");
        personArray.put(personInfo);

        personInfo = new JSONObject();
        personInfo.put("name", "Porter");
        personInfo.put("img", R.drawable.ic_launcher_foreground);
        personInfo.put("phone", "010-4567-8901");
        personInfo.put("group", "GIST");
        personInfo.put("email", "happy@gist.ac.kr");
        personArray.put(personInfo);

        personInfo = new JSONObject();
        personInfo.put("name", "Jimmy");
        personInfo.put("img", R.drawable.ic_launcher_foreground);
        personInfo.put("phone", "010-9876-5432");
        personInfo.put("group", "Korea.Univ");
        personInfo.put("email", "trust@korea.ac.kr");
        personArray.put(personInfo);

        personInfo = new JSONObject();
        personInfo.put("name", "Emma");
        personInfo.put("img", R.drawable.ic_launcher_foreground);
        personInfo.put("phone", "010-8765-4321");
        personInfo.put("group", "Korea.Univ");
        personInfo.put("email", "faith@cam.ac.uk");
        personArray.put(personInfo);

        personInfo = new JSONObject();
        personInfo.put("name", "Kelly");
        personInfo.put("img", R.drawable.ic_launcher_foreground);
        personInfo.put("phone", "010-8885-2341");
        personInfo.put("group", "");
        personInfo.put("email", "bye@cam.ac.uk");
        personArray.put(personInfo);
    }


    public static List<RecyclerItem> getData(Context context) throws JSONException {
        System.out.println(personArray.toString());
        List<RecyclerItem> datas = new ArrayList<>();

        for (int i = 0 ; i < personArray.length() ; i++) {
            JSONObject jObject = personArray.getJSONObject(i);
            String name = jObject.getString("name");
            int img = jObject.getInt("img");
            String phone = jObject.getString("phone");
            String group = jObject.getString("group");
            String email = jObject.getString("email");
            RecyclerItem data = new RecyclerItem(name, img, phone, group, email);
            datas.add(data);
        }
        return datas;
    }
}