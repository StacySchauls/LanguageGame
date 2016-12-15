import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

/**
 *  Class to implement a simple GUI to match and search languages with
 * their first 10 numbers.
 * @author Stacy Schauls    
 * @version Challenge
 */
public class LanguageHW implements ActionListener
{
    //fields used
    private WsuWindow win;
    private List LNames, Words, LNames2, Words2, Random;
    private JLabel Language, Values, output, output2, good, language2, value2;
    private JButton search, select, check;
    private java.sql.Statement stmt = null;
    private Map<String,Map<Integer, String>> map;
    private String lang;
    private int meaning, randomNum;
       
    /**
     * Constructor, creates our window with the proper components
     */
    public LanguageHW()
    {  
        
        //create the window and the components that go inside it
        //MINIMAL VERSION
        win = new WsuWindow();
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //scrolling list for the languages and values
        //language
        LNames = new List();
        LNames.setSize(100,80);
        LNames.setLocation(20,35);
        //values
        Words = new List();
        Words.setSize(110,80);
        Words.setLocation(150,35);
        
        //the label for the language list and words
        Language = new JLabel("Language");
        Values = new JLabel("Value");
        Language.setSize(100,20);
        Language.setLocation(25,15);
        Values.setSize(100,20);
        Values.setLocation(155,15);
        
        //Search bar
        search = new JButton("Search");
        search.setSize(80,30);
        search.setLocation(280, 35);
        output = new JLabel("Output");
        output.setFont(new Font("Arial", Font.BOLD, 16));
        output.setSize(110,30);
        output.setLocation(265,75);
        output.setHorizontalAlignment(0);
        
        //add the components to the window
        win.add(LNames); win.add(Words);  win.add(Language); win.add(Values);
        win.add(search); win.add(output);
        //STANDARD VERSION
        //buttons
        select = new JButton("Select");
        select.setSize(70,30);
        select.setLocation(20, 160);
        win.add(select);
        
        check = new JButton("Check");
        check.setSize(80,30);
        check.setLocation(280,160);
        win.add(check);
        
        
        //output label
        output2 = new JLabel();
        output2.setFont(new Font("Arial", Font.BOLD, 16));
        output2.setSize(70,20);
        output2.setLocation(20, 200);
        output2.setHorizontalAlignment(0);
        win.add(output2);
        
        good = new JLabel();
        good.setFont(new Font("Arial", Font.BOLD, 16));
        good.setSize(110,30);
        good.setLocation(265,200);
        good.setHorizontalAlignment(0);
        win.add(good);
        
        //lists
        LNames2 = new List();
        LNames2.setSize(90,80);
        LNames2.setLocation(110,160);
        win.add(LNames2);
        
        Words2 = new List();
        Words2.setSize(40,80);
        Words2.setLocation(220,160);
        win.add(Words2);
        //labels
        language2 = new JLabel("Language");
        language2.setSize(115,20);
        language2.setLocation(115,140);
        win.add(language2);
        
        value2 = new JLabel("Value");
        value2.setSize(100,20);
        value2.setLocation(225,140);
        win.add(value2);
        //separation rectangle
        WsuRectangle rect = new WsuRectangle();
        rect.setSize(355,3);
        rect.setLocation(15,130);
        win.add(rect);
  
        Random = new List();
        win.repaint();
        this.Database();
        this.mapping();
        
    }
    
    /**
     * Method to connect to the database and populate the lists
     */
    public void Database()
    {
        //connect to the driver
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver").newInstance();
           // System.out.println("connection To Driver Successful.");
        }catch(Exception e)
        {
            System.err.println("Error Connecting to driver: " + e.getMessage());
        }
        
        //open the connection to the database
        Connection con;
        String url = "jdbc:ucanaccess://src/counting.accdb";
        
        try
        {
            con = java.sql.DriverManager.getConnection(url);
           // System.out.println("Connection to database established.");
        }catch(Exception e)
        {
            System.err.println("Error establishing connection: " + e.getMessage());
            return;
        }
        
        //create a statement
        
        try
        {
            stmt = con.createStatement();
           // System.out.println("Statement created.");
        }catch (Exception e)
        {
            System.err.println("Error creating statement: "+e.getMessage());
        }
        
        //the queries
        String sql = "SELECT * FROM Language";
        String sql2 = "SELECT word FROM Vocab";
        
        //run the queries
        try
        {
            java.sql.ResultSet rs = stmt.executeQuery(sql);
            //System.out.println("Query successful.");
            while(rs.next())
            {
                //add the languages to the language list
                String lname = rs.getString("langName");
                LNames.add(lname);
                LNames2.add(lname);
            }
            java.sql.ResultSet rs2 = stmt.executeQuery(sql2);
            while(rs2.next())
            {
                String word = rs2.getString("word");
                Random.add(word);
            }
            //add 1-10 ti tge value box
            for(int i = 1; i<11; i++)
                {
                   // Words.add(i+"");
                    Words2.add(i+"");
                }
        }catch(Exception e)
        {
            System.err.println("Error running query \" " + sql +
                    " \" " + e.getMessage());
        }
    }
    
    /**
     * Method to map the values 
     */
    public void mapping()
   {
       //create the map
         map = new HashMap<String, Map<Integer,String>>();
        String sql = "SELECT langname, meaning_id, word FROM Vocab "
                + "INNER JOIN Language ON language.ID = Vocab.lang_id";
        //run the query 
     try
     {
        java.sql.ResultSet rs = stmt.executeQuery(sql);
        
        while(rs.next())
        {
            String langName = rs.getString("langname");
            int meaning_id = rs.getInt("meaning_id");
            String word = rs.getString("word");
            
            if(! map.containsKey(langName))
            {
                map.put(langName, new HashMap<Integer, String>());
            }
            map.get(langName).put(meaning_id, word);
        }
       
        
     }catch(Exception e)
        {
            System.err.println("App query failed: "+e.getMessage());
            return;
        }
     //Actionlisteners for each componenet as needed
    LNames.addActionListener(this);
    search.addActionListener(this);
    select.addActionListener(this);
    check.addActionListener(this);
     
   }
  
  /**
     * Method for the action listener for each button clicked
     * @param the action event
     */
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource().equals(LNames))
        {
              
              lang = LNames.getSelectedItem();
             Words.clear();
              
//            meaning = Words.getSelectedIndex();
//            output.setText(this.searching(lang, meaning));
              for(int i=0; i<10; i++)
              {
                 Words.add(map.get(lang).get(i));
              }   
            win.repaint();
        }else if(e.getSource().equals(select))
        {
            java.util.Random random = new java.util.Random();
            randomNum = random.nextInt(199-0) + 0;
            System.out.println(randomNum);
            output2.setText(Random.getItem(randomNum));
            
        }else if(e.getSource().equals(check))
        {
            lang = LNames2.getSelectedItem();
            meaning = Words2.getSelectedIndex();
            System.out.println(lang+" "+ meaning);
            if(map.get(lang).get(meaning).equals(Random.getItem(randomNum)))
            {
                good.setText("Good");
            }else
            {
                good.setText("Bad");
            }
        }
    }
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        LanguageHW lang = new LanguageHW();
    }
}
