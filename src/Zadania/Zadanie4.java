package Zadania;

import java.util.ArrayList;

public class Zadanie4 {

    public static int wykonaj_a()
    {
        ArrayList<String> lista = new ArrayList<String>();
        Wczytywanie.wczytaj(lista,"zadanie4.txt", ' ');
        int licz = 0;
        for(int i=0;i<lista.size();i++)
        {
            for(int j=0;j<lista.get(i).length();j++)
            {
                if(j<lista.get(i).length() -3 && (lista.get(i).substring(j,j+4).equals("XMAS") || lista.get(i).substring(j,j+4).equals("SAMX")))
                    licz++;
                if(i<lista.size()-3 && (lista.get(i).charAt(j)== 'X' ) && (lista.get(i+1).charAt(j)== 'M' )&&  (lista.get(i+2).charAt(j)== 'A' )&&  (lista.get(i+3).charAt(j)== 'S'))
                    licz++;
                if(i<lista.size()-3 &&  lista.get(i).charAt(j)== 'S' &&  lista.get(i+1).charAt(j)== 'A' && lista.get(i+2).charAt(j)== 'M'&&   lista.get(i+3).charAt(j)== 'X')
                    licz++;


                if(i<lista.size()-3 && j<lista.get(i).length()-3 && (lista.get(i).charAt(j)== 'X' ) && (lista.get(i+1).charAt(j+1)== 'M' ) &&  (lista.get(i+2).charAt(j+2)== 'A' )&&  (lista.get(i+3).charAt(j+3)== 'S' ))
                    licz++;
                if(i<lista.size()-3 && j<lista.get(i).length()-3 && ( lista.get(i).charAt(j)== 'S') && ( lista.get(i+1).charAt(j+1)== 'A') &&  ( lista.get(i+2).charAt(j+2)== 'M')&&  ( lista.get(i+3).charAt(j+3)== 'X'))
                    licz++;

                if(i>2 && j<lista.get(i).length()-3 && (lista.get(i).charAt(j)== 'X') && (lista.get(i-1).charAt(j+1)== 'M' ) &&  (lista.get(i-2).charAt(j+2)== 'A' )&&  (lista.get(i-3).charAt(j+3)== 'S'))
                    licz++;
                if(i>2 && j<lista.get(i).length()-3 && ( lista.get(i).charAt(j)== 'S') && (lista.get(i-1).charAt(j+1)== 'A') &&  (lista.get(i-2).charAt(j+2)== 'M')&&  ( lista.get(i-3).charAt(j+3)== 'X'))
                    licz++;
            }
        }
        return licz;
    }
    public static int wykonaj_b() {
        ArrayList<String> lista = new ArrayList<String>();
        Wczytywanie.wczytaj(lista, "zadanie4.txt", ' ');
        int licz = 0;
        for (int i = 2; i < lista.size(); i++) {
            for (int j = 2; j < lista.get(i).length(); j++) {
                if(lista.get(i).charAt(j)=='M' && lista.get(i-1).charAt(j-1)=='A'&&lista.get(i-2).charAt(j)=='M' && lista.get(i).charAt(j-2)=='S' && lista.get(i-2).charAt(j-2)=='S'  )
                    licz++;
                if(lista.get(i).charAt(j)=='M' && lista.get(i-1).charAt(j-1)=='A'&&lista.get(i-2).charAt(j)=='S' && lista.get(i).charAt(j-2)=='M' && lista.get(i-2).charAt(j-2)=='S'  )
                    licz++;
                if(lista.get(i).charAt(j)=='S' && lista.get(i-1).charAt(j-1)=='A'&&lista.get(i-2).charAt(j)=='S' && lista.get(i).charAt(j-2)=='M' && lista.get(i-2).charAt(j-2)=='M'  )
                    licz++;
                if(lista.get(i).charAt(j)=='S' && lista.get(i-1).charAt(j-1)=='A'&&lista.get(i-2).charAt(j)=='M' && lista.get(i).charAt(j-2)=='S' && lista.get(i-2).charAt(j-2)=='M'  )
                    licz++;
            }


        }
        return licz;
    }
}


