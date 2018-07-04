package dom4j;

import java.io.FileWriter;
import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

public class Dom4jTest {
	
	@Test
	public void test(){
		
	}
	
	//编写一个webxml文件
	@Test
	public void testWritXMLFile2(){
		Document document = DocumentHelper.createDocument();
		Element element = document.addElement("web-app");
		Element element2 = element.addElement("servlet");
		element2.addElement("servlet-name").addText("Helloservlet");
		element2.addElement("servlet-class").addText("com.hc.servlet.HelloServlet");
		
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("UTF-8");
		XMLWriter xmlWriter=null;
		try {
			xmlWriter = new XMLWriter(new FileWriter("src/main/resources/web.xml"), format);
			System.out.println("web文件编写成功");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				xmlWriter.write(document);
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				xmlWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	//编写一个applicatonContext.xml文件
	@Test
	public void testWritXMLFile(){
		Document document = DocumentHelper.createDocument();
		Element element = document.addElement("beans");
		element.addElement("bean").addAttribute("name", "person").addAttribute("class", "com.hc.bean.Person");
		element.addElement("bean").addAttribute("name", "worker").addAttribute("class", "com.hc.bean.Worker");
	
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("UTF-8");
		XMLWriter xmlWriter=null;
		try {
			xmlWriter = new XMLWriter(new FileWriter("src/main/resources/applicationContext.xml"), format);
			System.out.println("applicationContext文件编写成功");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				xmlWriter.write(document);
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				xmlWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
