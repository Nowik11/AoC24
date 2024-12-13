package Zadania;

import java.util.ArrayList;

public class Zadanie13 {

    long x=1, y=0;
    void euklides(long a, long  b)
    {
        if(b!=0)
        {
            euklides(b, a%b);
            long pom = y;
            y = x  - a/b*y;
            x = pom;
        }
    }

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
    public Zadanie13()
    {

    }

    public long wykonaj_b()
    {
        ArrayList<int[]> lista = new ArrayList();
        Wczytywanie.wczytaj_13(lista,"zadanie13.txt");
        long suma = 0;
        for(int i=0;i<lista.size();i++) {
            long ax = lista.get(i)[0];
            long ay = lista.get(i)[1];
            long bx = lista.get(i)[2];
            long by = lista.get(i)[3];
            long W;
            Long WA;
            Long WB;
            long przesuniecie = 10000000000000L;
            long prizex = (long) lista.get(i)[4] + przesuniecie;
            long prizey = (long) lista.get(i)[5] + przesuniecie;

            W = ax * by - ay * bx;
            WA = -bx * prizey + by * prizex;
            WB = ax * prizey - ay * prizex;
            if (W != 0) {

                if (WA % W == 0 && WB % W == 0) {
                    long a = WA/W;
                    long b =WB/W;
                    if(a>=0 && b>=0)
                        suma+=3*a +b;
                }
            } else
            {
                if(WA==0 && WB==0)
                {
                    long min = Long.MAX_VALUE;
                    this.x=1;
                    this.y=0;
                    euklides(ax,bx);
                    long d=ax*x + bx*y;
                    for(int k=0;;k++)
                    {
                        long a = x+ (k*bx)/d;
                        long b=y-(k*ax)/d;
                        if(a*ax>prizex || b*bx>prizex)
                        {
                            break;
                        }
                        if(a>=0 && b>=0)
                            min=Math.min(min,a*3+b);
                    }
                    suma+=min;
                }
            }


            }
        return suma;
    }

}
