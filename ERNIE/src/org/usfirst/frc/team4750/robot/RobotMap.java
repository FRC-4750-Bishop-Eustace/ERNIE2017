package org.usfirst.frc.team4750.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	//Joystick ports(USB) Check the driver station
	public static int DRIVE_STICK_USB_PORT = 0;
	
	
	//Motor ports(PWM)
	public static final int LIFTER_MOTOR = 0; 
	public static final int FRONT_LEFT_MOTOR = 1;
	public static final int BACK_LEFT_MOTOR = 2;
	public static final int FRONT_RIGHT_MOTOR = 3;
	public static final int BACK_RIGHT_MOTOR = 4;
	public static final int INTAKE_MOTOR = 5;
	public static final int SHOOTER_MOTOR = 6;
	public static final int AGITATOR_MOTOR = 7;
	
	
	//Motor Speeds; + is forward - is backwards; adjust speeds here and only here, everything else will follow
	public static final double SHOOTER_MOTOR_SPEED = 1;
	public static final double INTAKE_MOTOR_SPEED = -.5;
	public static final double LIFTER_MOTOR_SPEED = .2;
	public static final double AGITATOR_MOTOR_SPEED = .4;

	
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	
	public static final int SELECTOR_HIGH_DIO = 1;  // (On switch, closest to the middle)
	public static final int SELECTOR_MID_DIO =2; // (on switch, between edge and middle)
	public static final int SELECTOR_LOW_DIO = 3; // (on switch, edge)

	//Timers
	public static final double REACH_TIME = 5;
	public static final double TURN_TIME = 10;

}
