import info.lynxaa.yt2mp3.DownloadMP3;
import info.lynxaa.yt2mp3.file.FileUtils;

import java.util.List;
import java.util.Scanner;

/**
 * Main class for YT2MP3.
 * 
 * A simple java application to convert youtube videos into mp3 audio format.
 * 
 * @author Lynxaa/Ross
 */
public class Start {

	public static void main(String[] args) {
		final Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to YT2MP3 by Lynxaa!");
		System.out.println("Check me out @ http://lynxaa.info/ (Might be down)");
		System.out.println("Thanks to Lemm0n for finding the site!");
		System.out.println("");

		System.out.println("Enter the directory containing the video id's: ");
		System.out.print("> ");
		final String path = scanner.nextLine();		
		List<String> contents = FileUtils.readAllLines(path);
		
		System.out.println(" ");

		for (String line : contents) {
			System.out.println(line);
		}
		
		System.out.println(String.format("%s lines read.", new Object[] { contents.size() }));
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

		System.out.println("");
		scanner.close();
	}

}