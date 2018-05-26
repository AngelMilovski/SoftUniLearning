public class CircularQueue<T>
{
    private T[] elements;
    private int startIndex;
    private int endIndex;

    public int Count
    {
        get;
        private set;
    }

    private const int DefaultCapacity = 16;
    public CircularQueue(int capacity = DefaultCapacity)
    {
        this.elements = new T[capacity];
    }

    public void Enqueue(T element)
    {
        if (this.Count >= this.elements.Length)
        {
            this.Resize();
        }
        this.elements[this.endIndex] = element;
        this.endIndex = (this.endIndex + 1) % this.elements.Length;
        Count++;
    }

    private void Resize()
    {
        T[] newArr = new T[this.elements.Length * 2];
        this.CopyAllElements(newArr);
        this.elements = newArr;
        this.startIndex = 0;
        this.endIndex = this.Count;
    }

    private void CopyAllElements(T[] newArray)
    {
        int sourceIndex = this.startIndex;
        for (int i = 0; i < this.Count; i++)
        {
            newArray[i] = this.elements[sourceIndex];
            sourceIndex = (sourceIndex + 1) % this.elements.Length;
        }
    }

    public T Dequeue()
    {
        if (this.Count == 0)
        {
            throw new System.InvalidOperationException("The queue is empty!");
        }
        T element = elements[startIndex];
        this.startIndex = (this.startIndex + 1) % this.elements.Length;
        Count--;
        return element;
    }

    public T[] ToArray()
    {
        T[] resultArr = new T[this.Count];
        this.CopyAllElements(resultArr);
        return resultArr;
    }
}
