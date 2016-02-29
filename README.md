This project aims to implement a priority queue and use it to schedule real time processes

dHeap.java
implements a tree-based data structure that satisfies the heap property

dHeapInterface.java
specifies the methods that dHeap class should implement

dHeapTester.java
implements JUnit test cases for dHeap class

MyPriorityQueue.java
implements a data structure(adapted from dHeap), where the elements of the priority queue are ordered according to their natural ordering

Record.java
implements a Record object that represent the schedule

EDF.java
processes schedules by reading input from a txt file
Users should provide the complete path of the txt file through the command line argument 


Input instruction:
The input file will have lines of two forms:
"schedule process deadline duration"
or
"run time".
schedule:
schedule is a preset word that indicates that a new process is a about to start.
process is an arbitrary string. Will be used to indicate the name of the process (lunch, work, play etc)
deadline is a deadline of the process, represents time
duration  is the length of the process, represents time
run:
run is also a present word and indicates that you are ready to run the processes. 
Time  represents a time frame


Sample input 1:
schedule breakfast 1000 45
schedule study 1400 280
schedule dinner 1725 30
run 350

Sample output 1:
0: adding breakfast with deadline 1000 and duration 45
0: adding study with deadline 1400 and duration 280
0: adding dinner with deadline 1725 and duration 30
0: busy with breakfast with deadline 1000 and duration 45
45: done with breakfast
45: busy with study with deadline 1400 and duration 280
325: done with study
325: busy with dinner with deadline 1725 and duration 30
350: adding dinner with deadline 1725 and duration 5


Sample input 2:
schedule sleep 70 95
schedule coffee 80 20
run 70
schedule facebook 90 35
run 100

Sample output 2:
0: adding sleep with deadline 70 and duration 95
0: adding coffee with deadline 80 and duration 20
0: busy with sleep with deadline 70 and duration 95
70: adding sleep with deadline 70 and duration 25
70: adding facebook with deadline 90 and duration 35
70: busy with sleep with deadline 70 and duration 25
95: done with sleep (late)
95: busy with coffee with deadline 80 and duration 20
100: adding coffee with deadline 80 and duration 15
