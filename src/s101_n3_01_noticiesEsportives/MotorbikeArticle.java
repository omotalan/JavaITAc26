package s101_n3_01_noticiesEsportives;

public class MotorbikeArticle extends NewsArticle {
    private String team;
    private final String category = "Motorbike Racing";

    public MotorbikeArticle(String title, String team) {
        super(title);
        this.team = team;
        initialize();
    }

    private boolean esVip() { return mention(team, "honda", "yamaha"); }

    @Override
    public double calculatePriceNewsArticle() { return 100 + (esVip() ? 50 : 0); }

    @Override
    public int calculatePoints() { return 3 + (esVip() ? 3 : 0); }
}