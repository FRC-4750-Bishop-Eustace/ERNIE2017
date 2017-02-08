package org.usfirst.frc.team4750.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team4750.robot.Robot;
import org.usfirst.frc.team4750.robot.RobotMap;

/**
 *
 */
public class AutoMove extends Command {
	
	Timer timer = new Timer();
	double leftSpeed, rightSpeed;
	double driveTime;
	
	public AutoMove(double leftSpeed, double rightSpeed, double driveTime) {
		requires(Robot.driveTrain);
		this.leftSpeed = leftSpeed;
		this.rightSpeed = rightSpeed;
		this.driveTime = driveTime;
		
//		SmartDashboard.putBoolean("AutoMove.AutoMove()", true);
		
	}
	

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Robot.driveTrain.setLeftDriveMotor(leftSpeed);
		Robot.driveTrain.setRightDriveMotor(rightSpeed);
		timer.start();
		SmartDashboard.getNumber("Timer:", timer.get());

		SmartDashboard.putBoolean("AutoMove.initialize()", true);
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		SmartDashboard.putBoolean("AutoMove.execute()", true);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		SmartDashboard.putBoolean("AutoMove.isFinished()", true);
		if(timer.get() > driveTime) {
			return true;
		} else {
			return false;
		}
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		SmartDashboard.putBoolean("AutoMove.end()", true);
		//Robot.driveTrain.setDriveMotors(0);
		//timer.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		SmartDashboard.putBoolean("AutoMove.interrupted()", true);
	}
}