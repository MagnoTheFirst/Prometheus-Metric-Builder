package moduls

class Attribute {
	
	String ATTRIBUTE;
		
	public Attribute(String type, String value)
	{
		this.ATTRIBUTE = type + "=" + "\"" + value + "\"";
	}
		
	public String get_ATTRIBUTE()
	{
		return this.ATTRIBUTE;
	}
				
}
