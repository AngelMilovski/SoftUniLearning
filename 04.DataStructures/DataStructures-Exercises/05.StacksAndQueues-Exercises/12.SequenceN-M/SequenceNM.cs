using System;
using System.Collections.Generic;
using System.Linq;

public class SequenceNM
{
    public static void Main()
    {
        var numbers = Console.ReadLine()
            .Split(new[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
            .Select(int.Parse)
            .ToArray();
        var start = numbers[0];
        var end = numbers[1];

        if (end < start)
        {
            return;
        }
        var queue = new Queue<Item>();
        queue.Enqueue(new Item(start));

        while (queue.Count > 0)
        {
            Item current = queue.Dequeue();

            if (current.Value == end)
            {
                PrintSequence(current);
                return;
            }
            else if (current.Value < end)
            {
                queue.Enqueue(new Item(current.Value + 1, current));
                queue.Enqueue(new Item(current.Value + 2, current));
                queue.Enqueue(new Item(current.Value * 2, current));
            }
        }
    }

    private static void PrintSequence(Item start)
    {
        LinkedList<int> list = new LinkedList<int>();
        Item current = start;
        while (current != null)
        {
            list.AddFirst(current.Value);
            current = current.Prev;
        }
        var result = string.Join(" -> ", list);
        Console.WriteLine(result);
    }

    class Item
    {
        public int Value { get; set; }

        public Item Prev { get; set; }

        public Item(int value, Item prev = null)
        {
            this.Value = value;
            this.Prev = prev;
        }
    }
}

