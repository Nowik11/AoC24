package Zadania;

import java.util.ArrayList;

public class Zadanie13 {


    public static int wykonaj_a()
    {
        ArrayList<int[]> lista = new ArrayList();
        Wczytywanie.wczytaj_13(lista,"zadanie13.txt");
        int suma = 0;
        for(int i=0;i<lista.size();i++)
        {
            int ilosc=Integer.MAX_VALUE;
            int temp_ilosc=0;
            int ax=lista.get(i)[0];
            int ay=lista.get(i)[1];
            int bx=lista.get(i)[2];
            int by=lista.get(i)[3];
            int prizex=lista.get(i)[4];
            int prizey=lista.get(i)[5];
            int x = 0, y=0;
            int j=0;
            while(x<prizex && y<prizey)
            {
                x+=bx;
                y+=by;
                temp_ilosc++;
                j++;
            }
            for(;j>0;j--)
            {
                  x-=bx;
                  y-=by;
                  temp_ilosc--;
                  while(x<prizex && y< prizey)
                  {
                      x+=ax;
                      y+=ay;
                      temp_ilosc+=3;
                  }
                  if(x==prizex && y==prizey)
                      ilosc = Math.min(ilosc,temp_ilosc);

            }
            if(ilosc != Integer.MAX_VALUE)
                suma+=ilosc;

        }
        return suma;
    }

    public static long wykonaj_b()
    {
        ArrayList<int[]> lista = new ArrayList();
        Wczytywanie.wczytaj_13(lista,"zadanie13.txt");
        long suma = 0;
        for(int i=0;i<lista.size();i++)
        {
            long ilosc=Long.MAX_VALUE;
            long temp_ilosc=0;
            long ax=lista.get(i)[0];
            long ay=lista.get(i)[1];
            long bx=lista.get(i)[2];
            long by=lista.get(i)[3];
            long przesuniecie = 10000000000000L;
            long prizex=(long)lista.get(i)[4] + przesuniecie;
            long prizey=(long)lista.get(i)[5]+przesuniecie;
            long x = 0, y=0;
            long j=0;
            while(x<prizex && y<prizey)
            {
                x+=bx;
                y+=by;
                temp_ilosc++;
                j++;
            }
            for(;j>0;j--)
            {
                x-=bx;
                y-=by;
                temp_ilosc--;
                while(x<prizex && y< prizey)
                {
                    x+=ax;
                    y+=ay;
                    temp_ilosc+=3;
                }
                if(x==prizex && y==prizey)
                    ilosc = Math.min(ilosc,temp_ilosc);

            }
            if(ilosc != Long.MAX_VALUE)
                suma+=ilosc;

        }
        return suma;
    }

}
