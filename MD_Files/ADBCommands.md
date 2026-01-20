This is a great collection of commands. For an interview, being able to categorize these commands shows that you understand the **ADB Architecture** (Client, Server, and Daemon).

Here is your list organized into a clean, interview-ready Markdown format.

---

# 📱 Essential ADB Commands Cheat Sheet

The **Android Debug Bridge (ADB)** is a versatile command-line tool that lets you communicate with a device. It facilitates a variety of device actions, such as installing and debugging apps.

## 1. Server & Connectivity Management

These commands are used to troubleshoot connection issues or initialize the bridge.

| Command | Description |
| --- | --- |
| `adb start-server` | Starts the adb helper process on the host machine. |
| `adb kill-server` | Terminstes the adb server process. Useful if ADB is hung. |
| `adb devices` | Lists all attached emulators/devices and their serial numbers. |
| `adb connect [ip_address]` | Connects to a device over Wi-Fi (requires TCP/IP mode). |

---

## 2. Application Management

Commonly used by QA and Developers to test installation flows and updates.

* **Install an app:** `adb install path/to/app.apk`
* **Re-install/Update (Keep Data):**
`adb install -r com.myapp.package`
> **Interview Note:** The `-r` flag is crucial for testing **migration paths** and ensuring database schemas persist during an update.


* **Install on a specific device:**
`adb -s [device_serial] install com.myapp.package`
* **Uninstall an app:**
`adb uninstall com.myapp.package`
* **Batch Install (All connected devices):**
`adb devices | tail -n +2 | cut -sf 1 | xargs -IX adb -s X install -r com.myapp.package`

---

## 3. Logs & Diagnostics

Essential for root-cause analysis of crashes or ANRs (App Not Responding).

* **View Live Logs:**
`adb logcat`
* **Save Logs to File:**
`adb logcat -d > crash_log.txt`
* **Clear Log Buffer:**
`adb logcat -c` (Always do this before starting a fresh test to remove old noise).
* **Filter by Priority:**
`adb logcat *:E` (Shows only **Error** level logs).
`adb logcat com.myapp:D` (Shows **Debug** level for a specific package).
* **Generate Full Bug Report:**
`adb bugreport > bugreport.zip`
> **Interview Note:** A bug report contains `dumpsys`, `dumpstate`, and `logcat` data, providing a holistic view of the device state.



---

## 4. File & Media Operations

Used for moving test data or capturing evidence of UI bugs.

### File Transfer

* **Pull (Device to PC):** `adb pull /sdcard/video.mp4 ./local_folder`
* **Push (PC to Device):** `adb push image.png /sdcard/Pictures`

### Screen Capture

* **Screenshot:**
`adb shell screencap -p /sdcard/screen.png`
* **Screen Recording:**
`adb shell screenrecord /sdcard/demo.mp4`
*(Press `Ctrl+C` to stop recording).*

---

## 5. Stress Testing (Monkey Tool)

The Monkey tool sends a pseudo-random stream of user events (clicks, gestures) to the system.

* **Run Monkey Test:**
`adb shell monkey -p com.myapp.package -v 10000 -s 100`
* `-p`: Package to test.
* `-v`: Number of events (10,000).
* `-s`: **Seed value**.


> **Interview Note:** Mentioning the **Seed (-s)** is vital. It allows you to **reproduce** the exact same random sequence if a crash occurs.



---
