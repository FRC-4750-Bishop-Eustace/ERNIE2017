package org.usfirst.frc.team4750.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team4750.robot.Robot;
import org.usfirst.frc.team4750.robot.RobotMap;

/**
 *
 */
public class MecDrive extends Command {
	
	public MecDrive() {
		//this makes it so all the required pieces come here.
		requires(Robot.driveTrain);		
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		//this can used to test to see if a command is running for debugging
		SmartDashboard.putBoolean("Is MechDrive executing?", true);
		//this says that the robot's drivetrain is controlled by the driveStick defined in oi class
		Robot.driveTrain.controllerDrive(Robot.oi.driveStick);
		
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
=======
import org.usfirst.frc.team4750.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class MecDrive extends Command {

	public MecDrive(){
//		SmartDashboard.putBoolean("MecDrive.MecDrive()", true);
		requires(Robot.driveTrain);
	}
	
	protected void initialize(){
//		SmartDashboard.putBoolean("MecDrive.initialize()", true);
	}
	
	protected void execute(){
//		SmartDashboard.putBoolean("MecDrive.execute()", true);
		Robot.driveTrain.controllerDrive(Robot.oi.driveStick.getRawAxis(0),Robot.oi.driveStick.getRawAxis(3),Robot.oi.driveStick.getRawAxis(1),0);
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
//		SmartDashboard.putBoolean("MecDrive.isFinished()", true);
		return false;
	}
	
	protected void end(){
//		SmartDashboard.putBoolean("MecDrive.end()", true);
		Robot.driveTrain.setDriveMotors(0);
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
//		SmartDashboard.putBoolean("MecDrive.interrupted()", true);
		end();
	}

}
