package ru.kpfu.itis.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SendReviewForm {
    private String phone;
    private String reviewText;
}
