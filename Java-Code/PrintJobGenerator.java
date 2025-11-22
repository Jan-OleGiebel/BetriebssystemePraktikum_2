import java.util.Random;

public class PrintJobGenerator extends Thread {
    private Spooler spooler;
    private final int ID;

    public PrintJobGenerator(int ID, Spooler spooler) {
        this.spooler = spooler;
        this.ID = ID;
    }

    public void run() {
        var random = new Random();
        while(!isInterrupted()) {
            try {
                int printJobID = random.nextInt(100) + 1;
                int numberOfPages = random.nextInt(30) + 1;
                var printJob = new PrintJob("Dokument-" + printJobID+".txt", numberOfPages);

                System.out.println("[PrintJobGenerator " + this.ID + "] Fügt hinzu: " + printJob);
                spooler.addPrintJob(printJob);
                Thread.sleep(random.nextInt(3000) + 500);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}