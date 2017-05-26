package tesseractprova;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.sourceforge.tess4j.*;

public class TesseractProva {
    
    public String bojeShqip(String result)
        {
        char[] albresult = result.toCharArray();
            
            for(int i=0;i<result.length();i++)
            {if(albresult[i]=='é')
            {albresult[i]='ë';}
                
            }
            result = String.valueOf(albresult);
            return result;
        }
    
    /*private List<String> loadFile() {
    List<String> list = null;
    URI uri = null;

    try {
        uri = ClassLoader.getSystemResource("example.txt").toURI();
    } catch (URISyntaxException e) {
        LOGGER.error("Failed to load file.", e);
    }

    try (Stream<String> lines = Files.lines(Paths.get(uri))) {
        list = lines.collect(Collectors.toList());
    } catch (IOException e) {
        LOGGER.error("Failed to load file.", e);
    }
    return list;
    }*/

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
/*
List<String> lines = Arrays.asList(
        
    new Scanner(new File("shqip/100-fjale.txt")).useDelimiter("\\Z").next().split("[\\r\\n]+")
);*/

    
public static String bojeNdryshiminPasNjohjes(String result)
        {       
            
                String s1=result;  
                String[] pergjigje=s1.split("\\s");//splits the string based on whitespace  
                //using java foreach loop to print elements of string array  
                for(String w:pergjigje){  
                //System.out.println(w);  
                }  
                //System.out.println(pergjigje.length);
                //System.out.println(pergjigje[pergjigje.length-1]);
                
                String pergjigjeja= "";
                
                for(int i=0;(pergjigje.length)>i;i++)
                {pergjigjeja=pergjigjeja+" "+pergjigje[i];
//pergjigjeja=pergjigjeja.trim();
                        }       
                        
            return pergjigjeja;
        }

public static String[] tekstiPerTestim(String result)
        {       
            
                String s1=result;
                //String[] testojeFragmenti = (String[]) result.toArray(); 
                //String[] testojeFragmenti = new String[result.size()];result.toArray(testojeFragmenti);
               String[] testojeFragmenti=s1.split("\\s");//splits the string based on whitespace  
                //using java foreach loop to print elements of string array  
                for(String w:testojeFragmenti){  
                //System.out.println(w);  
                }  
                          
            return testojeFragmenti;
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


    public static boolean compareList(List ls1,List ls2){
        return ls1.toString().contentEquals(ls2.toString())?true:false;
    }
    
    public static List<String> ngaArrayListNeArrayList()
         {List<String> ngaArrayListNeString = new ArrayList<String>();List<String> lista = new ArrayList<String>();
         lista=merrNgaTxt("shqip/100000-orig.txt");int l=0;
         for(int i=0; i<lista.size() ; i++)
         {  l =(lista.get(i)).length()-1; 
             for(int j=l; j>0; j--)
             {
                if( ((lista.get(i)).charAt(l))== ((lista.get(i)).toUpperCase()).charAt(l))
                {l=l-1;}
             }
             if( !(((lista.get(i)).charAt(l))== ((lista.get(i)).toUpperCase()).charAt(l)) && l<(lista.get(i)).length()-1 )
             {  String stringuFrag="";
                for(int c=0; c<l+1; c++)
                {
                    stringuFrag = stringuFrag + ((lista.get(i)).charAt(c));
                }
                lista.set(i, stringuFrag);
             }
         
         }
         
         return lista;
    }
    

    
    public static void main(String[] args) {
        // ImageIO.scanForPlugins(); // for server environment
        String lokacioni = "shqip/test";
        MarrjaEHyrjeveNgaFolderi merrNgaFolderi = new MarrjaEHyrjeveNgaFolderi();
        
        //List<String> fotot = merrNgaFolderi.listFileToString(merrNgaFolderi.exploreThis(lokacioni));
        List<File> fajllat =merrNgaFolderi.exploreThis(lokacioni);
        
        int nrMax=2;String l="";
       //for(int i=0;i<nrMax;i++){
        
        for(int c=0; c<fajllat.size(); c++)
        {File imageFile  = fajllat.get(c);
        
        
        //}
        ITesseract instance = new Tesseract(); // JNA Interface Mapping
        // ITesseract instance = new Tesseract1(); // JNA Direct Mapping
        // instance.setDatapath("<parentPath>"); // replace <parentPath> with path to parent directory of tessdata
       instance.setLanguage("sqi");

        TesseractProva TProva = new TesseractProva();
        TestojePerGabim ts;
        PermisojeGabimin tp;
        
        try {
            //for(int i=0;i<)result= result ;
            String result = instance.doOCR(imageFile);
          //  String result2 = instance.doOCR(imageFile1);
            //System.out.println(TProva.tekstiPerTestim(result));
            //JOptionPane.showInputDialog(TProva.tekstiPerKontrollim(result),"hey");
            String fjalimitest = result;
            String fjala1 =""; String fjala2=""; String fjala3="";String fjala4="";
            fjala1= fjalimitest.substring(0,fjalimitest.length()/2);fjala2= fjalimitest.substring(fjalimitest.length()/2,fjalimitest.length());
            /*System.out.println(fjala1); System.out.println(fjala2); */
            System.out.println(result);
            
            System.out.println(tekstiPerKontrollim(result));
            System.out.println("Merri nga txt qoj ne array: "+merrNgaTxt("shqip/100-fjale.txt"));
            System.out.println("Gjatesi: " + merrNgaTxt("shqip/100-fjale.txt").size());List<String> wives=merrNgaTxt("shqip/100-fjale.txt");
            System.out.println("dsad: "+ wives.get(0));
            ts =new TestojePerGabim(tekstiPerKontrollim(result),merrNgaTxt("shqip/100000-fjalor.txt"));
          //compareList(TestojePerGabim.fjaletEGabuara.get(0) ,TestojePerGabim.fjaletEFjalorit.get(0));
          //System.out.println(Arrays.toString(ts.krahasoNeFjalor()));
          System.out.println(Arrays.toString(ts.krahasoNeFjalor()));
          //JOptionPane.showInputDialog(Arrays.toString(ts.gabimNeZanore(3)));
          System.out.println(Arrays.toString(ts.gabimNeBashtingllore(5)));
          tp = new PermisojeGabimin(result,ts.indeksiIteGjithaFG());
          System.out.println(ts.indeksiIteGjithaFG());
          tp.aktivizoNormalText();
          //String fjalimitest = tp.permisojegabiminM1();
          
          //fjala1= fjalimitest.substring(0,154);fjala2= fjalimitest.substring(154,fjalimitest.length());
          //System.out.println(fjala1); System.out.println(fjala2); System.out.println(fjala3);
          
         System.out.println("hey fillim:   "+tp.permisojegabiminM2()+" hey - mbarim");
         
         fjalimitest = tp.permisojegabiminM2();
         fjala1= fjalimitest.substring(0,fjalimitest.length()/2);fjala2= fjalimitest.substring(fjalimitest.length()/2,fjalimitest.length());
         System.out.println(fjala1); System.out.println(fjala2); 
      
  
        
        
        
      //  System.out.println(merrNgaFolderi.textFiles1(lokacioni));
      //  System.out.println(merrNgaFolderi.exploreThis(lokacioni));
        
         
         /**List<String> test1 = new ArrayList<String>();
         test1 = ngaArrayListNeArrayList();
         for(int i =0; i< test1.size(); i++)
         {System.out.println( test1.get(i) );}*/
         //JOptionPane.showMessageDialog(null, ngaArrayListNeArrayList());
         //JOptionPane.showMessageDialog(null, ngaArrayListNeArrayList(), "System Information", JOptionPane.INFORMATION_MESSAGE); 
         
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        }
    }
    }
}