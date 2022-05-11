package ru.kpfu.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.models.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
}

