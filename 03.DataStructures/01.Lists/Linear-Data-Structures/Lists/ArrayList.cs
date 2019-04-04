using System;
using System.Linq;

public class ArrayList<T>
{
    private T[] data;

    public ArrayList()
    {
        this.data = new T[2];
    }

    public int Count
    {
        get;
        private set;
    }

    public int Capacity
    {
        get;
        private set;
    }

    public T this[int index]
    {
        get
        {
            if (index < 0 || index >= this.Count)
            {
                throw new ArgumentOutOfRangeException();
            }
            return this.data[index];
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
        if (this.Count < 0 || this.Count >= this.data.Length)
        {
            this.Resize();
        }
        this.data[this.Count] = item;
        this.Count++;
    }

    private void Resize()
    {
        T[] newArrey = new T[this.Count * 2];
        Array.Copy(this.data, newArrey, this.Count);
        this.Capacity = newArrey.Length;
        this.data = newArrey;
    }

    public T RemoveAt(int index)
    {
        if (index < 0 || index >= this.Count)
        {
            throw new ArgumentOutOfRangeException();
        }
        T item = this.data[index];
        this.data[index] = default(T);
        for (int i = index; i < this.Count - 1; i++)
        {
            this.data[i] = this.data[i + 1];
        }
        this.Count--;


        if (this.Count <= this.data.Length / 4)
        {
            this.Shrink();
        }

        return item;
    }

    private void Shrink()
    {
        T[] newArray = new T[this.data.Length / 2];
        Array.Copy(this.data, newArray, this.Count);
        this.Capacity = newArray.Length;
        this.data = newArray;
    }

    public override string ToString()
    {
        string[] output = new string[this.Count];
        for (int i = 0; i < this.Count; i++)
        {
            output[i] = this.data[i].ToString();
        }

        return string.Join(" ", output);
    }
}