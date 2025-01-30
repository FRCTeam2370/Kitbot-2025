// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix6.hardware.Pigeon2;
import com.pathplanner.lib.auto.AutoBuilder;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.math.kinematics.DifferentialDriveWheelSpeeds;
import edu.wpi.first.math.kinematics.Kinematics;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.Encoder;
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
  public static Pigeon2 mPigeoon = new Pigeon2(1);
  public static Encoder leftEncoder = new Encoder(0, (Integer) null);
  public static Encoder rightEncoder = new Encoder(1, (Integer) null);
  private static Pose2d pose2d = new Pose2d();

  DifferentialDriveOdometry m_Odometry = new DifferentialDriveOdometry(mPigeoon.getRotation2d(), rightEncoder.getDistance(), leftEncoder.getDistance(), new Pose2d(0,0, new Rotation2d()));

  DifferentialDriveKinematics mkinematics = new DifferentialDriveKinematics(Units.inchesToMeters(24));

  DifferentialDriveWheelSpeeds wheelSpeeds = new DifferentialDriveWheelSpeeds(2.0,2.0);

  ChassisSpeeds chassisSpeeds = mkinematics.toChassisSpeeds(wheelSpeeds);

  double linearVelocity = chassisSpeeds.vxMetersPerSecond;

  double angularVelocity = chassisSpeeds.omegaRadiansPerSecond;

  /** Creates a new Drive. */
  public Drive() {
    ConfigureDrive();
  }

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
    var gyroAngle = mPigeoon.getRotation2d();
    pose2d = m_Odometry.update(gyroAngle, leftEncoder.getDistance(), rightEncoder.getDistance());
  }
}
