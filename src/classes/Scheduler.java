import java.util.ArrayList;

public class Scheduler {
    protected String name;
    protected int time;
    protected Process computing;
    protected ArrayList<Process> waitQueue;
    protected ArrayList<Process> readyQueue;
    protected ArrayList<Process> initQueue; // Used for progress bar
    protected ArrayList<Integer> computeSeq;

    public Scheduler() {
        waitQueue = new ArrayList<Process>();
        readyQueue = new ArrayList<Process>();
        initQueue = new ArrayList<Process>();
        computeSeq = new ArrayList<Integer>();
    }

    public String getName() {
        return name;
    }

    public void addProcess(Process p) {
        waitQueue.add(p);
        initQueue.add(p);
    }

    public void schedule() throws InterruptedException {}

    public void printBar() {
        // Clear the console
        System.out.print("\033[H\033[2J");
        System.out.flush();
        
        System.out.println("Visualizing " + name + " (2 ticks per second)");

        // Print each progress bar
        for (int i = 0; i < initQueue.size(); i++) {
            Process.getBar(initQueue.get(i));
        }
    }
}
