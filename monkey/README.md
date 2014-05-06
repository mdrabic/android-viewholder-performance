# Pre-reqs for the Monkey script #
To capture the FPS data, you need to run the following ADB command `adb shell setprop "viewancestor.profile_rendering" "true"`.
This will force the currently focused window to render at 60 Hz. You will need root for the setprop command
to work. Run `adb shell getprop "viewancestor.profile_rendering"` to verify that it has been set.

# Setup #
 1. Change the package name in `script.txt` to the package name for whatever build you built. See
    the `build.gradle` for the possible package names. Current names include:
    * com.mdrabic.viewholderperformance.app.bad      (release)
    * com.mdrabic.viewholderperformance.app.bad.test (debug)
    * com.mdrabic.viewholderperformance.app.good
    * com.mdrabic.viewholderperformance.app.good.test
    * com.mdrabic.viewholderperformance.app.best
    * com.mdrabic.viewholderperformance.app.best.test
 1. Push the script to the device, `/sdcard` is a good spot.

# Run #
`adb shell monkey -p <package name> -v -f /sdcard/script.txt <count>`

`adb shell monkey -p com.mdrabic.viewholderperformance.app.bad -v -f /sdcard/script.txt 3` will execute the
script 3 times.

