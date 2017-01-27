package org.usfirst.frc.team4750.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team4750.robot.RobotMap;
import org.usfirst.frc.team4750.robot.commands.Testing;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.VictorSP;

/**
 *
 */
public class TestMotor extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	
	VictorSP testMotor = new VictorSP(RobotMap.TEST_MOTOR);

	
	public void controllerDrive(Joystick i) {
		testMotor.set(1);
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new Testing());
	}
	
	public void stop(){
	}
}
