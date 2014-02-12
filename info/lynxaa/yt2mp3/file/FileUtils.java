package info.lynxaa.yt2mp3.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Basic file utilities to help file reading, saving, loading, etc.
 * I'll add more to this as I need it.
 * 
 * @author Lynxaa
 * @since Feb 12, 2014 3:21:22 PM
 */
public class FileUtils {
	
	/**
	 * Returns an array of strings containing the data from the file submitted for reading.
	 * 
	 * @param file
	 * @return <tt>java.util.List</tt>
	 */
	public static List<String> readAllLines(final String file) {
		final List<String> tempList = new ArrayList<String>();
		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(file)), StandardCharsets.UTF_8));
			String line;

			while ((line = reader.readLine()) != null) {
				tempList.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return tempList;
	}

	/**
	 * Reads all lines from the input file and then adds each line into the Collection array.
	 * 
	 * @param file
	 * @param content
	 * 			Collection to add the data to.
	 */
	public static void readFile(File file, Collection<String> content) {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));
			String line;

			while ((line = reader.readLine()) != null) {
				content.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
