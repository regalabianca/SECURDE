package modelAccessImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.DBConnection;
import modelAccess.ReviewDao;
import models.Review;

public class ReviewDaoImpl implements ReviewDao {

	@Override
	public boolean addReview(Review review) {
		String description = review.getDescription();
		int productId = review.getProductId();
		int accountId = review.getAccountId();
		
		try {
			Connection con = DBConnection.getConnection().getRawConnection();
			PreparedStatement ps = con.prepareStatement("INSERT INTO " + Review.TABLE_REVIEW + 
														"(" + Review.COL_DESCRIPTION + " ," +
														Review.COL_PRODUCTID + " ," +
														Review.COL_ACCOUNTID + " )" + "VALUES(?,?,?);");
						
			ps.setString(1, description);
			ps.setInt(2, productId);
			ps.setInt(3, accountId);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public Review getReview(int reviewId) {
		try {
			Connection con = DBConnection.getConnection().getRawConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM " + Review.TABLE_REVIEW + 
														" WHERE " + Review.COL_REVIEWID + " = ?");
			ps.setInt(1, reviewId);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()){
				Review review = new Review();
				review.setReviewId(rs.getInt(Review.COL_REVIEWID));
				review.setDescription(rs.getString(Review.COL_DESCRIPTION));
				review.setProductId(rs.getInt(Review.COL_PRODUCTID));
				review.setAccountId(rs.getInt(Review.COL_ACCOUNTID));
				return review;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public ArrayList<Review> getReviews(int productId) {
		ArrayList<Review> reviews = new ArrayList<>();
		
		try {
			Connection con = DBConnection.getConnection().getRawConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM " + Review.TABLE_REVIEW + 
														" WHERE " + Review.COL_PRODUCTID + " = ?");
			ps.setInt(1, productId);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()){
				Review review = new Review();
				review.setReviewId(rs.getInt(Review.COL_REVIEWID));
				review.setDescription(rs.getString(Review.COL_DESCRIPTION));
				review.setProductId(rs.getInt(Review.COL_PRODUCTID));
				review.setAccountId(rs.getInt(Review.COL_ACCOUNTID));
				reviews.add(review);
			}
			return reviews;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void updateReview(Review review) {
		String description = review.getDescription();
		int productId = review.getProductId();
		int accountId = review.getAccountId();
		int reviewId = review.getReviewId();
		
		try {
			Connection con = DBConnection.getConnection().getRawConnection();
			PreparedStatement ps = con.prepareStatement("UPDATE " + Review.TABLE_REVIEW + " SET " +  
														Review.COL_DESCRIPTION + " =?," +
														Review.COL_PRODUCTID + "  =?," +
														Review.COL_ACCOUNTID + " =?," +
														" WHERE " + Review.COL_REVIEWID + "=?;");
			ps.setString(1, description);
			ps.setInt(2, productId);
			ps.setInt(3, accountId);
			ps.setInt(4, reviewId);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteReview(int reviewId) {
		try {
			Connection con = DBConnection.getConnection().getRawConnection();
			PreparedStatement ps = con.prepareStatement("DELETE FROM " + Review.TABLE_REVIEW + 
														" WHERE " + Review.COL_REVIEWID + "=?;");
			ps.setInt(1, reviewId);
			ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
