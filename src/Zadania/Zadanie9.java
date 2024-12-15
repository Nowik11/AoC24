package Zadania;

import java.util.ArrayList;
import java.util.Collections;

public class Zadanie9 {
    public static long wykonaj_a()
    {
        String lista= "";
      lista=  Wczytywanie.wczytaj("zadanie9.txt");
        ArrayList<Integer> dysk = new ArrayList<>();
        for(int i=0;i<lista.length();i++)
        {
            for(char j='0';j<lista.charAt(i);j++)
            {
                if(i%2==0)
                {
                    dysk.add(i/2);
                }
                else{
                    dysk.add(-1);
                }
            }
        }
        for(int i=dysk.size()-1;i>=0;i--)
        {
            if(dysk.get(i)!=-1)
            {
                for(int j=0;j<i;j++)
                {
                    if(dysk.get(j)==-1) {
                        Collections.swap(dysk, j, i);
                        break;
                    }
                }
            }
        }
        long suma=0;
        for(int i=0;i<dysk.size() &&dysk.get(i)!=-1;i++)
        {
            suma+=dysk.get(i)*i;
        }
        return suma;
    }
    public static long wykonaj_b()
    {
        String lista= "";
        lista=  Wczytywanie.wczytaj("zadanie9.txt");
        ArrayList<Integer> dysk = new ArrayList<>();
        for(int i=0;i<lista.length();i++)
        {
            for(char j='0';j<lista.charAt(i);j++)
            {
                if(i%2==0)
                {
                    dysk.add(i/2);
                }
                else{
                    dysk.add(-1);
                }
            }
        }
        long suma=0;
        for(int i=dysk.size()-1;i>=0;i--)
        {

            if(dysk.get(i)!=-1)
            {
                int liczba = dysk.get(i);
                int count = 1;
                while ( i-count>=0 && dysk.get(i-count) == liczba )
                {
                    count++;
                }
                for(int j=0;j<dysk.size() && j<=i;j++)
                {

                    if(dysk.get(j)==-1)
                    {
                        boolean if_swap = true;
                        if(j+count>=dysk.size())
                            if_swap = false;
                        else {
                            for (int k = j; k < j + count; k++) {
                                if (dysk.get(k) != -1) {
                                    if_swap = false;
                                    break;
                                }
                            }
                        }
                        if(if_swap)
                        {
                            for(int k=0; k<count;k++)
                            {
                                Collections.swap(dysk, j+k, i-k);
                            }
                        }
                    }
                }
                i-=count;
                i++;
            }
        }
        for(int i=0;i<dysk.size();i++)
        {
            if(dysk.get(i)!=-1)
                suma+=dysk.get(i)*i;
        }
        return suma;
    }
}
