package org.usfirst.frc.team4750.robot.subsystems;

import org.usfirst.frc.team4750.robot.RobotMap;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Agitator extends Subsystem {

	//defines motor
	VictorSP agitatorMotor = new VictorSP(RobotMap.AGITATOR_MOTOR);
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}
	
	public void setAgitatorSpeed(){
		//sets speed of motor based on RobotMap
		agitatorMotor.set(RobotMap.AGITATOR_MOTOR_SPEED);
	}

}
