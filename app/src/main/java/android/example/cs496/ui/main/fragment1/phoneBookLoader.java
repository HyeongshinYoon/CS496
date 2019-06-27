//package android.example.cs496.ui.main.fragment1;
//
//import android.content.ContentResolver;
//import android.content.Context;
//import android.database.Cursor;
//import android.net.Uri;
//import android.provider.ContactsContract;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class phoneBookLoader {
//    public static List<RecyclerItem> getData(Context context){
//        List<RecyclerItem> datas = new ArrayList<>();
//        // 로직
//
//        // 전화번호부를 가지고 오기 위해 contentResolver를 사용. -> context가 필요함.
//        // 전화번호 데이터를 가져오는 커넥터 역할.
//        ContentResolver resolver = context.getContentResolver();
//
//        // 데이터가 있는 테이블 주소 가져오기
//        Uri phoneUri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
//        // 테이블에서 가져올 컬럼명을 정의
//        String proj[] = {ContactsContract.CommonDataKinds.Phone.PHOTO_ID,
//                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
//                ContactsContract.CommonDataKinds.Phone.NUMBER};
//
//        // 컨텐트 리졸버로 데이터 가져오기. 가져온 형태 -> 커서
//        Cursor cursor = resolver.query(phoneUri, proj, null, null, null);
//
//        // cursor에 데이터 존재여부
//        if(cursor != null ){
//            while (cursor.moveToNext()){
//                int index = cursor.getColumnIndex(proj[0]);
//                int photo = cursor.getInt(index);
//
//                index = cursor.getColumnIndex(proj[1]);
//                String name = cursor.getString(index);
//
//                index = cursor.getColumnIndex(proj[2]);
//                String tel = cursor.getString(index);
//
//                RecyclerItem data = new RecyclerItem(name, photo, tel);
//
//                datas.add(data);  // 위에 정의한 데이터 저장소에 add
//                // datas에 열 하나하나 단위의 데이터 클래스가 저장됨 -> 주소록만큼 datas의 개수가 생성됨.
//            }
//        }
//        cursor.close(); // 닫지 않으면 계속 열려있음.
//        //
//
//        return datas;
//    }
//
//}
//
