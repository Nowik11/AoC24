package Zadania;
import java.util.*;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;

public class Wczytywanie {

    public static void wczytaj_13(ArrayList<int[]> lista   , String nazwa)
    {
        try {
            File file = new File("src/dane/" + nazwa);
            Scanner sc2 = new Scanner(file);
            String A;
            String B;
            String Prize;
            while(sc2.hasNextLine()) {

                A = sc2.nextLine();
                B = sc2.nextLine();
                Prize = sc2.nextLine();
                A = A.substring(10);
                B = B.substring(10);
                Prize = Prize.substring(9);
                A = A.replace("X+", " ");
                B = B.replace("X+", " ");
                A = A.replace(", Y+", " ");
                B = B.replace(", Y+", " ");
                Prize = Prize.replace(", Y=", " ");
                Scanner sc = new Scanner(A);
                int[] tab = new int[6];
                tab[0] = sc.nextInt();
                tab[1] = sc.nextInt();
                sc = new Scanner(B);
                tab[2] = sc.nextInt();
                tab[3] = sc.nextInt();
                sc = new Scanner(Prize);
                tab[4] = sc.nextInt();
                tab[5] = sc.nextInt();
                lista.add(tab);
                if(sc2.hasNextLine()) {
                    A = sc2.nextLine();
                }
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("złe dane :(");
        }
    }
    public static void wczytaj14(ArrayList<zad14_wektory> lista   , String nazwa)
    {
        try {
            File file = new File("src/dane/" + nazwa);
            Scanner sc = new Scanner(file);
            String temp;
            while(sc.hasNextLine()) {
                temp = sc.nextLine();
                temp=temp.replace("p=", " ");
                temp=temp.replace("v=", " ");
                temp=temp.replace(',' , ' ');
                Scanner sc2 = new Scanner(temp);
                int px = sc2.nextInt();
                int py = sc2.nextInt();
                int vx = sc2.nextInt();
                int vy = sc2.nextInt();
                lista.add(new zad14_wektory(vx, vy, px, py));
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("złe dane :(");
        }
    }

    public static void zjebane_wczytanie(HashMap<Integer , Set<Integer>> map, String nazwa)
    {
        try {
            File file = new File("src/dane/" + nazwa);
            Scanner sc = new Scanner(file);
            String temp;
           while(sc.hasNextLine())
           {
               temp = sc.nextLine();
              temp=temp.replace('|', ' ');
               Scanner sc2 = new Scanner(temp);
               int a = sc2.nextInt() , b=sc2.nextInt();
               if(!map.containsKey(a))
               {
                   map.put(a, new HashSet<>());
               }
               map.get(a).add(b);

           }
        }
        catch (FileNotFoundException e) {
            System.out.println("złe dane :(");
        }
    }

    public static void wczytaj(ArrayList<Integer> lista1, ArrayList<Integer> lista2, String nazwa)  {
       try {
           File file = new File("src/dane/" + nazwa);
           Scanner sc = new Scanner(file);
           int a, b;
           while (sc.hasNextInt()) {
               a = sc.nextInt();
               b = sc.nextInt();
               lista1.add(a);
               lista2.add(b);
           }
           sc.close();
       }
       catch (FileNotFoundException e) {
           System.out.println("złe dane :(");
       }
    }
    public static void wczytaj_bez_przerw(ArrayList<ArrayList<Integer>> lista, String nazwa)  {
        try {
            File file = new File("src/dane/" + nazwa);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String temp = sc.nextLine();
                ArrayList<Integer> t  = new ArrayList<>();
                for(int i = 0;i<temp.length();i++)
                {
                    t.add((int) temp.charAt(i)-'0');
                }
                lista.add(t);
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("złe dane :(");
        }
    }
    public static void wczytaj(ArrayList<String> lista, String nazwa, char c )
    {
        try {
            File file = new File("src/dane/" + nazwa);
            Scanner sc = new Scanner(file);
            String linia;
            while (sc.hasNextLine()) {
                linia = sc.nextLine();
                lista.add(linia);
            }
        }
        catch(Exception e)
            {
             System.out.println("złe dane :(");
            }

    }
    public static void wczytaj_long(ArrayList<Long> lista, String nazwa )
    {
        try {
            File file = new File("src/dane/" + nazwa);
            Scanner sc = new Scanner(file);
            long linia;
            while (sc.hasNextLong()) {
                linia = sc.nextLong();
                lista.add(linia);
            }
        }
        catch(Exception e)
        {
            System.out.println("złe dane :(");
        }

    }

    public static void wczytaj(ArrayList<ArrayList<Integer>> lista, String nazwa) {
        try {
            File file = new File("src/dane/" + nazwa);
            Scanner sc = new Scanner(file);
            String linia;

                while (sc.hasNextLine()) {
                    linia = sc.nextLine();
                    linia = linia.replace(',',' ');
                    Scanner sc2 = new Scanner(linia);
                    ArrayList<Integer> temp = new ArrayList<>();
                    while (sc2.hasNextInt()) {
                        temp.add(sc2.nextInt());
                    }
                    lista.add(temp);
                }
        }
        catch(Exception e){
                System.out.println("złe dane :(");
            }

    }
    public static void wczytaj_7(ArrayList<Pair<Long,ArrayList<Long>>> lista, String nazwa)
    {
        try {
            File file = new File("src/dane/" + nazwa);
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()) {

                ArrayList<Long> temp = new ArrayList<>();
                String linia = sc.nextLine();
                linia = linia.replace(':',' ');
                Scanner sc2 = new Scanner(linia);
                long a = sc2.nextLong();
                while (sc2.hasNextLong()) {
                    temp.add(sc2.nextLong());
                }


                lista.add(new Pair<>(a, temp));
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("smuteczek no :(");
        }
    }
    public static String wczytaj( String nazwa)
    {
        try{
            File file = new File("src/dane/" + nazwa);
            Scanner sc= new Scanner(file);
            String temp="";
            while(sc.hasNextLine())
                temp+=sc.nextLine();
            return temp;
        }
        catch(Exception e)
        {
            System.out.println("smuteczek no :(");
        }
        return "";
    }
}
