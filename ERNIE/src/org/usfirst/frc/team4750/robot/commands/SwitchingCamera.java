package org.usfirst.frc.team4750.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4750.robot.Robot;
import org.usfirst.frc.team4750.robot.subsystems.Camera;

public class SwitchingCamera extends Command {

	public SwitchingCamera(){
		requires(Robot.camera);
	}
	
	protected void execute(){
		if(Robot.oi.cameraButton.get()){
			Robot.camera.currentState();
		// NOTE. NEED TO DEBOUNCE THE PRESS!
		}
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
