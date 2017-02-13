package org.usfirst.frc.team4750.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team4750.robot.Robot;
import org.usfirst.frc.team4750.robot.RobotMap;
import org.usfirst.frc.team4750.robot.commands.MecDrive;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.RobotDrive;

/**
 *
 */
public class DriveTrain extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	
	private VictorSP f_rightMotor;
	private VictorSP f_leftMotor;
	private VictorSP b_rightMotor;
	private VictorSP b_leftMotor;
	// put this line back and it stops uploading properly.. Don't know why it's a problem...
	private RobotDrive robotDrive;
		
	
	
	public DriveTrain(int frontLeftMotorPort, int backLeftMotorPort, int frontRightMotorPort, int backRightMotorPort){
		f_leftMotor = new VictorSP(frontLeftMotorPort);
		b_leftMotor = new VictorSP(backLeftMotorPort);
		f_rightMotor = new VictorSP(frontRightMotorPort);
		b_rightMotor = new VictorSP(backRightMotorPort);
		
		robotDrive = new RobotDrive(f_leftMotor, b_leftMotor, f_rightMotor, b_rightMotor);    //RobotMap.FRONT_LEFT_MOTOR, RobotMap.BACK_LEFT_MOTOR, RobotMap.FRONT_RIGHT_MOTOR, RobotMap.BACK_RIGHT_MOTOR);
	}
	
	
	public void controllerDrive(Joystick i) {
		//sets up the joystick and which axis controls what
		robotDrive.mecanumDrive_Cartesian(i.getRawAxis(0), -i.getRawAxis(3), -i.getRawAxis(1), 0);
		//robotDrive.mecanumDrive_Cartesian(i.getX(), -i.getY(), -i.getTwist(), 0);
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new MecDrive());
	}
	
	public void setLeftDriveMotor(double speed){
		f_leftMotor.set(speed);
		b_leftMotor.set(speed);
	}
	public void setRightDriveMotor(double speed){
		f_rightMotor.set(-speed);
		b_rightMotor.set(-speed);
	}
	public void setDriveMotors(double speed){
		setLeftDriveMotor(speed);
		setRightDriveMotor(speed);
	}
	public void setDriveMotors(double leftspeed, double rightspeed) {
		setLeftDriveMotor(leftspeed);
		setRightDriveMotor(rightspeed);
	}
}
