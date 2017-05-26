/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tesseractprova;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 *
 * @author Home
 */
public class PermisojeGabimin {
    private String result;private List<String> fjaletEGabuara;
    private TestojePerGabim ts =new TestojePerGabim(fjaletEGabuara, merrNgaTxt("shqip/100000-fjalor.txt"));
    boolean [] indeksiIteGjithaFG = null; char[] alfabeti={'a','b','c','ç','d','e','ë','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','x','y','z'};
    public PermisojeGabimin(String res, boolean[] c)
    {result = res;
    fjaletEGabuara = tekstiPerKontrollim(result);
    indeksiIteGjithaFG = c;
    }      
    
    public static List<String> tekstiPerKontrollim(String result)
        {       
            
                String s1=result;
                //String[] testojeFragmenti = (String[]) result.toArray(); 
                //String[] testojeFragmenti = new String[result.size()];result.toArray(testojeFragmenti);
               String[] testojeFragmentin=s1.split("\\s");//splits the string based on whitespace  
                //using java foreach loop to print elements of string array  
                for(String w:testojeFragmentin){  
                //System.out.println(w);  
               // String [] strings = new String [] {"1", "2" };
                }  
            List<String> testojeFragmentin1 =  new ArrayList<String>(Arrays.asList(testojeFragmentin));    
            return testojeFragmentin1;
        }
    
    public static List<String> merrNgaTxt(String fileName) {
    List<String> wives = new ArrayList<String>();
        try {
        //BufferedReader input = new BufferedReader(new FileReader(fileName));
       //BufferedReader input = new BufferedReader(new FileReader(fileName));
        BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "iso-8859-1"));
        // for each line
            for(String line = input.readLine(); line != null; line = input.readLine()) {
                wives.add(line);
            }
            input.close();
        } catch(IOException e) {
            e.printStackTrace();
            System.exit(1);
            return null;
        }
        return wives;
    }   
    
    public List<String> normalText()
    {String rezultatiIPermisuar=""; List<String> rezList = new ArrayList<String>();
        rezList = fjaletEGabuara;int mfjaleve=fjaletEGabuara.size();
        for(int i=0;i<mfjaleve;i++)
        {String fjala= fjaletEGabuara.get(i);int mfjala =(fjala).length();
            if(!fjala.equals("")){    
                for(int j=0; j<mfjala; j++)
                {  if( j>0&&j<mfjala )
                    {   if( ((fjala).toLowerCase()).charAt(j)!= (fjala).charAt(j))
                        {   String fjalaN="";
                            for(int n=0;n<mfjala;n++)
                            {
                                if(n==j){ fjalaN=fjalaN+ ((fjala).toLowerCase()).charAt(n);}
                                else{fjalaN=fjalaN+(fjala).charAt(n);}
                            }
                            fjala=fjalaN;
                        }
                    }
                }
            }
            rezList.set(i, fjala);
        }
        return rezList;
    }
    
    public void aktivizoNormalText()
    {
    this.fjaletEGabuara = normalText();
    }
    
    public String permisojegabiminM1()
    { String rezultatiIPermisuar=""; List<String> rezList = new ArrayList<String>();int[] k = new int[fjaletEGabuara.size()];
        for(int i=0; i<fjaletEGabuara.size(); i++)
        {   if(indeksiIteGjithaFG[i]==false)
                    {rezList.add(fjaletEGabuara.get(i));
                    }

            else{
            
                if(!((fjaletEGabuara.get(i)).equals(""))||!((fjaletEGabuara.get(i)).equals(" "))){  
                
                   if( ts.aEPermbanFjalaShkronjen(fjaletEGabuara.get(i), 'i') )
                        {k[i]=k[i]+1;}
                   if(ts.krahasoFjalenNeFjalor(ts.ndrroSHkronjeNeFjale(fjaletEGabuara.get(i) ,'i','t'))==true)
                        {k[i]=k[i]+1;}
                   if( ts.aERrethBashkShkroNeFjale(fjaletEGabuara.get(i), 'i') )
                        {k[i]=k[i]-1;}
                   if(k[i]>1){rezList.add(ts.ndrroSHkronjeNeFjale(fjaletEGabuara.get(i) ,'i','t') );//indeksiIteGjithaFG[i]=false;
                   }
                   else{rezList.add(fjaletEGabuara.get(i));}
                    
                }
            }
        }
        for(int i=0; i<rezList.size(); i++)
        { rezultatiIPermisuar= rezultatiIPermisuar+rezList.get(i) + "  ";
    
        }
    return rezultatiIPermisuar;
    }
    
    public String permisojegabiminM2()
    { String rezultatiIPermisuar=""; List<String> rezList = new ArrayList<String>();int[] k = new int[fjaletEGabuara.size()];
        for(int i=0; i<fjaletEGabuara.size(); i++)
        {   if(indeksiIteGjithaFG[i]==false)
                    {rezList.add(fjaletEGabuara.get(i));
                    }

            else{int gjFjales=(fjaletEGabuara.get(i)).length();
                if(!((fjaletEGabuara.get(i)).equals(""))||!((fjaletEGabuara.get(i)).equals(" "))){  
                boolean testFjala=false;
                    for(int j=0; j<gjFjales; j++)
                    {  int saShkNeAlfabet=alfabeti.length; 
                        for(int l=0; l<saShkNeAlfabet; l++){
                            if(ts.krahasoFjalenNeFjalor(ts.ndrroShkronjeNePozit(fjaletEGabuara.get(i) , j, alfabeti[l]))==true)
                            {rezList.add(ts.ndrroShkronjeNePozit(fjaletEGabuara.get(i) , j ,alfabeti[l]) ); j=gjFjales; l=saShkNeAlfabet; testFjala=true;}
                        
                        }
                       
                    }
                    if(testFjala){}
                    else {rezList.add(fjaletEGabuara.get(i));}
                }
            }
        }
        for(int i=0; i<rezList.size(); i++)
        { rezultatiIPermisuar= rezultatiIPermisuar+rezList.get(i) + "  ";
    
        }
    return rezultatiIPermisuar;
    }
    
}
