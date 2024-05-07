
public class Playlist {
	private Song[] songs;
	private int numSongs;
	private static final int MIN_CAPACITY = 3;
	
	// Constructors
	public Playlist() {
		songs = new Song[MIN_CAPACITY];
		numSongs = 0;
	}
	public Playlist (int capacity) {
		if (capacity > MIN_CAPACITY) {
			songs = new Song[capacity];
		}
		else {
			songs = new Song[MIN_CAPACITY];
		}
		numSongs = 0;
	}
	
	// Accessors
	public int getCapacity() {
		return songs.length;
	}
	public int getNumSongs() {
		return numSongs;
	}
	public Song getSong(int index) {
		if (index < 0 || index >= songs.length) {
			return null;
		}
		else {
			return songs[index];
		}
	}
	public Song[] getSongs() {
		Song[] result = new Song[numSongs];
		
		for (int i = 0; i < result.length; i++) {
			result[i] = songs[i];
		}
		return result;
	}
	
	
	// Add/Set methods
	public boolean addSong(Song song) {
		if (addSong(numSongs, song)) {
			return true;
		}
		return false;
	}
	public boolean addSong(int index, Song song) {
		
		if (songs.length <= numSongs || index < 0 || index > numSongs || song == null) {
			return false;
		}
		else {
			
			for (int i = numSongs - 1; i >= index; i--) { 	// Does not work yet, the song is assigned to each element 
				songs[i + 1] = songs[i];
			}
			songs[index] = song;
			numSongs++;
			return true;
		}
	}
	public int addSongs(Playlist playlist) {
		int count = 0;
		
		if (playlist == null) {
			return 0;
		}
		else {
			
			int numSongs = playlist.getNumSongs();
			for (int i = 0; i < numSongs; i++) {
				if(this.addSong(playlist.getSong(i))) {
					count++;
				}
			}
			return count;	
		}
	}
	
	// Remove methods
	public Song removeSong() {
		if (songs == null) {
			return null;
		}
		else {
			return removeSong(numSongs - 1);
		}
	}
	public Song removeSong(int index) {
		if (index < 0 || index > numSongs || index > songs.length || songs[index] == null) {
			return null;
		}
		else {
			Song output = songs[index];
			songs[index] = null;
			
			for (int i = index; i < songs.length - 1; i++) {
				Song temp = songs[i];
				songs[i] = songs[i + 1];
				songs[i + 1] = temp;
				
			}
			numSongs--;
			return output;	
		}
		
	}

}
