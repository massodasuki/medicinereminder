package com.unifreelancer.masso.medicinereminder;

/**
 * Created by Masso on 8/14/2017.
 */

public class PillAlert {
    private static PillAlert _instance = null;

    private PillAlert(){

    }

    public static PillAlert instance(){

        if (_instance == null){
            _instance = new PillAlert();
        }
        return _instance;
    }

    private String mydataToShare = null;

    public  void setMydataToShare(String mydataToShare)
    {
        this.mydataToShare = mydataToShare;
    }

    public String getMydataToShare() {
        return mydataToShare;
    }
}
