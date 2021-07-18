package com.demo.ann;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "review_table", schema = "yms_demo2")
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String reviewerName;
	private String review;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getReviewerName() {
		return reviewerName;
	}
	public void setReviewerName(String reviewerName) {
		this.reviewerName = reviewerName;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public Review(String reviewerName, String review) {
		this.reviewerName = reviewerName;
		this.review = review;
	}
	public Review() {}
	@Override
	public String toString() {
		return "Review [id=" + id + ", reviewerName=" + reviewerName + ", review=" + review + "]";
	}
	
	

}