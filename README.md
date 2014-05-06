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

## Build and Run ##
`./gradlew tasks` to see what `assemble` and `install` tasks are available
