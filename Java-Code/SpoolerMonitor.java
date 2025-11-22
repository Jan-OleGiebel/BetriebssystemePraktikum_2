public class SpoolerMonitor extends Thread {
    private Spooler spooler;

    public SpoolerMonitor(Spooler spooler) {
        this.spooler = spooler;
    }

    public void run() {
        while(!isInterrupted()) {
            try {
                System.out.println("[SpoolerMonitor] Warteschlange: " + spooler.getSize() + "/" + spooler.getMaxSize());
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}