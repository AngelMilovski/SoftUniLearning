using System;
using System.Collections;
using System.Collections.Generic;

public class LinkedList<T> : IEnumerable<T>
{
    private Node<T> head;
    private Node<T> tail;

    public int Count { get; private set; }

    public LinkedList()
    {
        this.head = null;
        this.tail = null;
        this.Count = 0;
    }

    public void AddFirst(T item)
    {
        Node<T> newNode = new Node<T>(item);
        if (this.Count == 0)
        {
            InitializingHeadAndTail(newNode);
        }
        else
        {
            newNode.Next = this.head;
            this.head = newNode;
        }
        this.Count++;
    }

    public void AddLast(T item)
    {
        Node<T> newNode = new Node<T>(item);
        if (this.Count == 0)
        {
            InitializingHeadAndTail(newNode);
        }
        else
        {
            this.tail.Next = newNode;
            this.tail = newNode;
        }
        Count++;
    }

    public T RemoveFirst()
    {
        if (this.Count == 0)
        {
            ThrowExeption();
        }
        T element = this.head.Value;
        if (Count == 1)
        {
            this.head = null;
            this.tail = null;
        }
        else
        {
            this.head = this.head.Next;
        }
        this.Count--;
        return element;
    }

    public T RemoveLast()
    {
        if (this.Count == 0)
        {
            ThrowExeption();
        }
        T element = this.tail.Value;
        if (this.Count == 1)
        {
            this.head = null;
            this.tail = null;
        }
        else
        {
            Node<T> parent = this.head;
            while (parent.Next != this.tail)
            {
                parent = parent.Next;
            }
            parent.Next = null;
            this.tail = parent;
        }
        this.Count--;
        return element;
    }

    public IEnumerator<T> GetEnumerator()
    {
        Node<T> start = this.head;
        while (start != null)
        {
            yield return start.Value;
            start = start.Next;
        }
    }

    IEnumerator IEnumerable.GetEnumerator()
    {
        return GetEnumerator();
    }

    private void InitializingHeadAndTail(Node<T> newNode)
    {
        this.head = newNode;
        this.tail = newNode;
    }

    private void ThrowExeption()
    {
        throw new InvalidOperationException();
    }
}