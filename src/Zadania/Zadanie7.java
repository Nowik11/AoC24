package Zadania;

import java.util.ArrayList;

public class Zadanie7 {
    public static long wykonaj_a()
    {
        ArrayList<Pair<Long,ArrayList<Long>>> lista = new ArrayList<>();
        long suma = 0;
        Wczytywanie.wczytaj_7(lista,"zadanie7.txt");
        for(int i=0;i<lista.size();i++)
        {
            for(int j=0;j<Math.pow(2,lista.get(i).getValue().size()-1);j++)
            {
                long suma_temp=lista.get(i).getValue().get(0);
                for(int k=0;k<lista.get(i).getValue().size()-1;k++)
                {

                    if(((long)(Math.pow(2,k)) & j)!=0)
                    {
                        suma_temp+=lista.get(i).getValue().get(k+1);
                    }
                    else
                    {
                        suma_temp*=lista.get(i).getValue().get(k+1);
                    }
                }
                if(suma_temp==lista.get(i).getKey())
                {
                    suma += suma_temp;
                    break;
                }
            }


        }
        return suma;
    }

    public static boolean jebac_to_zadanie_zajebane(int operator,int k,int i, long suma,ArrayList<Pair<Long,ArrayList<Long>>> lista)
    {
        switch(operator) {
            case 0: {
                suma+=lista.get(i).getValue().get(k);
                break;
            }
            case 1: {
                suma*=lista.get(i).getValue().get(k);
                break;
            }
            case 2: {
                String temp = ""+suma+lista.get(i).getValue().get(k);
                suma = Long.parseLong(temp);
                break;
            }
        }
        if(suma == lista.get(i).getKey() && k == lista.get(i).getValue().size()-1)
            return true;
        else if(k<lista.get(i).getValue().size()-1){
            return jebac_to_zadanie_zajebane(0, k + 1, i, suma, lista) ||
                    jebac_to_zadanie_zajebane(1, k + 1, i, suma, lista) ||
                    jebac_to_zadanie_zajebane(2, k + 1, i, suma, lista);
        }
        return false;
    }
    public static long wykonaj_b()
    {
        ArrayList<Pair<Long,ArrayList<Long>>> lista = new ArrayList<>();
        long suma = 0;
        Wczytywanie.wczytaj_7(lista,"zadanie7.txt");
        for(int i=0;i<lista.size();i++)
        {
            if(jebac_to_zadanie_zajebane(0,1,i,lista.get(i).getValue().get(0),lista)||jebac_to_zadanie_zajebane(1,1,i,lista.get(i).getValue().get(0),lista)||jebac_to_zadanie_zajebane(2,1,i,lista.get(i).getValue().get(0),lista))
            {
                suma+=lista.get(i).getKey();
            }
        }
        return suma;
    }

}
