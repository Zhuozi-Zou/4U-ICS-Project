// ZOU ZHUOZI 2015081226
// Period 1
// Final Project: App Store

public class CheckDownloads
{
    protected String wantDownload;
    protected String[] haveDownloaded;

    public CheckDownloads (String name, String[] downloads, int size)
    {
	this.haveDownloaded = new String [size];

	this.wantDownload = name;
	for (int i = 0 ; i < size ; i++)
	    this.haveDownloaded [i] = downloads [i];
    }


    public void setWantDownload (String n)
    {
	this.wantDownload = n;
    }


    public String getWantDownload ()
    {
	return wantDownload;
    }


    public void setHaveDownloaded (String p, int loc)
    {
	this.haveDownloaded [loc] = p;
    }


    public String getHaveDownloaded (int loc)
    {
	return haveDownloaded [loc];
    }


    public boolean whetherDownloaded ()
    {
	for (int i = 0 ; i < haveDownloaded.length ; i++)
	{
	    if (wantDownload.equals (haveDownloaded [i]))
		return true;
	}
	return false;
    }
}

