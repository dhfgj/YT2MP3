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

public class FileUtils {
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
