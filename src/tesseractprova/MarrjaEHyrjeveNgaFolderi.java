/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tesseractprova;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.WildcardFileFilter;

/**
 *
 * @author Home
 */
public class MarrjaEHyrjeveNgaFolderi {
    static List<String> textFiles1(String lokacioni) {
        List<String> textFiles1 = new ArrayList<String>();
        File dir = new File(lokacioni);
        for (File file : dir.listFiles()) {
            if (file.getName().toLowerCase().endsWith((".jpg"))) {
                textFiles1.add(file.getName());
            }
        }
        return textFiles1;
    }
  
List <File> exploreThis(String dirPath)
    {

        File topDir = new File(dirPath);

        List<File> directories = new ArrayList<>();
        directories.add(topDir);

        List<File> textFiles = new ArrayList<>();

        List<String> filterWildcards = new ArrayList<>();
        filterWildcards.add("*.jpg");
        filterWildcards.add("*.jpeg");
        filterWildcards.add("*.png");

        FileFilter typeFilter = new WildcardFileFilter(filterWildcards);

        while (directories.isEmpty() == false)
        {
            List<File> subDirectories = new ArrayList();

            for(File f : directories)
            {
                subDirectories.addAll(Arrays.asList(f.listFiles((FileFilter)DirectoryFileFilter.INSTANCE)));
                textFiles.addAll(Arrays.asList(f.listFiles(typeFilter)));
            }

            directories.clear();
            directories.addAll(subDirectories);


        }

        return textFiles;

}
    public List<String> listFileToString(List<File> textFiles)
    {   List<String> listaNeString = new ArrayList<String>();
        
        for (File file : textFiles)
        {
            listaNeString.add(file.getName());
        }
        
        return listaNeString;
    }
    
    public void printJPG(){
        File folder = new File("shqip");
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
                    if (listOfFiles[i].isFile()) {
                        System.out.println("File " + listOfFiles[i].getName());
                  //  if(listOfFiles[i].endsWith(".png")){System.out.println("JPG File " + listOfFiles[i].getName());}
                }   else if (listOfFiles[i].isDirectory()) {
                System.out.println("Directory " + listOfFiles[i].getName());
            }
        }
    }
}
