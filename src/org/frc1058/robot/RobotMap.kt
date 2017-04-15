package org.frc1058.robot

object RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public  int leftMotor = 1;
	// public  int rightMotor = 2;
	
	//TALON IDS
	const val SHOOTER1_TALON_ID = 5;
	const val HOPPER_MOTOR_TALON_ID = 0;
	const val GEAR_MANIPULATOR_PIVOT_TALON_ID = 6;
	const val LEFT_DRIVE_1_TALON_ID = 7;
	const val LEFT_DRIVE_2_TALON_ID = 8;
	const val RIGHT_DRIVE_1_TALON_ID = 3;
	const val RIGHT_DRIVE_2_TALON_ID = 2;
	const val CLIMBER_TALON_ID = 4;
	const val CYCLONE_TALON_ID = 1;
	
	//PWM IDS
	const val GEAR_MANIPULATOR_ROLLER_VICTOR_ID = 1;
	const val CAMERA_SERVO = 0;

	//MISC IDS:
	const val GEAR_MANIPULATOR_SOLENOID = 6;
	const val GEAR_LED_RING_CHANNEL = 0;
	const val SHOOTER_LED_RING_CHANNEL = 1;
	//DONT USE PCM CHANNEL 7 IT THROWS ERRORS
	
	//CONSTANT VALUES
	const val DRIVEBASE_kP : Double = 0.35;
	const val DRIVEBASE_kI : Double = 0.0;
	const val DRIVEBASE_kD : Double = 0.0;
	const val DRIVEBASE_kF : Double = 1.0;

	const val DRIVEBASE_POSITION_TOLERANCE = 0.5;
	const val DRIVEBASE_MAX_RPM = 653;
	const val DRIVEBASE_COUNTS_PER_REV = 256;
	
	const val BOILER_EDGE_SHOOTER_RPM = -4100;//run at -4100 for nominal speed
	
	const val INTAKE_PIVOT_ENCODER_TOLERANCE = 50;
	const val INTAKE_PIVOT_STOW_POSITION = 0;
	const val INTAKE_PIVOT_VERTICAL_POSITION = 1600;
	const val INTAKE_PIVOT_GEARINTAKE_POSITION = 3795;
	const val INTAKE_PIVOT_BALLINTAKE_POSITION = 982;
	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// int rangefinderPort = 1;
	// int rangefinderModule = 1;
	
	//GAMEPAD PORTS
	
	const val xButton = 3;
	const val aButton = 1;
	const val bButton = 2;
	const val yButton = 4;
	const val leftBumper = 5;
	const val rightBumper = 6;
	const val backButton = 7;
	const val startButton = 8;
	const val leftStickPress = 9;
	const val rightStickPress = 10;
	const val leftStick_xAxis = 0;
	const val leftStick_yAxis = 1;
	const val leftTrigger_Axis = 2;
	const val rightTrigger_Axis = 3;
	const val rightStick_xAxis = 4;
	const val rightStick_yAxis = 5;
}