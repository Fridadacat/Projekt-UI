package Data;

public class User {
	
	String name;
	int reachedPointsNature = 0;
	int reachedPointsPolitics = 0;
	int reachedPointsInformatics = 0;
	
	
	public void setpointsNature(int points) {
		this.reachedPointsNature = points;
	}
	
	public void setPointsPolitics(int points) {
		this.reachedPointsPolitics = points;
	}
	
	public void setPointsInformatics(int points) {
		this.reachedPointsInformatics = points;
	}
	
	public void setUserName(String name) {
		this.name = name;
	}
	
	public int getPointsNature() {
		return reachedPointsNature;
	}
	
	public int getPointsPolitics() {
		return reachedPointsPolitics;
	}
	
	public int getPointsinformatics() {
		return reachedPointsInformatics;
	}
	
	public String getUserName() {
		return name;
	}
	
	

}
