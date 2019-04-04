using System;

public class Launcher
{
    public static void Main()
    {
        var list = new LinkedList<int>();

        list.AddLast(5);
        list.AddFirst(3);
        list.AddFirst(2);
        list.AddLast(10);
        list.RemoveFirst();
        list.RemoveLast();
        Console.WriteLine(list);
        list.AddFirst(2);

        Console.WriteLine("--------------------");

        list.AddLast(5);
        list.AddFirst(3);
        list.AddFirst(2);
        list.AddLast(10);
        list.RemoveFirst();
        list.RemoveLast();
        list.RemoveFirst();
        
        Console.WriteLine("--------------------");

        list.RemoveLast();
    }
}