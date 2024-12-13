package Zadania;

import java.util.ArrayList;

public class Zadanie12 {

    public static Pair<Integer,Integer> DFS(int x, int y, ArrayList<String> lista, ArrayList<ArrayList<Boolean>> visited )
    {
        visited.get(y).set(x, true);
        int obwod = 0;
        int pole= 1;
        if(x<lista.get(y).length()-1 && lista.get(y).charAt(x+1) == lista.get(y).charAt(x) )
        {
            if( visited.get(y).get(x+1) != true )
            {
                Pair<Integer,Integer> temp = DFS(x+1, y, lista, visited );
            pole +=temp.getValue();
            obwod += temp.getKey();
            }
        }
        else{ obwod++;}
        if(x>0 && lista.get(y).charAt(x-1) == lista.get(y).charAt(x) )
        {
             if( visited.get(y).get(x-1) != true) {
                 Pair<Integer, Integer> temp = DFS(x - 1, y, lista, visited);
                 pole += temp.getValue();
                 obwod += temp.getKey();
             }
        }
        else{ obwod++;}
        if(y>0 && lista.get(y-1).charAt(x) == lista.get(y).charAt(x))
        {
            if( visited.get(y-1).get(x) != true ) {
                Pair<Integer, Integer> temp = DFS(x, y - 1, lista, visited);
                pole += temp.getValue();
                obwod += temp.getKey();
            }
        }
        else{ obwod++;}
        if(y<lista.size()-1 && lista.get(y+1).charAt(x) == lista.get(y).charAt(x))
        {
            if( visited.get(y+1).get(x) != true )
            {
            Pair<Integer,Integer> temp =  DFS(x, y+1, lista, visited );
            pole +=temp.getValue();
            obwod += temp.getKey();
            }
        }
        else{
            obwod++;}
        return new Pair<>(obwod, pole);
    }

//    public static int licz_sciany(int x,int y,ArrayList<String> lista, ArrayList<ArrayList<Boolean>> visitedObwod)
//    {
//        int sciany = 0;
//        Kierunki kierunki = new Kierunki();
//        int kierunek_ruch= 0;
//        int kieunek_krawedzi;
//        char startowa = lista.get(y).charAt(x);
//        while(true)
//        {
//           if(kierunek_ruch ==0)
//           {
//               if(y>0 &&lista.get(y +kierunki.kierunek[kierunek_ruch].getValue()).charAt(x+ kierunki.kierunek[kierunek_ruch].getKey())==startowa){
//               if(x==0 || lista.get(y).charAt(x-1) !=startowa )
//                {
//                    kieunek_krawedzi=3;
//                    break;
//                }
//                   if(x==lista.get(y).length() || lista.get(y).charAt(x+1) !=startowa )
//                   {
//                       kieunek_krawedzi=1;
//                       break;
//                   }
//               }
//           }
//           else if(kierunek_ruch ==1)
//           {
//               if(x<lista.size()-1 &&lista.get(y +kierunki.kierunek[kierunek_ruch].getValue()).charAt(x+ kierunki.kierunek[kierunek_ruch].getKey())==startowa){
//                   if(y==0 || lista.get(y-1).charAt(x) !=startowa )
//                   {
//                       kieunek_krawedzi=2;
//                       break;
//                   }
//                   if(y==lista.get(y).length() || lista.get(y+1).charAt(x) !=startowa )
//                   {
//                       kieunek_krawedzi=0;
//                       break;
//                   }
//               }
//           }
//           else if(kierunek_ruch==2)
//           {
//               if(y<lista.size()-1 &&lista.get(y +kierunki.kierunek[kierunek_ruch].getValue()).charAt(x+ kierunki.kierunek[kierunek_ruch].getKey())==startowa){
//                   if(x==0 || lista.get(y).charAt(x-1) !=startowa )
//                   {
//                       kieunek_krawedzi=3;
//                       break;
//                   }
//                   if(x==lista.get(y).length() || lista.get(y).charAt(x+1) !=startowa )
//                   {
//                       kieunek_krawedzi=1;
//                       break;
//                   }
//               }
//           }
//           else if(kierunek_ruch== 3)
//           {
//               if(x>0 &&lista.get(y +kierunki.kierunek[kierunek_ruch].getValue()).charAt(x+ kierunki.kierunek[kierunek_ruch].getKey())==startowa){
//                   if(y==0 || lista.get(y-1).charAt(x) !=startowa )
//                   {
//                       kieunek_krawedzi=2;
//                       break;
//                   }
//                   if(y==lista.get(y).length() || lista.get(y+1).charAt(x) !=startowa )
//                   {
//                       kieunek_krawedzi=0;
//                       break;
//                   }
//               }
//           }
//           else if(kierunek_ruch== 4)
//               return 4;
//           kierunek_ruch++;
//        }
//    }
    public static int DFS2(int x,int y,ArrayList<String> lista, ArrayList<ArrayList<Boolean>> visited)
    {
        visited.get(y).set(x, true);
        int sciany = 0;
        char obecna=lista.get(y).charAt(x);

        if((x==lista.get(y).length()-1|| lista.get(y).charAt(x+1) != obecna)  &&(y==lista.size()-1 ||lista.get(y+1).charAt(x) != obecna))
            sciany++;

        if((x==lista.get(y).length()-1|| lista.get(y).charAt(x+1) != obecna)  &&(y==0 ||lista.get(y-1).charAt(x) != obecna))
            sciany++;

        if((x==0|| lista.get(y).charAt(x-1) != obecna)  &&(y==0 ||lista.get(y-1).charAt(x) != obecna))
            sciany++;

        if((x==0|| lista.get(y).charAt(x-1) != obecna)  &&(y==lista.size()-1 ||lista.get(y+1).charAt(x) != obecna))
            sciany++;

        if((x<lista.get(y).length()-1 && lista.get(y).charAt(x+1) == obecna)  &&(y<lista.size()-1 && lista.get(y+1).charAt(x) == obecna) && lista.get(y+1).charAt(x+1)!=obecna)
            sciany++;

        if((x<lista.get(y).length()-1 && lista.get(y).charAt(x+1) == obecna)  &&(y>0 && lista.get(y-1).charAt(x) == obecna) && lista.get(y-1).charAt(x+1)!=obecna)
            sciany++;

        if((x>0 && lista.get(y).charAt(x-1) == obecna)  &&(y<lista.size()-1 && lista.get(y+1).charAt(x) == obecna) && lista.get(y+1).charAt(x-1)!=obecna)
            sciany++;

        if((x>0 && lista.get(y).charAt(x-1) == obecna)  &&(y>0 && lista.get(y-1).charAt(x) == obecna) && lista.get(y-1).charAt(x-1)!=obecna)
            sciany++;

        if(x<lista.get(y).length()-1 && lista.get(y).charAt(x+1) == lista.get(y).charAt(x) )
        {
            if( visited.get(y).get(x+1) != true )
            {
                sciany += DFS2(x+1, y, lista, visited );

            }
        }
        if(x>0 && lista.get(y).charAt(x-1) == lista.get(y).charAt(x) )
        {
            if( visited.get(y).get(x-1) != true) {
                sciany += DFS2(x-1, y, lista, visited );
            }
        }
        if(y>0 && lista.get(y-1).charAt(x) == lista.get(y).charAt(x))
        {
            if( visited.get(y-1).get(x) != true ) {
                sciany += DFS2(x, y-1, lista, visited );
            }
        }
        if(y<lista.size()-1 && lista.get(y+1).charAt(x) == lista.get(y).charAt(x))
        {
            if( visited.get(y+1).get(x) != true )
            {
                sciany += DFS2(x, y+1, lista, visited );
            }
        }
        return sciany;
    }
    public static int wykonaj_a()
    {
        ArrayList<String> lista = new ArrayList<>();
        Wczytywanie.wczytaj(lista,"zadanie12.txt",'c');
        ArrayList<ArrayList<Boolean>> visited = new ArrayList<>();
        for(int i=0;i<lista.size();i++)
        {
            ArrayList<Boolean> a = new ArrayList<>();
            for(int j=0;j<lista.get(i).length();j++)
            {
                a.add(false);
            }
            visited.add(a);
        }
        int suma=0;
        for(int i=0;i<lista.size();i++)
        {
            for (int j = 0; j < lista.get(i).length(); j++)
            {
                if(!visited.get(i).get(j))
                {
                    Pair<Integer,Integer >dane =DFS(j, i, lista, visited );
                    suma += (dane.getValue())* dane.getKey();
                }
            }
        }
        return suma;

    }
    public static int wykonaj_b()
    {
        ArrayList<String> lista = new ArrayList<>();
        Wczytywanie.wczytaj(lista,"zadanie12.txt",'c');
        ArrayList<ArrayList<Boolean>> visitedPole = new ArrayList<>();
        ArrayList<ArrayList<Boolean>> visitedObwod = new ArrayList<>();
        for(int i=0;i<lista.size();i++)
        {
            ArrayList<Boolean> a = new ArrayList<>();
            ArrayList<Boolean>b= new ArrayList<>();
            for(int j=0;j<lista.get(i).length();j++)
            {
                a.add(false);
                b.add(false);
            }
            visitedPole.add(a);
            visitedObwod.add(b);
        }
        int suma=0;
        for(int i=0;i<lista.size();i++)
        {
            for (int j = 0; j < lista.get(i).length(); j++)
            {
                if(!visitedPole.get(i).get(j))
                {
                    Pair<Integer,Integer >dane =DFS(j, i, lista, visitedPole);
                    int a =DFS2(j,i,lista,visitedObwod);
                    suma += dane.getValue() * a;
                }
            }
        }
        return suma;

    }
}

