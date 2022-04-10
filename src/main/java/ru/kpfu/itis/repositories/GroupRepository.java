package ru.kpfu.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.models.Message;

public interface GroupRepository extends JpaRepository<Message, Integer> {
}
