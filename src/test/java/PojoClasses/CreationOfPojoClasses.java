package PojoClasses;

public class CreationOfPojoClasses 
{	
	private String url;
	private String expertise;
	private String instructor;
	private String services;
	private CoursesNestedJSON_Child courses; //Here we create another class of Nested JSON//Mini-JSON
	private String linkedIn;
		
		 //Short-cut in eclipse to create the Getters/Setters method
		//We implement POJO classes
		//Alt+Shift+S
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		public String getExpertise() {
			return expertise;
		}
		public void setExpertise(String expertise) {
			this.expertise = expertise;
		}
		public String getInstructor() {
			return instructor;
		}
		public void setInstructor(String instructor) {
			this.instructor = instructor;
		}
		public String getServices() {
			return services;
		}
		public void setServices(String services) {
			this.services = services;
		}
		
		public CoursesNestedJSON_Child getCourses() {
			return courses;
		}
		public void setCourses(CoursesNestedJSON_Child courses) {
			this.courses = courses;
		}
		public String getLinkedIn() {
			return linkedIn;
		}
		public void setLinkedIn(String linkedIn) {
			this.linkedIn = linkedIn;
		}
		
		
		
		
		
		
		
		
		
		

	}

