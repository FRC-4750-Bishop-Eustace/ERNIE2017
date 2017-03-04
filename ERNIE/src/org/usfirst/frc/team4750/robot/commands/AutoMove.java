package org.usfirst.frc.team4750.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team4750.robot.Robot;

/**
 *
 */
public class AutoMove extends Command {
	
	Timer timer;
	double leftSpeed, rightSpeed, driveTime;
	boolean peg;
	
	public AutoMove(double leftSpeed, double rightSpeed, double driveTime, boolean peg) {
		requires(Robot.driveTrain);
		this.leftSpeed = leftSpeed;
		this.rightSpeed = rightSpeed;
		this.driveTime = driveTime;
		this.peg = peg;
		timer = new Timer();
		
//		SmartDashboard.putBoolean("AutoMove.AutoMove()", true);
		
	}
	

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {	
		timer.start();
		SmartDashboard.getNumber("Timer:", timer.get());

		SmartDashboard.putBoolean("AutoMove.initialize()", true);
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.driveTrain.setLeftDriveMotor(leftSpeed);
		Robot.driveTrain.setRightDriveMotor(rightSpeed);
		SmartDashboard.putBoolean("AutoMove.execute()", true);
		peg = Robot.peg.Output();
		}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		SmartDashboard.putBoolean("AutoMove.isFinished()", true);
		if(timer.get() > driveTime && Robot.peg.Output() == true) {
			Robot.peglight.setLight(true);
			return true;
		}else if(Robot.gear.Output() == true){
			Robot.peglight.setLight(false);
			return true;
		}else{
			return false;
		}
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		SmartDashboard.putBoolean("AutoMove.end()", true);
		Robot.driveTrain.setDriveMotors(0 , 0);
		timer.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		SmartDashboard.putBoolean("AutoMove.interrupted()", true);
	}
}