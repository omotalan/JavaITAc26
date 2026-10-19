package s101_n3_01_noticiesEsportives;

public class FootballArticle extends NewsArticle {
    private String tournament, club, player;
    private final String category = "Football";

    public FootballArticle(String title, String tournament, String club, String player) {
        super(title);
        this.tournament = tournament;
        this.club = club;
        this.player = player;
        initialize();
    }

    private boolean esGran() { return mention(club, "barça", "barca", "madrid", "barcelona", "real madrid"); }
    private boolean esEstrella() { return mention(player, "ferran torres", "benzema"); }

    @Override
    public double calculatePriceNewsArticle() {
        double price = 300;
        if (igual(tournament, "Lliga de Campions")) price += 100;
        if (esGran()) price += 100;
        if (esEstrella()) price += 50;
        return price;
    }

    @Override
    public int calculatePoints() {
        int points = 5;
        if (igual(tournament, "Lliga de Campions")) points += 3;
        else if (igual(tournament, "Lliga")) points += 2;
        if (esGran()) points += 1;
        if (esEstrella()) points += 1;
        return points;
    }
}