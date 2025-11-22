import java.util.ArrayList;

public class Spooler {
    private final int SIZE = 5;
    private ArrayList<PrintJob> spoolerList;

    public Spooler() {
        spoolerList = new ArrayList<>(SIZE);
    }

    public void addPrintJob(PrintJob printJob) throws InterruptedException {
        synchronized (this) {
            while(spoolerList.size() >= SIZE) {
                wait();
            }

            spoolerList.add(printJob);
            notifyAll();
        }
    }

    public PrintJob getPrintJob() throws InterruptedException {
        synchronized (this) {
            while(spoolerList.size() <= 0) {
                wait();
            }

            notifyAll();
            return spoolerList.removeFirst();
        }
    }

    public int getSize() {
        return spoolerList.size();
    }

    public int getMaxSize() {
        return SIZE;
    }
}