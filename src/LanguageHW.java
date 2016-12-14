/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.sql.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Stacy
 */
public class LanguageHW 
{
    private List LNames, Words;
    private JLabel Language, Values, output;
    private JButton search;
    private java.sql.Statement stmt = null;
    /**
     * Constructor, creates our window with the proper components
     */
    public LanguageHW()
    {   //create the window and the components that go inside it
        WsuWindow win = new WsuWindow();
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
        win.repaint();
        this.Database();
        this.application();
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
            }
            //add 1-10 ti tge value box
            for(int i = 0; i<10; i++)
                {
                    Words.add(i+"");
                }
        }catch(Exception e)
        {
            System.err.println("Error running query \" " + sql +
                    " \" " + e.getMessage());
        }
    }
    
   public void application()
   {
        Map<String,Map<Integer, String>> map;
        map = new HashMap<String, Map<Integer,String>>();
        String sql = "SELECT langname, meaning_id, word FROM Vocab "
                + "INNER JOIN Language ON language.ID = Vocab.lang_id";
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
        System.out.println(map.size());
        
     }catch(Exception e)
     {
         System.err.println("App query failed: "+e.getMessage());
         return;
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
