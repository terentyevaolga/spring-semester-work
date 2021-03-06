package ru.kpfu.itis.repositories;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.models.Group;

public interface GroupRepository extends JpaRepository<Group, Integer> {

  @EntityGraph(attributePaths = {"users"})
  Group findGroupByName(String name);
}
