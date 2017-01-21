package org.usfirst.frc.team4750.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;


public class DriveForwardAndTurn extends CommandGroup {
		
	public DriveForwardAndTurn(double driveSpeed, double driveTime, double turnSpeed, double turnTime){
		addSequential(new MoveForward(driveSpeed, driveSpeed, driveTime));
		addSequential(new MoveForward(turnSpeed, -turnSpeed, turnTime));
	}

}
