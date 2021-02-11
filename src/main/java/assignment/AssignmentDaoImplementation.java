package assignment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class AssignmentDaoImplementation implements AssignmentDao 
{

	JdbcTemplate jdbctemplate;
	
	public AssignmentDaoImplementation(DataSource ds) {
	 jdbctemplate=new JdbcTemplate(ds);
	}
	
	public int insert(Student s) {
		
		String query="insert into student values(?,?,?)";
		
		int count=jdbctemplate.update(query,s.getName(),s.getAge(),s.getMarks());
		
		return count;
	}

	public List<Student> getList() {
		String query="select * from student";
		
		RowMapper<Student> rowmapper=new RowMapper<Student>() {

			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				
		     Student st=new Student();
		     st.setName(rs.getString("name"));
		     st.setAge(rs.getInt("age"));
		     st.setMarks(rs.getInt("marks"));
				
				return st;
			}
		};
		
	   List<Student> list=new ArrayList<Student>();
		
		
		list=  jdbctemplate.query(query, rowmapper);
		
		  Collections.sort(list, new MyComparator());
		
		return list;
	}

}
