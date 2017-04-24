package org.frc1058.robot.subsystems

import com.ctre.CANTalon
import edu.wpi.first.wpilibj.AnalogGyro
import edu.wpi.first.wpilibj.Solenoid
import edu.wpi.first.wpilibj.command.Subsystem
import org.frc1058.robot.RobotMap
import org.frc1058.robot.commands.DriveSplitArcade
import org.frc1058.robot.ControllerModes

public object DriveBase : Subsystem(){
	
	val l1 = CANTalon(RobotMap.LEFT_DRIVE_1_TALON_ID);
	val r1 = CANTalon(RobotMap.RIGHT_DRIVE_1_TALON_ID);
	val l2 = CANTalon(RobotMap.LEFT_DRIVE_2_TALON_ID);
	val r2 = CANTalon(RobotMap.RIGHT_DRIVE_2_TALON_ID);
	val gyro = AnalogGyro(0);
	
	val gearLed = Solenoid(RobotMap.GEAR_LED_RING_CHANNEL);
	val shooterLed = Solenoid(RobotMap.SHOOTER_LED_RING_CHANNEL);

	var currentMode: ControllerModes = ControllerModes.PERCENTVBUS;
	
	
	override public fun initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(DriveSplitArcade());
	}
	
	public fun initDriveBase(){
		with(l1){
			setSafetyEnabled(false);
			enableControl();
			reverseSensor(true);
			configEncoderCodesPerRev(256);
			setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
		}
		with(r1){
			setSafetyEnabled(false);
			enableControl();
			reverseSensor(true);
			configEncoderCodesPerRev(256);
			setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
		}
		with(l2){
			setSafetyEnabled(false);
			changeControlMode(CANTalon.TalonControlMode.Follower);
		}
		with(r2){
			setSafetyEnabled(false);
			changeControlMode(CANTalon.TalonControlMode.Follower);
		}	
	}

	public fun changeMode(mode: ControllerModes){
		when (mode){
			ControllerModes.PERCENTVBUS ->{
				with(l1){
					changeControlMode(CANTalon.TalonControlMode.PercentVbus);
					enableBrakeMode(false);
				}
				with(r1){
					changeControlMode(CANTalon.TalonControlMode.PercentVbus);
					enableBrakeMode(false);
				}
		        l2.enableBrakeMode(false);
		        r2.enableBrakeMode(false);
			}
			ControllerModes.PID ->{
				with(l1){
					 changeControlMode(CANTalon.TalonControlMode.Speed);
					 setPID(RobotMap.DRIVEBASE_kP, RobotMap.DRIVEBASE_kI, RobotMap.DRIVEBASE_kD, RobotMap.DRIVEBASE_kF, 0, 0.0, 0);
					 configMaxOutputVoltage(12.0);
				}
				with(r1){
					changeControlMode(CANTalon.TalonControlMode.Speed);
					setPID(RobotMap.DRIVEBASE_kP, RobotMap.DRIVEBASE_kI, RobotMap.DRIVEBASE_kD, RobotMap.DRIVEBASE_kF, 0, 0.0, 0);
					configMaxOutputVoltage(12.0);
				}
			}
			ControllerModes.ENCODERS ->{
				with(l1){
					changeControlMode(CANTalon.TalonControlMode.Position);
					//TODO: FIX THIS GARBAGE
					//WHY ARE THE P AND I VALUES DIFFERENT
					setPID(0.52, 0.0, RobotMap.DRIVEBASE_kD, 0.0, 0, 500.0, 0);
					configMaxOutputVoltage(4.0);
				}
				with(r1){
					changeControlMode(CANTalon.TalonControlMode.Position);
					//TODO: FIX THIS GARBAGE
					//WHY ARE THE P AND I VALUES DIFFERENT
					setPID(0.52, 0.0, RobotMap.DRIVEBASE_kD, 0.0, 0, 500.0, 0);
					configMaxOutputVoltage(4.0);
				}
			}
		}
	}
	public fun driveTank(left:Double, right:Double){
		when(currentMode){
			ControllerModes.PERCENTVBUS ->{
				l1.set(left);
				l2.set(left);
				r1.set(-right)
				r2.set(-right)
			}
			ControllerModes.PID ->{
				l1.setSetpoint(left*60);
				l2.setSetpoint(left*60);
				r1.setSetpoint(-right*60);
				r2.setSetpoint(-right*60);
			}
			ControllerModes.ENCODERS ->{
				l1.setSetpoint(left);
				l2.setSetpoint(left);
				r1.setSetpoint(right);
				r2.setSetpoint(right);
			}
		}
	}	
}
	
