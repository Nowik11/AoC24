package Zadania;

import java.util.ArrayList;
import java.util.Collections;

public class Zadanie15 {

    public static int wykonaj_a()
    {
        ArrayList<String> input = new ArrayList<>();
        ArrayList<ArrayList<Character>> mapa = new ArrayList<>();
        Wczytywanie.wczytaj(input,"zadanie15_mapa.txt",'c');
        for(int i=0;i<input.size();i++)
        {
            ArrayList<Character> temp = new ArrayList<>();
            for(int j=0;j<input.get(i).length();j++)
            {
                temp.add(input.get(i).charAt(j));
            }
            mapa.add(temp);
        }
        String ruchy = Wczytywanie.wczytaj("zadanie15_ruchy.txt");
        int suma = 0;
        int x= 0, y=0;
        outerloop :for(;y<mapa.size();y++)
        {
            x=0;
            for(;x<mapa.get(y).size();x++)
            {
                if(mapa.get(y).get(x)=='@')
                    break outerloop;
            }
        }
        for(int i=0;i<ruchy.length();i++) {
            switch (ruchy.charAt(i))
            {
                case '^' :
                {
                    if(mapa.get(y-1).get(x)=='.')
                    {
                        mapa.get(y-1).set(x,'@');
                        mapa.get(y).set(x,'.');
                        y--;
                    }
                    else if(mapa.get(y-1).get(x)=='O')
                    {
                        int yy = y-1;
                        while(mapa.get(yy).get(x)=='O')
                        {
                            yy--;
                        }
                        if(mapa.get(yy).get(x)=='.') {
                            mapa.get(yy).set(x, 'O');
                            mapa.get(y).set(x,'.');
                            mapa.get(y-1).set(x,'@');
                            y--;
                        }
                    }
                    break;
                }
                case 'v' :
                {
                    if(mapa.get(y+1).get(x)=='.')
                    {
                        mapa.get(y+1).set(x,'@');
                        mapa.get(y).set(x,'.');
                        y++;
                    }
                    else if(mapa.get(y+1).get(x)=='O')
                    {
                        int yy = y+1;
                        while(mapa.get(yy).get(x)=='O')
                        {
                            yy++;
                        }
                        if(mapa.get(yy).get(x)=='.') {
                            mapa.get(yy).set(x, 'O');
                            mapa.get(y).set(x,'.');
                            mapa.get(y+1).set(x,'@');
                            y++;
                        }
                    }
                    break;

                }
                case '>' : {
                    if (mapa.get(y).get(x + 1) == '.') {
                        mapa.get(y).set(x + 1, '@');
                        mapa.get(y).set(x, '.');
                        x++;
                    } else if (mapa.get(y ).get(x+1) == 'O') {
                        int xx = x + 1;
                        while (mapa.get(y).get(xx) == 'O') {
                            xx++;
                        }
                        if (mapa.get(y).get(xx) == '.') {
                            mapa.get(y).set(xx, 'O');
                            mapa.get(y).set(x, '.');
                            mapa.get(y ).set(x+1, '@');
                            x++;
                        }
                    }
                    break;
                }
                case '<' : {
                    if (mapa.get(y).get(x - 1) == '.') {
                        mapa.get(y).set(x - 1, '@');
                        mapa.get(y).set(x, '.');
                        x--;
                    } else if (mapa.get(y ).get(x-1) == 'O') {
                        int xx = x - 1;
                        while (mapa.get(y).get(xx) == 'O') {
                            xx--;
                        }
                        if (mapa.get(y).get(xx) == '.') {
                            mapa.get(y).set(xx, 'O');
                            mapa.get(y).set(x, '.');
                            mapa.get(y ).set(x-1, '@');
                            x--;
                        }
                    }
                    break;
                }
            }
        }

        for(int i=0;i<mapa.size();i++)
        {
            for(int j=0;j<mapa.get(i).size();j++)
            {
                if(mapa.get(i).get(j)=='O')
                    suma += 100*i + j;
            }
        }
        return suma;
    }
    public static int wykonaj_b()
    {
        ArrayList<String> input = new ArrayList<>();
        ArrayList<ArrayList<Character>> mapa = new ArrayList<>();
        Wczytywanie.wczytaj(input,"zadanie15_mapa.txt",'c');
        for(int i=0;i<input.size();i++)
        {
            ArrayList<Character> temp = new ArrayList<>();
            for(int j=0;j<input.get(i).length();j++)
            {
                if(input.get(i).charAt(j)=='.') {
                    temp.add('.');
                    temp.add('.');
                }
                if(input.get(i).charAt(j)=='O')
                {
                    temp.add('[');
                    temp.add(']');
                }
                if(input.get(i).charAt(j)=='@')
                {
                    temp.add('@');
                    temp.add('.');
                }
                if(input.get(i).charAt(j)=='#')
                {
                    temp.add('#');
                    temp.add('#');
                }

            }
            mapa.add(temp);
        }
        String ruchy = Wczytywanie.wczytaj("zadanie15_ruchy.txt");
        int suma = 0;
        int x= 0, y=0;
        outerloop :for(;y<mapa.size();y++)
        {
            x=0;
            for(;x<mapa.get(y).size();x++)
            {
                if(mapa.get(y).get(x)=='@')
                    break outerloop;
            }
        }
        for(int i=0;i<ruchy.length();i++) {
            switch (ruchy.charAt(i))
            {
                case '^' :
                {
                    if(mapa.get(y-1).get(x)=='.')
                    {
                        mapa.get(y-1).set(x,'@');
                        mapa.get(y).set(x,'.');
                        y--;
                    }
                   else if(mapa.get(y-1).get(x)=='[' || mapa.get(y-1).get(x)==']')
                    {
                        int prawo = 0;
                        boolean prawy_impakt = true;
                        int lewo = 0;
                        if(mapa.get(y-1).get(x)=='[') {
                            prawo++;
                            prawy_impakt = false;
                        }
                        else if(mapa.get(y-1).get(x)==']')
                            lewo++;

                        int yy = y-1;
                        Outerloop : while(true)
                        {
                            int start = x-lewo, koniec =x+prawo;
                            boolean wszystkie_wolne = true;
                            for(int xx = start; xx<=koniec; xx++)
                            {

                                if(mapa.get(yy-1).get(xx)=='#')
                                    break Outerloop;
                                if(mapa.get(yy-1).get(xx)!='.')
                                    wszystkie_wolne = false;
                            }
                            if(wszystkie_wolne)
                            {
                               Out : while(true)
                               {
                                    for (int xx = x-lewo; xx <= x+prawo; xx++)
                                    {
                                        if(lewo==0 && prawo==0) {
                                           mapa.get(y).set(x, '.');
                                           mapa.get(y-1).set(x, '@');
                                            y--;
                                            break Out;
                                        }
                                        mapa.get(yy-1).set(xx, mapa.get(yy).get(xx));
                                        mapa.get(yy).set(xx, '.');

                                    }
                                    if(!(yy+1 == y)) {
                                        if (mapa.get(yy + 1).get(x - lewo) == ']')
                                            lewo++;
                                        else if (!(mapa.get(yy + 1).get(x - lewo) == '@'))
                                            lewo--;
                                        if (mapa.get(yy + 1).get(x + prawo) == '[')
                                            prawo++;
                                        else if (!(mapa.get(yy + 1).get(x + prawo) == '@'))
                                            prawo--;
                                    }
                                   yy++;
                               }
                                break Outerloop;
                            }
                            if(mapa.get(yy-1).get(start)==']')
                                lewo++;
                            if(mapa.get(yy-1).get(start)=='.' || mapa.get(yy-1).get(start)=='#')
                                lewo--;
                            if(mapa.get(yy-1).get(koniec)=='[')
                                prawo++;
                            if(mapa.get(yy-1).get(koniec)=='.' || mapa.get(yy-1).get(koniec)=='#')
                                prawo--;
                            yy--;
                        }
                    }
                    break;
                }
                case 'v' :
                {
                    if(mapa.get(y+1).get(x)=='.')
                    {
                        mapa.get(y+1).set(x,'@');
                        mapa.get(y).set(x,'.');
                        y++;
                    }
                    else if(mapa.get(y+1).get(x)=='O')
                    {
                        int yy = y+1;
                        while(mapa.get(yy).get(x)=='O')
                        {
                            yy++;
                        }
                        if(mapa.get(yy).get(x)=='.') {
                            mapa.get(yy).set(x, 'O');
                            mapa.get(y).set(x,'.');
                            mapa.get(y+1).set(x,'@');
                            y++;
                        }
                    }
                    break;

                }
                case '>' : {
                    if (mapa.get(y).get(x + 1) == '.') {
                        mapa.get(y).set(x + 1, '@');
                        mapa.get(y).set(x, '.');
                        x++;
                    } else if (mapa.get(y ).get(x+1) == '[') {
                        int xx = x + 1;
                        while (mapa.get(y).get(xx) == '[' || mapa.get(y).get(xx) == ']') {
                            xx++;
                        }
                        if (mapa.get(y).get(xx) == '.') {
                          for(int j=x+2;j<=xx;j+=2)
                          {
                              mapa.get(y).set(j,'[');
                              mapa.get(y).set(j+1,']');
                          }
                          mapa.get(y).set(x,'.');
                          mapa.get(y).set(x+1,'@');
                          x++;
                        }
                    }
                    break;
                }
                case '<' : {
                    if (mapa.get(y).get(x - 1) == '.') {
                        mapa.get(y).set(x - 1, '@');
                        mapa.get(y).set(x, '.');
                        x--;
                    } else if (mapa.get(y ).get(x-1) == ']') {
                        int xx = x - 1;
                        while (mapa.get(y).get(xx) == '[' || mapa.get(y).get(xx) == ']') {
                            xx--;
                        }
                        if (mapa.get(y).get(xx) == '.') {
                            for(int j=x-2;j>=xx;j-=2)
                            {
                                mapa.get(y).set(j,']');
                                mapa.get(y).set(j-1,'[');
                            }
                            mapa.get(y).set(x,'.');
                            mapa.get(y).set(x-1,'@');
                            x--;
                        }
                    }
                    break;
                }
            }
            System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
            for(int j=0;j<mapa.size();j++)
            {
                System.out.println(mapa.get(j));
                System.out.println();
            }
        }

        for(int i=0;i<mapa.size();i++)
        {
            for(int j=0;j<mapa.get(i).size();j++)
            {
                if(mapa.get(i).get(j)=='O')
                    suma += 100*i + j;
            }
        }
        return suma;
    }
}
