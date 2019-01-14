package com.example.qluser.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.usertype.LoggableUserType;



@Entity
@Table(name = "news")
public class News {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "news_id", nullable=false)
	private int newsID;

	@Column(name = "url")
	private String url;

	@Column(name = "title")
	private String title;

	@Column(name = "news_desc")
	private String description;

	@Column(name = "content")
	private String content;

	@Column(name = "news_status")
	private String newsStatus;

	@Column(name = "is_hot")
	private String isHot;
	
@ManyToOne
@JoinColumn(name = "user_id")
	 private Users userN;
//	 @OneToMany(cascade = CascadeType.ALL,mappedBy = "passagier")
//	   private List<Buchung> buchungen = new ArrayList<>();
//	@OneToMany
//	@JoinColumn(name = "user_id")
//	private Users userIDD;
	 @Column(name = "approver_id", nullable=false)
		private int approverID;

		@Column(name = "created_at")
		private String createdAt;

		@Column(name = "updated_at")
		private String updatedAt;

		@Column(name = "approved_at")
		private String approvedAt;

		public News(int newsID, String url, String title, String description, String content, String newsStatus,
				String isHot, Users userN, int approverID, String createdAt, String updatedAt, String approvedAt) {
			super();
			this.newsID = newsID;
			this.url = url;
			this.title = title;
			this.description = description;
			this.content = content;
			this.newsStatus = newsStatus;
			this.isHot = isHot;
			this.userN = userN;
			this.approverID = approverID;
			this.createdAt = createdAt;
			this.updatedAt = updatedAt;
			this.approvedAt = approvedAt;
		}

		public News() {
			super();
		}

		public int getNewsID() {
			return newsID;
		}

		public void setNewsID(int newsID) {
			this.newsID = newsID;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public String getNewsStatus() {
			return newsStatus;
		}

		public void setNewsStatus(String newsStatus) {
			this.newsStatus = newsStatus;
		}

		public String getIsHot() {
			return isHot;
		}

		public void setIsHot(String isHot) {
			this.isHot = isHot;
		}

		public Users getUserN() {
			return userN;
		}

		public void setUserN(Users userN) {
			this.userN = userN;
		}

		public int getApproverID() {
			return approverID;
		}

		public void setApproverID(int approverID) {
			this.approverID = approverID;
		}

		public String getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(String createdAt) {
			this.createdAt = createdAt;
		}

		public String getUpdatedAt() {
			return updatedAt;
		}

		public void setUpdatedAt(String updatedAt) {
			this.updatedAt = updatedAt;
		}

		public String getApprovedAt() {
			return approvedAt;
		}

		public void setApprovedAt(String approvedAt) {
			this.approvedAt = approvedAt;
		}

//	 @ManyToOne(fetch = FetchType.LAZY, optional = false)
//	    @JoinColumn(name = "post_id", nullable = false)
//	    @OnDelete(action = OnDeleteAction.CASCADE)
//	    @JsonIgnore
//	    private Post post;
//	@ManyToOne(fetch = FetchType.LAZY, optional = false)
//	@JoinColumn(name = "user_id", nullable = false)
//	@OnDelete(action = OnDeleteAction.CASCADE)
//	 @JsonIgnore
	 
	





//	 @ManyToOne
//	    @JoinColumn(name = "user_id")
//		public Users getUserIDD() {
//			return userIDD;
//		}
//
//		public void setUserIDD(Users userIDD) {
//			this.userIDD = userIDD;
//		}

	

	
	
}
