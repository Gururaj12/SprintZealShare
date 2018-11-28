package com.sprintzeal.sprint.sprintzeal;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.toolbox.StringRequest;

public class Trunks {

    public static final String checkEmail = "https://www.eductalent.org/mobile/users/checkemail?email=";
    public static void retryPolicy(StringRequest request){
        request.setRetryPolicy(new DefaultRetryPolicy(
                30000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
    }
    public static final String loginUrl = "https://lms.sprintzeal.com/mobile/users/login?";
    public static final String registerUrl = "https://lms.sprintzeal.com/mobile/users/signup?";
    public static final String myCoursesUrl = "https://lms.sprintzeal.com/mobile/users/mycourse?email=";
    public static final String demoCoursesUrl = "https://lms.sprintzeal.com/mobile/users/democourse?email=";
    public static final String helpUrl = "https://lms.sprintzeal.com/mobile/users/help?status=1";
    public static final String contactUrl = "https://lms.sprintzeal.com/mobile/users/QueryFromCntact?";
    public static final String profileUrl = "https://lms.sprintzeal.com/mobile/users/view_profile?email=";
    public static final String chapterUrl = "https://lms.sprintzeal.com/mobile/users/chapters?page=chapters&chapters=&hidded=&video_id=&video_name=&course_id=";
    public static final String videoUrl = "https://lms.sprintzeal.com/mobile/users/videopage?page=video&video_id=&video_name=&chapters=";
    public static final String updateProfile = "https://lms.sprintzeal.com/mobile/users/edit_my_profile?email=";
    public static final String updateVideoStatusUrl = "";
    public static final String coursePriceDetailsUrl = "https://lms.sprintzeal.com/mobile/users/online_price_details?country=United%20States&course_id=";

    //SharedPreference
    public static final String SHP_NAME = "myPref";
    public static final String SHP_EMAIL = "email";


    public static final String COURSE_ID = "course_id";
    public static final String COURSE_NAME = "course_name";
    public static final String CATEGORY_ID = "category_id";
    public static final String FROM = "from";
    public static final String CART_ID = "cart_id";
    public static final String CART_AMOUNT = "cart_amount";


  //  public static final String MyPREFERENCES = "MyData" ;

    public static final String Device_id = "device_id";


    public static final String Token_id = "token_id";
    public static final String Os_version = "os_version";
    public static final String Operationg_system = "operationg_system";
    public static final String Resolution = "resolution";
    public static final String Screen_details = "screen_details";
    public static final String Time_zone = "time_zone";
    public static final String App_verson = "app_verson";
    public static final String Model_type = "model_type";
    public static final String DeviceType = "os";
    public static final String Manufacture_mode = "manufacture_mode";
    public static final String Ip_address = "ip_address";
    public static final String guest_id = "guest_id";
    public static final String rdevice_id = "rdevice_id";
    public static final String device_toke = "device_toke";
    public static final String login_token = "login_token";
    public static final String cust_id = "cust_id";
    public static final String course_id = "course_id";
    public static final String trainer_id = "trainer_id";

}
