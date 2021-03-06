package midterm_prob2;

public class Admin {
	//implement
	
	private Department[] departments;
	
	
	
	public Admin(Department[] departments) {
		this.departments = departments;
	}

	public String hourlyCompanyMessage(){
		StringBuilder builder = new StringBuilder();
		
		for (Department department : departments) {
			builder.append(format(department.getName(), department.nextMessage()));
		}
		
		return builder.toString();
	}
	
	public String format(String name, String message) {
		return name+": "+ message+"\n";
	}
}
