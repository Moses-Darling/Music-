
import java.util.*;
import java.text.*;
public class Song {
	private String title,genre;
	private Date duration ;
	private double rating;
	void setTitle(String t)
	{this.title=t;}
	void setGenre(String g)
	{this.genre=g;}
	void setDuration(Date d) 
	{this.duration=d;}
	void setRating(double r)
	{this.rating=r;}
	String getTitle()
	{return this.title;}
	String getGenre() 
	{return this.genre;}
	double getRating()
	{return this.rating;}
	Date getDuration()
	{return this.duration;}
	public Song() throws ParseException{
		setTitle("song");
		setGenre("Gener");
		setDuration(new SimpleDateFormat("mm:ss").parse("05.20"));
		setRating(5.0);
	}
	public Song(String title, String genre, Date duration, Double rating) {
		setTitle(title);
		setGenre(genre);
		setDuration(duration);
		setRating(rating);
	}
	static Song createSong(String line) throws ParseException {
		String[] s=line.split(",");
		
		return new Song(s[0],s[1],new SimpleDateFormat("mm:ss").parse(s[2]),Double.valueOf(s[3]));
	}
	public static void main(String[] args) throws ParseException {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of songs:");
		int n=sc.nextInt();
		ArrayList<Song> allsong=new ArrayList<Song>();
		String sname,sgenre,sduration,srating;
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<n;i++) {
			allsong.add(createSong(sc.next()));
		}
		System.out.println("Enter a type to sort\n1.Duration Sort\n2.Time Sort");
		int opt=sc.nextInt();
		
		switch(opt) {
		case 1:
			Collections.sort(allsong,(Song s1,Song s2)->(s1.getDuration().getTime()<s2.getDuration().getTime())?-1:(s1.getDuration().getTime()>s2.getDuration().getTime())?1:0);
			System.out.println("Title\tGenre\tDuration\tRating");
			for(Song s:allsong)
				System.out.format("%-20s %-10s %-12s %-12s\n",s.getTitle(),s.getGenre(),new SimpleDateFormat("mm:ss").format(s.getDuration()),s.getRating());
			break;
		case 2:
			Collections.sort(allsong,(Song s1,Song s2)->(s1.getRating()<s2.getRating())?-1:(s1.getRating()>s2.getRating())?1:0);
			System.out.println("Title\tGenre\tDuration\tRating");
			for(Song s:allsong)
				System.out.format("%-20s %-10s %-12s %-12s\n",s.getTitle(),s.getGenre(),new SimpleDateFormat("mm:ss").format(s.getDuration()),s.getRating());
			break;
			case 3:System.out.println("Invalid Input");
		}
	}

}

