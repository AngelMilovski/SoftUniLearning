using System;
using System.Collections;
using System.Collections.Generic;

public class LinkedQueue<T> : IEnumerable<T>
{
    private Node<T> head;
    private Node<T> tail;

    public int Count { get; private set; }
    
    public void Enqueue(T element)
    {
        Node<T> newTail = new Node<T>(element);
        switch (this.Count)
        {
            case 0:
                this.head = newTail;
                this.tail = newTail;
                break;
            default:
                this.tail.Next = newTail;
                newTail.Prev = this.tail;
                this.tail = newTail;
                break;
        }
        this.Count++;
    }

    public T Dequeue()
    {
        if (this.Count == 0)
        {
            throw new InvalidOperationException("The LinkedQueue is empty!");
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

    public T[] ToArray()
    {
        T[] newArr = new T[this.Count];
        Node<T> currentHead = this.head;
        for (int i = 0; i < this.Count; i++)
        {
            newArr[i] = currentHead.Value;
            currentHead = currentHead.Next;
        }
        return newArr;
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
}