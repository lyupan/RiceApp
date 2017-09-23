package edu.rice.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import edu.rice.model.Course;


public class XML_Parser {
	@XmlRootElement
	@XmlAccessorType(XmlAccessType.FIELD)
	private static class Courses {

	    @XmlElement(name="course")
	    private Course[] courses;

	}
	
//	public static String getHTML(String urlToRead) throws Exception {
//		StringBuilder result = new StringBuilder();
//		URL url = new URL(urlToRead);
//		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//		conn.setRequestMethod("GET");
//		BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//		String line;
//		while ((line = rd.readLine()) != null) {
//			result.append(line);
//		}
//		rd.close();
//		return result.toString();
//   }
	
	public static void main(String[] args) {
		String term = "201710";
		String title = "";
		String course = "532";
		String crn = "";
		String coll = "";
		String dept = "";
		String subj = "COMP";
		
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
	        	System.out.println(c.getSubject() + c.getCourseNumber());
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

