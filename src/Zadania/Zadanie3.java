package Zadania;

import java.io.FileNotFoundException;
import java.util.*;


public class Zadanie3 {

    public static int wykonaj(boolean czy_b )
    {
        ArrayList<String> lista = new ArrayList<>();
        Wczytywanie.wczytaj(lista, "zadanie3.txt", 'c');
        int suma = 0;
        boolean rob = true;
        for(int i = 0; i < lista.size(); i++)
        {
            for(int j=0;j<lista.get(i).length()-8;j++)
            {
                if(lista.get(i).substring(j,j+4).equals("do()")&& czy_b)
                    rob=true;
                if(lista.get(i).substring(j,j+7).equals("don't()") && czy_b)
                    rob=false;
                if(lista.get(i).substring(j,j+3).equals("mul")&& rob)
                {
                    int k=j+3;
                    if(lista.get(i).charAt(k)!='(')
                    {
                        continue;
                    }
                    else
                    {
                        k++;
                        boolean OK = true;
                        while(lista.get(i).charAt(k)!=')')
                        {
                            if(!((lista.get(i).charAt(k)<='9' && lista.get(i).charAt(k)>='0') || lista.get(i).charAt(k)==',')){
                                OK = false;
                                break;
                            }
                            k++;
                        }
                        if(OK) {
                            String srodek = lista.get(i).substring(j+4,k);
                            srodek= srodek.replace(',',' ');
                            Scanner sc = new Scanner(srodek);
                            int a,b;
                            try{
                                a = sc.nextInt();
                            }
                            catch(Exception e)
                            {
                                a=0;
                            }
                            try
                            {
                                b = sc.nextInt();
                            }
                            catch(Exception e)
                            {
                                b=0;
                            }
                            suma+=a*b;
                            sc.close();

                        }
                    }

                }
            }
        }
        return suma;
    }


}
