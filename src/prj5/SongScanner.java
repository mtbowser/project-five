package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 * 
 * @author lil bo peep
 * @version Apr 5, 2018
 */
public class SongScanner
{
    // ~ Fields ................................................................
    Scanner scn;


    // ~ Constructors ..........................................................

    public SongScanner()
        throws FileNotFoundException
    {

        scn = new Scanner(
            new File(
                "C:\\Users\\lil bo peep\\Downloads\\Prj5TestingInputFiles_20151116 (1).zip\\InputFiles\\SongList.csv"));
        scn.useDelimiter(",");
        System.out.print(scn.next());
        // Uma Thurman,Fall Out Boy,2015,rock
        // Uma Thurman,Fall Out Boy,2015,rock
        // Upside Down,Diana Ross,1980,disco
        // Watching the Detectives,Elvis Costello,1977,punk

    }


    // ~Public Methods ........................................................
    public SongList<Song> loadSongs(Scanner scn)
    {
        SongList<Song> songs = new SongList<Song>();

        while (scn.hasNext())
        {
            String str = scn.nextLine();
            String[] songInfo = str.split(",");
            Song song =
                new Song(songInfo[0], songInfo[1], songInfo[2], songInfo[3]);
           songs.add(song);
           
        }
        return songs;
    }
   

}
