import java.io.*;

/**
 * The EDF class read txt file 
 * and process the schedule according to user's command
 * 
 * @author Yifan He
 * @version 1.0
 * @since 02-14-2016
 */

public class EDF {
    
    public static final int INITIAL_SIZE = 10;

    /**
     * the driver for the EDF class
     * 
     * @param args
     *            the complete path of the txt file to be read
     */
    
    
    public static void main(String[] args) {
        
        // the line to read
        String line;
        // to read the input from file
        BufferedReader inputStrem = null;

        String command;
        String process;
        long deadline;
        long duration;

        long time;

        // check input validity
        if (args.length != 1) {
            System.err.println("Incorrect number of arguments: " + args.length);
            System.err.println("java hw6.EDF <input-file>");
            System.exit(1);
        }

        File file = new File(args[0]);
        MyPriorityQueue<Record> queue = 
                new MyPriorityQueue<Record>(INITIAL_SIZE);
        long current_time = 0;

        // try opening file
        try {
            inputStrem = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            System.err.println("Failed to open " + file);
            System.exit(1);
        }

        // try reading the file line by line
        try {
            while ((line = inputStrem.readLine()) != null) {
                String[] arguments = line.split(" ");
                command = arguments[0];

                // adding schedule
                if (command.equals("schedule")) {
                    process = arguments[1];
                    deadline = Long.parseLong(arguments[2]);
                    duration = Long.parseLong(arguments[3]);
                    Record adding = new Record(process, deadline, duration);
                    queue.add(adding);
                    System.out.println(current_time 
                            + ": adding " + adding.toString());

                    // running
                } else if (command.equals("run")) {

                    // total time to run
                    time = Long.parseLong(arguments[1]) - current_time;

                    // while there is still time
                    while (time > 0) {

                        // work on/remove the task
                        Record doing = queue.poll();
                        // stop if no task anymore
                        if (doing==null) {
                            break;
                        }
                        System.out.println
                        (current_time + ": busy with " + doing.toString());
                        // subtract duration from remaining time
                        time -= doing.GetDuration();

                        // time up but task not done yet. add the record back to
                        // queue
                        if (time < 0) {
                            // add back the overdrawn time
                            current_time += (doing.GetDuration() + time);
                            // add back the remaining part of the task
                            doing = new Record(doing, -time);
                            queue.add(doing);
                            // clear remaining time
                            time = 0;
                            System.out.println
                            (current_time + ": adding " + doing.toString());

                            // task done
                        } else {
                            // proceed along timeline
                            current_time += doing.GetDuration();
                            System.out.println
                            (current_time + ": done with " 
                            + doing.toString(current_time));
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
