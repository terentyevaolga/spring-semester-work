package forms;

public class SendReviewForm {
    private String name;
    private String email;
    private String reviewText;

    public SendReviewForm() {
    }

    public SendReviewForm(String name, String email, String reviewText) {
        this.name = name;
        this.email = email;
        this.reviewText = reviewText;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", reviewText='" + reviewText + '\'' +
                '}';
    }
}
