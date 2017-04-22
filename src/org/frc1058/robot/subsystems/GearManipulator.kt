package org.frc1058.robot.subsystems

import edu.wpi.first.wpilibj.command.Subsystem
import org.frc1058.robot.RobotMap
import org.frc1058.robot.OI
import com.ctre.CANTalon

public object GearManipulator: Subsystem() {
	
	public enum class GearManipulatorMode{
		PID, PERCENTVBUS
	}
	
	var currentMode : GearManipulatorMode = GearManipulatorMode.PID;
	val pivotMotor =  CANTalon(RobotMap.GEAR_MANIPULATOR_PIVOT_TALON_ID);
	val rollerMotor =  CANTalon(RobotMap.GEAR_MANIPULATOR_PIVOT_TALON_ID);
	
	override public fun initDefaultCommand() {
		//setDefaultCommand();
	}
	
	public fun initPivotMotor(mode: GearManipulatorMode = currentMode){
		with(pivotMotor){
			setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
			changeControlMode(CANTalon.TalonControlMode.Position);
		}
		when(mode){
			GearManipulatorMode.PID->{
				with(pivotMotor){
					setPID(RobotMap.GEAR_MANIPULATOR_kP,RobotMap.GEAR_MANIPULATOR_kI, RobotMap.GEAR_MANIPULATOR_kP)
					enableControl();
					reverseOutput(false);
					reverseSensor(false);
					setForwardSoftLimit(0.0);
				}	
			}
			GearManipulatorMode.PERCENTVBUS->{
				with(pivotMotor){
					changeControlMode(CANTalon.TalonControlMode.PercentVbus);
				}
			}
		}
		pivotMotor.setPosition(0.0);
	}
	
	public fun setMaxIntakeSpeed(maxVoltage: Double){
		pivotMotor.configMaxOutputVoltage(maxVoltage);		
	}
	
	public fun setIntakePosition(setpoint: Double){
		if(setpoint>0 || OI.operatorGamepad.getStartButton()){
			pivotMotor.setSetpoint(-setpoint);
    	}
	}
	
	public fun drivePivotManual(output: Double){
    	pivotMotor.set(output);
    }
	
	
}