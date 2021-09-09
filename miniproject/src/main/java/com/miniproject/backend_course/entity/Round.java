package com.miniproject.backend_course.entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Round {
	
	    @Id
	    @GeneratedValue
		private int id;
		private String name;
		private int seq;
		
		
		
		public Round(int id, String name, int seq) {
			super();
			this.id = id;
			this.name = name;
			this.seq = seq;
		}

		public Round() {
			super();
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getSeq() {
			return seq;
		}

		public void setSeq(int seq) {
			this.seq = seq;
		}

		@Override
		public String toString() {
			return "Round [id=" + id + ", name=" + name + ", seq=" + seq + "]";
		}
		
		

}
