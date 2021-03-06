package com.miniproject.backend_course.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "Interview_Table")
@SQLDelete(sql = "UPDATE Interview_Table SET is_deleted =1 WHERE interview_id=?")
@Where(clause = "is_deleted=0")
public class Interview {

	@Id
	@GeneratedValue
	private int interview_id;

	private Timestamp time;
	@NotNull(message = "not empty")
	private String status;
	private Boolean isDeleted = Boolean.FALSE;

	@ManyToOne
	@JoinColumn(name = "interviewee_id", nullable = false)
	private Interviewee interviewee;

	@ManyToOne
	@JoinColumn(name = "position_id", nullable = false)
	private Positions positions;

	@ManyToOne
	@JoinColumn(name = "round_id", nullable = false)
	private Round rounds;

	@ManyToOne
	@JoinColumn(name = "interviewer_id", nullable = false)
	private Interviewer interviewer;

	protected Interview() {

	}

	public Interview(int interview_id, Timestamp time, String status, Interviewee interviewee, Positions positions,
			Round rounds, Interviewer interviewer, Boolean isDeleted) {
		super();
		this.interview_id = interview_id;
		this.time = time;
		this.status = status;
		this.interviewee = interviewee;
		this.positions = positions;
		this.rounds = rounds;
		this.interviewer = interviewer;
		this.isDeleted = isDeleted;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getInterview_id() {
		return interview_id;
	}

	public void setInterview_id(int interview_id) {
		this.interview_id = interview_id;
	}

	/*
	 * public int getInterviewee_id() { return interviewee.getId(); }
	 * 
	 * 
	 * public void setInterviewee_id(int interview_id) { this.interview_id =
	 * interviewee.getId(); }
	 */

	public Interviewee getInterviewee() {
		return interviewee;
	}

	public void setInterviewee(Interviewee interviewee) {
		this.interviewee = interviewee;
	}

	public Positions getPositions() {
		return positions;
	}

	public void setPositions(Positions positions) {
		this.positions = positions;
	}

	public Round getRounds() {
		return rounds;
	}

	public void setRounds(Round rounds) {
		this.rounds = rounds;
	}

	public Interviewer getInterviewer() {
		return interviewer;
	}

	public void setInterviewer(Interviewer interviewer) {
		this.interviewer = interviewer;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

}
