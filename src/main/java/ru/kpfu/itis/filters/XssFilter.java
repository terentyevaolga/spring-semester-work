package ru.kpfu.itis.filters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.text.StringEscapeUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class XssFilter extends OncePerRequestFilter {

  @Override
  protected void doFilterInternal(HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse, FilterChain filterChain)
      throws ServletException, IOException {
    Map<String, String[]> parameters = httpServletRequest.getParameterMap();
    for (Map.Entry<String, String[]> entry: parameters.entrySet()) {
      List<String> array = new ArrayList<>(entry.getValue().length);
      for (String value: entry.getValue()) {
        if (value == null) {
          continue;
        }
        value = value.replaceAll("'", "''");
        value = StringEscapeUtils.escapeJava(value);
        value = StringEscapeUtils.escapeHtml4(value);
        value = StringEscapeUtils.escapeEcmaScript(value);
        array.add(value);
      }
      parameters.put(entry.getKey(), array.toArray(String[]::new));
    }
    filterChain.doFilter(httpServletRequest, httpServletResponse);
  }
}
