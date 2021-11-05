package repositories;

import models.Film;
import models.Serial;

import java.util.List;
import java.util.Optional;

public interface SerialsRepository {
    List<Serial> findAll();
    Optional<Serial> findById(Long id);
    Serial save(Serial serial);
    void deleteById(Long id);
    Serial findByName(String name);
}
