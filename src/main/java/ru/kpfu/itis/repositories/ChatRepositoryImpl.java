package ru.kpfu.itis.repositories;

import java.util.List;
import javax.persistence.EntityManager;

import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.models.Message;

@Repository
@AllArgsConstructor
public class ChatRepositoryImpl implements ChatRepository {

  private final EntityManager entityManager;

  @Override
  public Message save(Message message) {
    entityManager.getTransaction().begin();
    entityManager.persist(message);
    Message retMessage = entityManager.createQuery(
            "select m from Message m where m.from = :from and m.date =:date and m.text =:text and m.group = :group",
            Message.class
        )
        .setParameter("from", message.getFrom())
        .setParameter("date", message.getDate())
        .setParameter("text", message.getText())
        .setParameter("group", message.getGroup())
        .getSingleResult();
    entityManager.getTransaction().commit();
    return retMessage;
  }

  /** spring data не поддерживает limit и даже через query сделать нельзя
   * Единственный адекватный способ - передавать в аргумент метода pageable (пагинация), но для бизнес
   * логики плохо зависеть от каких либо специфичных реализаций spring, поэтому решено сделать
   * метод через entityManager
   */
  @Override
  public List<Message> getLastMessages(String group, Integer limit) {
    Session session = entityManager.unwrap(Session.class);
    session.getTransaction().begin();
    List<Message> messages = session.createQuery("select m from Message m order by m.date", Message.class)
        .setMaxResults(limit)
        .getResultList();
    session.setReadOnly(messages, true);
    session.getTransaction().commit();
    return messages;
  }
}
