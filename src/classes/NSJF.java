import java.util.ArrayList;
import java.util.Iterator;

public class NSJF extends Scheduler {
    private static NSJF sched_nsjf = new NSJF();

    public static NSJF getInstance() {
        return sched_nsjf;
    }

    private NSJF() {
        name = "NSJF";
        time = 0;
        computing = null;
        waitQueue = new ArrayList<Process>();
        readyQueue = new ArrayList<Process>();
    }

    public void schedule() throws InterruptedException {
        while (!(waitQueue.isEmpty() && readyQueue.isEmpty() && computing == null)) {
            // Move ready processes from waitQueue to readyQueue
            Iterator<Process> iterator = waitQueue.iterator();
            while (iterator.hasNext()) {
                Process p = iterator.next();
                if (p.ready(time)) {
                    readyQueue.add(p);
                    iterator.remove();
                }
            }
    
            // Sort readyQueue based on remaining CPU time
            readyQueue.sort((p1, p2) -> p1.getTime_r() - p2.getTime_r());
    
            // If no process is currently computing, take the process with shortest remaining time from readyQueue
            if (computing == null && !readyQueue.isEmpty()) {
                computing = readyQueue.remove(0);
            }
    
            // Compute the current process
            if (computing != null) {
                computeSeq.add(computing.compute());
                if (computing.finished()) {
                    computing = null;
                }
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