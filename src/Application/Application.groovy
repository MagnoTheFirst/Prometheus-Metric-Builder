package Application

import moduls.File_handler
import moduls.Html_file_util
import moduls.Metric
import moduls.Attribute



/**
 * @author MagnoTheFirst
 * This Application can convert the content of a file into Prometheus metric. 
 * To run the Application properly the procedure is the following:
 * 1.) Instanciate a Html_file_util that points to the file wich contains the needed information
 * 2.) Remove all unnesecary content like tags, words etc. 
 * 3.) store the formated input in a variable of type String
 * 4.) create the Attributes that are used as label in the metric
 * 5.) create the metric and append the attributes
 * 6.) Create a file instance of the file where your metrics should be stored. The file must be a .prom file
 * 7.) Clear the file
 * 8.) write your metrics in.
 * 
 * Please give me feedback if you have inputs what i can and should do better. 
 * 
 * 
 * */
class Application {
	public static void main(String[] args) {
		
		/*---------------------------------------------------------tmic customer-------------------------------------------------------------*/
		//1.)
		Html_file_util h1 = new Html_file_util("C:/Users/taalaal4/LAB/Files4Testing/", "micbackend_test_extracted_html.txt");
		//2.)
		h1.remove_tag("td align=center", "")
		h1.remove_tag("td", "")
		h1.remove_tag("active sessions", "")
		
		//3.)
		String value_line_1=h1.get_specific_line(0)
		String value_line_2 = h1.get_specific_line(1)

		//4.)
		Attribute a1 = new Attribute("node", "tmic");
		Attribute a2 = new Attribute("instance", "Customer");
		Attribute a3 = new Attribute("field","active sessions" )

		//5.)
		Metric m1 = new Metric("sc_test_metric", "For test reasons", a1, "Gauge");
		m1.append_attribute(a2);
		m1.append_attribute(a3);
		
		//6.)
		File_handler f1 = new File_handler("C:/Users/taalaal4/LAB/Files4Testing", "metrics.prom");
		f1.clear_file();
		m1.setValue(value_line_2);
		f1.file_writer(m1.get_metric());
		/*------------------------------------------------------------------------------------------------------------------------------------*/
	}
}
