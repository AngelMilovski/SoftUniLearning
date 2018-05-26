using System;
using System.Collections;
using System.Collections.Generic;

public class ReversedList<T> : IEnumerable<T>
{
    private T[] data;

    public ReversedList()
    {
        this.data = new T[2];
        this.Capacity = 2;
    }
    public int Capacity { get; private set; }

    public int Count { get; private set; }

    public T this[int index]
    {
        get
        {
            if (index < 0 || index >= this.Count)
            {
                throw new ArgumentOutOfRangeException();
            }
            return this.data[this.Count - 1 - index];
        }
        set
        {
            if (index < 0 || index >= this.Count)
            {
                throw new ArgumentOutOfRangeException();
            }
            this.data[index] = value;
        }
    }

    public void Add(T item)
    {
        if (this.Count >= this.data.Length)
        {
            this.Resize();
        }

        this.data[this.Count] = item;
        this.Count++;
    }

    private void Resize()
    {
        this.Capacity *= 2;
        T[] longerArr = new T[this.Capacity];
        this.CopyAllElements(longerArr);
        this.data = longerArr;
    }

    private void CopyAllElements(T[] newArray)
    {
        int sourseIndex = 0;
        for (int i = 0; i < this.Count; i++)
        {
            newArray[i] = this.data[sourseIndex];
            sourseIndex = (sourseIndex + 1) % this.data.Length;
        }
    }
    public T RemoveAt(int index)
    {
        if (index < 0 || index >= this.Count)
        {
            throw new ArgumentOutOfRangeException();
        }
        T element = this[index];
        this.data[this.Count - 1 - index] = default(T);

        for (int i = this.Count - 1 - index; i < this.Count - 1; i++)
        {
            this.data[i] = this.data[i + 1];
        }
        this.Count--;
        if (this.Count <= this.data.Length / 4)
        {
            this.Shrink();
        }

        return element;
    }

    private void Shrink()
    {
        T[] newArr = new T[this.data.Length / 2];
        this.CopyAllElements(newArr);
    }

    public IEnumerator<T> GetEnumerator()
    {
        for (int i = 0; i < this.Count; i++)
        {
            yield return this[i];
        }
    }

    IEnumerator IEnumerable.GetEnumerator()
    {
        return GetEnumerator();
    }

    public override string ToString()
    {
        return string.Join(", ", this.data);
    }
}