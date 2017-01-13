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
	public MecDrive() {
		//creates robot drive object using PWN 1,2,3,4
		RobotDrive m_robotDrive = new RobotDrive(1,2,3,4);
		
		//creates joystick being used in USB port 1 on the Drive Station
		Joystick m_driveStick = new Joystick(1);
		
		m_robotDrive.mecanumDrive_Cartesian(m_driveStick.getX(), m_driveStick.getY(), m_driveStick.getZ(), 0);
	}
	

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
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
