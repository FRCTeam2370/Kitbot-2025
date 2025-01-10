// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drive extends SubsystemBase {
  public static Spark RightDriver = new Spark(1);
  public static Spark RightPassenger = new Spark(2);
  public static Spark LeftDriver = new Spark(3);
  public static Spark LeftPassenger = new Spark(4);

  private static DifferentialDrive mDrive = new DifferentialDrive(LeftDriver, RightDriver);

  /** Creates a new Drive. */
  public Drive() {
    ConfigureDrive();
  }

  private static void ConfigureDrive () {
    RightDriver.addFollower(RightPassenger);
    LeftDriver.addFollower(LeftPassenger);
  }
  
  public static void Drive (double XSpeed, double Rotation) {
    mDrive.arcadeDrive(XSpeed, Rotation);
  } 

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
