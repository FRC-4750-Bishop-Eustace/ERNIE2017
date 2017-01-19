package org.usfirst.frc.team4750.robot.subsystems;

import org.usfirst.frc.team4750.robot.RobotMap;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem {
	
	Victor intake = new Victor(RobotMap.INTAKE_MOTOR);

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}
	
	public void setIntakeSpeed(double speed){
		intake.set(.5*speed);
	}

}
