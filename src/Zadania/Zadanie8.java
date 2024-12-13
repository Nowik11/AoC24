package Zadania;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Zadanie8 {

    public static int wykonaj_a()
    {
        ArrayList<String> lista = new ArrayList<>();
        Wczytywanie.wczytaj(lista,"zadanie8.txt",'c');
        HashMap<Character,ArrayList<Pair<Integer,Integer>>> mapa = new HashMap<>();
        HashSet<String> wynik = new HashSet<>();
        for(int y=0;y<lista.size();y++)
        {
            for(int x=0;x<lista.get(y).length();x++)
            {
                if(lista.get(y).charAt(x)!='.')
                {
                    if(!mapa.containsKey(lista.get(y).charAt(x)))
                    {
                        mapa.put(lista.get(y).charAt(x), new ArrayList<>());
                    }
                    mapa.get(lista.get(y).charAt(x)).add(new Pair<>(x,y));
                }
            }
        }
        for(Character c:mapa.keySet() )
        {
            for(int i = 0; i<mapa.get(c).size(); i++)
            {
                for(int j=0;j<mapa.get(c).size();j++)
                {
                    if(i!=j)
                    {
                        int roz_x = (mapa.get(c).get(i).getKey()-mapa.get(c).get(j).getKey());
                        int roz_y = (mapa.get(c).get(i).getValue()-mapa.get(c).get(j).getValue());
                        if(mapa.get(c).get(j).getValue()-roz_y>=0 && mapa.get(c).get(j).getValue()-roz_y<lista.size() && mapa.get(c).get(j).getKey()-roz_x>=0 && mapa.get(c).get(j).getKey()-roz_x<lista.get(0).length())
                        {
                            wynik.add((int)(mapa.get(c).get(j).getKey()-roz_x)+" "+(int)(mapa.get(c).get(j).getValue()-roz_y));
                        }
                        if(mapa.get(c).get(i).getValue()+roz_y>=0 && mapa.get(c).get(i).getValue()+roz_y<lista.size() && mapa.get(c).get(i).getKey()+roz_x>=0 && mapa.get(c).get(i).getKey()+roz_x<lista.get(0).length())
                        {
                            wynik.add((int)(mapa.get(c).get(i).getKey()+roz_x)+" "+(int)(mapa.get(c).get(i).getValue()+roz_y));
                        }
                    }
                }
            }
        }
        return wynik.size();
    }
    public static int wykonaj_b()
    {
        ArrayList<String> lista = new ArrayList<>();
        Wczytywanie.wczytaj(lista,"zadanie8.txt",'c');
        HashMap<Character,ArrayList<Pair<Integer,Integer>>> mapa = new HashMap<>();
        HashSet<String> wynik = new HashSet<>();
        for(int y=0;y<lista.size();y++)
        {
            for(int x=0;x<lista.get(y).length();x++)
            {
                if(lista.get(y).charAt(x)!='.')
                {
                    if(!mapa.containsKey(lista.get(y).charAt(x)))
                    {
                        mapa.put(lista.get(y).charAt(x), new ArrayList<>());
                    }
                    mapa.get(lista.get(y).charAt(x)).add(new Pair<>(x,y));
                }
            }
        }
        for(Character c:mapa.keySet() )
        {
            for(int i = 0; i<mapa.get(c).size(); i++)
            {
                for(int j=0;j<mapa.get(c).size();j++)
                {
                    if(i!=j)
                    {
                        wynik.add(mapa.get(c).get(i).getKey() +" " + mapa.get(c).get(i).getValue());
                        wynik.add(mapa.get(c).get(j).getKey() +" " + mapa.get(c).get(j).getValue());
                        int roz_x = (mapa.get(c).get(i).getKey()-mapa.get(c).get(j).getKey());
                        int roz_y = (mapa.get(c).get(i).getValue()-mapa.get(c).get(j).getValue());
                        int roz_x_kopia1 = roz_x;
                        int roz_y_kopia1 = roz_y;
                        int roz_x_kopia2 = roz_x;
                        int roz_y_kopia2 = roz_y;
                        while(mapa.get(c).get(j).getValue()-roz_y_kopia1>=0 && mapa.get(c).get(j).getValue()-roz_y_kopia1<lista.size() && mapa.get(c).get(j).getKey()-roz_x_kopia1>=0 && mapa.get(c).get(j).getKey()-roz_x_kopia1<lista.get(0).length())
                        {

                            wynik.add((int)(mapa.get(c).get(j).getKey()-roz_x_kopia1)+" "+(int)(mapa.get(c).get(j).getValue()-roz_y_kopia1));
                            roz_x_kopia1 +=roz_x;
                            roz_y_kopia1 +=roz_y;
                        }
                        while(mapa.get(c).get(i).getValue()+roz_y_kopia2>=0 && mapa.get(c).get(i).getValue()+roz_y_kopia2<lista.size() && mapa.get(c).get(i).getKey()+roz_x_kopia2>=0 && mapa.get(c).get(i).getKey()+roz_x_kopia2<lista.get(0).length())
                        {
                            wynik.add((int)(mapa.get(c).get(i).getKey()+roz_x_kopia2)+" "+(int)(mapa.get(c).get(i).getValue()+roz_y_kopia2));
                            roz_x_kopia2 +=roz_x;
                            roz_y_kopia2 +=roz_y;
                        }
                    }
                }
            }
        }
        return wynik.size();
    }

}
