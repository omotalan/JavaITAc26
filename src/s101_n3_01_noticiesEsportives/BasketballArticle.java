package s101_n3_01_noticiesEsportives;

public class BasketballArticle extends NewsArticle {
    private String tournament, club;
    private final String category = "Basketball";

    public BasketballArticle(String title, String tournament, String club) {
        super(title);
        this.tournament = tournament;
        this.club = club;
        initialize();
    }

    private boolean esGran() { return mention(club, "barça", "barca", "madrid"); }

    @Override
    public double calculatePriceNewsArticle() {
        double price = 250;
        if (igual(tournament, "Eurolliga")) price += 75;
        if (esGran()) price += 75;
        return price;
    }

    @Override
    public int calculatePoints() {
        int points = 4;
        if (igual(tournament, "Eurolliga")) points += 3;
        else if (igual(tournament, "ACB")) points += 2;
        if (esGran()) points += 1;
        return points;
    }
}