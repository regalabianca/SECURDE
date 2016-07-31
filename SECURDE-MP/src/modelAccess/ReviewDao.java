package modelAccess;

import java.util.ArrayList;

import models.Review;

public interface ReviewDao {
	public boolean addTransaction (Review review);
	public Review getReview (int reviewId);
	public ArrayList<Review> getReviews (int productId);
	public void updateReview (Review review);
	public void deleteReview (int reviewId);
}
