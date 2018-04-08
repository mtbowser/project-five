package prj5;

import CS2114.Window;
import java.awt.Button;

/**
 * 
 * // -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 * 
 *  @author lil bo peep
 *  @version Apr 8, 2018
 */
public class GUIWindow extends Input 
{
    //~ Fields ................................................................
    Button next;
    Button prev; 
    Button byHobby;
    Button byMajor;
    Button byGenre;
    Button quit;
    Window window;
    GUIGlyph[] glyphs;

    
    //~ Constructors ..........................................................
    public GUIWindow()
    {
        window = new Window();
        
        
    }
    //~Public  Methods ........................................................
    public void clickedQuit()
    {
        //quit.
    }
    

}
