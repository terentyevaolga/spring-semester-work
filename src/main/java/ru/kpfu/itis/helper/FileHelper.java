package ru.kpfu.itis.helper;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.UUID;

public class FileHelper {

  private final String sharingPath;
  private final Path location;


  public FileHelper(String sharingPath, Path location) {
    this.sharingPath = sharingPath;
    if (!Files.exists(location)) {
      try {
        Files.createDirectories(location);
      }
      catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
    this.location = location;
  }

  public String saveFile(byte[] file) throws IOException {
    String fileName = UUID.randomUUID().toString();
    try (OutputStream stream = Files.newOutputStream(location.resolve(fileName))) {
      stream.write(file);
    }
    return fileName;
  }

  public Optional<String> getFilePath(String fileName) {
    if (Files.exists(location.resolve(fileName))) {
      return Optional.of(sharingPath + "/" + fileName);
    }
    return Optional.empty();
  }
}
