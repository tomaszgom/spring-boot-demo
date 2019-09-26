package tg.springbootdemo.entity;

/**
 * 
 * 
 * @BusinessLogic: 
 * Project Issue is a core part of Project. It is super class for all project items representing different
 * types of work that needs to be assigned and completed. Different types of issue inherit from issue.
 *
 */



public class ProjectIssue {
	
	private int id;
	private String title;
	private String description;
	
	public ProjectIssue() {	
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	
	
}
