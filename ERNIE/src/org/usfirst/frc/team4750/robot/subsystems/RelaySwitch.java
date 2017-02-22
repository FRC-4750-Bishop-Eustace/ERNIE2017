package org.usfirst.frc.team4750.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team4750.robot.OI;

public class RelaySwitch extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	
	OI oi;

	Relay relay = new Relay(1);
	boolean debounced = true;
	boolean lightOn = false;
	
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		
	}
	
	public void relaySwitch() {
		SmartDashboard.putBoolean("LED Ring is:", lightOn);
		
		if (lightOn) {
			//Tells relay to turn on
			relay.set(Relay.Value.kForward);
		} else {
			//Tells the relay to turn off
			relay.set(Relay.Value.kOff);
		}
		
		if (oi.driveStick.getRawButton(1) && debounced) {
			
			lightOn = !lightOn;
			debounced = false;
		} else if (!oi.driveStick.getRawButton(1)) {
			debounced = true;
		}
	}
}
