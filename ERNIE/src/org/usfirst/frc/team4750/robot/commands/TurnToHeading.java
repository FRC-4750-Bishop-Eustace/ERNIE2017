/**
 * 
 */
package org.usfirst.frc.team4750.robot.commands;

import org.usfirst.frc.team4750.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * @author mkopack
 * Use this to perform a controlled automatic turn to a given heading.
 * 
 * The basic idea here is to take in an amount to turn in degrees.
 * Then, use what's called a PID controller to control how fast we need the motors to turn to 
 * change the heading. The closer we are to the target heading the slower we command the motors
 * so we don't overshoot.
 * 
 */
public class TurnToHeading extends Command {

	double offset;
	double targetheading;
	double startheading;
	double lastheadingread;
	
	/**
	 * Constructor.
	 * @param offset degrees we need to turn to reach goal. Often this will come from the vision system. 
	 * Negative numbers indicate a left turn, positive are a right turn.
	 */
	public TurnToHeading(double offset) {
		this.offset = offset;
	}
	
	@Override
	protected void initialize() {
		//do a reset of the IMU here
		//read the IMU, store the value into startheading
		
		startheading = 0; // READ FROM IMU!!!
		
		targetheading = startheading + offset;
		// handle the under/overflow conditions where we cross 360/0
		if(targetheading < 0)
			targetheading = 360+targetheading;
		if(targetheading > 360)
			targetheading = targetheading-360;
	}
	
	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		// read the current value from the IMU.
		// lastheadingread = ; // READ FROM IMU
		
		
		// the farther off the target we are, the higher we need to set the motors
		// x/1.0 = degreesofftarget/180;
		// note that there IS a minimum power setting or else we won't turn at all (motors will stall)
		// so if x< minumum, if we're within 2 degrees of target, just consider us done. 
		//  otherwise set us to the minimum motor speed.
		double speed = 0.0; //= degreesoffset/180.0;
		// see if we need to turn left or right. If the offset is - then we need to turn left.
		if(offset<0.0)
			speed = speed * -1.0;
		// otherwise we're going right and we're fine...
		
		// now tell it to turn!
		Robot.driveTrain.setDriveMotors(speed, -1.0*speed);
	}
	
	/* (non-Javadoc)
	 * @see edu.wpi.first.wpilibj.command.Command#isFinished()
	 */
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		// if we're within 2 degrees of the target,
		if (lastheadingread-targetheading <2.0 || targetheading-lastheadingread<2.0) {
			//close enough!
			return true;
		}
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		// let's stop
		Robot.driveTrain.setDriveMotors(0.0, 0.0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		SmartDashboard.putBoolean("TurnToHeading.interrupted()", true);
	}
}
