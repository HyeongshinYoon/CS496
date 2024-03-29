package android.example.cs496.ui.main.fragment1;

import android.example.cs496.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class dummyData {

    static JSONArray personArray;
    static List<RecyclerItem> datas = new ArrayList<>();
    private static int numData = 0;
    private static int lastNum = 0;

    public dummyData() throws JSONException {
        //person의 한명 정보가 들어갈 JSONObject 선언
        personArray = new JSONArray();
        JSONObject personInfo = new JSONObject();

        //정보 입력
        personInfo.put("id", 0);
        personInfo.put("name", "");
        personInfo.put("img", R.drawable.ic_addperson);
        personInfo.put("phone", "");
        personInfo.put("group", "");
        personInfo.put("email", "");
        personArray.put(personInfo);

        personInfo = new JSONObject();
        personInfo.put("id", 1);
        personInfo.put("name", "Amy");
        personInfo.put("img", R.drawable.ic_launcher_foreground_primarylight);
        personInfo.put("phone", "010-6355-5770");
        personInfo.put("group", "KAIST");
        personInfo.put("email", "helloworld@kaist.ac.kr");
        personArray.put(personInfo);

        personInfo = new JSONObject();
        personInfo.put("id", 2);
        personInfo.put("name", "Olivia");
        personInfo.put("img", R.drawable.ic_launcher_foreground_primarylight);
        personInfo.put("phone", "010-2345-6789");
        personInfo.put("group", "DGIST");
        personInfo.put("email", "freedom@dgist.ac.kr");
        personArray.put(personInfo);

        personInfo = new JSONObject();
        personInfo.put("id", 3);
        personInfo.put("name", "Hazel");
        personInfo.put("img", R.drawable.ic_launcher_foreground_primarylight);
        personInfo.put("phone", "010-3456-7890");
        personInfo.put("group", "UNIST");
        personInfo.put("email", "vacation@unist.ac.kr");
        personArray.put(personInfo);

        personInfo = new JSONObject();
        personInfo.put("id", 4);
        personInfo.put("name", "Porter");
        personInfo.put("img", R.drawable.ic_launcher_foreground_primarylight);
        personInfo.put("phone", "010-4567-8901");
        personInfo.put("group", "GIST");
        personInfo.put("email", "happy@gist.ac.kr");
        personArray.put(personInfo);

        personInfo = new JSONObject();
        personInfo.put("id", 5);
        personInfo.put("name", "Jimmy");
        personInfo.put("img", R.drawable.ic_launcher_foreground_primarylight);
        personInfo.put("phone", "010-9876-5432");
        personInfo.put("group", "Korea.Univ");
        personInfo.put("email", "trust@korea.ac.kr");
        personArray.put(personInfo);

        personInfo = new JSONObject();
        personInfo.put("id", 6);
        personInfo.put("name", "Emma");
        personInfo.put("img", R.drawable.ic_launcher_foreground_primarylight);
        personInfo.put("phone", "010-8765-4321");
        personInfo.put("group", "Korea.Univ");
        personInfo.put("email", "faith@cam.ac.uk");
        personArray.put(personInfo);

        personInfo = new JSONObject();
        personInfo.put("id", 7);
        personInfo.put("name", "Kelly");
        personInfo.put("img", R.drawable.ic_launcher_foreground_primarylight);
        personInfo.put("phone", "010-8885-2341");
        personInfo.put("group", "");
        personInfo.put("email", "bye@cam.ac.uk");
        personArray.put(personInfo);

        personInfo = new JSONObject();
        personInfo.put("id", 8);
        personInfo.put("name", "Zoe");
        personInfo.put("img", R.drawable.ic_launcher_foreground_primarylight);
        personInfo.put("phone", "010-1212-9871");
        personInfo.put("group", "KAIST");
        personInfo.put("email", "cs496.happy@kaist.ac.kr");
        personArray.put(personInfo);

        personInfo = new JSONObject();
        personInfo.put("id", 9);
        personInfo.put("name", "Aria");
        personInfo.put("img", R.drawable.ic_launcher_foreground_primarylight);
        personInfo.put("phone", "010-3333-5544");
        personInfo.put("group", "");
        personInfo.put("email", "good_day@naver.com");
        personArray.put(personInfo);
    }


    public static void setInitialData() throws JSONException {
        datas = new ArrayList<>();
        for (int i = 0; i < personArray.length(); i++) {
            JSONObject jObject = personArray.getJSONObject(i);
            String name = jObject.getString("name");
            int img = jObject.getInt("img");
            String phone = jObject.getString("phone");
            String group = jObject.getString("group");
            String email = jObject.getString("email");
            RecyclerItem data = new RecyclerItem(i, name, img, phone, group, email);
            datas.add(data);
        }
        Collections.sort(datas);
        lastNum = numData = getCountData();
    }

    public static int getCountData(){
        return datas.size();
    }

    public static List<RecyclerItem> refreshData() {
        Collections.sort(datas);
        return datas;
    }

    public static void editData(int position, RecyclerItem new_item) {

        int real_position = 0;
        for (int i = 0; i < datas.size(); i++) {
            if (datas.get(i).getId() == position) {
                real_position = i;
                break;
            }
        }
        datas.remove(real_position);
        datas.add(new_item);
        Collections.sort(datas);
    }

    public static void deleteData(int position, RecyclerItem new_item) {

        int real_position = 0;
        for (int i = 0; i < datas.size(); i++) {
            if (datas.get(i).getId() == position) {
                real_position = i;
                break;
            }
        }
        datas.remove(real_position);
        numData = datas.size();
    }

    public static void insertData(RecyclerItem new_item) {

        new_item.setImg(R.drawable.ic_launcher_foreground_primarylight);
        new_item.setId(lastNum);
        lastNum += 1;
        datas.add(new_item);
        Collections.sort(datas);
        numData = datas.size();
    }
}