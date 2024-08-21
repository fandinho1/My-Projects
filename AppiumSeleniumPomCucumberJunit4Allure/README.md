# Configuration

Get appium, appium inspector and other relevant here https://github.com/appium

#Verify the device is recognized

adb devices

# Get device properties

adb -s <device_name> shell getprop

# Get App package and App activity using ADB command

List of all installed packages:
adb shell pm list packages -f

Main activity of an specific package:
adb shell dumpsys package <package_name>

# Run automation

gradlew clean test

# Run automation of an specific device

gradlew clean test -DdeviceName=emulator-5556
