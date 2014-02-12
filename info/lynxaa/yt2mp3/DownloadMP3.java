package info.lynxaa.yt2mp3;

import info.lynxaa.yt2mp3.io.URLManager;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class DownloadMP3 {
	private String videoID;

	public static DownloadMP3 downloadMP3(final String videoID, final String savePath) {
		return new DownloadMP3(videoID, savePath);
	}

	private DownloadMP3(final String videoID, final String savePath) {
		this.setVideoID(videoID);

		new Thread(new DownloadMP3Thread(videoID, savePath)).start();
	}

	public String getVideoID() {
		return videoID;
	}

	public void setVideoID(String videoID) {
		this.videoID = videoID;
	}

	private static final class DownloadMP3Thread implements Runnable {
		private String videoID;
		private String download;
		private String savePath;

		public DownloadMP3Thread(final String video, final String savePath) {
			this.videoID = video;
			this.savePath = savePath;
			
			if (!savePath.endsWith(File.separator)) {
				this.savePath = savePath + File.separator;
			}
		}

		@Override
		public void run() {
			final String url = "http://youtubeinmp3.com/fetch/?api=advanced&video=http://www.youtube.com/watch?v=" + videoID;
			URL webUrl = null;
			try {
				webUrl = new URL(url);
			} catch (MalformedURLException e) {
				System.out.println(e.getMessage());
			}
			
			final URLManager urlManager = URLManager.newManager(webUrl);

			try {
				urlManager.setupReadStreams();
				String line;

				while ((line = urlManager.readLine()) != null) {
					String[] args = line.split("Link: ");

					if (args.length < 1) {
						System.err.println("Failed to download: " + videoID);
					} else {
						final String downloadURL = args[1];
						setDownload(downloadURL);
						urlManager.saveUrl(savePath + videoID + ".mp3", getDownload());
					}

					line = urlManager.readLine();
				}
			} catch (IOException | NullPointerException | ArrayIndexOutOfBoundsException e) {
				System.out.println("Failed to download a file.. err: " + e.getMessage() + " | VIDEOID: " + this.videoID);
			} finally {
				urlManager.closeStreams();
			}
		}

		public String getDownload() {
			return download;
		}

		public void setDownload(String download) {
			this.download = download;
		}
	}
}
