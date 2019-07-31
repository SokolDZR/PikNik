package com.example.piknik_lab;

import android.app.Activity;
import android.content.Context;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.widget.EditText;

//import android.support.v4.app.ActivityCompat;

public class Functions extends Activity {

    EditText editNum = (EditText) findViewById(R.id.deviceNumber);
    String deviceNumber = editNum.getText().toString();

    String getUserNumber() {
        TelephonyManager tMgr = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        String mPhoneNumber = tMgr.getLine1Number();
        return mPhoneNumber;
    }

    void userRegister(){
        String userNumber = getUserNumber();
        sendMessage(3, getDeviceNumber());
    }

    String getDeviceNumber(){
         return deviceNumber;
    }

    void sendMessage(int power, String device_number){

        String messageText = null;

        switch (power){
            case 1:
                messageText = "CMON";
                break;
            case 2:
                messageText = "CMOF";
                break;
            case 3:
                 messageText = "*123456*#" + getUserNumber() + "#";
                 break;
            default:
                break;
        }

        SmsManager sms = SmsManager.getDefault();
                sms.sendTextMessage(device_number, null, messageText, null, null);
    }
}
