package org.usfirst.frc.team4750.robot.commands;

import org.usfirst.frc.team4750.robot.Robot;
import org.usfirst.frc.team4750.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SetShooterSpeed extends Command {

	protected void execute(){
		Robot.shooter.setShooterSpeed(RobotMap.SHOOTER_MOTOR_SPEED);
		SmartDashboard.putBoolean("is SetShooterSpeed running?" , true);
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

