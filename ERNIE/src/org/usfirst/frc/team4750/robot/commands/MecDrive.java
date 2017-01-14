package org.usfirst.frc.team4750.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4750.robot.Robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.RobotDrive;

/**
 *
 */
public class MecDrive extends Command {
	double leftSpeed, rightSpeed;
	RobotDrive m_robotDrive = new RobotDrive(0,1,2,3);
	Joystick m_driveStick = new Joystick(1);
	
	public MecDrive(double leftSpeed, double rightSpeed) {
		requires(Robot.driveTrain);
		this.leftSpeed = leftSpeed;
		this.rightSpeed = rightSpeed;
	}
	

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Robot.driveTrain.setLeftDriveMotor(leftSpeed);
		Robot.driveTrain.setRightDriveMotor(rightSpeed);
		m_robotDrive.mecanumDrive_Cartesian(m_driveStick.getX(), m_driveStick.getY(), m_driveStick.getZ(), 0);
		
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}
