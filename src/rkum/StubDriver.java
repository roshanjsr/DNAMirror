package rkum;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapreduce.Job;

public class StubDriver {
	
	public static void main(String[] args) throws Exception {
		if(args.length != 2){
			System.out.printf("USAGE: StubDriver <input dir><output dir>\n");
			//System.exit(-1);
		}
		JobConf conf=new JobConf(StubDriver.class);
		@SuppressWarnings("deprecation")
		Job job1 = new Job(conf, "DNAFam");
		job1.setJarByClass(StubDriver.class);
		job1.setMapperClass(StubMapper.class);
		job1.setReducerClass(StubReducer.class);
		job1.setOutputKeyClass(Text.class);
		job1.setOutputValueClass(Text.class);
		//job.setPartitionerClass(StubPartitioner.class);
		//job.setNumReduceTasks(2);
		//conf.setNumMapTasks(2);
		
		job1.setMapOutputKeyClass(Text.class);
		job1.setMapOutputValueClass(Text.class);
		
		FileInputFormat.addInputPath(job1, new Path(args[0]));
		FileOutputFormat.setOutputPath(job1, new Path(args[1]));
		boolean result = job1.waitForCompletion(true);
		System.exit(result ? 0 : 1);
		}
}
