import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;

public class BookScraper {
    public static void main(String[] args) {
        String url = "http://books.toscrape.com/";
        String fileName = "books.csv";

        try {
            // Fetch HTML from the site
            Document doc = Jsoup.connect(url).get();

            // Select all product containers
            Elements books = doc.select(".product_pod");

            // Set up CSV writer
            FileWriter csvWriter = new FileWriter(fileName);
            csvWriter.append("Title,Price,Rating\n");

            for (Element book : books) {
                String title = book.select("h3 a").attr("title");
                String price = book.select(".price_color").text();
                String ratingClass = book.select(".star-rating").first().className(); // e.g., "star-rating Three"
                String rating = ratingClass.replace("star-rating", "").trim(); // Extract "Three"

                // Write to CSV
                csvWriter.append(title).append(",")
                         .append(price).append(",")
                         .append(rating).append("\n");
            }

            csvWriter.flush();
            csvWriter.close();
            System.out.println("✅ Data saved to books.csv");

        } catch (IOException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
}
