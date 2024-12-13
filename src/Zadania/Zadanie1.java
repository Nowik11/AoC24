package Zadania;
import java.util.ArrayList;
import java.util.HashMap;

public class Zadanie1 {

    public static int wykonaj_a(){

        ArrayList<Integer> lista1 = new ArrayList<>();
        ArrayList<Integer> lista2 = new ArrayList<>();
        Wczytywanie.wczytaj(lista1,lista2,"zadanie1.txt");
        lista1.sort(Integer::compareTo);
        lista2.sort(Integer::compareTo);
        int suma = 0;
        for(int i=0;i<lista1.size();i++)
        {
            suma+=Math.abs(lista1.get(i)-lista2.get(i));
        }
        return suma;
    }
    public static int wykonaj_b(){
        ArrayList<Integer> lista1 = new ArrayList<>();
        ArrayList<Integer> lista2 = new ArrayList<>();
        Wczytywanie.wczytaj(lista1,lista2,"zadanie1.txt");
        lista1.sort(Integer::compareTo);
        lista2.sort(Integer::compareTo);
        int suma = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<lista2.size();i++)
        {
            if(map.containsKey(lista2.get(i)))
            {
                map.put(lista2.get(i),map.get(lista2.get(i))+1);
            }
            else
            {
                map.put(lista2.get(i),1);
            }
        }
        for(int i=0;i<lista1.size();i++)
        {
            if(map.containsKey(lista1.get(i)))
                suma+=lista1.get(i)*(int)(map.get(lista1.get(i)));
        }
        return suma;
    }

}
