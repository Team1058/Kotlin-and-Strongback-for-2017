package org.frc1058.robot.commands

import edu.wpi.first.wpilibj.command.Command;
import org.frc1058.robot.subsystems.GearManipulator;


public class DriveGearIntake: Command {
	
	var rollerSpeed: Double = 0.0;
	
	public constructor(speed: Double){
		rollerSpeed = speed;
	}
	
	override protected fun initialize() {
	}
	
	override protected fun execute() {
		GearManipulator.setRollerSpeed(rollerSpeed);
	}
	
	override protected fun isFinished(): Boolean {
		 return false;
	}
	
	override protected fun end() {
		GearManipulator.setRollerSpeed(0.0);
    }
	
	override protected fun interrupted() {
		GearManipulator.setRollerSpeed(0.0);
    }
}