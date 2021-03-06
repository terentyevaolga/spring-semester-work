package ru.kpfu.itis.mapper;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class EntityMapper {

  public static <T> T map(Object model, Class<T> dtoClass) {
    Field[] modelFields = model.getClass().getDeclaredFields();
    T dto;
    try {
      dto = dtoClass.getConstructor().newInstance();
      for (Field field : modelFields) {
        Field dtoField;
        try {
          dtoField = dtoClass.getDeclaredField(field.getName());
        }
        catch (NoSuchFieldException e) {
          continue;
        }
        String name = field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
        Object value = model.getClass()
            .getMethod("get" + name)
            .invoke(model);
        dto.getClass().getMethod("set" + name, dtoField.getType()).invoke(dto, value);
      }
    }
    catch (InstantiationException | NoSuchMethodException | InvocationTargetException
        | IllegalAccessException e) {
      throw new RuntimeException(e);
    }
    return dto;
  }
}
