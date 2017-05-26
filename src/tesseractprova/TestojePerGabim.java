/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tesseractprova;


import java.util.List;

/**
 *
 * @author Home
 */
public class TestojePerGabim {
    private List<String> fjaletEGabuara;
    private List<String> fjaletEFjalorit;
    public TestojePerGabim(List<String> g,List<String> f)
    {   fjaletEGabuara=g;
        fjaletEFjalorit=f;
        
    }
    KlasaEZanoreve zanoreKlasa = new KlasaEZanoreve();
    

    public static boolean compareList(List ls1,List ls2){
        return ls1.toString().contentEquals(ls2.toString())?true:false;
    }
    
    public boolean[] gabimNeZanore(int z)
    {   boolean[] listaEKeqeZ = new boolean[fjaletEGabuara.size()];
        
        for(int i=0; i<(fjaletEGabuara.size());i++)    
        {  int k=0;
            for(int j=0; j<((fjaletEGabuara.get(i)).length()); j++)
            {   
                
                 if(zanoreKlasa.aEshteZanore((((fjaletEGabuara.get(i)).toLowerCase()).charAt(j))))
                            {k=k+1;}
                        else{k=0;}
                 if(k>=z)
                {listaEKeqeZ[i]=true; continue;//j=((fjaletEGabuara.get(i)).length());
                }
            }
        }
        return listaEKeqeZ;
    }
    
    public boolean[] gabimNeBashtingllore(int z)
    {   boolean[] listaEKeqeB = new boolean[fjaletEGabuara.size()];
        
        for(int i=0; i<(fjaletEGabuara.size());i++)    
        {  int k=0;
            for(int j=0; j<((fjaletEGabuara.get(i)).length()); j++)
            {   
                
                 if(!(zanoreKlasa.aEshteZanore((((fjaletEGabuara.get(i)).toLowerCase()).charAt(j)))))
                            {k=k+1;}
                        else{k=0;}
                 if(k>=z)
                {listaEKeqeB[i]=true; continue;//j=((fjaletEGabuara.get(i)).length());
                }
            }
        }
        return listaEKeqeB;
    }
    
    public boolean[] krahasoNeFjalor()
    {   //ArrayList<Boolean> listaEKeqe =  new ArrayList<Boolean>();
       // String[] listaEKeqe = new String[100];
       boolean[] listaEKeqe = new boolean[fjaletEGabuara.size()];
    
    for(int i=0; i<(fjaletEGabuara.size());i++)    
    {   for(int j=0; j<(fjaletEFjalorit.size()); j++)
        {   
            if(fjaletEFjalorit.get(j).equals((fjaletEGabuara.get(i)).toLowerCase())){listaEKeqe[i]=true;}
        }
    }
    /*
    System.out.println("hjkh: "+listaEKeqe.length);
    System.out.println("hjkh: "+listaEKeqe[0]);
    System.out.println("hjkh: "+fjaletEGabuara.size());*/
   /* for(int i=0; i<fjaletEGabuara.size(); i++){
    listaEKeqe = compareList(fjaletEGabuara.get(i) ,fjaletEFjalorit.get(i));
    }*/
        return listaEKeqe;
    }
    
    public boolean krahasoFjalenNeFjalor(String fjala)
    {boolean aEkzFjala=false;
    
    for(int j=0; j<(fjaletEFjalorit.size()); j++)
        {   
            if(fjaletEFjalorit.get(j).equals((fjala).toLowerCase())){aEkzFjala=true;}
        }

        return aEkzFjala;
    }
    
    public String ndrroSHkronjeNeFjale(String fjala, char shkronjaP, char shkronjaS)
    {   String fjalaERe = "";
        if(!fjala.equals("")){
            for(int i=0; i<fjala.length(); i++)
            {       if(fjala.charAt(i)==shkronjaP){fjalaERe=fjalaERe+shkronjaS;}
                else{fjalaERe=fjalaERe+fjala.charAt(i);}
            }
        }
        return fjalaERe;
    }
    
