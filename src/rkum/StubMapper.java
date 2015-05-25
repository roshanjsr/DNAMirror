package rkum;

import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.*;


public class StubMapper extends Mapper<Object, Text, Text, Text>{

	@Override
	public void map(Object key, Text value, Context context)
	throws IOException, InterruptedException {
	
	String[] words= new String[2];
	int i=0;
	//Split the lines into words with spaces or tabs as separators
	StringTokenizer stringTokenizer = new StringTokenizer (value.toString(), " ");
	while (stringTokenizer.hasMoreElements ())
		{
			words[i]= (String)stringTokenizer.nextElement ();
		    i++;
		}
	//Reverse the string and sort them
	String sb=new StringBuilder(words[1]).reverse().toString();
	String[] srt= new String[2];
	srt[0]=words[1];
	srt[1]=sb;
	Arrays.sort(srt);
	context.write(new Text(srt[0].toString()), new Text(words[0]));
	System.err.println("RKUMLOG:This is a mapper.");
	}
}
