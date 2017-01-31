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
	}

}
