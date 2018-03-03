import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Properties;

public class Island
{
    static String ownerName = "\"ownerName\":\"";
    static String xCoord = "\"xCoord\":\"";
    static String yCoord = "\"yCoord\":\"";
    static String allyName = "\"ownerAllyTag\":\"";
    static String allyId = "\"ownerAllyId\":\"";
    static String ownerId = "\"ownerId\":\"";
    static String cityName = "\"name\":\"";
    static String cityId = "\"id\":";
    static String level = "\"level\":\"";
    static String type = "\"type\":\"";
    static ArrayList<String> nl=new ArrayList<String>();
    static ArrayList<String> xl=new ArrayList<String>();
    static ArrayList<String> yl=new ArrayList<String>();
    static ArrayList<String> al=new ArrayList<String>();
    static ArrayList<String> il=new ArrayList<String>();
	public static String textBetweenWords(String sentence, String firstWord, String secondWord)	{
	    return sentence.substring(sentence.indexOf(firstWord) + firstWord.length(), 
	        sentence.indexOf(secondWord));
	}
	public static String twoHalfs(String s, int player)
	{
		String parts = s.substring(s.indexOf(player+2, 0));
		return parts;
	}
	public static int cities(String Island)
	{
        System.out.println("Cities");
		String copy = "";
		String typePlace = "";
		int counter = 0;
		for(int c = 0; c<=16; c++)
		{
			copy = Island;
	        for (int i = Island.indexOf(level, 0)+level.length();Island.charAt(i) != '"' ; i++)
	        {
	        	typePlace += Island.charAt(i);
	        }
	        counter++;
	        String[] lll = Island.split(level, 2);
			//System.out.println(typePlace);
			typePlace = "";
			if(lll.length>1)
			{
				Island = lll[1];
			}
			else
			{
				break;
			}
	       /* Island = "";
	        for (int i = copy.indexOf(level, 0)+level.length();i<copy.length(); i++)
	        {
	        	Island+=copy.charAt(i);
	    		System.out.println("level" +  c + "      " + counter);
		        System.out.println(Island);
	        }*/
		}
		System.out.println(counter);
		return counter;
		
	}
	public static void searchPlayer(String Island, int realcounter)
	{
        System.out.println("Players");
		//String players = "";
		String copy = "";
		String player = "";
		String x = checkX(Island);
		String y = checkY(Island);
		for(int c = 0; c<=realcounter; c++)
		{
			copy = Island;
			
	        for (int i = Island.indexOf(ownerName, 0)+13;Island.charAt(i) != '"' ; i++)
	        {
	        	player += Island.charAt(i);
	        }

	        xl.add(x);
	        yl.add(y);
	      //  Island = "";
	       // players +=player + "\n";
	        String[] lll = Island.split(ownerName, 2);
	        System.out.println(lll.length);
			if(lll.length>1)
			{
				Island = lll[1];
			}
			else
			{
				break;
			}
			/*if(player.charAt(0)=='\\')
	        {
	        	player = hexToString(player);
	       	}*/
			if (player.indexOf("\\u") != -1)
			{
				player = hexToString(player);
			}
	        nl.add(player);
	        player = "";
	        /*for (int i = copy.indexOf(ownerName)+13;i<copy.length(); i++)
	        {
	        	Island+=copy.charAt(i);
	        	System.out.println("player");
		        System.out.println(Island);
	        }*/
	        
	       // System.out.println(players);
		}
	/*	Properties p = new Properties();
		try {
			p.load(new StringReader("key="+players));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		players = p.getProperty("key");
        return players;*/
	}
	public static void Ally(String Island)
	{
        System.out.println("Ally");
		String copy = "";
		String ally = "";
			copy = Island;
		        for (int i = Island.indexOf(allyName, 0)+16;Island.charAt(i) != '"' ; i++)
		        {
		        	ally += Island.charAt(i);
		        }
				/*(ally.charAt(0)=='\\')
		        {
		        	ally = hexToString(ally);
		       	}*/
		        if (ally.indexOf("\\u") != -1)
		        {
		        	ally = hexToString(ally);
		        }
				      al.add(ally);


				ally = "";

		       /* Island = "";
		        for (int i = copy.indexOf(allyName, 0)+16;i<copy.length(); i++)
		        {
		        	Island+=copy.charAt(i);
		    		System.out.println("Ally");
			        System.out.println(Island);
		        }*/

			
	}
	public static void allyId(String Island, int realcounter)
	{
        System.out.println("allyId");
		String copy = "";
		String ally = "";
			copy = Island;
			for(int c=0;c<=realcounter;c++)
			{
		        for (int i = Island.indexOf(allyId, 0)+allyId.length();Island.charAt(i) != '"' ; i++)
		        {
		        	ally += Island.charAt(i);
		        }
		       /* Island = "";
		        for (int i = copy.indexOf(allyName, 0)+16;i<copy.length(); i++)
		        {
		        	Island+=copy.charAt(i);
		    		System.out.println("Ally");
			        System.out.println(Island);
		        }*/
		        String[] lll = Island.split(allyId, 2);
				if(lll.length>1)
				{
					Island = lll[1];
				}
				else
				{
					break;
				}
				if(ally.equals("0"))
				{
					al.add("-");
				}
				else
				{
			       Ally(Island);
				} 
				ally="";
			}
	}
	public static void ownerId(String Island, int realcounter)
	{
        System.out.println("ownerId");
		String copy = "";
		String id = "";
			copy = Island;
			for(int c = 0; c<=realcounter; c++)
			{	
		        for (int i = Island.indexOf(ownerId, 0)+11;Island.charAt(i) != '"' ; i++)
		        {
		        	id += Island.charAt(i);
		        }
		        String[] lll = Island.split(ownerId, 2);
				if(lll.length>1)
				{
					Island = lll[1];
				}
				else
				{
					break;
				}
		        /*Island = "";
		        for (int i = copy.indexOf(ownerId, 0)+11;i<copy.length(); i++)
		        {
		        	Island+=copy.charAt(i);
		    		System.out.println("ownerId");
			        System.out.println(Island);
		        }*/
			       il.add(id);
			       id = "";
			}
	}
	public static String checkX(String Island)
	{
		System.out.println("x");
		String x = "";
			for (int i = Island.indexOf(xCoord, 0)+10;Island.charAt(i) != '"' ; i++)
	        {
	        	x += Island.charAt(i);
	        }
	       /* for (int i = copy.indexOf(xCoord)+10;i<copy.length(); i++)
	        {
	        	Island+=copy.charAt(i);
		        System.out.println(Island);
	        }*/
		Properties p = new Properties();
		try {
			p.load(new StringReader("key="+x));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		x = p.getProperty("key");
        return x;
	}
	public static String checkY(String Island)
	{

		 System.out.println("search");
		String y = "";
			for (int i = Island.indexOf(yCoord, 0)+10;Island.charAt(i) != '"' ; i++)
	        {
	        	y += Island.charAt(i);
	        }
	        /*for (int i = copy.indexOf(yCoord)+10;i<copy.length(); i++)
	        {
	        	Island+=copy.charAt(i);
		        System.out.println(Island);
	        }*/
		Properties p = new Properties();
		try {
			p.load(new StringReader("key="+y));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		y = p.getProperty("key");
        return y;
	}
	/*public static String delete(String s, int i)
	{
		String copy ="";
		int c = i;
		for(; i<=c+3;i++)
		{
			copy += s.charAt(i);
		}
		return copy;
		
	}*/
	public static String hexToString(String player)
	{
		String text = "";
		String s = "";
		boolean b = false;
		for(int i = 0; i <player.length(); i++)
		{
			if(player.charAt(i) == '\\' && player.charAt(i+1) == 'u') 
			{
				int d = i+2;				
				for(int c = i+2;c<=d+3;c++)
				{
					s+=player.charAt(c);
					System.out.println(s);
				}
				int hexVal = Integer.parseInt(s, 16);
				char c = (char) hexVal;
				text+=c;
				System.out.println(text);
				i+=5;
				s="";
				b=true;
			}
			else
			{
				text+=player.charAt(i);
			}
			
		}
		return text;
		
		

	}
	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
	//	URL oracle = new URL("");
		
	        /*BufferedReader in = new BufferedReader(
	        new InputStreamReader(oracle.openStream()));*/
		/*for(int y = 1; y<=99;y++)
		{
			for(int x = 1;x<=99;x++)
			{
				FileReader fileReader = 
		                new FileReader("C:\\Users\\user\\Desktop\\תיקון טלפונים\\eclipse\\workspace\\Ikariam\\Islands\\‬1-1.log");
			 BufferedReader in = 
		                new BufferedReader(fileReader);
		        String inputLine = "";
		        inputLine += in.readLine();
		        in.close();
		        String x1 = checkX(inputLine);
		        String y1 = checkY(inputLine);
		        if(!(x1!=Integer.toString(x) && y1!=Integer.toString(y)))
		        {
			        String players = "";
			        //players = searchPlayer(inputLine);
			        searchPlayer(inputLine);
		        }
		        else
		        {
		        	System.out.println("null");
		        }
			}
		}*/
			
			 
			 

		        // players = searchPlayer(inputLine);
		        /*for (int i = inputLine.indexOf(player);i<inputLine.length(); i++)
		        {
	            	inputLine+=inputLine.charAt(i);
		        }*/
        File file = new File("C:\\Users\\GUY\\Desktop\\ikariam.csv");

		        for(int y = 1; y<=99;y++)
				{
					for(int x = 1;x<=99;x++)
					{
				        BufferedReader in = new BufferedReader(
				                new InputStreamReader(new FileInputStream("C:\\Users\\GUY\\Desktop\\java\\אקליפס\\eclipse\\Ikariam\\Islands\\"+x+"-"+y+".log"), "UTF-8"));
						FileReader fileReader = 
				                new FileReader("C:\\Users\\GUY\\Desktop\\java\\אקליפס\\eclipse\\Ikariam\\Islands\\"+x+"-"+y+".log");
						//BufferedReader in = 
				            //    new BufferedReader(fileReader);
						String inputLine = "";
				        inputLine += in.readLine();
				        in.close();
			        String x1 = checkX(inputLine);
			        String y1 = checkY(inputLine);
			        System.out.println(x+":"+y);
			        if((x1.equals(Integer.toString(x)) && y1.equals(Integer.toString(y))))
			        {
			        	System.out.println(x+":"+y);
			        	int realcounter = cities(inputLine);
				        searchPlayer(inputLine, realcounter);
				        allyId(inputLine, realcounter);
				        ownerId(inputLine,realcounter);
				        realcounter=0;
			        	//System.out.println(nl.size());

				        
			        }
			        /*else if(x==41 && y == 54)
			        {
			        	int realcounter = cities(inputLine);
				        searchPlayer(inputLine, realcounter);
				        Ally(inputLine, realcounter);
				        ownerId(inputLine,realcounter);
				        realcounter=0;
			        	System.out.println(nl.size());
				        for(int i=0;i<nl.size();i++)
				        {
				        	//System.out.println(nl.get(i)+" " + il.get(i) + " " + al.get(i) + " " + xl.get(i) + " " + yl.get(i));
				        	System.out.println(nl.get(i));
				        	System.out.println(il.get(i));
				        	System.out.println(al.get(i));
				        	System.out.println(xl.get(i));
				        	System.out.println(yl.get(i));
				        	op.println(nl.get(i)+"," + il.get(i) + "," + al.get(i) + "," + xl.get(i) + "," + yl.get(i)+",");
				        }
			        }*/
				}
			}
		        PrintWriter op = new PrintWriter(file);

		        for(int i=0;i<nl.size();i++)
		        {
		        	System.out.println(nl.get(i)+" " + il.get(i) + " " + al.get(i) + " " + xl.get(i) + " " + yl.get(i));
		        	/*System.out.println(nl.get(i));
		        	System.out.println(il.get(i));
		        	System.out.println(al.get(i));
		        	System.out.println(xl.get(i));
		        	System.out.println(yl.get(i));*/
		        	//op.println(nl.get(i)+"," + il.get(i) + "," + al.get(i) + "," + xl.get(i) + "," + yl.get(i)+",");
		        	op.println(nl.get(i)+"," + il.get(i) + "," + xl.get(i) + "," + yl.get(i)+",");
		        }
		        op.close();


		        	

	}
}
