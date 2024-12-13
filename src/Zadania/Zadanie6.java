package Zadania;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import Zadania.Kierunki;

public class Zadanie6 {



    public static int wykonaj_a()
    {
        Kierunki kierunki = new Kierunki();
        ArrayList<String> lista = new ArrayList<>();
        Wczytywanie.wczytaj(lista,"zadanie6.txt",'c');
        HashSet<String> set = new HashSet<>();
        int y=0;
        int x=0;
        boolean b=true;
        for(;y<lista.size()&&b;y++)
        {
            x=0;
            for(;x<lista.get(y).length();x++)
            {

                if(lista.get(y).charAt(x)=='^') {
                    b=false;
                    break;

                }
            }
        }
        y--;
        int kierunek = 0;
        Kierunki zwrot = new Kierunki();
        while(y<lista.size()-1 && y>0 &&x<lista.get(y).length()-1 &&  x>0)
        {
            set.add(x+" "+y);
            if(lista.get(y+zwrot.kierunek[kierunek].getValue()).charAt(x+zwrot.kierunek[kierunek].getKey())=='#')
            {
              kierunek++;
              kierunek %=4;
            }
            x+=zwrot.kierunek[kierunek].getKey();
            y+=zwrot.kierunek[kierunek].getValue();
        }
        return set.size()+1;

    }
    public static boolean sprawdz_czy_petla(Kierunki kierunki,ArrayList<String> list, int xx , int yy)
    {
        ArrayList<String> lista = new ArrayList<>();
        lista.addAll(list);
        lista.set(yy,lista.get(yy).substring(0,xx)+'#'+lista.get(yy).substring(xx+1));
        ArrayList<ArrayList<Integer>> czy_byl_cwel = new ArrayList<>();
        for(int i=0;i<lista.size();i++)
        {
            ArrayList<Integer> temp = new ArrayList<>();
            for(int j=0;j<lista.get(i).length();j++)
                temp.add(-1);
            czy_byl_cwel.add(temp);
        }
        int y=0;
        int x=0;
        boolean b=true;
        for(;y<lista.size()&&b;y++)
        {
            x=0;
            for(;x<lista.get(y).length();x++)
            {

                if(lista.get(y).charAt(x)=='^') {
                    b=false;
                    break;

                }
            }
        }
        y--;
        int kierunek = 0;
        Kierunki zwrot = new Kierunki();
        while(y<lista.size()-1 && y>0 &&x<lista.get(y).length()-1 &&  x>0)
        {
            if(czy_byl_cwel.get(y).get(x)==kierunek)
                return true;
            czy_byl_cwel.get(y).set(x,kierunek);
            while(lista.get(y+zwrot.kierunek[kierunek].getValue()).charAt(x+zwrot.kierunek[kierunek].getKey())=='#')
            {
                kierunek++;
                kierunek %=4;
            }
            x+=zwrot.kierunek[kierunek].getKey();
            y+=zwrot.kierunek[kierunek].getValue();
        }

        return false;
    }

    public static int wykonaj_b()
    {
        Kierunki kierunki = new Kierunki();
        ArrayList<String> lista = new ArrayList<>();
        Wczytywanie.wczytaj(lista,"zadanie6.txt",'c');
        int licz = 0;
       for(int i=0;i<lista.size();i++)
       {
           for(int j=0;j<lista.get(i).length();j++)
           {
               if(lista.get(i).charAt(j)=='.') {
                   if(sprawdz_czy_petla(kierunki,lista,j,i))
                       licz++;
               }
           }
       }
       return licz;



    }
}
