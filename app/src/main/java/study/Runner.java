package study;

public class Runner{
	private String path;
	private String help;
	private String verbose;
	
	public static void main(String[] args) {
		Runner myRunner = new Runner();
		myRunner.run(args);
	}
	
	private void run(String[] args) {
		Options options = createOption();
	}
	
	private Options createOption() {
		
	}
}