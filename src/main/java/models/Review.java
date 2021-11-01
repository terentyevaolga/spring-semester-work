package models;

public class Review {
    private Long id;
    private String userName;
    private String userEmail;
    private String userReviewText;

    public Long getId() { return id;}
    public void setId(Long id) { this.id = id; }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserReviewText() {
        return userReviewText;
    }

    public void setUserReviewText(String userReviewText) {
        this.userReviewText = userReviewText;
    }
}
