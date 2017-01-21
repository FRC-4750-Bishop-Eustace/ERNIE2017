package org.usfirst.frc.team4750.robot.commands;

import org.usfirst.frc.team4750.robot.Robot;
import org.usfirst.frc.team4750.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class SetShooterSpeed extends Command {

	protected void execute(){
		Robot.shooter.setShooterSpeed(RobotMap.SHOOTER_MOTOR_SPEED);
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	protected void end(){
		Robot.shooter.setShooterSpeed(0);
	}

}
