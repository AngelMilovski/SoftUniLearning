using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;

public class LinkedStack<T> : IEnumerable<T>
{
    
    private Node<T> head;
    private Node<T> tail;
   
    

    public int Count { get; private set; }

    public LinkedStack()
    {
        this.head = null;
        this.tail = null;
        this.Count = 0;
    }

    public void Push(T element)
    {
        Node<T> newTail = new Node<T>(element);
        if (this.Count == 0)
        {
            this.InitializingTailAndHead(newTail);
        }
        else
        {
            this.tail.Next = newTail;
            newTail.Prev = this.tail;
            this.tail = newTail;
        }
       
        this.Count++;
    }

    public T Pop()
    {
        if (this.Count == 0)
        {
            this.ThrowExeption();
        }
        T element = this.tail.Value;
        if (this.Count == 1)
        {
            this.head = null;
            this.tail = null;
        }
        else
        {
            this.tail = this.tail.Prev;
            this.tail.Next = null;
        }
        this.Count--;
        return element;
    }

    public T[] ToArray()
    {
        T[] resultArr = new T[this.Count];
        Node<T> currenElement = this.tail;
        for (int i = 0; i < resultArr.Length; i++)
        {
            resultArr[i] = currenElement.Value;
            currenElement = currenElement.Prev;
        }
        return resultArr;
    }

    

    public IEnumerator<T> GetEnumerator()
    {
        Node<T> current = this.tail;
        while (current != null)
        {
            yield return current.Value;
            current = current.Prev;
        }
    }

    public void ForEach(Action<T> action)
    {
        Node<T> currentNode = this.tail;
        while (currentNode != null)
        {
            action(currentNode.Value);
            currentNode = currentNode.Prev;
        }
    }

    IEnumerator IEnumerable.GetEnumerator()
    {
        return GetEnumerator();
    }

    private void ThrowExeption()
    {
        throw new InvalidOperationException();
    }

    private void InitializingTailAndHead(Node<T> newNode)
    {
        this.head = newNode;
        this.tail = newNode;
    }
}
