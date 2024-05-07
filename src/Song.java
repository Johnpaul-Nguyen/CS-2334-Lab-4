import java.util.Arrays;

public class Song {
	private String title;
	private String artist;
	private int[] time;
	private int[] timeCopy;
	
	// Constructor
		public Song(String title, String artist, int[] time) {
			this.title = title;
			this.artist = artist;
			this.time = Arrays.copyOf(time, time.length);
		}
		
		// Accessors
		public String getTitle() {
			return title;
		}
		public String getArtist() {
			return artist;
		}
		public int[] getTime() {
			timeCopy = new int[time.length];
			
			for (int i = 0; i < time.length; i++) {
				timeCopy[i] = time[i];
			}
			
			return timeCopy;
		}
}
