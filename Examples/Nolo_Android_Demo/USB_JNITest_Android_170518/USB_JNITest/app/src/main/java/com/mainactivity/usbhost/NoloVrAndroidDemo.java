package com.mainactivity.usbhost;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.caliber.Nolo_ControllerStates;
import com.caliber.Nolo_Pose;
import com.watchdata.usbhostconn.HexSupport;
import com.watchdata.usbhostconn.UsbCustomTransfer;

import static com.mainactivity.usbhost.NoloVrAndroidDemo.NoloDeviceType.LeftController;

/**
 * Created by xu.huang.zf on 2017/4/17.
 */

public class NoloVrAndroidDemo extends Activity implements View.OnClickListener {
    private Button btn_init,btn_conn,btn_send,btn_setDisconnected,btn_finish;
    private Button btn_getVersion,btn_getElectricity,btn_getTracking, btn_getPose,btn_getControllerState,btn_getHmdCalibration;
    private TextView tv_init,tv_conn,tv_state,tv_finish,tv_version,tv_electricity,tv_tracking,tv_pose,tv_controllerstate,tv_calibration;
    private EditText et_sendData;
    private UsbCustomTransfer usbCustomTransfer;
    private UsbCustomTransfer.DisconnectedCallback mDisconnectedCallback;
    private final int NoloDeviceConnSuccess = 1;
    private final int NoloDeviceDisconnceted = 2;
    enum NoloDeviceType {
        Hmd,
        LeftController,
        RightController,
        BaseStationOne,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.nolovrandroiddemo);
        ui_init();
        usbCustomTransfer = UsbCustomTransfer.getInstance(this);

    }

    private void ui_init(){
        btn_init = (Button)findViewById(R.id.bt_init);
        btn_init.setOnClickListener(this);
        btn_conn = (Button)findViewById(R.id.bt_conn);
        btn_conn.setOnClickListener(this);
        btn_send = (Button)findViewById(R.id.bt_sendData);
        btn_send.setOnClickListener(this);
        btn_setDisconnected = (Button)findViewById(R.id.bt_setDisconnectedCallback);
        btn_setDisconnected.setOnClickListener(this);
        btn_finish = (Button)findViewById(R.id.bt_finish);
        btn_finish.setOnClickListener(this);
        btn_getVersion = (Button)findViewById(R.id.bt_getVersion);
        btn_getVersion.setOnClickListener(this);
        btn_getElectricity = (Button)findViewById(R.id.bt_getElectricity);
        btn_getElectricity.setOnClickListener(this);
        btn_getTracking = (Button)findViewById(R.id.bt_getTracking);
        btn_getTracking.setOnClickListener(this);
        btn_getPose = (Button)findViewById(R.id.bt_getPose);
        btn_getPose.setOnClickListener(this);
        btn_getControllerState = (Button)findViewById(R.id.bt_getControllerState);
        btn_getControllerState.setOnClickListener(this);
        btn_getHmdCalibration = (Button)findViewById(R.id.bt_getHmdCalibration);
        btn_getHmdCalibration.setOnClickListener(this);

        tv_init = (TextView)findViewById(R.id.tv_init);
        tv_conn = (TextView) findViewById(R.id.tv_conn);
        tv_state = (TextView) findViewById(R.id.tv_setDisconnectedCallback);
        tv_finish = (TextView) findViewById(R.id.tv_finish);
        tv_version = (TextView) findViewById(R.id.tv_getVersion);
        tv_electricity = (TextView) findViewById(R.id.tv_getElectricity);
        tv_tracking = (TextView)findViewById(R.id.tv_getTracking);
        tv_pose = (TextView)findViewById(R.id.tv_getPose);
        tv_controllerstate = (TextView) findViewById(R.id.tv_getControllerState);
        tv_calibration = (TextView) findViewById(R.id.tv_getHmdCalibration);

        et_sendData = (EditText) findViewById(R.id.et_sendData);
        mDisconnectedCallback = new UsbCustomTransfer.DisconnectedCallback() {
            @Override
            public void setUsbDeviceConnState(int mstate) {

                if(mstate == NoloDeviceConnSuccess){
                    // 设备正常连接
                    tv_state.setText("Usb Device Inserted");

                }else if(mstate == NoloDeviceDisconnceted){
                    // 设备断开
                    tv_state.setText("Nolo Device Disconnected");

                }
            }
        };
        btn_send.setClickable(false);
        btn_setDisconnected.setClickable(false);
        btn_finish.setClickable(false);
        btn_getVersion.setClickable(false);
        btn_getElectricity.setClickable(false);
        btn_getTracking.setClickable(false);
        btn_getPose.setClickable(false);
        btn_getControllerState.setClickable(false);
        btn_getHmdCalibration.setClickable(false);

    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.bt_init:
                usbCustomTransfer.usb_init();
                break;
            case R.id.bt_conn:
                int res = usbCustomTransfer.usb_conn();
                tv_conn.setText(String.valueOf(res));
                if(res == 1){
                    // connected success
                    btn_send.setClickable(true);
                    btn_setDisconnected.setClickable(true);
                    btn_finish.setClickable(true);
                    btn_getVersion.setClickable(true);
                    btn_getElectricity.setClickable(true);
                    btn_getTracking.setClickable(true);
                    btn_getPose.setClickable(true);
                    btn_getControllerState.setClickable(true);
                    btn_getHmdCalibration.setClickable(true);
                }
                break;

            case R.id.bt_sendData:
                if(!btn_send.isClickable())
                    Toast.makeText(this,"please sure the device connected",Toast.LENGTH_SHORT);
                byte[] mbyte = HexSupport.toBytesFromHex(et_sendData.getText().toString());
                usbCustomTransfer.usb_sendData(mbyte);
                break;
            case R.id.bt_setDisconnectedCallback:
                if(!btn_setDisconnected.isClickable())
                    Toast.makeText(this,"please sure the device connected",Toast.LENGTH_SHORT);
                usbCustomTransfer.setDisconnectedCallback(mDisconnectedCallback);
                break;
            case R.id.bt_finish:
                if(!btn_finish.isClickable())
                    Toast.makeText(this,"please sure the device connected",Toast.LENGTH_SHORT);
                usbCustomTransfer.usb_finish();
                break;
            case R.id.bt_getVersion:
                if(!btn_getVersion.isClickable())
                    Toast.makeText(this,"please sure the device connected",Toast.LENGTH_SHORT);
                //
                int version = usbCustomTransfer.getVersionByDeviceType(1);
                tv_version.setText(String.valueOf(version));
                break;
            case R.id.bt_getElectricity:
                if(!btn_getElectricity.isClickable())
                    Toast.makeText(this,"please sure the device connected",Toast.LENGTH_SHORT);
                int elec = usbCustomTransfer.getElectricityByDeviceType(1);
                tv_electricity.setText(String.valueOf(elec));
                break;
            case R.id.bt_getTracking:
                if(!btn_getTracking.isClickable())
                    Toast.makeText(this,"please sure the device connected",Toast.LENGTH_SHORT);
                int tracking = usbCustomTransfer.getDeviceTrackingStatus(1);
                tv_tracking.setText(String.valueOf(tracking));
            case R.id.bt_getPose:
                if(!btn_getPose.isClickable())
                    Toast.makeText(this,"please sure the device connected",Toast.LENGTH_SHORT);
                Nolo_Pose mnolo_pose = usbCustomTransfer.getPoseByDeviceType(1);
                if(mnolo_pose != null) {
                    String posx = String.valueOf(mnolo_pose.getPos().getX());
                    tv_pose.setText("posX:" + posx + "\n");
                    String posy = String.valueOf(mnolo_pose.getPos().getY());
                    tv_pose.append("posY:" + posy + "\n");
                    String posz = String.valueOf(mnolo_pose.getPos().getZ());
                    tv_pose.append("posZ:" + posz + "\n");
                    String quaternionx = String.valueOf(mnolo_pose.getNolo_Quaternion().getX());
                    tv_pose.append("quaternionX:" + quaternionx + "\n");
                    String quaterniony = String.valueOf(mnolo_pose.getNolo_Quaternion().getY());
                    tv_pose.append("quaternionY:" + quaterniony + "\n");
                    String quaternionz = String.valueOf(mnolo_pose.getNolo_Quaternion().getZ());
                    tv_pose.append("quaternionZ:" + quaternionz + "\n");
                    String quaternionw = String.valueOf(mnolo_pose.getNolo_Quaternion().getW());
                    tv_pose.append("quaternionW:" + quaternionw + "\n");
                }
                break;
            case R.id.bt_getControllerState:
                if(!btn_getControllerState.isClickable())
                    Toast.makeText(this,"please sure the device connected",Toast.LENGTH_SHORT);
                Nolo_ControllerStates mnlo_controllerState = usbCustomTransfer.getControllerStatesByDeviceType(1);
                if(mnlo_controllerState != null) {
                    String buttons = String.valueOf(mnlo_controllerState.getButtons());
                    tv_controllerstate.setText("Buttons:" + buttons + "\n");
                    String touches = String.valueOf(mnlo_controllerState.getTouches());
                    tv_controllerstate.append("Touches:" + touches + "\n");
                    String touchpadaxisX = String.valueOf(mnlo_controllerState.getTouchpadAxis().getX());
                    tv_controllerstate.append("touchpadaxisX:" + touchpadaxisX + "\n");
                    String touchpadaxisY = String.valueOf(mnlo_controllerState.getTouchpadAxis().getY());
                    tv_controllerstate.append("touchpadaxisY:" + touchpadaxisY + "\n");
                }
                break;
            case R.id.bt_getHmdCalibration:
                if(!btn_getHmdCalibration.isClickable())
                    Toast.makeText(this,"please sure the device connected",Toast.LENGTH_SHORT);
                String cal = String.valueOf(usbCustomTransfer.getHmdCalibration());
                tv_calibration.setText(cal);
                break;
        }
    }



}
