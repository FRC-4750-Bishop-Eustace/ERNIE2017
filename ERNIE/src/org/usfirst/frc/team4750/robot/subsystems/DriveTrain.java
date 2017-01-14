package org.usfirst.frc.team4750.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team4750.robot.RobotMap;
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

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
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
}
