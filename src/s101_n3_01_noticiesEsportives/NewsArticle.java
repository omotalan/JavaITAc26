package s101_n3_01_noticiesEsportives;

public abstract class NewsArticle {
    
    private final String title;
    private String text = "";
    private int points;
    private double price;

    protected NewsArticle(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }
        this.title = title;
    }

    public abstract double calculatePriceNewsArticle();
    public abstract int calculatePoints();

    // After initializing instance, the subclass calculates points and price
    protected final void initialize() {
        this.points = calculatePoints();
        this.price = calculatePriceNewsArticle();
    }

    // Search helpers
    protected static boolean igual(String a, String b) {
        return a != null && a.equalsIgnoreCase(b);
    }

    protected static boolean mention(String font, String... candidates) {
        if (font == null) return false;
        String f = font.toLowerCase();
        for (String c : candidates) {
            if (f.contains(c.toLowerCase())) return true;
        }
        return false;
    }

    // Getters
    public String getTitle()  { return title; }
    public String getText()     { return text; }
    public int getPoints()   { return points; }
    public double getPrice()     { return price; }

    // Setters
    public void setText(String text) { this.text = text; }

}