    public String ndrroVetemNjeSHkronjeNeFjale(String fjala, char shkronjaP, char shkronjaS)
    {   String fjalaERe = ""; boolean testNdrrimi = false;
        if(!fjala.equals("")){
            for(int i=0; i<fjala.length(); i++)
            {       if(fjala.charAt(i)==shkronjaP&&!testNdrrimi){fjalaERe=fjalaERe+shkronjaS;testNdrrimi=true;}
                else{fjalaERe=fjalaERe+fjala.charAt(i);}
            }
        }
        return fjalaERe;
    }
    public String ndrroShkronjeNePozit(String fjala, int pozita, char shkronjaS)
    {   String fjalaERe = "";
        if(!fjala.equals("")){
            for(int i=0; i<fjala.length(); i++)
            {       if(i==pozita){fjalaERe=fjalaERe+shkronjaS;}
                else{fjalaERe=fjalaERe+fjala.charAt(i);}
            }
        }
        return fjalaERe;
    }
    
    public boolean aEPermbanFjalaShkronjen(String fjala, char shk)
    {boolean aEPermban = false;
        if(!fjala.equals("")){    for(int j=0; j<(fjala).length(); j++)
                    {  if( ((fjala).toLowerCase()).charAt(j)==shk)
                        {aEPermban=true;}
                    }
        }
    return aEPermban;}
    public int pozitaEShkronjesNeFjale(String fjala, char shk)
    {int pozita=0;
        if(!fjala.equals("")){    
                for(int j=0; j<(fjala).length(); j++)
                    {  if( ((fjala).toLowerCase()).charAt(j)==shk)
                        {pozita=j;}
                    }
        }
    return pozita;}
    
    public boolean aERrethBashkShkroNeFjale(String fjala, char shk)
    {boolean aERrethojne = false; boolean aEPermban = false;
        if(!fjala.equals("")){    
                for(int j=0; j<(fjala).length(); j++)
                {  if( ((fjala).toLowerCase()).charAt(j)==shk)
                    {aEPermban=true;
                            if(j==0){if( zanoreKlasa.aEshteZanore(((fjala).toLowerCase()).charAt(j+1))== false)
                                {aERrethojne=true;}
                            }
                            else if(j==(fjala).length()-1){if( zanoreKlasa.aEshteZanore(((fjala).toLowerCase()).charAt(j-1))== false)
                                {aERrethojne=true;}
                            }
                            else{
                                if( zanoreKlasa.aEshteZanore(((fjala).toLowerCase()).charAt(j-1))== false && zanoreKlasa.aEshteZanore(((fjala).toLowerCase()).charAt(j+1))== false)
                                {aERrethojne=true;}
                            }
                    }
                }
        }
    return aERrethojne;}
    
    
    public boolean[] indeksiIteGjithaFG()
    {boolean[] indeksiIFjaleveTeGabuara = new boolean[fjaletEGabuara.size()];
    
    boolean[] bol1 = this.krahasoNeFjalor();
    boolean[] bol2 = this.gabimNeZanore(3);
    boolean[] bol3 = this.gabimNeBashtingllore(5);
    
    for(int i=0; i<fjaletEGabuara.size();i++)
    {if(bol1[i]==false||bol2[i]==true||bol3[i]==true){indeksiIFjaleveTeGabuara[i]=true;}
    else {indeksiIFjaleveTeGabuara[i]=false;}
    }
    System.out.println(this.krahasoNeFjalor().length+"   "+this.gabimNeZanore(3).length+"   "+this.gabimNeBashtingllore(5).length+" "+fjaletEGabuara.size()+"  "+indeksiIFjaleveTeGabuara.length);
    return indeksiIFjaleveTeGabuara;
    }
    
    public boolean aEshteSakte(boolean test)
    { boolean eshte = false;
    if(test == true){eshte = true;}
    return eshte;
    }
    
}