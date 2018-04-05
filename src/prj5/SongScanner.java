package prj5;

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
    String  fakeData;


    // ~ Constructors ..........................................................
    // Uma Thurman,Fall Out Boy,2015,rock
    // Upside Down,Diana Ross,1980,disco
    // Watching the Detectives,Elvis Costello,1977,punk
    public SongScanner()
    {
        fakeData = "Uma Thurman,Fall Out Boy,2015,rock\r\n"
            + "Upside Down,Diana Ross,1980,disco\r\n"
            + "Watching the Detectives,Elvis Costello,1977,punk\r\n";
        Scanner scn = new Scanner(fakeData);
        System.out.print(scn.next());

    }
    // ~Public Methods ........................................................
    public Song loadSongs() 
    {
        
    }

}
