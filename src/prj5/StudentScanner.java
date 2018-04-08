package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StudentScanner
{
    //~ Fields ................................................................
    private Scanner scn;
    
    //190,10/19/15 14:45,Math or CMDA,Southeast,music,No,No,Yes,Yes,Yes,Yes,No,No,Yes,Yes,Yes,No,Yes,
    //No,No,No,No,No,,,Yes,Yes,No,No,No,No,Yes,Yes,Yes,No,No,No,Yes,Yes,Yes,Yes,No,No,Yes,Yes,Yes,Yes,
    //Yes,Yes,No,No,Yes,No,Yes,Yes,Yes,Yes,No,No,No,No,Yes,No,Yes,Yes,No,No,No,No,Yes,No,Yes,Yes,No,No,
    //Yes,Yes,No,No,Yes,Yes,No,No,No,No,Yes,No,Yes,No,No,No,Yes,No,Yes,No,Yes,Yes,Yes,Yes,Yes,Yes,
    //No,No,Yes,Yes,Yes,Yes,Yes,No,Yes,No,Yes,Yes,No,No,No,No,No,No,No,No,Yes,Yes
    //~ Constructors ..........................................................
    public StudentScanner()
        throws FileNotFoundException
    {

        scn = new Scanner(
            new File(
                "C:\\Users\\lil bo peep\\Downloads\\Prj5TestingInputFiles_20151116 (1).zip\\InputFiles\\MusicSurveyData.csv"));
        scn.useDelimiter(",");
        System.out.print(scn.next());
       

    }
    //~Public  Methods ........................................................
    public 
}
