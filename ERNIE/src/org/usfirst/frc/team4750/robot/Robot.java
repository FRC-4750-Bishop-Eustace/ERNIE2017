package org.usfirst.frc.team4750.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team4750.robot.commands.AutoDriveForwardAndTurn;
import org.usfirst.frc.team4750.robot.commands.AutoMove;
import org.usfirst.frc.team4750.robot.commands.MecDrive;
import org.usfirst.frc.team4750.robot.commands.TurnToHeading;
import org.usfirst.frc.team4750.robot.subsystems.Agitator;
import org.usfirst.frc.team4750.robot.subsystems.AutoSwitch;
import org.usfirst.frc.team4750.robot.subsystems.Camera;
//import org.usfirst.frc.team4750.robot.commands.ExampleCommand;
import org.usfirst.frc.team4750.robot.subsystems.DriveTrain;
import org.usfirst.frc.team4750.robot.subsystems.Intake;
import org.usfirst.frc.team4750.robot.subsystems.Lifter;
//import org.usfirst.frc.team4750.robot.subsystems.ExampleSubsystem;
import org.usfirst.frc.team4750.robot.subsystems.Shooter;





/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final DriveTrain driveTrain = new DriveTrain(
			RobotMap.FRONT_LEFT_MOTOR,
			   RobotMap.BACK_LEFT_MOTOR,
			   RobotMap.FRONT_RIGHT_MOTOR,
			   RobotMap.BACK_RIGHT_MOTOR);

	//this defines the subsystems so they can be called along with their subclasses
	public static final Shooter shooter = new Shooter();
	public static final Intake intake = new Intake();
	public static final Agitator agitator = new Agitator();
	public static final Lifter lifter = new Lifter();
	public static Camera camera = new Camera();

	//public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static OI oi;
	public static final AutoSwitch autoswitch = new AutoSwitch();

	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

	
	//public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();

	AutoMode autoMode;
	
	//SendableChooser<Command> chooser = new SendableChooser<>();
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		oi = new OI();
		
		//chooser.addDefault("Default Auto", new ExampleCommand());
		// chooser.addObject("My Auto", new MyAutoCommand());
		//SmartDashboard.putData("Auto mode", chooser);
		
		//Set the mode we're going to run in Autonomous...
		// Normally we'd read this from the mechanical switch
		autoMode = AutoMode.TURN_TO_HEADING;
		
		// (left speed, right speed, time)
		// Ok, see which position the switch is in
		switch(autoMode){
			case MOVE_FORWARD:
				autonomousCommand = new AutoMove(+1.0, 1.0, RobotMap.REACH_TIME);
				break;
				
		// (driveSpeed, driveTime, turnSpeed, turnTime)
			case DRIVE_FORWARD_AND_TURN:
				autonomousCommand = new AutoDriveForwardAndTurn(+1, RobotMap.REACH_TIME, +1, RobotMap.TURN_TIME);
				break;
			case TURN_TO_HEADING:
				autonomousCommand = new TurnToHeading(90.0f);
				break;
		}
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
		// always start up the cameras
		camera.init();
		//autonomousCommand = chooser.getSelected();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// read the command to run from the switch.
		// commenting this out for now so we can test rotating with the IMU
		
		//autonomousCommand = autoswitch.getMode();
				
		
		// schedule the autonomous command (example)
		
		SmartDashboard.putBoolean("Robot.autonomousInit()",true);
		if (autonomousCommand != null)
			autonomousCommand.start();

	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		SmartDashboard.putBoolean("Robot.autonomousPeriodic()",true);
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		
		// if we didn't previously initialize (because in testing we skipped the autonomous mode)
		// go ahead and initialize it now.
		if(!camera.isInitialized())
			camera.init();
		
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
