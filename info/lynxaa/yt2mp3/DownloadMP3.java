package info.lynxaa.yt2mp3;

/**
 * Sets up the data used to submit the download thread for parsing & downloading.
 * 
 * @see info.lynxaa.yt2mp3#DownloadMP3Thread
 * 
 * @author Ross/Lynxaa
 */
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
}
