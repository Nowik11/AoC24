package Zadania;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Zadanie11 {



    public static long rekurencja(long liczba, int i,int blinks, HashMap<String, Long> map) {
        System.out.println(i);
        if(map.containsKey(liczba+" "+i))
            return map.get(liczba+" " +i);
        if(i==blinks)
        {
            map.put(liczba+" 75",(long)1);
            return 1;
        }

        if (liczba == 0) {
           long a= rekurencja(1,i+1,blinks,map);
           map.put(liczba+" "+i,a);
           return a;
        }
        else
        {
            String temp_liczba = liczba+"";
            if (temp_liczba.length() % 2 == 0)
            {
                long a= rekurencja(Long.parseLong(temp_liczba.substring(0,temp_liczba.length()/2)), i+1, blinks,map) + rekurencja(Long.parseLong(temp_liczba.substring(temp_liczba.length()/2)),i+1, blinks,map);
                map.put(liczba+" "+i,a);
                return a;
            }
            else
            {
                long a= rekurencja(liczba *2024,i+1, blinks,map);
                map.put(liczba+" "+i,a);
                return a;
            }
        }
    }

    public static long wykonaj_b(int blinks){
        ArrayList<Long> list = new ArrayList<Long>();
        Wczytywanie.wczytaj_long(list, "zadanie11.txt");
        String []kolor = {"\u001B[31m" , "\u001B[32m" ,"\u001B[33m" , "\u001B[34m","\u001B[35m","\u001B[36m","\u001B[37m","\u001B[41m" };
        long suma = 0;
        HashMap<String, Long> map = new HashMap<>();
        for(int k = 0; k < list.size(); k++) {
            System.out.println(kolor[k]);
            suma += rekurencja(list.get(k), 0, blinks,map);

        }
        return suma;
    }
}
