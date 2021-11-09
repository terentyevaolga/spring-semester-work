package repositories;

import models.Article;
import models.Film;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArticlesRepositoryImpl implements ArticlesRepository {

    private Connection connection;

    private final String INSERT_INTO_ARTICLES = "insert into article(title, description) values(?, ?);";
    private final String FIND_ARTICLE_BY_ID = "select * from \"article\" where id=?;";
    private final String FIND_ARTICLE_ALL = "select * from article";

    public ArticlesRepositoryImpl(Connection connection) {
        this.connection = connection;
    }



    @Override
    public List<Article> findAll() {
        ResultSet resultSet = null;
        List<Article> articles = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ARTICLE_ALL);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Article article = new Article();
                article.setId(resultSet.getInt("id"));
                article.setTitle(resultSet.getString("title"));
                article.setDescription(resultSet.getString("description"));
                articles.add(article);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return articles;
    }

    @Override
    public Article findById(int id) {
        ResultSet resultSet = null;
        Article article;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ARTICLE_BY_ID);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                article = new Article();
                article.setId(resultSet.getInt("id"));
                article.setTitle(resultSet.getString("title"));
                article.setDescription(resultSet.getString("description"));
                return article;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Article save(Article article) {
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(INSERT_INTO_ARTICLES);
            preparedStatement.setString(1, article.getTitle());
            preparedStatement.setString(2, article.getDescription());

            resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                article.setId(resultSet.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return article;
    }
}
