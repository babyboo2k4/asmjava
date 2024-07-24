package assm2;

import java.util.ArrayList;
import java.util.Scanner;


public class Application {
    private static ArticleRepository repository = new MySqlArticleRepository();
    private static ArticleService vnexpressService = new VnExpressArticleService();
    private static ArticleService myService = new MyArticleService();

    public static void main(String[] args) {
        generateMenu();
    }

    public static void generateMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Crawl thông tin từ Vnexpress.");
            System.out.println("2. Crawl thông tin từ nguồn của tôi.");
            System.out.println("3. Hiển thị danh sách tin hiện có.");
            System.out.println("4. Thoát chương trình.");
            System.out.print("Chọn một tùy chọn: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    crawlArticles(vnexpressService);
                    break;
                case 2:
                    crawlArticles(myService);
                    break;
                case 3:
                    displayArticles();
                    break;
                case 4:
                    System.out.println("Thoát chương trình.");
                    return;
                default:
                    System.out.println("Tùy chọn không hợp lệ.");
            }
        }
    }

    private static void crawlArticles(ArticleService service) {

        String url = "https://vnexpress.net/the-thao";
        ArrayList<String> links = service.getLinks(url);
        for (String link : links) {
            Article article = service.getArticle(link);
            repository.save(article);
        }
        System.out.println("Đã crawl xong.");
    }

    private static void displayArticles() {
        ArrayList<Article> articles = repository.findAll();
        for (Article article : articles) {
            System.out.println(article.getId() + ": " + article.getTitle());
        }
        System.out.print("Nhập mã tin để xem chi tiết hoặc 'exit' để thoát: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!input.equals("exit")) {
            try {
                int id = Integer.parseInt(input);
                Article article = repository.findByUrl(Integer.toString(id));
                if (article != article) {
                    System.out.println("Title: " + article.getTitle());
                    System.out.println("Description: " + article.getDescription());
                    System.out.println("Content: " + article.getContent());
                } else {
                    System.out.println("Không tìm thấy tin.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Mã tin không hợp lệ.");
            }
            System.out.print("Nhập mã tin để xem chi tiết hoặc 'exit' để thoát: ");
            input = scanner.nextLine();
        }
    }

}
