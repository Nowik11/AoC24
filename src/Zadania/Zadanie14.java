package Zadania;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Zadanie14 {

    public static int wykonaj_a()
    {
        int height = 103;
        int width = 101;
        int time=100;
        ArrayList<zad14_wektory> lista = new ArrayList<>();
        Wczytywanie.wczytaj14(lista, "zadanie14.txt");
        int quadrant1=0;
        int quadrant2=0;
        int quadrant3=0;
        int quadrant4=0;
        for(int i=0;i<lista.size();i++)
        {
            int px = (lista.get(i).getPx() +time *lista.get(i).getVx())%width;
            if(px<0)
                px+=width;
            int py = (lista.get(i).getPy() +time *lista.get(i).getVy())%height;
            if(py<0)
                py+=height;
            if(px<width/2 && py<height/2)
            {
                quadrant1++;
            } else if (px<width/2 && py>height/2 ) {
                quadrant2++;

            } else if (px>width/2 && py<height/2) {
                quadrant3++;

            }
            else if (px>width/2 && py>height/2 ) {
                quadrant4++;
            }
        }
        return quadrant1*quadrant2*quadrant3*quadrant4;
    }
    public static void wykonaj_bXD(int time)
    {
        int height = 103;
        int width = 101;
        ArrayList<zad14_wektory> lista = new ArrayList<>();
        Wczytywanie.wczytaj14(lista, "zadanie14.txt");
        int[][] tab = new int[103][101];
        for(int i=0;i<lista.size();i++)
        {
            int px = (lista.get(i).getPx() +time *lista.get(i).getVx())%width;
            if(px<0)
                px+=width;
            int py = (lista.get(i).getPy() +time *lista.get(i).getVy())%height;
            if(py<0)
                py+=height;
            tab[py][px]=255;
        }
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for(int i=0;i<tab.length;i++)
        {
            for(int j=0;j<tab[i].length;j++)
            {
             image.setRGB(j,i,tab[i][j]);
            }

        }
        try{
        File outputFile = new File("src/bmpdo14/"+time+".png");
        ImageIO.write(image, "png", outputFile);
    }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
