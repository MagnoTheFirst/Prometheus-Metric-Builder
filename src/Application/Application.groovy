package Application

import moduls.File_handler
import moduls.Html_file_util
import moduls.Metric
import moduls.Attribute

class Application {
	public static void main(String[] args) {
		
		/*---------------------------------------------------------tmic customer-------------------------------------------------------------*/
		
		Html_file_util h1 = new Html_file_util("C:/Users/taalaal4/LAB/Files4Testing/", "micbackend_test_extracted_html.txt");
		h1.remove_tag("td align=center", "")
		h1.remove_tag("td", "")
		h1.remove_tag("active sessions", "")
		
		String value_line_1=h1.get_specific_line(0)
		String value_line_2 = h1.get_specific_line(1)

		
		Attribute a1 = new Attribute("node", "tmic");
		Attribute a2 = new Attribute("instance", "Customer");
		Attribute a3 = new Attribute("field","active sessions" )
		
		Metric m1 = new Metric("sc_test_metric", "For test reasons", a1, "Gauge");
		m1.append_attribute(a2);
		m1.append_attribute(a3);
		
		File_handler f1 = new File_handler("C:/Users/taalaal4/LAB/Files4Testing", "metrics.prom");
		f1.clear_file();
		m1.setValue(value_line_2);
		f1.file_writer(m1.get_metric());
		/*----------------------------------------------------------------------------------------------------------------------*/
	}
}
