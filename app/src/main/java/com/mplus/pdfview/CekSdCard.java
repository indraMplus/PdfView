package com.mplus.pdfview;

import android.os.Environment;

public class CekSdCard {//Method to Check If SD Card is mounted or not
    public static boolean isSDCardPresent() {
        if (Environment.getExternalStorageState().equals(

                Environment.MEDIA_MOUNTED)) {
            return true;
        }
        return false;
    }
}
