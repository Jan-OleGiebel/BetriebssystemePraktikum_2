public class main {
    public static void main(String[] args) {
        var spooler = new Spooler();
        var spoolerMonitor = new SpoolerMonitor(spooler);

        var printJobGenerator0 = new PrintJobGenerator(0, spooler);
        var printJobGenerator1 = new PrintJobGenerator(1, spooler);
        var printJobGenerator2 = new PrintJobGenerator(2, spooler);

        var printer0 = new Printer(0, spooler);
        var printer1 = new Printer(1, spooler);
        var printer2 = new Printer(2, spooler);

        spoolerMonitor.start();

        printJobGenerator0.start();
        printJobGenerator1.start();
        printJobGenerator2.start();

        printer0.start();
        printer1.start();
        printer2.start();

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        printJobGenerator0.interrupt();
        printJobGenerator1.interrupt();
        printJobGenerator2.interrupt();

        printer0.interrupt();
        printer1.interrupt();
        printer2.interrupt();

        spoolerMonitor.interrupt();
    }
}