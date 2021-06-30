package moduls


class Metric {
	String first_line;
	String second_line;
	String metric;
	Object value;
	String final_metric;
	
	public Metric(String metric_name, String metric_description, Attribute instance, String type)
	{
			this.first_line = "# HELP "+  metric_name.trim() +" " +  metric_description + "\n";
			this.second_line = "# TYPE "+  metric_name.trim() + " "+ type + "\n";
			this.metric = metric_name + "{" + instance.get_ATTRIBUTE() + "} ";

	}
	
	
	public void append_attribute(Attribute attribute)
	{
//		final_metric = final_metric.replace('} ', ',' + "\"" +  attribute.get_ATTRIBUTE() + "\"" + '} ' );
		metric = metric.replace('} ', ','  +  attribute.get_ATTRIBUTE() + '} ' );

	}
	
	
	public void set_value(Object value)
	{
		this.value = value.toString().trim();
//		this.metric += value;
	}
	
	public String get_metric()
	{
		if(value != null)
		{
			this.final_metric = first_line + second_line + metric + value;
//			this.metric += value;
			return this.final_metric.toString();
		}
		else {
			this.metric + null
			println "Each Metric have to contain a value;"
			return null;
		}
	}
	
}
