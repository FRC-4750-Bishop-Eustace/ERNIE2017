package org.usfirst.frc.team4750.robot;

import org.usfirst.frc.team4750.robot.commands.Lifting;
import org.usfirst.frc.team4750.robot.commands.SetIntakeSpeed;
import org.usfirst.frc.team4750.robot.commands.SetShooterSpeed;
import org.usfirst.frc.team4750.robot.commands.SwitchingCamera;


import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

//import org.usfirst.frc.team4750.robot.commands.ExampleCommand;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//Define the Joystick
	public Joystick driveStick = new Joystick(RobotMap.DRIVE_STICK_USB_PORT);
	
	//Joystick buttons
	Button shootButton = new JoystickButton(driveStick, 1);
	Button intakeButton = new JoystickButton(driveStick, 2);
	Button lifterButton = new JoystickButton(driveStick, 3);
	public Button cameraButton = new JoystickButton(driveStick, 4);
	
	public OI(){
		//where the commands for the buttons are placed
		shootButton.whileHeld(new SetShooterSpeed());
		intakeButton.toggleWhenPressed(new SetIntakeSpeed());
		lifterButton.whileHeld(new Lifting());// will be changed to prob active so we can have the speeds change to help with lifti
		cameraButton.whenReleased(new SwitchingCamera());
	}
}
