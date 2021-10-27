package com.miniproject.backend_course.dto;

import java.sql.Timestamp;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;

import com.miniproject.backend_course.entity.Interview;
import com.miniproject.backend_course.entity.Interviewee;
import com.miniproject.backend_course.entity.Interviewer;
import com.miniproject.backend_course.entity.Positions;
import com.miniproject.backend_course.entity.Round;


@DTO
public class InterviewDTO {

	@Id
	// @GeneratedValue
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
	
	public static Interview convertToInterviewEntity(InterviewDTO interviewDto) {
		ModelMapper modelMapper = new ModelMapper();
		Interview interview = modelMapper.map(interviewDto, Interview.class);
		return interview;
	}
	
	public static InterviewDTO convertToInterviewDto(Interview interview) {
		ModelMapper modelMapper = new ModelMapper();
		InterviewDTO interviewDto1 = modelMapper.map(interview, InterviewDTO.class);
		return interviewDto1;
	}


}
