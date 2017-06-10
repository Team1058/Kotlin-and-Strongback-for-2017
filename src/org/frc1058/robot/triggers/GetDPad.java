package org.frc1058.robot.triggers;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.*;

/**
 * Gamepad DPadUp support
 */
class GetDPad extends Trigger {
	private final Joystick joy;
	private final double m_degrees;
	
	public GetDPad(Joystick joy, double degrees) {
		this.joy = joy;
		m_degrees = degrees;
	}	

	public boolean get() {
        return (joy.getPOV(0) == m_degrees);
    }
}