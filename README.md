ViewHolder Performance Testing
==============================

The goal is to test the performance of the ViewHolder pattern in the following scenarios: 
 1. Worst possible implementation; Always inflate the layout
 2. Good implementation; Reuse the `convertView` when not null
 3. Best implementation; Use the ViewHolder pattern

## Build Configurations ##
Three build flavors are used which contain the different `Adapter` implementations:
 1. `Baddoge` - Always inflates the row layout
 2. `Gooddoge` - Recycles the view if `convertView` is not null
 3. `Bestdoge` - Uses the ViewHolder pattern. 

The two default built types are used:
 1. `Debug` - Contains `Debug.start/endTrace` call in `getView()` to generate the Trace file
 2. `Release` - No Tracing, what should be used if you want to run the `monkey` script to capture the `fps` of the ListView.

The test app is a ListFragment that contains 10,000 row items. The row item view
contains seven total views.

## Build and Run ##
`./gradlew tasks` to see what `assemble` and `install` tasks are available

Results
=======

## Test Description ##
All tests were performed on the a Galaxy S4 API Level 17 emulator using Genymotion.
Each adapter implementation was profiled with Traceview. The Traceview files
can be found in the `traces` folder. In addition to profiling with Traceview, a
`monkey` script was used to calculate the frames per second of the ListView. The
monkey script was ran 25 times for each adapter implementation which in turn was
used to calculate an average fps.

## Test Results ##
Results of running the test on a Galaxy S4 API Level 17 Genymotion emulator.

|                    | Bad    | Good   | Best   |
| ----------------   |:------:|:------:|:------:|
| **Average FPS**    | 46.455 | 47.145 | 49.501 |
| **Real Time/Call** | 8.328  | 0.832  | 0.715  |
_*Real Time/Call in milliseconds_

