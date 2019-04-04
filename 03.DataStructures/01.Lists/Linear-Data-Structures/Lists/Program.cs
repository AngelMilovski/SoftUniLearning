using System;

using System.Collections.Generic;

public class Program
{
    public static void Main()
    {
        
        var list = new ArrayList<int>();

        list.Add(1);
        list.Add(2);
        list.Add(3);
        list.Add(4);

        Console.WriteLine(list);

        list.RemoveAt(2);
        list.RemoveAt(2);
        Console.WriteLine(list);
    }
}