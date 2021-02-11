package assignment;

import java.util.List;
import java.util.TreeSet;

public interface AssignmentDao 
{

	public int insert(Student s);
	
	public List<Student> getList();
}
