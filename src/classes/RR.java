import java.util.Iterator;

public class RR extends Scheduler{
    private static RR sched_rdrb = new RR();

    public static RR getInstance() {
        return sched_rdrb;
    }

    private RR() {
        name = "RdRb";
        time = 0;
    }

    public void schedule() throws InterruptedException {
        while (!(waitQueue.isEmpty() && readyQueue.isEmpty())) {
            // Move ready processes from waitQueue to readyQueue
            Iterator<Process> iterator = waitQueue.iterator();
            while (iterator.hasNext()) {
                Process p = iterator.next();
                if (p.ready(time)) {
                    readyQueue.add(p);
                    iterator.remove();
                }
            }

            if (!readyQueue.isEmpty()) {
                computeSeq.add(readyQueue.get(0).compute());
                if (!(readyQueue.get(0).finished())) {
                    readyQueue.add(readyQueue.get(0));
                }
                readyQueue.remove(0);
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
