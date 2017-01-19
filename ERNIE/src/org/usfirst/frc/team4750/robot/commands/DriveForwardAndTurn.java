package org.usfirst.frc.team4750.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;


public class DriveForwardAndTurn extends CommandGroup {
		
	public DriveForwardAndTurn(double speed, double time){
		addSequential(new MecDriveAuto(speed, speed, time));
	}

}
