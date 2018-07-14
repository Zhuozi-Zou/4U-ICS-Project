// ZOU ZHUOZI 2015081226
// Period 1
// Final Project: App Store

public class AddTo
{
    protected String name, price;

    public AddTo (String n, String p)
    {
	this.name = n;
	this.price = p;
    }


    public void setName (String n)
    {
	this.name = n;
    }


    public String getName ()
    {
	return name;
    }


    public void setPrice (String p)
    {
	this.price = p;
    }


    public String getPrice ()
    {
	return price;
    }
}
