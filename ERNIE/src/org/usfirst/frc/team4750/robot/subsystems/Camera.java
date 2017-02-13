package org.usfirst.frc.team4750.robot.subsystems;

import org.opencv.core.Mat;
import org.usfirst.frc.team4750.robot.RobotMap;
import org.usfirst.frc.team4750.robot.OI;
import org.usfirst.frc.team4750.robot.Robot;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Camera extends Subsystem  {
	//defining cameras
	UsbCamera camera1 = new UsbCamera("USB Camera 1", RobotMap.CAMERA1);
	UsbCamera camera2 = new UsbCamera("USB Camera 2", RobotMap.CAMERA2);
	UsbCamera camera3 = new UsbCamera("USB Camera 3", RobotMap.CAMERA3);
	UsbCamera currCamera = new UsbCamera("Current USB Camera", RobotMap.CURRCAMERA);
	
	CvSink cvSink = CameraServer.getInstance().getVideo(currCamera);
    CvSource outputStream = CameraServer.getInstance().putVideo("Current View", 320, 240);
    
    Mat image = new Mat();
	
	public Camera(){
	//setting up FPS and Resolution
    camera1.setResolution(320, 240);
    camera1.setFPS(20);
    
    camera2.setResolution(320, 240);
    camera2.setFPS(20);
    
    camera3.setResolution(320, 240);
    camera3.setFPS(20);
    
    // As a starting point for everytime
    currCamera = camera1;
    
   	
	}
	public void streaming(){
		//streams camera feed
		cvSink.grabFrame(image);
		outputStream.putFrame(image);
		
	}
	
	public UsbCamera currentState(){
		int i = 1;
		//for(int i=0; i<4; i++){
	do{	
		if(i == 1){
			currCamera = camera1;
			cvSink.setSource(camera1);
			cvSink.grabFrame(image);
			outputStream.putFrame(image);
			return currCamera;
		}else if(i == 2){
			currCamera = camera2;
			cvSink.setSource(camera2);
			cvSink.grabFrame(image);
			outputStream.putFrame(image);
			return currCamera;
		}else if(i == 3){
			currCamera = camera3;
			cvSink.setSource(camera3);
			cvSink.grabFrame(image);
			outputStream.putFrame(image);
			return currCamera;
			}
		i++;
	}while(i < 4);
		
	if(i == 4) i = 1;
		
		return camera1;
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
	
