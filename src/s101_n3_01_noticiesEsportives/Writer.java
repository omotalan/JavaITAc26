package s101_n3_01_noticiesEsportives;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Writer {
    private static double salary = 1500;

    private final String dni;
    private String name;
    private List<NewsArticle> newsArticles = new ArrayList<>();

    public Writer(String name, String dni) {
        this.name = name;
        this.dni = dni;
    }

    // Getters
    public static double getSalary() { return salary; }
    public String getDni() { return dni; }
    public String getName() { return name; }
    public List<NewsArticle> getNewsArticles() {
        return Collections.unmodifiableList(newsArticles);
    }
    
    // Setters
    public void setName(String name) { this.name = name; }
    public static void setSalary(double newSalary) { salary = newSalary; }

    // Add or delete articles
    public Optional<NewsArticle> searchNewsArticle(String title) {
        return newsArticles.stream()
                .filter(n -> n.getTitle().equalsIgnoreCase(title))
                .findFirst();
    }

    public boolean addNewsArticle(NewsArticle newsArticle) {
        if (searchNewsArticle(newsArticle.getTitle()).isPresent()) return false;
        return newsArticles.add(newsArticle);
    }

    public boolean deleteNewsArticle(String title) {
        return newsArticles.removeIf(n -> n.getTitle().equalsIgnoreCase(title));
    }

}