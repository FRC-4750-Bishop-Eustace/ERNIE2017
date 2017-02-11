package org.usfirst.frc.team4750.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import java.util.Arrays;

import org.opencv.core.Mat;
import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.vision.VisionRunner;
import edu.wpi.first.wpilibj.vision.VisionThread;
import edu.wpi.cscore.CvSink;
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	
	private static final int IMG_WIDTH = 320;
	private static final int IMG_HEIGHT = 240;
	
	//private VisionThread visionThread;
	private double centerX = -1.0;
	
	//private final Object imgLock = new Object();
	private UsbCamera camera;
	private CvSink cvSink;
	private Mat mat = new Mat();
	private Rect rect;
	
	private GripPipeline pipeline = new GripPipeline();
	
	@Override
	public void robotInit() {
		camera = CameraServer.getInstance().startAutomaticCapture();
		camera.setResolution(IMG_WIDTH, IMG_HEIGHT);
		cvSink = CameraServer.getInstance().getVideo();
		
		//SmartDashboard.putNumber("Target Position", -1.0);
		SmartDashboard.putBoolean("Was non-empty", false);
		SmartDashboard.putBoolean("Was empty", false);

		
//		camera.setWhiteBalanceManual(1);
//		camera.setBrightness(128);
    
		
//		visionThread = new VisionThread(camera, new GripPipeline(), pipeline -> {
//			
//			//cvSink = CameraServer.getInstance().getVideo();
//			//cvSink.grabFrame(mat);
//			//pipeline.process(mat);
//			//SmartDashboard.putBoolean("Testing 2:",pipeline.testing());
//			
//			if (!pipeline.filterContoursOutput().isEmpty()) {
//				//Mat bluroutput = ((Vision)pipeline).blurOutput();
//				
//				Rect r = Imgproc.boundingRect(pipeline.filterContoursOutput().get(0));
//				synchronized (imgLock) {
//					centerX = r.x + (r.width / 2);
//					//SmartDashboard.putBoolean("ProcessingImage", true);
//				}
//			}
//		});
//		visionThread.start();
//        
//    //drive = new RobotDrive(1, 2);
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString line to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional comparisons to the
	 * switch structure below with additional strings. If using the
	 * SendableChooser make sure to add them to the chooser code above as well.
	 */
	@Override
	public void autonomousInit() {
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
//		SmartDashboard.putBoolean("Is this working", true);
//		double centerX;
//		synchronized (imgLock) {
//			centerX = this.centerX;
//		}
//		SmartDashboard.putNumber("centerX", centerX);
//		//double turn = centerX - (IMG_WIDTH / 2);
//		//drive.arcadeDrive(-0.6, turn * 0.005);
		cvSink.grabFrame(mat);
		pipeline.process(mat);
		
		SmartDashboard.putString("Resize Img Output 1x1", Arrays.toString(pipeline.resizeImageOutput().get(1, 1)));
		SmartDashboard.putString("Max HSL Test", Arrays.toString(pipeline.hslThresholdOutput().get(1, 1)));
		SmartDashboard.putNumber("Number of unfiltered contours", pipeline.findContoursOutput().size());
		SmartDashboard.putNumber("Number of filtered contours", pipeline.filterContoursOutput().size());
		
		if(!pipeline.filterContoursOutput().isEmpty()){
			SmartDashboard.putBoolean("Was non-empty", true);
			rect = Imgproc.boundingRect(pipeline.filterContoursOutput().get(0));
			SmartDashboard.putNumber("Target Position", rect.x + (rect.width/2.0));
		} else {
			SmartDashboard.putBoolean("Was empty", true);
			SmartDashboard.putNumber("Target Position", -1.0);
		}
		
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
	}
}

