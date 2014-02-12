import info.lynxaa.yt2mp3.DownloadMP3;
import info.lynxaa.yt2mp3.file.FileUtils;

import java.util.List;
import java.util.Scanner;

/**
 * Main class for YT2MP3.
 * 
 * A simple java application to convert youtube videos into mp3 audio format.
 * 
 * What do you guys think.. should I add a UI for this simple application, or keep it command prompt only?
 * 
 * @author Lynxaa
 * @since Feb 12, 2014 3:21:22 PM
 */
public class Start {

	/**
	 * Main method that gets called once the application is launched.
	 * 
	 * @param args
	 * 		  Run arguments. I might use these for something later on.
	 */
	public static void main(String[] args) {
		final Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to YT2MP3 by Lynxaa!");
		System.out.println("What do you guys think.. should I add a UI for this simple application, or keep it command prompt only?");
		System.out.println("PM me on HF or Github.");
		System.out.println("Check me out @ http://lynxaa.info/ (Might be down)");
		System.out.println("Thanks to Lemm0n for finding the site!");
		System.out.println("");

		System.out.println("Enter the directory containing the video id's: ");
		System.out.print("> ");
		final String path = scanner.nextLine();		
		List<String> contents = FileUtils.readAllLines(path);
		
		System.out.println(" ");

		/** Inform the user of the lines read & what will be downloaded. */
		for (String line : contents) {
			System.out.println(line);
		}
		
		System.out.println("");

		System.out.println("Enter the save directory: ");
		System.out.print("> ");
		final String directory = scanner.nextLine();

		System.out.println("Downloading files could take a while depending on the speed of your internet.");
		System.out.println("");

		for (final String url : contents) {
			@SuppressWarnings("unused")
			final DownloadMP3 downloadMP3 = DownloadMP3.downloadMP3(url, directory);
		}

		scanner.close();
	}

}
