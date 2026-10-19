package s101_n3_01_noticiesEsportives;

public class TennisArticle extends NewsArticle {
    private String tournament, player;
    private final String category = "Tennis";

    public TennisArticle(String title, String tournament, String player) {
        super(title);
        this.tournament = tournament;
        this.player = player;
        initialize();
    }

    private boolean esVip() { return mention(player, "federer", "nadal", "djokovic"); }

    @Override
    public double calculatePriceNewsArticle() {
        return 150 + (esVip() ? 100 : 0);
    }

    @Override
    public int calculatePoints() {
        return 4 + (esVip() ? 3 : 0);
    }
}
