package rkum;

import java.io.IOException;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class StubReducer extends Reducer<Text, Text, NullWritable, Text>{
	@Override
	public void reduce(Text key, Iterable<Text> values, Context context)
		throws IOException, InterruptedException {
		
		String family = "";
		for(Text iw:values)
		{
			if(family.length()!=0)
				family = family + ",";
			if(!(family.toLowerCase().contains(iw.toString().toLowerCase())))
				family = family + iw;
			System.err.println("RKUMLOG:This is a log.");
		}
		//Iterator<Text> iter=values.iterator();
        //while (iter.hasNext()) 
        //{
        //    double val=iter.next().get();
        //    family = family+ val;
        //}
		context.write(NullWritable.get(), new Text(family));
	}
}
