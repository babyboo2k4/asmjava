package assm2;

import java.sql.*;
import java.util.ArrayList;

import static java.sql.DriverManager.getConnection;

public class MySqlArticleRepository implements ArticleRepository {
    private Connection connection;

    public MySqlArticleRepository() {
        try {
            connection = getConnection(
                    "jdbc:mysql://localhost:3306/assm2", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<Article> findAll() {
        ArrayList<Article> articles = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM articles");
            while (resultSet.next()) {
                Article article = new Article();

                articles.add(article);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return articles;
    }

    @Override
    public Article findByUrl(String url) {
        Article article = new Article();
        String query = "SELECT * FROM articles WHERE baseUrl = ?";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/assm2", "root", "");
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, url);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Article(
                            rs.getInt("id"),
                            rs.getString("baseUrl"),
                            rs.getString("title"),
                            rs.getString("description"),
                            rs.getString("content"),
                            rs.getString("thumbnail"),
                            rs.getDate("createdAt"),
                            rs.getDate("updatedAt"),
                            rs.getDate("deletedAt"),
                            rs.getInt("status")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return article;
    }

    @Override
    public Article save(Article article) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO (baseUrl, title, description, content, thumbnail, createdAt, updatedAt, deletedAt, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.executeUpdate();
            ResultSet keys = preparedStatement.getGeneratedKeys();
            if (keys.next()) {
                article.setId(keys.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return article;
    }

    @Override
    public Article update(Article article) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE articles SET title = ?,description = ?, content = ?,thumbnail = ?,updatedAt = ?,deletedAt = ?,status = ? WHERE id = ?");
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return article;
    }

    @Override
    public void deleteByUrl(String url) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM articles WHERE baseUrl = ?");
            preparedStatement.setString(1, url);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
