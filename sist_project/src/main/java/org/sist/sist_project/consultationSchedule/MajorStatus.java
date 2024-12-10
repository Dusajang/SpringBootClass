package org.sist.sist_project.consultationSchedule;

public enum MajorStatus {
	
	MAJOR("전공자"),
    NON_MAJOR("비전공자");

    private final String description;

    MajorStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
    
}
