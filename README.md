# Prometheus-Metric-Builder
This Repo contains a modul that converts the content of a file into Prometheus metrics. 
To run the application properly you have to access to an file that conains the Information that you need for your metrics.
Maybe you have to make use of a script that reduces the content of a Log File or an HTML file or JSON File to the essential information. 
Therfor you can check the Script directory. 
After your Information is stored in some File you can build your metric following a few steps: 
This Application can convert the content of a file into Prometheus metric. 

 * 1.) Instanciate a Html_file_util that points to the file wich contains the needed information
 * 2.) Remove all unnesecary content like tags, words etc. 
 * 3.) store the formated input in a variable of type String
 * 4.) create the Attributes that are used as label in the metric
 * 5.) create the metric and append the attributes
 * 6.) Create a file instance of the file where your metrics should be stored. The file must be a .prom file
 * 7.) Clear the file
 * 8.) write your metrics in.
  
Please give me feedback if you have inputs what i can and should do better. 
Best Regards MagnoTheFirst
