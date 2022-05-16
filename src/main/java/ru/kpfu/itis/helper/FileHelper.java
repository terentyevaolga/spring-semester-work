package ru.kpfu.itis.helper;

import lombok.extern.java.Log;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.UUID;

@Log
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
      log.info(String.valueOf(file[0]));
      stream.write(file);
      stream.flush();
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
