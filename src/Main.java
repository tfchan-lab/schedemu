import java.util.Scanner;

public class Main {
    public static void usage() {
        System.out.println("Usage:");
        System.out.println("schedemu ? | Displays this message");
        System.out.println("schedemu <Scheduler> <Processes>... | Visualize scheduling with chosen scheduler and user-defined processes");
        System.out.println("Schedulers available: FCFS, SRTF, NSJF, RdRb");
        System.out.println("Example: schedemu RdRb 0,20 2,2 4,2");
        System.exit(0);
    }
    public static void main(String[] args) throws InterruptedException {
        if (args.length >= 1) {
            if (args[0].equals("?")) {
                usage();
            }
            else if (args.length >= 2) {
                Scheduler sched = new Scheduler();
                if (args[0].equals("FCFS")) {
                    sched = FCFS.getInstance();
                }
                else if (args[0].equals("SRTF")) {
                    sched = SRTF.getInstance();
                }
                else if (args[0].equals("NSJF")) {
                    sched = NSJF.getInstance();
                }
                else if (args[0].equals("RdRb")) {
                    sched = RR.getInstance();
                }
                else {
                    System.out.println("[ERROR] Unknown Scheduler\nSchedulers available: FCFS, SRTF, NSJF, RdRb");
                    System.exit(0);
                }
                for (int i = 1; i < args.length; i++) {
                    Scanner sc = new Scanner(args[i]);
                    sc.useDelimiter(",");
                    sched.addProcess(new Process(i - 1, sc.nextInt(), sc.nextInt()));
                    sc.close();
                }
                sched.schedule();
            }
        }
        else {
            usage();
        }
    }
}