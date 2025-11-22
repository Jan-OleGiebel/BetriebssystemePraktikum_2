import java.util.Random;

public class Printer extends Thread {
    private Spooler spooler;
    private final int ID;

    public Printer(int ID, Spooler spooler) {
        this.spooler = spooler;
        this.ID = ID;
    }

    public void run() {
        var random = new Random();
        while(!isInterrupted()) {
            try {
                var printJob = spooler.getPrintJob();
                System.out.println("[Printer " + this.ID + "] Druckt: " + printJob);
                Thread.sleep(random.nextInt(3000) + 2000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}