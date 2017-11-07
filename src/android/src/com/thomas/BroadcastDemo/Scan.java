package com.thomas.BroadcastDemo;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;



public class Scan extends CordovaPlugin {
    private final static int SCANNIN_GREQUEST_CODE = 1;
    private CallbackContext callbackContext;
    private Activity activity;

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {

        activity = cordova.getActivity();
        this.callbackContext = callbackContext;


        if("recognize".equals(action)) {
            String textPileCode = args.getString(0);
            Intent intent = new Intent();
            intent.setClass(activity, MipcaActivityCapture.class);
            intent.putExtra("textPileCode",textPileCode);
            cordova.startActivityForResult( this,intent, SCANNIN_GREQUEST_CODE);
        }
        return true;
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case SCANNIN_GREQUEST_CODE:
                if(resultCode == Activity.RESULT_OK){
                    Bundle bundle = data.getExtras();
                    callbackContext.success(bundle.getString("result"));
                }
                break;
        }
    }

}
