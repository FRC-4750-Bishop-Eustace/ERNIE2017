package org.usfirst.frc.team4750.robot;

import org.usfirst.frc.team4750.robot.commands.Lifting;
import org.usfirst.frc.team4750.robot.commands.SetIntakeSpeed;
import org.usfirst.frc.team4750.robot.commands.SetShooterSpeed;
import org.usfirst.frc.team4750.robot.commands.SwitchingCamera;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//Variables for cubing of the inputs
	public double driveStickXcube, driveStickYcube, driveStickTwistcube;
	
	//Define the Joystick
	public Joystick driveStick = new Joystick(RobotMap.DRIVE_STICK_USB_PORT);
	
	
	//Joystick buttons
	Button shootButton = new JoystickButton(driveStick, 1);
	Button intakeButton = new JoystickButton(driveStick, 2);
	Button lifterButton = new JoystickButton(driveStick, 3);
	Button cameraButton = new JoystickButton(driveStick, 4);
		
	public OI(){		
		//where the commands for the buttons are placed
		shootButton.toggleWhenPressed(new SetShooterSpeed());
		intakeButton.toggleWhenPressed(new SetIntakeSpeed());
		lifterButton.whileHeld(new Lifting());
		cameraButton.whenReleased(new SwitchingCamera());
		
		/**uses the formula x' = ax^3 + (1-a)x
		 * x' is the sensivity-adjusted output (-1 to +1)
		 * x is a joystick output ranging from -1 to +1
		 * a is a variable from -1 to +1
		 * Adjust "a" to find the right sensitivity
		 * Right now a = 1, so the equation comes down to x^3. We can change it.
		 * We could use throttle to change a so the drive can control how much sensivity they want.
		 * I think we should just cube it.
		 */
		driveStickXcube = Math.pow(driveStick.getX(), 3);
		driveStickYcube = Math.pow(driveStick.getY(), 3);
		driveStickTwistcube = Math.pow(driveStick.getTwist(), 3);
	}
}
