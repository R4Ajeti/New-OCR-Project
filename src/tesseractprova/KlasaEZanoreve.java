/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tesseractprova;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Home
 */
public class KlasaEZanoreve {

public KlasaEZanoreve()
{}
    
public static boolean aEshteZanore(char z)
{boolean pergjigje = false;
if(z=='a'||z=='e'||z=='ë'||z=='i'||z=='o'||z=='u'||z=='y')
{pergjigje = true;}
return pergjigje;
}

public static int saZanore(String z)
{int pergjigje = 0;
for(int i=0;i<(z.length());i++)
{
if( ((aEshteZanore(z.charAt(i))))== true){pergjigje=pergjigje+1;}
}
return pergjigje;
}

public static int saZanore1(String z)
{int pergjigje = 0;
for(int i=0;i<(z.length());i++)
{
if( z.charAt(i)=='a'||z.charAt(i)=='e'||z.charAt(i)=='ë'||z.charAt(i)=='i'||z.charAt(i)=='o'||z.charAt(i)=='u'||z.charAt(i)=='y'){pergjigje=pergjigje+1;}
}
return pergjigje;

}

public static List<Character> saZanore(String z, int pozita)
{int gjatesiaefj=z.length(); char[] pergjigje=new char[gjatesiaefj];
List<Character> chars = new ArrayList<>();
int count =-1;
for(int i=0;i<(gjatesiaefj);i++)
{if(i==0){i=i+pozita;}
if( ((aEshteZanore(z.charAt(i))))== true){count=count+1; chars.add(z.charAt(i));}
}
return chars;
}

public static char[] cilatZanore(String z, int pozita)
{int gjatesiaefj=z.length(); char[] pergjigje=new char[gjatesiaefj];
int count =-1;
for(int i=0;i<(gjatesiaefj);i++)
{if(i==0){i=i+pozita;}
if( ((aEshteZanore(z.charAt(i))))== true){count=count+1; pergjigje[count]=z.charAt(i);}
}
return pergjigje;
}
    
}
