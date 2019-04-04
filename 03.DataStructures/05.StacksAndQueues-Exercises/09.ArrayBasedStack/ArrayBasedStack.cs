using System;
using System.Collections;
using System.Collections.Generic;

public class ArrayStack<T> : IEnumerable<T>
{
    private T[] elements;
    private int endIndex;
    private const int InitialCapacity = 16;
    
    public int Count { get; private set; }

    public ArrayStack(int capacity = InitialCapacity)
    {
        this.elements = new T[capacity];
    }

    public void Push(T element)
    {
        if (this.Count >= this.elements.Length)
        {
            this.Grow();
        }
        this.elements[this.endIndex] = element;
        this.endIndex = (this.endIndex + 1) % this.elements.Length;
        this.Count++;
    }

    public T Pop()
    {
        if (this.Count == 0)
        {
            throw new InvalidOperationException("The ArrayStack is empty!");
        }
        this.Count--;
        T element = this.elements[this.Count];
        return element;
    }

    public T[] ToArray()
    {
        T[] newArr = new T[this.Count];
        this.CopyAllElementsForToArray(newArr);
        return newArr;
    }

    private void Grow()
    {
        T[] longerArr = new T[this.elements.Length * 2];
        CopyAllElements(longerArr);
        this.elements = longerArr;
        this.endIndex = this.Count;
    }

    private void CopyAllElements(T[] newArr)
    {
        var sourceIndex = 0;
        for (int i = 0; i < this.Count; i++)
        {
            newArr[i] = this.elements[sourceIndex];
            sourceIndex = (sourceIndex + 1) % this.elements.Length;
        }
    }

    private void CopyAllElementsForToArray(T[] arr)
    {
        int startIndex = this.Count - 1;
        for (int i = 0; i < this.Count; i++)
        {
            arr[i] = this.elements[this.Count - 1 - i];
        }
    }

    public IEnumerator<T> GetEnumerator()
    {
        int start = this.Count;
        while (start > 0)
        {
            start--;
            yield return this.elements[start];
        }
    }

    IEnumerator IEnumerable.GetEnumerator()
    {
        return GetEnumerator();
    }
}