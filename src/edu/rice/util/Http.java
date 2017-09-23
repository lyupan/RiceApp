package edu.rice.util;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import edu.rice.model.Course;

/*
http://courses.rice.edu/admweb/%21SWKSECX.main?term=201220&amp;title=&amp;course=&amp;crn=&amp;coll=&amp;dept=&amp;subj=LING
*/

public final class Http {
	
	public static final Http Singleton = new Http();
	
	private Http() {
		
	}

	@XmlRootElement
	@XmlAccessorType(XmlAccessType.FIELD)
	private static class Courses {
	    @XmlElement(name="course")
	    private Course[] courses;

	}
	
	public List<Course> getCousrses(String term, String title, String course, 
			String crn, String coll, String dept, String subj) {
		List<Course> results = new LinkedList<Course>();
		term = "201710";
		title = "";
		course = "532";
		crn = "";
		coll = "";
		dept = "";
		subj = "COMP";
		
		String url = "https://courses.rice.edu/admweb/!SWKSECX.main?" + 
				"term=" + term + 
				"&title=" + title +
				"&course=" + course +
				"&crn=" + crn +
				"&coll=" + coll +
				"&dept=" + dept +
				"&subj=" + subj;
		JAXBContext jc;
		try {
			jc = JAXBContext.newInstance(Courses.class);
			
			Unmarshaller unmarshaller = jc.createUnmarshaller();
			Courses courses = (Courses) unmarshaller.unmarshal(new URL(url));//(new StreamSource( xmlContent));

			for (Course c:courses.courses)
	        	results.add(c);
	        	
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return results;
 	}
	
	public static void main(String[] args) throws URISyntaxException {
//		
//		for (Course c : Http.Singleton.getCousrses())
//			System.out.println(c.getSubject() + c.getCourseNumber());
	}
}
