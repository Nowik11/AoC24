package Zadania;
import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class Zadanie5 {

    public static int wykonaj_a()
    {
        HashMap<Integer, Set<Integer>> map  = new HashMap<>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        Wczytywanie.zjebane_wczytanie(map, "Zadanie5_zasady.txt");
        Wczytywanie.wczytaj(list, "Zadanie5_dane.txt");
        int suma = 0;
        for(int i=0;i<list.size();i++)
        {
            boolean zapisac = true;
            for(int j=0;j<list.get(i).size() && zapisac;j++)
            {
                for(int k=j+1;k<list.get(i).size();k++)
                {
                    if(map.containsKey(list.get(i).get(j)))
                    {
                        if(!map.get(list.get(i).get(j)).contains(list.get(i).get(k)) && map.containsKey(list.get(i).get(k)) && map.get(list.get(i).get(k)).contains(list.get(i).get(j)))
                        {
                            zapisac = false;
                            break;
                        }

                    }
                    else
                    {
                        if(map.containsKey(list.get(i).get(k)) && map.get(list.get(i).get(k)).contains(list.get(i).get(j)))
                        {
                            zapisac = false;
                            break;
                        }
                    }
                }
            }
            if(zapisac)
            {
                suma += list.get(i).get((list.get(i).size())/2);
            }

        }
        return suma;
    }
    public static int wykonaj_b()
    {
        HashMap<Integer, Set<Integer>> map  = new HashMap<>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        Wczytywanie.zjebane_wczytanie(map, "Zadanie5_zasady.txt");
        Wczytywanie.wczytaj(list, "Zadanie5_dane.txt");
        int suma = 0;

        for(int i=0;i<list.size();i++)
        {
            boolean zapisac = true;
            for(int j=0;j<list.get(i).size() && zapisac;j++)
            {
                for(int k=j+1;k<list.get(i).size();k++)
                {
                    if(map.containsKey(list.get(i).get(j)))
                    {
                        if(!map.get(list.get(i).get(j)).contains(list.get(i).get(k)) && map.containsKey(list.get(i).get(k)) && map.get(list.get(i).get(k)).contains(list.get(i).get(j)))
                        {
                            zapisac = false;
                            break;
                        }

                    }
                    else
                    {
                        if(map.containsKey(list.get(i).get(k)) && map.get(list.get(i).get(k)).contains(list.get(i).get(j)))
                        {
                            zapisac = false;
                            break;
                        }
                    }
                }
            }
            if(!zapisac)
            {
                for(int j=0;j<list.get(i).size()-1;j++)
                {
                    for(int k=0;k<list.get(i).size()-1;k++)
                    {
                        if(map.containsKey(list.get(i).get(k+1)))
                        {
                            if(map.get(list.get(i).get(k+1)).contains(list.get(i).get(k)))
                            {
                                Collections.swap(list.get(i),k,k+1);
                            }
                        }
                    }
                }
                suma += list.get(i).get((list.get(i).size()-1)/2);
            }

        }
        return suma;
    }
}
