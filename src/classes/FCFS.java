import java.util.ArrayList;
import java.util.Iterator;

public class FCFS extends Scheduler {
    private static FCFS sched_fcfs = new FCFS();

    public static FCFS getInstance() {
        return sched_fcfs;
    }

    private FCFS() {
        name = "FCFS";
        time = 0;
        computing = null;
        waitQueue = new ArrayList<Process>();
        readyQueue = new ArrayList<Process>();
    }

    public void schedule() throws InterruptedException {
        while (!(waitQueue.isEmpty() && readyQueue.isEmpty() && computing == null)) {
            Iterator<Process> iterator = waitQueue.iterator();
            while (iterator.hasNext()) {
                Process p = iterator.next();
                if (p.ready(time)) {
                    readyQueue.add(p);
                    iterator.remove();
                }
            }
            
            if (computing == null && !readyQueue.isEmpty()) {
                computing = readyQueue.remove(0);
                computeSeq.add(computing.compute());
            }
            else if (computing != null) {
                computeSeq.add(computing.compute());
            }
            
            if (computing.finished()) {
                computing = null;
            }
            time++;
            printBar();
            Thread.sleep(500);
        }
        System.out.print("Computing Sequence (by PID): ");
        for (int i = 0; i < computeSeq.size(); i++) {
            System.out.print(computeSeq.get(i));
        }
        System.out.println();
    }
}