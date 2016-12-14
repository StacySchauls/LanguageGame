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
    private Map<String,String> map = null;
    private int id, lang_id, meaning_id;
    private String langname,word;

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
        Map<Integer, String> map2;
        map2 = new HashMap<Integer, String>();
        
       //queries
       String sql5 = "SELECT langname FROM Language";
       String sql = "SELECT ID FROM Language";
       String sql2 = "SELECT lang_id FROM Vocab";
       String sql3 = "SELECT meaning_id FROM Vocab";
       String sql4 = "SELECT word FROM Vocab";
     try
     {
         //query 1
        
         //System.out.println("Query5 successful.");
         
         
         java.sql.ResultSet rs1 = stmt.executeQuery(sql);
         //System.out.println("Query1 successful.");
         while(rs1.next())
         {
              id = rs1.getInt("ID");
         }
         java.sql.ResultSet rs2 = stmt.executeQuery(sql2);
         //System.out.println("Query2 successful.");
         while(rs2.next())
         {
              lang_id = rs2.getInt("lang_id");
         }
         
         //System.out.println("Query3 successful.");
         //while(rs3.next())
         {
             
         }
         java.sql.ResultSet rs3 = stmt.executeQuery(sql3);
         java.sql.ResultSet rs4 = stmt.executeQuery(sql4);
         java.sql.ResultSet rs5 = stmt.executeQuery(sql5);
         
         //System.out.println("Query4 successful.");
         
         
             
         
         while(rs5.next())
         {
            langname = rs5.getString("langName");
            while(rs3.next())
            {
                meaning_id = rs3.getInt("meaning_id");
                  
                
                   if(rs4.next())
                    {
                        while(meaning_id <10)
                        {
                        word = rs4.getNString("word");
                        System.out.println(word);
                        System.out.println(meaning_id);
                        map2.put(meaning_id, word);
                       // map.put(langname, map2);
                       meaning_id ++;
                        }
                        
                    }

                
                  
            }
         }
       for(int key : map2.keySet())
       {
           //System.out.println(key);
           //System.out.println(map2.get(key));
       }
         
          //System.out.println("App. query successful");
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
