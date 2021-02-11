package assignment;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("assignment")
@EnableWebMvc
public class AppConfiguration extends WebMvcConfigurerAdapter 
{

	@Bean
	public InternalResourceViewResolver getView()
	{
		InternalResourceViewResolver ir=new InternalResourceViewResolver();
		ir.setPrefix("/");
		ir.setSuffix(".jsp");
		return ir;
	}
	
	//======= get data souce bean for database connection   ==================
	
	@Bean
	 public DriverManagerDataSource getDataSource()
	 {
		 DriverManagerDataSource ds=new DriverManagerDataSource();
		 ds.setDriverClassName("com.mysql.jdbc.Driver");
		 ds.setUrl("jdbc:mysql://localhost:3306/mydemo");
		 ds.setUsername("root");
		 ds.setPassword("Mauli@1997");
		 
		 return ds;
	 }
	
	@Bean
	public AssignmentDao getDaoDependecy()
	{
		AssignmentDao ad=new AssignmentDaoImplementation(getDataSource());
		return ad;
	}
	
}
