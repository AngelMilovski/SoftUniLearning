using System;

class Rectangle
{
    //Constant Fields
    //readonly unalterable Const Field is fixed for a live in object
    private  int width;
    private  int heigth;

    //const unalterable Const Field
    //public const int width = 20;
    //public const int heigth = 30;

    //Release of Constructors instead 2 constructors
    public Rectangle(int size) : this(size, size)
    {
        //this.width = size;              //square size
        //this.heigth = size;
    }

    public Rectangle(int width, int heigth)
    {
        this.width = width;             //rectangle sizes
        this.heigth = heigth;
    }

    public int Width
    {
        get
        {
            return this.width;
        }
    }
    public int Heigth
    {
        get
        {
            return this.heigth;
        }
    }



    //private int width;            These are Fields
    //private int heigth;

    //public int Width              These are Properties
    //{
    //    get
    //    {
    //        return this.width;
    //    }
    //    set
    //    {
    //        if (value < 0)
    //        {
    //            throw new ArgumentOutOfRangeException("The width need to be non-negative!");
    //        }
    //        width = value;
    //    }
    //}
    //public int Heigth
    //{
    //    get
    //    {
    //        return this.heigth;
    //    }
    //    set
    //    {
    //        if (value < 0)
    //        {
    //            throw new ArgumentOutOfRangeException("The heigth need to be non-negative!");
    //        }
    //        heigth = value;
    //    }
    //}

    //public Rectangle(int size)
    //{
    //    this.Width = size;
    //    this.Heigth = size;
    //}

    //public Rectangle(int width, int heigth)
    //{
    //    this.Width = width;
    //    this.Heigth = heigth;
    //}

    public override string ToString()
    {
        return string.Format($"Rect {this.width}, {this.heigth}");
    }

    public string  Area
    {
        get                                       //Property
        {
            int area = this.width * this.heigth;
            return string.Format($"Area = {area}");
        }
    }

    //public int Area()
    //{                                             Method
    //    var area = this.Width * this.Heigth;
    //    return area;
    //}
    
}