public class PrintJob {
    private final String title;
    private final int numberOfPages;

    public PrintJob(String title, int numberOfPages) {
        this.title = title;
        this.numberOfPages = numberOfPages;
    }

    public String getTitle() {
        return title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public String toString() {
        return title + ", " + numberOfPages + " Seiten";
    }
}