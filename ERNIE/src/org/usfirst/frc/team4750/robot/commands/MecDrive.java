package org.usfirst.frc.team4750.robot.commands;

import org.usfirst.frc.team4750.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class MecDrive extends Command {

	public MecDrive(){
		requires(Robot.driveTrain);
	}
	
	protected void initialize(){
		
	}
	
	protected void execute(){
		Robot.driveTrain.controllerDrive(Robot.oi.driveStick);
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	protected void end(){
		Robot.driveTrain.setDriveMotors(0);
	}

}
