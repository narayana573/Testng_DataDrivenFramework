---

### 📱 Android Debug Bridge (ADB) Command Reference

| ADB Command | Short Description |
| --- | --- |
| **Server Management** |  |
| `adb start-server` | Starts the ADB server process on the host machine. |
| `adb kill-server` | Terminates the ADB server process to reset connections. |
| `adb devices` | Lists all connected physical devices and emulators. |
| **Application Management** |  |
| `adb install <path_to_apk>` | Installs a new application on the device. |
| `adb install -r <path_to_apk>` | Re-installs/updates an app while keeping its existing data. |
| `adb -s <serial> install <apk>` | Installs an app on a specific device (used for multi-device setups). |
| `adb uninstall <package_name>` | Removes the specified application from the device. |
| **Logs & Diagnostics** |  |
| `adb logcat` | Prints real-time device logs to the console. |
| `adb logcat -d > [file_path]` | Dumps the current log buffer to a local file and exits. |
| `adb logcat -c` | Clears (flushes) the entire log buffer on the device. |
| `adb logcat <package>:<priority>` | Filters logs by specific package and priority (V, D, I, W, E, F, S). |
| `adb bugreport > [file_path]` | Generates a comprehensive zip of device state, logs, and dumpsys. |
| **File Operations** |  |
| `adb pull <remote> <local>` | Copies a file or directory from the device to the local machine. |
| `adb push <local> <remote>` | Copies a file or directory from the local machine to the device. |
| **Screen Capture** |  |
| `adb shell screencap -p <path>` | Takes a screenshot and saves it to the specified device path. |
| `adb shell screenrecord <path>` | Records the device screen (stop with `Ctrl+C`). |
| **Stress Testing** |  |
| `adb shell monkey -p <pkg> -v <N>` | Generates `N` random user events for stress testing an app. |
| `adb shell monkey ... -s <seed>` | Uses a specific seed to reproduce a previous random monkey test. |
| **System Interaction** |  |
| `adb shell` | Opens an interactive Linux command-line shell on the device. |
| `adb reboot` | Restarts the connected device. |
| `adb forward <local> <remote>` | Forwards socket connections from a host port to a device port. |

---
