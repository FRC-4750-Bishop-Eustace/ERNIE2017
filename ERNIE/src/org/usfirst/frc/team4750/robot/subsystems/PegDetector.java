package org.usfirst.frc.team4750.robot.subsystems;

import org.usfirst.frc.team4750.robot.Robot;
import org.usfirst.frc.team4750.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class PegDetector extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	
	DigitalInput input = new DigitalInput(RobotMap.PEG_SENSOR);
	DigitalInput input2 = new DigitalInput(RobotMap.SECOND_PEG_SENSOR);

	protected void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		
	}
	
	public boolean Output() {
		SmartDashboard.putBoolean("Peg Detector", !input.get());//made it so the outputs are correct
		SmartDashboard.putBoolean("Peg Detector2", !input2.get());
		if(!input.get() == false && !input2.get() == false){
			Robot.peglight.setLight(false);
			return false;
		}else if(!input.get() == true || !input2.get() == true){
			Robot.peglight.setLight(true);
			return true;
		}
		return false;
	}

}
