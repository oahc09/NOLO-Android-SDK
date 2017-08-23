package com.mainactivity.usbhost;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by xu.huang.zf on 2017/4/18.
 */

public class LayoutCreatorTest extends Activity implements View.OnClickListener {

    private TextView tv_api;
    private Button bt_init;
    private TextView tv_init;
    private Button bt_conn;
    private TextView tv_conn;
    private Button bt_setDisconnectedCallback;
    private TextView tv_setDisconnectedCallback;
    private EditText et_sendData;
    private Button bt_sendData;
    private Button bt_getVersion;
    private TextView tv_getVersion;
    private Button bt_getElectricity;
    private TextView tv_getElectricity;
    private Button bt_getTracking;
    private TextView tv_getTracking;
    private Button bt_getPose;
    private TextView tv_getPose;
    private Button bt_getControllerState;
    private TextView tv_getControllerState;
    private Button bt_getHmdCalibration;
    private TextView tv_getHmdCalibration;
    private Button bt_finish;
    private TextView tv_finish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nolovrandroiddemo);
        initView();
    }

    private void initView() {
        tv_api = (TextView) findViewById(R.id.tv_api);
        bt_init = (Button) findViewById(R.id.bt_init);
        tv_init = (TextView) findViewById(R.id.tv_init);
        bt_conn = (Button) findViewById(R.id.bt_conn);
        tv_conn = (TextView) findViewById(R.id.tv_conn);
        bt_setDisconnectedCallback = (Button) findViewById(R.id.bt_setDisconnectedCallback);
        tv_setDisconnectedCallback = (TextView) findViewById(R.id.tv_setDisconnectedCallback);
        et_sendData = (EditText) findViewById(R.id.et_sendData);
        bt_sendData = (Button) findViewById(R.id.bt_sendData);
        bt_getVersion = (Button) findViewById(R.id.bt_getVersion);
        tv_getVersion = (TextView) findViewById(R.id.tv_getVersion);
        bt_getElectricity = (Button) findViewById(R.id.bt_getElectricity);
        tv_getElectricity = (TextView) findViewById(R.id.tv_getElectricity);
        bt_getTracking = (Button) findViewById(R.id.bt_getTracking);
        tv_getTracking = (TextView) findViewById(R.id.tv_getTracking);
        bt_getPose = (Button) findViewById(R.id.bt_getPose);
        tv_getPose = (TextView) findViewById(R.id.tv_getPose);
        bt_getControllerState = (Button) findViewById(R.id.bt_getControllerState);
        tv_getControllerState = (TextView) findViewById(R.id.tv_getControllerState);
        bt_getHmdCalibration = (Button) findViewById(R.id.bt_getHmdCalibration);
        tv_getHmdCalibration = (TextView) findViewById(R.id.tv_getHmdCalibration);
        bt_finish = (Button) findViewById(R.id.bt_finish);
        tv_finish = (TextView) findViewById(R.id.tv_finish);

        bt_init.setOnClickListener(this);
        bt_conn.setOnClickListener(this);
        bt_setDisconnectedCallback.setOnClickListener(this);
        bt_sendData.setOnClickListener(this);
        bt_getVersion.setOnClickListener(this);
        bt_getElectricity.setOnClickListener(this);
        bt_getTracking.setOnClickListener(this);
        bt_getPose.setOnClickListener(this);
        bt_getControllerState.setOnClickListener(this);
        bt_getHmdCalibration.setOnClickListener(this);
        bt_finish.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_init:

                break;
            case R.id.bt_conn:

                break;
            case R.id.bt_setDisconnectedCallback:

                break;
            case R.id.bt_sendData:

                break;
            case R.id.bt_getVersion:

                break;
            case R.id.bt_getElectricity:

                break;
            case R.id.bt_getTracking:

                break;
            case R.id.bt_getPose:

                break;
            case R.id.bt_getControllerState:

                break;
            case R.id.bt_getHmdCalibration:

                break;
            case R.id.bt_finish:

                break;
        }
    }

    private void submit() {
        // validate
        String sendData = et_sendData.getText().toString().trim();
        if (TextUtils.isEmpty(sendData)) {
            Toast.makeText(this, "sendData不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something


    }
}
