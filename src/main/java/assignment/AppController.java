package assignment;

import java.util.List;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController 
{
	@Autowired
	AssignmentDao ad;
	
   @RequestMapping("/insert")
	public ModelAndView insert(@RequestParam("name")String name,@RequestParam("age")int age,@RequestParam("marks")int marks)
	{
		ModelAndView mv=new ModelAndView();
	   
		Student s=new Student();
		s.setName(name);
		s.setAge(age);
		s.setMarks(marks);
		
		int a=ad.insert(s);
		System.out.println(a);
		mv.setViewName("Second");
		
		return mv;
	}
	
   @RequestMapping("/getlist")
	public ModelAndView getList()
	{
		ModelAndView mv=new ModelAndView();
		
		 List<Student> st=ad.getList();
		 System.out.println("helere is done..");
		    mv.addObject("list",st);
		     mv.setViewName("index");
		 return mv;
	}
	
   @RequestMapping("/getAdditionMarks")
   public ModelAndView getAddition()
   {
	   ModelAndView mv=new ModelAndView();
	   
	    List<Student> list=ad.getList();
	    double addition=0;
	    for(Student st:list)
	    {
	    	addition=addition+st.getMarks();
	    }
	   
	  mv.addObject("addition",addition);
	  mv.setViewName("index");
	   return mv;
   }
   
}
