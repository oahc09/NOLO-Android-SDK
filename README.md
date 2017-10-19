# NOLO-Android-SDK  
You can use this SDK to develop android applications that supports NOLO.

[NOLO-Java-Android-SDK](./NOLOVR/Java)

[NOLO-C-Android-SDK](./NOLOVR/C)

For first time users,see [here](./Docs/getStart/GetStart.md).

You can also view open source code [Nolo_Android_Demo_Java](./Examples).

  
If you have problems,Check [FAQ](https://github.com/NOLOVR/NOLO-Android-SDK/issues).  

Documentation for the Java API is available on [here](./Docs/Docs_for_Java).

Documentation for the C API is available on [here](./Docs/Docs_for_C).

Android_Java_SDK_170923->171019：  
1. Remove usb_conn method. While click the "OK" button on the USB access pop-up, devices will connect automaticly. 
2. Add a haptic interface "void triggerHapticPulse(int deviceType,int intensity)".  
- Parameter: deviceType:  1-leftcontroller 2-rightcontroller  
-  Parameter: intensity: 0~100 

3. Change "setDisconnectedCallback" to "setConnectedStatusCallback". Change "DisconnectedCallback" to "ConnectedStatusCallback".
- Parameter: 0-Disconnected, 1-Connected.  

Android_C_SDK_170829：  
Add the C interface Android SDK.

