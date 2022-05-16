package ru.kpfu.itis.forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FilmForm {

  private String name;
  private String trailer;
  private String rating;
  private String year;
  private String director;
  private String description;
  private MultipartFile icon;
}
