package study;

import org.apache.commons.cli.*;

public class AprCli {

	public static void main(String[] args) {
		AprCli runner = new AprCli();
		runner.run(args);
	}
	
	private void run(String[] args) {
		Options options = createOptions();
		
		if()
		
	}
	
	private Options createOptions() {
		Options options = new Options();
		
		options.addOption(Option.builder("f").longOpt("faultDirPath")
				.desc("set a path of a fault directory")
				.hasArg()
				.argName("Path name of fault directory")
				.required()
				.build());
		
		options.addOption(Option.builder("t").longOpt("testCasePath")
				.desc("set a path of a testCasePath")
				.hasArg()
				.argName("Path name of test case")
				.required()
				.build());
		
		options.addOption(Option.builder("h").longOpt("help")
				.desc("Help")
				.build());
		
		return options;
	}
}
