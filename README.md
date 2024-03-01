# SchedEmu
SchedEmu is a simple commandline visualizer of basic CPU schedulers.

## Introduction
This repository contains a simple, lightweight command-line visualizer of basic CPU schedulers. I made this visualizer to put my knowledge from OOP and OS courses into practice.

## Installation
To get started with SchedEmu, you can choose one of the following methods:

1. **Download the latest release**: You can download the latest release from [release](https://github.com/tfchan-lab/schedemu/releases/).
2. **Compile from source**: If you prefer, you can also compile the program from source using the latest JDK.

Please note that it may not work in OSes other than Windows 8/10/11, as I have not imported an external library for the progress bar.

## Usage
Here are some of the commands you can use with SchedEmu:

- `schedemu ?` - Displays this message.
- `schedemu <Scheduler> <Processes>...` - Visualize scheduling with chosen scheduler and user-defined processes.

These are the schedulers currently implemented: 
- `FCFS`(First-Come-First-Serve)
- `SRTF`(Shortest-Remaining-Time-First)
- `NSJF`(Nonpreemptive-Shortest-Job-First)
- `RdRb`(Round-Robin).

Example parameters: `schedemu RdRb 0,20 2,2 4,2`

The above command will define 3 processes:
- `PID0` which arrives at time 0 and requires 20 time units to finish execution
- `PID1` which arrives at time 2 and requires 2 time units to finish execution
- `PID2` which arrives at time 2 and requires 2 time units to finish execution

The visualizer will show how these 3 processes are scheduled by RdRb scheduler.
