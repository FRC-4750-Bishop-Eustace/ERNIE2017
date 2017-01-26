package org.usfirst.frc.team4750.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team4750.robot.Robot;
import org.usfirst.frc.team4750.robot.RobotMap;
import org.usfirst.frc.team4750.robot.commands.MecDrive;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Victor;

/**
 *
 */
public class DriveTrain extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	
	Victor f_rightMotor = new Victor(RobotMap.FRONT_RIGHT_MOTOR);
	Victor f_leftMotor = new Victor(RobotMap.FRONT_LEFT_MOTOR);
	Victor b_rightMotor = new Victor(RobotMap.BACK_RIGHT_MOTOR);
	Victor b_leftMotor = new Victor(RobotMap.BACK_LEFT_MOTOR);

	
	// put this line back and it stops uploading properly.. Don't know why it's a problem...
	private RobotDrive m_robotDrive = new RobotDrive(f_leftMotor, b_leftMotor, f_rightMotor, b_rightMotor);//RobotMap.FRONT_LEFT_MOTOR, RobotMap.BACK_LEFT_MOTOR, RobotMap.FRONT_RIGHT_MOTOR, RobotMap.BACK_RIGHT_MOTOR);
	
	
	public void controllerDrive(Joystick i) {
		m_robotDrive.mecanumDrive_Cartesian(i.getRawAxis(0), -i.getRawAxis(3), -i.getRawAxis(1), 0);
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new MecDrive());
	}
	
	public void setLeftDriveMotor(double speed){
	/*
		f_leftMotor.set(speed);
		b_leftMotor.set(speed);
		*/
	}
	public void setRightDriveMotor(double speed){
		/*
		f_rightMotor.set(-speed);
		b_rightMotor.set(-speed);
		*/
	}
	public void setDriveMotors(double speed){
		/*
		setLeftDriveMotor(speed);
		setRightDriveMotor(speed);
		*/
	}
}
