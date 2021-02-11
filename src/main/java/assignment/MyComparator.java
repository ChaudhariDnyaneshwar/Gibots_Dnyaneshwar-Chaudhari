package assignment;

import java.util.Comparator;

public class MyComparator implements Comparator {

	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub

		Student st=(Student)o1;
		Student st1=(Student)o2;
		if(st.getMarks()<st1.getMarks())
			return (-1);
		else
		return (1);
	}

}
