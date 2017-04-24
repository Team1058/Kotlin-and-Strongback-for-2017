package org.frc1058.robot.subsystems

import edu.wpi.first.wpilibj.command.Subsystem
import org.frc1058.robot.ControllerModes
import org.frc1058.robot.RobotMap
import org.frc1058.robot.OI
import com.ctre.CANTalon

public object GearManipulator: Subsystem() {
	
	var currentMode : ControllerModes = ControllerModes.PID;
	val pivotMotor =  CANTalon(RobotMap.GEAR_MANIPULATOR_PIVOT_TALON_ID);
	val rollerMotor =  CANTalon(RobotMap.GEAR_MANIPULATOR_PIVOT_TALON_ID);
	
	override public fun initDefaultCommand() {
		//setDefaultCommand();
	}
	
	public fun initPivotMotor(mode: ControllerModes = currentMode){
		with(pivotMotor){
			setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
			changeControlMode(CANTalon.TalonControlMode.Position);
		}
		when(mode){
			ControllerModes.PID, ControllerModes.ENCODERS->{
				with(pivotMotor){
					setPID(RobotMap.GEAR_MANIPULATOR_kP,RobotMap.GEAR_MANIPULATOR_kI, RobotMap.GEAR_MANIPULATOR_kP)
					enableControl();
					reverseOutput(false);
					reverseSensor(false);
					setForwardSoftLimit(0.0);
				}	
			}
			ControllerModes.PERCENTVBUS->{
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
	
	public fun setRollerSpeed(speed: Double){
		rollerMotor.set(speed);
	}
}