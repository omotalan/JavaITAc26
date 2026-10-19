package s101_n3_01_noticiesEsportives;

public class FormulaOneArticle extends NewsArticle {
    private String escuderia;
    private final String category = "Formula One";

    public FormulaOneArticle(String title, String escuderia) {
        super(title);
        this.escuderia = escuderia;
        initialize();
    }

    private boolean esVip() { return mention(escuderia, "ferrari", "mercedes"); }

    @Override
    public double calculatePriceNewsArticle() { return 100 + (esVip() ? 50 : 0); }

    @Override
    public int calculatePoints() { return 4 + (esVip() ? 2 : 0); }
}
