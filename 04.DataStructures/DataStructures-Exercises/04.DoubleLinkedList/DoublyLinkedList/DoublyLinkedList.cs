using System;
using System.Collections;
using System.Collections.Generic;

public class DoublyLinkedList<T> : IEnumerable<T>
{
    private Node<T> head;
    private Node<T> tail;

    public int Count { get; private set; }

    public DoublyLinkedList()
    {
        this.head = null;
        this.tail = null;
        this.Count = 0;
    }

    public void AddFirst(T element)
    {
        Node<T> newHead = new Node<T>(element);
        if (Count == 0)
        {
            InitializingTailAndHead(newHead);
        }
        else
        {
            this.head.Prev = newHead;
            newHead.Next = this.head;
            this.head = newHead;
        }
        this.Count++;
    }

    public void AddLast(T element)
    {
        Node<T> newTail = new Node<T>(element);
        if (Count == 0)
        {
            InitializingTailAndHead(newTail);
        }
        else
        {
            this.tail.Next = newTail;
            newTail.Prev = this.tail;
            this.tail = newTail;
        }
        this.Count++;
    }

    private void InitializingTailAndHead(Node<T> newNode)
    {
        this.head = newNode;
        this.tail = newNode;
    }

    public T RemoveFirst()
    {
        if (this.Count == 0)
        {
            ThrowExeption();
        }
        T element = this.head.Value;
        if (this.Count == 1)
        {
            this.head = null;
            this.tail = null;
        }
        else
        {
            this.head = this.head.Next;
            this.head.Prev = null;
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
            this.tail = this.tail.Prev;
            this.tail.Next = null;
        }
        this.Count--;
        return element;
    }

    public void ForEach(Action<T> action)
    {
        Node<T> currentNode = this.head;
        while (currentNode != null)
        {
            action(currentNode.Value);
            currentNode = currentNode.Next;
        }
    }

    public IEnumerator<T> GetEnumerator()
    {
        Node<T> current = this.head;
        while (current != null)
        {
            yield return current.Value;
            current = current.Next;
        }
    }

    IEnumerator IEnumerable.GetEnumerator()
    {
        return GetEnumerator();
    }

    public T[] ToArray()
    {
        T[] resultArr = new T[this.Count];
        Node<T> currentElement = this.head;
        for (int i = 0; i < resultArr.Length; i++)
        {
            resultArr[i] = currentElement.Value;
            currentElement = currentElement.Next;
        }
        return resultArr;
    }
    
    private void ThrowExeption()
    {
        throw new InvalidOperationException();
    }
}