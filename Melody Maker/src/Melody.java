import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Melody {
	
	private Queue<Note>song;
	private double tempo;

	public Melody(Queue<Note> song) {
		this.song=song;
		tempo = 1.0;
	}
	
	public Queue<Note> getNotes() {
		return song;
	}

	public double getTotalDuration() {
		double totalDur=0.0;
		boolean isInRepeat=false;
		double repeatedDuration = 0.0;
		Queue<Note>copy=new LinkedList<>();
		while(!song.isEmpty()) {
			Note note = song.poll();
			copy.offer(note);
			double dur = note.getDuration() * tempo;
			
			if(note.isRepeat()) {

				totalDur += (2 * (repeatedDuration));
				if(isInRepeat) {
					totalDur +=dur;
				}
				isInRepeat = !isInRepeat;
			}
			
			if(isInRepeat) {
				repeatedDuration += dur;
			}else {
				totalDur += dur;
			}
		}
		resetToOrginal(copy);
		return totalDur;
	}
	
	private void resetToOrginal(Queue<Note> copy) {
		while(!copy.isEmpty()) {
			song.offer(copy.poll());
		}
		
	}

	public void changeTempo(double tempo) {
		this.tempo=tempo;
	}
	
	@Override
	public String toString() {
		Queue<Note>copy=new LinkedList<>();
		String string="";
		while(!song.isEmpty()) {
			Note note = song.poll();
			string += (note.toString()+"/n");
		}
		resetToOrginal(copy);
		return string;
	}
	
	public void reverse() {
		Stack<Note> stack = new Stack<>();
		Queue<Note>copy=new LinkedList<>();
		while(!song.isEmpty()) {
			Note note = song.poll();			
			stack.push(note);
		}
		resetToOrginal(copy);
	}
	
	public void append(Melody other) {
		while(!other.getNotes().isEmpty()) {
			song.offer(other.getNotes().poll());
		}
	}

	public void play() {
		boolean isInRepeat = false;
		Queue<Note>copy=new LinkedList<>();
		Queue<Note>repeatSection=new LinkedList<>();
		while(!song.isEmpty()) {
			Note note = song.poll();
			copy.offer(note);
			if(note.isRepeat()) {
				if(isInRepeat) {
					while(!repeatSection.isEmpty()) {
						repeatSection.poll().play();					}
				}
				isInRepeat = !isInRepeat;
			}
			
			if(isInRepeat) {
				note.play();
				repeatSection.offer(note);
			}else {
				note.play();
			}
		}
	}
}


