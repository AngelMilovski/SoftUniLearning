namespace Dogs
{
    public class Dog
    {
        //Properties
        public string Name { get; set; }

        public string Breed { get; set; }

        //Constructors
        public Dog() :this(null, null)
        {
            
        }
        
        public Dog(string name, string breed)
        {
            this.Name = name;
            this.Breed = breed;
        }

        //Method
        public string Bark()
        {
            return string.Format("{0} ({1}) says Bauuuu!"
                , this.Name ?? "unnamed dog"
                , this.Breed != null ? this.Breed : "no breed");
        }

        //override
        public override string ToString()
        {
            return string.Format("{0} ({1}) says Bauuuu!"
                , this.Name ?? "unnamed dog"
                , this.Breed ?? "I don`t know it breed");
        }
    }
}