// ZOU ZHUOZI 2015081226
// Period 1
// Final Project: App Store

public class CheckWishList
{
    protected String wantAdd;
    protected String[] haveAdded;

    public CheckWishList (String name, String[] wishList, int size)
    {
	this.haveAdded = new String [size];

	this.wantAdd = name;
	for (int i = 0 ; i < size ; i++)
	    this.haveAdded [i] = wishList [i];
    }


    public void setWantAdd (String n)
    {
	this.wantAdd = n;
    }


    public String getWantAdd ()
    {
	return wantAdd;
    }


    public void setHaveAdded (String p, int loc)
    {
	this.haveAdded [loc] = p;
    }


    public String getHaveAdded (int loc)
    {
	return haveAdded [loc];
    }


    public boolean whetherAdded ()
    {
	for (int i = 0 ; i < haveAdded.length ; i++)
	{
	    if (wantAdd.equals (haveAdded [i]))
		return true;
	}
	return false;
    }
}
