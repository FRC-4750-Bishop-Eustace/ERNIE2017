
package org.usfirst.frc.team4750.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.cscore.CameraServerJNI;
import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;


import org.usfirst.frc.team4750.robot.subsystems.Agitator;
import org.usfirst.frc.team4750.robot.subsystems.DriveTrain;
import org.usfirst.frc.team4750.robot.subsystems.Intake;
import org.usfirst.frc.team4750.robot.subsystems.Lifter;
import org.usfirst.frc.team4750.robot.subsystems.Shooter;
import org.opencv.core.Mat;
import org.usfirst.frc.team4750.robot.OI;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	//this defines the subsystems so they can be called along with their subclasses
	public static final DriveTrain driveTrain = new DriveTrain();
	public static final Shooter shooter = new Shooter();
	public static final Intake intake = new Intake();
	public static final Agitator agitator = new Agitator();
	public static final Lifter lifter = new Lifter();
	
	//public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static OI oi;

	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		oi = new OI();
		//chooser.addDefault("Default Auto", new ExampleCommand());
		// chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Auto mode", chooser);
	
Thread t = new Thread(() -> {
    		
    		//boolean allowCam1 = false;
    		//boolean allowCam2 = false;
    		
    		
    		UsbCamera camera1 = new UsbCamera("USB Camera 1", 0);
            camera1.setResolution(320, 240);
            camera1.setFPS(20);
            UsbCamera camera2 = new UsbCamera("USB Camera 2", 1);
            camera2.setResolution(320, 240);
            camera2.setFPS(20);
            /*UsbCamera camera3 = CameraServer.getInstance().startAutomaticCapture(3);
            camera3.setResolution(320, 240);
            camera3.setFPS(30);*/
            
            
            CvSink cvSink = CameraServer.getInstance().getVideo(camera1);
            //CvSink cvSink2 = CameraServer.getInstance().getVideo(camera2);
            //CvSink cvSink3 = CameraServer.getInstance().getVideo(camera3);
            CvSource outputStream = CameraServer.getInstance().putVideo("Current View", 320, 240);
            
            Mat image = new Mat();
            while(!Thread.interrupted()) {
            	cvSink.grabFrame(image);
            	
            	if(oi.cameraButton.get()) {
            		cvSink.setSource(camera2);
            		cvSink.grabFrame(image);
            	}else{
            		cvSink.setSource(camera1);
            		cvSink.grabFrame(image);
            	}
                
                outputStream.putFrame(image);
            }
            
        });
        t.start();
		
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		autonomousCommand = chooser.getSelected();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)autonomousCommand.cancel();
		// this makes it so the agitator starts running when the robot comes on
		Robot.agitator.setAgitatorSpeed();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
