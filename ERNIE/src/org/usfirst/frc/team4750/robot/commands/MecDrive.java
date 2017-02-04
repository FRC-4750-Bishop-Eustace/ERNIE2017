package org.usfirst.frc.team4750.robot.commands;

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
