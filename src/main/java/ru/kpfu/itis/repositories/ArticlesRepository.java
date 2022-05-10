package ru.kpfu.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.kpfu.itis.models.Article;

import java.util.List;

public interface ArticlesRepository extends JpaRepository<Article, Integer> {

  List<Article> findArticleByGroupName(String groupName);

  @Query(
      value = "select * from article where group_id = (select gu.group_id from group_user"
              + " gu where gu.user_id = (select us.name from users us where name = :name))",
      nativeQuery = true)
  List<Article> findArticleByUser(@Param("name") String name);
}
