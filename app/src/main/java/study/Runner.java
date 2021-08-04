package study;

import org.apache.commons.cli.Options;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;

public class Runner{
	private String path;
	private boolean help;
	private boolean verbose;
	
	public static void main(String[] args) {
		Runner myRunner = new Runner();
		myRunner.run(args);
	}
	
	private void run(String[] args) {
		Options options = createOption();
		
		if(parseOptions(options, args)) {
			if(help) {
				printHelp(options);
				return;
			}
			
			System.out.println("You provided \"" + path + "\" as the value of the option p");
			
			if(verbose) {
				System.out.println("Your program is terminated.");
			}
		}
	}
	
	private boolean parseOptions(Options options, String[] args) {
		CommandLineParser parser = new DefaultParser();
		
		try {
			CommandLine cmd = parser.parse(options, args);
		path = cmd.getOptionValue("p");
		verbose = cmd.hasOption("v");
		help = cmd.hasOption("h");
		} catch(Exception e){
			printHelp(options);
			return false;
		}
		
		return true;
		
		
	}
	
	private Options createOption() {
		Options options = new Options();
		
		options.addOption(Option.builder("p").longOpt("path")
				.desc("set a path of a directory or a file to display")
				.hasArg()
				.argName("Path name to display")
				.required()
				.build());
		options.addOption(Option.builder("h").longOpt("help")
				.desc("help")
				//.hasArg()
				//.argName("Path name to display")
				.build());
		options.addOption(Option.builder("v").longOpt("verbose")
				.desc("display detailed message")
				//.hasArg()
				.argName("verbose option")
				.build());
		
		return options;
	}
	
	private void printHelp(Options options) {
		HelpFormatter formatter = new HelpFormatter();
		String header = "CLI test program";
		String footer = "\nPlease report issues";
		formatter.printHelp("CLIExample", header, options, footer, true);
	}
}