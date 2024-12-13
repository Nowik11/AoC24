package Zadania;
import java.util.*;


public class Zadanie2 {
    public static boolean sprawdz(ArrayList<Integer> list)
    {
        int rosnie;
        if(list.get(1)-list.get(0)<0 && Math.abs(list.get(0)-list.get(1))<=3 && Math.abs(list.get(0)-list.get(1))>0)
        {
            rosnie=-1;
        }
        else if(list.get(1)-list.get(0)>0 && Math.abs(list.get(0)-list.get(1))<=3 && Math.abs(list.get(0)-list.get(1))>0)
        {
            rosnie=1;
        }
        else
            return false;
        for(int i =1;i<list.size()-1;i++)
        {
            if(((list.get(i+1)-list.get(i))*rosnie)>3 || ((list.get(i+1)-list.get(i))*rosnie)<=0)
            {
                return false;
            }
            if(i==list.size()-2)
                return true;
        }
        return false;
    }

    public static int wykonaj_a()
    {
        ArrayList<ArrayList<Integer>> lista=new ArrayList<>();
        Wczytywanie.wczytaj(lista,"zadanie2.txt");
        int licz  = 0;
        for(ArrayList<Integer> list : lista)
        {
            if(sprawdz(list))
                licz++;
        }
        return licz;

    }
    public static boolean sprawdz_bez(ArrayList<Integer> list, int i)
    {
        ArrayList<Integer> temp=new ArrayList<>();
        temp.addAll(list);
        temp.remove(i);
        return sprawdz(temp);
    }
    public static int wykonaj_b()
    {
        ArrayList<ArrayList<Integer>> lista=new ArrayList<>();
        Wczytywanie.wczytaj(lista,"zadanie2.txt");
        int licz  = 0;
        for(ArrayList<Integer> list : lista) {

        if(sprawdz(list)) {
            licz++;
        }
        else
        {
            for(int i=0;i<list.size();i++)
            {
                if(sprawdz_bez(list, i)) {
                    licz++;
                    break;
                }
            }
        }
        }
        return licz;
    }
}
