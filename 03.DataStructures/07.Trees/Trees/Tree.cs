using System;
using System.Collections.Generic;

public class Tree<T>
{
    public T Value { get; private set; }

    public List<Tree<T>> Children { get; set; } 

    public Tree(T value, params Tree<T>[] children)
    {
        this.Value = value;
        this.Children = new List<Tree<T>>();
        foreach (var child in children)
        {
            this.Children.Add(child);
        }
    }

    //public void Print(int indent = 0)
    //{
    //    Console.WriteLine($"{new string(' ', 2 * indent)}{this.Value}");
    //    foreach (var child in this.Children)
    //    {
    //        child.Print(indent + 1);
    //    }
    //}

    public void Print(int indent = 0)
    {
        this.Print(this, indent);
    }

    public void Print(Tree<T> node, int indent)
    {
        Console.WriteLine($"{new string(' ', indent * 2)}{node.Value}");
        foreach (Tree<T> child in node.Children)
        {
            child.Print(indent + 1);
        }                                       //    /\  
    }                                           //   /  \
                                                //    ||
                                                // recursion
                                                //    ||
    public void Each(Action<T> action)          //   \  /
    {                                           //    \/
        action(this.Value);
        foreach (Tree<T> child in this.Children)
        {
            child.Each(action);
        }
    }

    public IEnumerable<T> OrderDFS()
    {
        List<T> result = new List<T>();
        this.DFS(this, result);
        return result;
    }

    private void DFS(Tree<T> node, List<T> result)
    {
        foreach (Tree<T> child in node.Children)
        {
            this.DFS(child, result);
        }
        result.Add(node.Value);
    }

    public IEnumerable<T> OrderBFS()
    {
        Queue<Tree<T>> queue = new Queue<Tree<T>>();
        queue.Enqueue(this);
        List<T> result = new List<T>();

        while (queue.Count > 0)
        {
            Tree<T> current = queue.Dequeue();
            result.Add(current.Value);
            foreach (var child in current.Children)
            {
                queue.Enqueue(child);
            }
        }
        return result;
    }
}
