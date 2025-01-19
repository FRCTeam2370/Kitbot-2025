// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.pathplanner.lib.auto.AutoBuilder;

import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.math.kinematics.DifferentialDriveWheelSpeeds;
import edu.wpi.first.math.kinematics.Kinematics;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drive extends SubsystemBase {
  public static WPI_TalonSRX RightDriver = new WPI_TalonSRX(0);
  public static WPI_TalonSRX RightPassenger = new WPI_TalonSRX(1);
  public static WPI_TalonSRX LeftDriver = new WPI_TalonSRX(2);
  public static WPI_TalonSRX LeftPassenger = new WPI_TalonSRX(3);

  private static DifferentialDrive mDrive = new DifferentialDrive(LeftDriver, RightDriver);

  /** Creates a new Drive. */
  public Drive() {
    ConfigureDrive();
  }

  DifferentialDriveKinematics kinematics = new DifferentialDriveKinematics(Units.inchesToMeters(27.0)); 

  ChassisSpeeds chassisSpeeds = new ChassisSpeeds(2.0, 0, 1.0);

  DifferentialDriveWheelSpeeds wheelSpeeds = kinematics.toWheelSpeeds(chassisSpeeds);

  double leftVeocity = wheelSpeeds.leftMetersPerSecond;

  double rightVelocity = wheelSpeeds.rightMetersPerSecond;


  private static void ConfigureDrive () {
    RightPassenger.follow(RightDriver);
    LeftPassenger.follow(LeftDriver);
    LeftDriver.setInverted(true);
    LeftPassenger.setInverted(true);
  }
  
  public static void drive (double XSpeed, double Rotation) {
    mDrive.arcadeDrive(XSpeed, Rotation);
  } 

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
