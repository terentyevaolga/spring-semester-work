package forms;

public class SendReviewForm {
    private String phone;
    private String reviewText;

    public SendReviewForm() {
    }

    public SendReviewForm(String phone, String reviewText) {
        this.phone = phone;
        this.reviewText = reviewText;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    @Override
    public String toString() {
        return "SendReviewForm{" +
                "phone='" + phone + '\'' +
                ", reviewText='" + reviewText + '\'' +
                '}';
    }
}
