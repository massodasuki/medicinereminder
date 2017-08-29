package com.unifreelancer.masso.medicinereminder;

/**
 * Created by Masso on 8/20/2017.
 */

public class ConfigCRUD {

        /*Masso
        //Address of our scripts of the CRUD
        public static final String URL_ADD="http://khamra.biz/addMedic.php";
        public static final String URL_GET_ALL = "http://khamra.biz/getAllMed.php";
        public static final String URL_GET_EMP = "http://khamra.biz/getMed.php?id=";
        public static final String URL_UPDATE_EMP = "http://khamra.biz/updateMed.php";
        public static final String URL_DELETE_EMP = "http://khamra.biz/deleteMed.php?id=";

        //New
        public static final String URL_GET_USER_INFO = "http://khamra.biz/getUserInfo.php?username=";

        */

        //Address of our scripts of the CRUD
        public static final String URL_ADD="http://pocketmedicinee.com/addMedic.php";
        public static final String URL_GET_ALL = "http://pocketmedicinee.com/getAllMed.php";
        public static final String URL_GET_EMP = "http://pocketmedicinee.com/getMed.php?id=";
        public static final String URL_UPDATE_EMP = "http://pocketmedicinee.com/updateMed.php";
        public static final String URL_DELETE_EMP = "http://pocketmedicinee.com/deleteMed.php?id=";

        //New
        public static final String URL_GET_USER_INFO = "http://pocketmedicinee.com/getUserInfo.php?username=";


        //Keys that will be used to send the request to php scripts
        public static final String KEY_EMP_ID = "id";
        public static final String KEY_EMP_USER = "username";
        public static final String KEY_EMP_NAME = "name";
        public static final String KEY_EMP_DESC = "description";
        public static final String KEY_EMP_PRICE = "price";

        //JSON Tags
        public static final String TAG_JSON_ARRAY="result";
        public static final String TAG_ID = "id";
        public static final String TAG_NAME = "medname";
        public static final String TAG_DESC= "desc";
        public static final String TAG_PRICE = "price";

        //employee id to pass with intent
        public static final String MED_ID = "med_id";


        //employee id to pass with intent
        public static final String USERNAME = "username";

        //JSON Tags
        public static final String TAG_MYNAME = "name";
        public static final String TAG_MYUSERNAME = "username";
        public static final String TAG_MYPASSWORD = "password";
        public static final String TAG_MYEMAIL = "email";
}
