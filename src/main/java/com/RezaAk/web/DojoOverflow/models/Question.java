package com.RezaAk.web.DojoOverflow.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="questions")
public class Question {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@Size(min = 1, max = 200)
	private String content;
	
	@Column(updatable=false)
	private Date createdAt;
	
	private Date updatedAt;
	
    @OneToMany(mappedBy="question", fetch = FetchType.LAZY)
    private List<Answer> answers;
	
    @ManyToMany(fetch= FetchType.LAZY, cascade=CascadeType.REFRESH)
    @JoinTable(
    	name = "tags_questions",
    	joinColumns = @JoinColumn(name="question_id"),
    	inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<Tag> tags;
    
    
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	
	public Question() {
		
	}
	
	public Question(String question){
		this.content = question;
	}
	
	public Question(String question, List<Tag> tags) {
		this.content = question;
		this.tags = tags;
	}
	
	public Question(String question, List<Tag> tags, List<Answer> answers) {
		this.content = question;
		this.tags = tags;
		this.answers = answers;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	
	public void addAnswer(Answer answer) {
		if(this.answers == null) {
			this.answers = new ArrayList<Answer>();
		}
		this.answers.add(answer);
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	
	public void addTags(Tag tag) {
		if(this.tags == null) {
			this.tags = new ArrayList<Tag>();
		}
		this.tags.add(tag);
		System.out.print("$@!$#!$#@$#@" + this.tags);
	}
	
}