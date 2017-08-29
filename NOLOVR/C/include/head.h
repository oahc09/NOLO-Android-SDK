#pragma once

#ifndef NOLO_API
#define NOLO_API extern "C"
#endif
#include <windows.h>
#include <math.h>

namespace NOLO
{
	typedef struct Nolo_Vector2
	{
		float x;
		float y;
	}Nolo_Vector2;

	typedef struct Nolo_Vector3
	{
		float x;
		float y;
		float z;
	}Nolo_Vector3;

	typedef struct Nolo_Quaternion
	{
		float x;
		float y;
		float z;
		float w;
	}Nolo_Quaternion;

	typedef struct Nolo_Pose
	{
		Nolo_Vector3 pos;
		Nolo_Quaternion rot;
	}Nolo_Pose;

	/*
		buttons:
		TouchPad = 1 << 0;
        Trigger = 1 << 1;
        Menu = 1 << 2;
        System = 1 << 3;
        Grip = 1 << 4;
	*/
	typedef struct Nolo_ControllerStates
	{
		UINT buttons;
		UINT touches;
		Nolo_Vector2 touchpadAxis;
	}Nolo_ControllerStates;

	/**
	******************************************************************************
	* Function description：After the application gets the usb permission, call this method to establish a connection
	* Parameter：null
	* Return Value：bool
	*【应用获取到usb读取权限之后，调用此方法与建立连接】
	******************************************************************************
	*/
	NOLO_API bool _cdecl NoloDevice_conn();

	/**
	******************************************************************************
	* Function description：Disconnect the application from the usb device
	* Parameter：null
	* Return Value：bool
	*【断开应用与usb设备的连接】
	******************************************************************************
	*/
	NOLO_API bool _cdecl NoloDevice_finish();

	/**
	******************************************************************************
	* Function description：Get device tracking status
	* Parameter：int 
	0:hmd
	1:conroller one
	2:controller two
	3:basestation
	* Return Value：int
	*【获取设备跟踪状态】
	******************************************************************************
	*/
	NOLO_API int _cdecl GetDeviceTrackingStatus(int type);

	/**
	******************************************************************************
	* Function description：Get the device hardware version number
	* Parameter：int 
	0:hmd
	1:conroller one
	2:controller two
	3:basestation
	* Return Value：int
	*【获取设备硬件版本号】
	******************************************************************************
	*/
	NOLO_API int _cdecl GetVersionByDeviceType(int type);

	/**
	******************************************************************************
	* Function description：Get NOLO device electricity quantity
	* Parameter：int 
	0:hmd
	1:conroller one
	2:controller two
	3:basestation
	* Return Value：int
	*【获取设备电量信息】
	******************************************************************************
	*/
	NOLO_API int _cdecl GetElectricityByDeviceType(int type);

	/**
	******************************************************************************
	* Function description：Get device tracking information
	* Parameter：int 
	0:hmd
	1:conroller one
	2:controller two
	3:basestation
	* Return Value：Nolo_Pose
	*【获取设备定位信息】
	******************************************************************************
	*/
	NOLO_API Nolo_Pose _cdecl GetPoseByDeviceType(int type);

	/**
	******************************************************************************
	* Function description：Get the controller status information
	* Parameter：int
	0:hmd
	1:conroller one
	2:controller two
	3:basestation
	* Return Value：Nolo_ControllerStates
	*【获取手柄状态信息】
	******************************************************************************
	*/
	NOLO_API Nolo_ControllerStates _cdecl GetControllerStatesByDeviceType(int type);

	/**
	******************************************************************************
	* Function description：Get the headset marker when calibrating the position
	* Parameter：NULL
	* Return Value：Nolo_Vector3
	*【获取头盔标定时位置】
	******************************************************************************
	*/
	NOLO_API Nolo_Vector3 _cdecl GetHmdInitPosition();

	/**
	******************************************************************************
	* Function description：Send data to NOLO device
	* Parameter：int data[] int len
	* Return Value：bool
	*【震动数据接口】
	******************************************************************************
	*/
	NOLO_API bool _cdecl NoloDevice_sendData(int[] data, int len);
}
