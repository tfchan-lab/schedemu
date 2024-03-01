public class Process {
    public int id;
    private int time_a; // Arrival Time
    private int time_r; // Remaining CPU Time
    private int time_i; // Initial CPU Time

    public Process() {}
    public Process(int id, int time_a, int time_i) {
        this.id = id;
        this.time_a = time_a;
        this.time_r = time_i;
        this.time_i = time_i;
    }

    public boolean ready(int time) {
        return time >= time_a;
    }

    public boolean finished() {
        return time_r == 0;
    }

    public int getTime_a() {
        return time_a;
    }

    public int getTime_r() {
        return time_r;
    }

    public int compute() {
        if (!finished()) {
            time_r--;
        }
        return id;
    }

    public int progress() {
        return (int) ((1 - ((double) time_r / time_i)) * 100);
    }

    public static void getBar(Process p) {
        System.out.printf("Process %d: |%-20s|%d%%%n",
            p.id, 
            new String(new char[(int)Math.floor(p.progress() * 20 / 100)]).replace('\0', '■'),
            p.progress()
        );
    }
}