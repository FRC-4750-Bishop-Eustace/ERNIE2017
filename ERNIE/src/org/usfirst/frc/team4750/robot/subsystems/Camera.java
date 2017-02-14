package org.usfirst.frc.team4750.robot.subsystems;

import org.opencv.core.Mat;
import org.usfirst.frc.team4750.robot.RobotMap;
import org.usfirst.frc.team4750.robot.commands.SwitchingCamera;
import org.usfirst.frc.team4750.robot.OI;
import org.usfirst.frc.team4750.robot.Robot;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Camera extends Subsystem  {

	//defining cameras
	UsbCamera camera1;
	UsbCamera camera2;
	UsbCamera camera3;
	UsbCamera currCamera;
	
	CvSink cvSink;
    CvSource outputStream; 
    int i;  // index of the current camera that is streaming
    Mat image; 
	
	public Camera(){
		
		camera1 = new UsbCamera("USB Camera 1", RobotMap.CAMERA1);
		camera2 = new UsbCamera("USB Camera 2", RobotMap.CAMERA2);
		camera3 = new UsbCamera("USB Camera 3", RobotMap.CAMERA3);
		currCamera = camera1;
		
		/*
		CameraServer.getInstance().addCamera(camera1);
		CameraServer.getInstance().addCamera(camera2);
		CameraServer.getInstance().addCamera(camera3);
		
		//cvSink = CameraServer.getInstance().getVideo(currCamera);
		/*
	    outputStream = CameraServer.getInstance().putVideo("Current View", 320, 240);
	    i = 1;  // index of the current camera that is streaming
	    image = new Mat();
		*/
		
		
		/*
	//setting up FPS and Resolution
    camera1.setResolution(320, 240);
    camera1.setFPS(20);
    
    camera2.setResolution(320, 240);
    camera2.setFPS(20);
    
    camera3.setResolution(320, 240);
    camera3.setFPS(20);
    */
    
	}
	
	public void streaming(){
		//streams camera feed
		/*
		cvSink.grabFrame(image);
		outputStream.putFrame(image);
		*/
	}
	
	public void currentState(){
		/*
		i++;
		if(i>3) i=1;
		
		if(i == 1){
			currCamera = camera1;
			cvSink.setSource(camera1);
			cvSink.grabFrame(image);
			outputStream.putFrame(image);
			
		}else if(i == 2){
			currCamera = camera2;
			cvSink.setSource(camera2);
			cvSink.grabFrame(image);
			outputStream.putFrame(image);
			
		}else if(i == 3){
			currCamera = camera3;
			cvSink.setSource(camera3);
			cvSink.grabFrame(image);
			outputStream.putFrame(image);
			}
			*/
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		//setDefaultCommand(new SwitchingCamera());
	}

}
	
