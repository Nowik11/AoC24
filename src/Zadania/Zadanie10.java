package Zadania;

import java.util.ArrayList;
import java.util.HashSet;

public class Zadanie10 {

    public static void DFS(ArrayList<ArrayList<Integer>> list, int x, int y, HashSet<String> set) {
        if(list.get(y).get(x) == 9) {
            set.add(x + " " + y);
        }
        else {
            if(x>0 && list.get(y).get(x-1) == list.get(y).get(x)+1)
                DFS(list, x-1, y, set);
            if(y>0 && list.get(y-1).get(x) == list.get(y).get(x)+1)
                DFS(list, x, y-1, set);
            if(x<list.size()-1 && list.get(y).get(x+1) == list.get(y).get(x)+1)
                DFS(list, x+1, y, set);
            if (y<list.size()-1 && list.get(y+1).get(x) == list.get(y).get(x)+1)
                DFS(list, x, y+1, set);
        }
    }
    public static int DFS2(ArrayList<ArrayList<Integer>> list, int x, int y) {
        int suma = 0;
        if(list.get(y).get(x) == 9) {
                return 1;
            }
        else {
            if(x>0 && list.get(y).get(x-1) == list.get(y).get(x)+1)
                suma +=DFS2(list, x-1, y);
            if(y>0 && list.get(y-1).get(x) == list.get(y).get(x)+1)
                suma +=DFS2(list, x, y-1);
            if(x<list.size()-1 && list.get(y).get(x+1) == list.get(y).get(x)+1)
                suma += DFS2(list, x+1, y);
            if (y<list.size()-1 && list.get(y+1).get(x) == list.get(y).get(x)+1)
               suma+= DFS2(list, x, y+1);
        }
        return suma;
    }
    public static int wykonaj_a()
    {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        Wczytywanie.wczytaj_bez_przerw(list,"zadanie10.txt");
        int suma = 0;
        for(int i=0;i<list.size();i++)
        {
            for (int j=0;j<list.get(i).size();j++)
            {
                if(list.get(i).get(j)==0)
                {
                    HashSet<String> set = new HashSet<>();
                    DFS(list, j, i, set);
                    suma += set.size();
                }
            }
        }
        return suma;
    }
    public static int wykonaj_b()
    {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        Wczytywanie.wczytaj_bez_przerw(list,"zadanie10.txt");
        int suma = 0;
        for(int i=0;i<list.size();i++)
        {
            for (int j=0;j<list.get(i).size();j++)
            {
                if(list.get(i).get(j)==0)
                {
                    suma += DFS2(list, j, i);
                }
            }
        }
        return suma;
    }
}
