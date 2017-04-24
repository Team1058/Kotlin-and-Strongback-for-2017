package org.frc1058.robot.commands

import edu.wpi.first.wpilibj.command.Command;
import org.frc1058.robot.subsystems.GearManipulator;
import org.frc1058.robot.OI;
import org.frc1058.robot.RobotMap;

public class DriveAndPivotGearIntake: Command {
	
	var rollerSpeed: Double = 0.0;
	var intakeSetpoint: Double = 0.0;
	var maxVoltage: Double = 0.0;
	
	public constructor(setpoint: Double, speed: Double, voltage: Double = 12.0){
		requires(GearManipulator);
    	rollerSpeed = speed;
    	intakeSetpoint = setpoint;
		maxVoltage = voltage;
	}
	
	override protected fun initialize() {
		GearManipulator.setMaxIntakeSpeed(maxVoltage);
		
	}
	
	override protected fun execute() {
		GearManipulator.setIntakePosition(intakeSetpoint);
		if(!OI.operatorGamepad.getRightAxisButton()){
			GearManipulator.setRollerSpeed(rollerSpeed);
    	}
    	else{
    		GearManipulator.setRollerSpeed(0.0);
    	}
	}
	
	override protected fun isFinished(): Boolean {
		 return false;
	}
	
	override protected fun end() {
		GearManipulator.setIntakePosition(RobotMap.INTAKE_PIVOT_VERTICAL_POSITION);
    	GearManipulator.setRollerSpeed(0.0);
    }
	
	override protected fun interrupted() {
		GearManipulator.setRollerSpeed(0.0);
    	GearManipulator.setIntakePosition(RobotMap.INTAKE_PIVOT_VERTICAL_POSITION);
    }
}