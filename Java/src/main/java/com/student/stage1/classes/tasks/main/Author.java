package com.student.stage1.classes.tasks.main;

public class Author {
	private String firstName;
	private String secondName;
	private String patronymic;
	
	public Author(String firstName, String secondName) {
		if (firstName == null || firstName.isEmpty() ||
				secondName == null || secondName.isEmpty()) {
			throw new IllegalArgumentException("Name can't be empty or be absent.");
		}
		
		this.firstName = firstName;
		this.secondName = secondName;
	}

	public Author(String firstName, String patronymic, String secondName) {
		this(firstName, secondName);
		this.patronymic = patronymic;
	}


	//getters & setters
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		if (firstName == null || firstName.isEmpty()) {
			throw new IllegalArgumentException("Name can't be empty or be absent.");
		}
		this.firstName = firstName;
	}
	public String getSecondName() {
		return secondName;
	}
	public void setSecondName(String secondName) {
		if (secondName == null || secondName.isEmpty()) {
			throw new IllegalArgumentException("Name can't be empty or be absent.");
		}
		this.secondName = secondName;
	}
	public String getPatronymic() {
		return patronymic;
	}
	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}
	
	
	@Override
	public String toString() {
		String result = firstName + " ";
		result = (patronymic == null || patronymic.isEmpty()) ? 
						result : result + patronymic + " ";
		return result + secondName;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((patronymic == null) ? 0 : patronymic.hashCode());
		result = prime * result + ((secondName == null) ? 0 : secondName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Author other = (Author) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (patronymic == null) {
			if (other.patronymic != null)
				return false;
		} else if (!patronymic.equals(other.patronymic))
			return false;
		if (secondName == null) {
			if (other.secondName != null)
				return false;
		} else if (!secondName.equals(other.secondName))
			return false;
		return true;
	}
}
