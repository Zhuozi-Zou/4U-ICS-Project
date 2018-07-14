// ZOU ZHUOZI 2015081226
// Period 1
// Final Project: App Store

import java.io.*;
import java.math.*;
import hsa.*;
// The "AppStore" class.
public class AppStore
{
    static final int maxSize = 100000;


    public static void main (String[] args) throws IOException
    {
	mainMenu ();
    } // main method


    private static void mainMenu () throws IOException
    {
	int choice;
	while (true)
	{
	    Stdout.println ("\n\n");
	    Stdout.println ("\t\t\tApp Store\n\n");
	    Stdout.println ("\t\t********Main Menu********\n");
	    Stdout.println ("\t\t1. Game List");
	    Stdout.println ("\t\t2. Other App List");
	    Stdout.println ("\t\t3. Your Wish List");
	    Stdout.println ("\t\t4. Your Downloads");
	    Stdout.println ("\t\t5. Your Current Balance");
	    Stdout.println ("\t\t0. Quit");

	    Stdout.print ("\n\n\nEnter your choice ---> ");
	    choice = Stdin.readInt ();

	    if (choice == 0)
	    {
		Stdout.println ("Good Bye");
		System.exit (0);
	    }

	    else if (choice == 1)
	    {
		showGameList ();
	    }

	    else if (choice == 2)
	    {
		showOtherAppList ();
	    }

	    else if (choice == 3)
	    {
		showYourWishList ();
	    }

	    else if (choice == 4)
	    {
		showYourDownloads ();
	    }

	    else if (choice == 5)
	    {
		showCurrentBalance ();
	    }

	}
    }


    private static void showGameList () throws IOException
    {
	int choice;
	while (true)
	{
	    Stdout.println ("\n\n\n");
	    Stdout.println ("\t\t********Game List********\n");
	    Stdout.println ("\t\t1. Free Games");
	    Stdout.println ("\t\t2. Paid Games");
	    Stdout.println ("\t\t0. Back to Main Menu");

	    Stdout.print ("\n\n\nEnter your choice ---> ");
	    choice = Stdin.readInt ();

	    if (choice == 0)
	    {
		mainMenu ();
	    }
	    else if (choice == 1)
	    {
		showFreeGames ();
	    }

	    else if (choice == 2)
	    {
		showPaidGames ();
	    }
	}
    }


    private static void showOtherAppList () throws IOException
    {
	int choice;
	while (true)
	{
	    Stdout.println ("\n\n\n");
	    Stdout.println ("\t\t********Other App List********\n");
	    Stdout.println ("\t\t1. Free Apps");
	    Stdout.println ("\t\t2. Paid Apps");
	    Stdout.println ("\t\t0. Back to Main Menu");

	    Stdout.print ("\n\n\nEnter your choice ---> ");
	    choice = Stdin.readInt ();

	    if (choice == 0)
	    {
		mainMenu ();
	    }
	    else if (choice == 1)
	    {
		showFreeOtherApps ();
	    }

	    else if (choice == 2)
	    {
		showPaidOtherApps ();
	    }
	}
    }


    private static void showYourWishList () throws IOException
    {
	int choice, loc;
	String fileName = "wish list.txt";
	String[] wishList = new String [maxSize];
	int size = 0;

	BufferedReader infile;
	infile = new BufferedReader (new FileReader (fileName));
	for (int lines = 0 ; lines < maxSize ; lines++)
	{
	    wishList [lines] = infile.readLine ();
	    if (wishList [lines] == null)
		break;
	    Stdout.println (wishList [lines]);
	    size++;
	}
	infile.close ();

	while (true)
	{
	    Stdout.println ("\n\n\n");
	    Stdout.println ("\t\t********Your Wish List********\n");
	    Stdout.println ("\t\t1. Delete Apps");
	    Stdout.println ("\t\t2. Add More");
	    Stdout.println ("\t\t3. Download All Now");
	    Stdout.println ("\t\t0. Back to Main Menu");

	    Stdout.print ("\n\n\nEnter your choice ---> ");
	    choice = Stdin.readInt ();

	    if (choice == 0)
	    {
		mainMenu ();
	    }
	    else if (choice == 1)
	    {
		Stdout.print ("\n\nEnter the location of the app ---> ");
		loc = Stdin.readInt ();
		deleteAppsFromWishList (wishList, size, loc);
	    }

	    else if (choice == 2)
	    {
		addMoreAppsToWishList ();
	    }
	    else if (choice == 3)
	    {
		downloadNowFromWishList (wishList, size);
	    }
	}
    }


    private static void showYourDownloads () throws IOException
    {
	int choice, loc;
	String fileName = "downloads.txt";
	String[] downloads = new String [maxSize];
	int size = 0;

	BufferedReader infile;
	infile = new BufferedReader (new FileReader (fileName));
	for (int lines = 0 ; lines < maxSize ; lines++)
	{
	    downloads [lines] = infile.readLine ();
	    if (downloads [lines] == null)
		break;
	    Stdout.println (downloads [lines]);
	    size++;
	}
	infile.close ();

	while (true)
	{
	    Stdout.println ("\n\n\n");
	    Stdout.println ("\t\t********Your Downloads********\n");
	    Stdout.println ("\t\t1. Delete Apps");
	    Stdout.println ("\t\t2. Download more");
	    Stdout.println ("\t\t0. Back to Main Menu");

	    Stdout.print ("\n\n\nEnter your choice ---> ");
	    choice = Stdin.readInt ();

	    if (choice == 0)
	    {
		mainMenu ();
	    }
	    else if (choice == 1)
	    {
		Stdout.print ("\n\nEnter the location of the game ---> ");
		loc = Stdin.readInt ();
		deleteAppsFromYourDownloads (downloads, size, loc);
	    }

	    else if (choice == 2)
	    {
		downloadMoreYourDownloads ();

	    }
	}
    }


    private static void showCurrentBalance () throws IOException
    {
	int choice;
	String fileName = "current balance.txt";
	String str;
	double balance, addAmount;

	BufferedReader infile;
	infile = new BufferedReader (new FileReader (fileName));

	str = infile.readLine ();
	infile.close ();

	balance = Double.parseDouble (str);

	Stdout.print ("\nYour Current Balance: $");
	Stdout.println (balance, 0, 2);

	while (true)
	{
	    Stdout.println ("\n\n\n");
	    Stdout.println ("\t\t************************************");
	    Stdout.println ("\t\t1. Add Money");
	    Stdout.println ("\t\t0. Back to Main Menu");
	    Stdout.println ("\t\t************************************");

	    Stdout.print ("\n\n\nEnter your choice ---> ");
	    choice = Stdin.readInt ();

	    if (choice == 0)
	    {
		mainMenu ();
	    }
	    else if (choice == 1)
	    {
		Stdout.print ("\n\nEnter the amount you want to add ---> ");
		addAmount = Stdin.readDouble ();
		addMoney (balance, addAmount);
	    }
	}
    }



    private static void showFreeGames () throws IOException
    {
	int choice, loc;
	int size1, size2, size3, size4, size5;
	int numRat1, numRat2, numRat3, numRat4, numRat5;
	String[] freeGame1 = new String [maxSize];
	String[] freeGame2 = new String [maxSize];
	String[] freeGame3 = new String [maxSize];
	String[] freeGame4 = new String [maxSize];
	String[] freeGame5 = new String [maxSize];
	double rat1, rat2, rat3, rat4, rat5;
	String fileName1 = "free game 1.txt";
	String fileName2 = "free game 2.txt";
	String fileName3 = "free game 3.txt";
	String fileName4 = "free game 4.txt";
	String fileName5 = "free game 5.txt";

	BufferedReader infile;
	infile = new BufferedReader (new FileReader (fileName1));

	size1 = 0;
	for (int lines = 0 ; lines < maxSize ; lines++)
	{
	    freeGame1 [lines] = infile.readLine ();
	    if (freeGame1 [lines] == null)
		break;
	    size1++;
	}
	numRat1 = Integer.parseInt (freeGame1 [size1 - 2]);
	rat1 = Double.parseDouble (freeGame1 [size1 - 1]);

	for (int output = 0 ; output < size1 - 2 ; output++)
	    Stdout.println (freeGame1 [output]);
	Stdout.println ("Number of Ratings: " + numRat1);
	Stdout.println ("Rating: " + rat1);

	infile = new BufferedReader (new FileReader (fileName2));

	size2 = 0;
	for (int lines = 0 ; lines < maxSize ; lines++)
	{
	    freeGame2 [lines] = infile.readLine ();
	    if (freeGame2 [lines] == null)
		break;
	    size2++;
	}
	numRat2 = Integer.parseInt (freeGame2 [size2 - 2]);
	rat2 = Double.parseDouble (freeGame2 [size2 - 1]);

	for (int output = 0 ; output < size2 - 2 ; output++)
	    Stdout.println (freeGame2 [output]);
	Stdout.println ("Number of Ratings: " + numRat2);
	Stdout.println ("Rating: " + rat2);

	infile = new BufferedReader (new FileReader (fileName3));

	size3 = 0;
	for (int lines = 0 ; lines < maxSize ; lines++)
	{
	    freeGame3 [lines] = infile.readLine ();
	    if (freeGame3 [lines] == null)
		break;
	    size3++;
	}
	numRat3 = Integer.parseInt (freeGame3 [size3 - 2]);
	rat3 = Double.parseDouble (freeGame3 [size3 - 1]);

	for (int output = 0 ; output < size3 - 2 ; output++)
	    Stdout.println (freeGame3 [output]);
	Stdout.println ("Number of Ratings: " + numRat3);
	Stdout.println ("Rating: " + rat3);

	infile = new BufferedReader (new FileReader (fileName4));

	size4 = 0;
	for (int lines = 0 ; lines < maxSize ; lines++)
	{
	    freeGame4 [lines] = infile.readLine ();
	    if (freeGame4 [lines] == null)
		break;
	    size4++;
	}
	numRat4 = Integer.parseInt (freeGame4 [size4 - 2]);
	rat4 = Double.parseDouble (freeGame4 [size4 - 1]);

	for (int output = 0 ; output < size4 - 2 ; output++)
	    Stdout.println (freeGame4 [output]);
	Stdout.println ("Number of Ratings: " + numRat4);
	Stdout.println ("Rating: " + rat4);

	infile = new BufferedReader (new FileReader (fileName5));

	size5 = 0;
	for (int lines = 0 ; lines < maxSize ; lines++)
	{
	    freeGame5 [lines] = infile.readLine ();
	    if (freeGame5 [lines] == null)
		break;
	    size5++;
	}
	numRat5 = Integer.parseInt (freeGame5 [size5 - 2]);
	rat5 = Double.parseDouble (freeGame5 [size5 - 1]);

	for (int output = 0 ; output < size5 - 2 ; output++)
	    Stdout.println (freeGame5 [output]);
	Stdout.println ("Number of Ratings: " + numRat5);
	Stdout.println ("Rating: " + rat5);

	infile.close ();

	while (true)
	{
	    Stdout.println ("\n\n\n");
	    Stdout.println ("\t\t********Operating Menu********\n");
	    Stdout.println ("\t\t1. Add to Wish List");
	    Stdout.println ("\t\t2. Download now");
	    Stdout.println ("\t\t3. Rate now");
	    Stdout.println ("\t\t4. Back to Game List");
	    Stdout.println ("\t\t0. Back to Main Menu");

	    Stdout.print ("\n\n\nEnter your choice ---> ");
	    choice = Stdin.readInt ();

	    if (choice == 0)
	    {
		mainMenu ();
	    }
	    else if (choice == 1)
	    {
		Stdout.print ("\n\nEnter the location of the game ---> ");
		loc = Stdin.readInt ();
		while (loc < 1 || loc > 5)
		{
		    Stdout.print ("\nThe location is not valid, please enter again ---> ");
		    loc = Stdin.readInt ();
		}
		if (loc == 1)
		{
		    addToWishList (freeGame1 [4], 0);
		}
		else if (loc == 2)
		{
		    addToWishList (freeGame2 [4], 0);
		}
		else if (loc == 3)
		{
		    addToWishList (freeGame3 [4], 0);
		}
		else if (loc == 4)
		{
		    addToWishList (freeGame4 [4], 0);
		}
		else if (loc == 5)
		{
		    addToWishList (freeGame5 [4], 0);
		}
	    }

	    else if (choice == 2)
	    {
		Stdout.print ("\n\nEnter the location of the game ---> ");
		loc = Stdin.readInt ();
		while (loc < 1 || loc > 5)
		{
		    Stdout.print ("\nThe location is not valid, please enter again ---> ");
		    loc = Stdin.readInt ();
		}
		if (loc == 1)
		{
		    downloadNowSingleFree (freeGame1 [4]);
		}
		else if (loc == 2)
		{
		    downloadNowSingleFree (freeGame2 [4]);
		}
		else if (loc == 3)
		{
		    downloadNowSingleFree (freeGame3 [4]);
		}
		else if (loc == 4)
		{
		    downloadNowSingleFree (freeGame4 [4]);
		}
		else if (loc == 5)
		{
		    downloadNowSingleFree (freeGame5 [4]);
		}
	    }

	    else if (choice == 3)
	    {
		Stdout.print ("\n\nEnter the location of the game ---> ");
		loc = Stdin.readInt ();
		while (loc < 1 || loc > 5)
		{
		    Stdout.print ("\nThe location is not valid, please enter again ---> ");
		    loc = Stdin.readInt ();
		}

		Stdout.print ("\n\nEnter the mark you want to give (out of 5) ---> ");
		double mark = Stdin.readDouble ();
		while (mark < 0 || mark > 5)
		{
		    Stdout.print ("\nThe rating is not valid, please enter again ---> ");
		    mark = Stdin.readDouble ();
		}

		if (loc == 1)
		{
		    rateFreeGames (loc, rat1, numRat1, mark, freeGame1, size1);
		}
		else if (loc == 2)
		{
		    rateFreeGames (loc, rat2, numRat2, mark, freeGame2, size2);
		}
		else if (loc == 3)
		{
		    rateFreeGames (loc, rat3, numRat3, mark, freeGame3, size3);
		}
		else if (loc == 4)
		{
		    rateFreeGames (loc, rat4, numRat4, mark, freeGame4, size4);
		}
		else if (loc == 5)
		{
		    rateFreeGames (loc, rat5, numRat5, mark, freeGame5, size5);
		}
	    }

	    else if (choice == 4)
	    {
		showGameList ();
	    }
	}
    }


    private static void showPaidGames () throws IOException
    {
	int choice, loc;
	int size1, size2, size3, size4, size5;
	int numRat1, numRat2, numRat3, numRat4, numRat5;
	String[] paidGame1 = new String [maxSize];
	String[] paidGame2 = new String [maxSize];
	String[] paidGame3 = new String [maxSize];
	String[] paidGame4 = new String [maxSize];
	String[] paidGame5 = new String [maxSize];
	double rat1, rat2, rat3, rat4, rat5;
	double price1, price2, price3, price4, price5;
	String fileName1 = "paid game 1.txt";
	String fileName2 = "paid game 2.txt";
	String fileName3 = "paid game 3.txt";
	String fileName4 = "paid game 4.txt";
	String fileName5 = "paid game 5.txt";

	BufferedReader infile;
	infile = new BufferedReader (new FileReader (fileName1));

	size1 = 0;
	for (int lines = 0 ; lines < maxSize ; lines++)
	{
	    paidGame1 [lines] = infile.readLine ();
	    if (paidGame1 [lines] == null)
		break;
	    size1++;
	}
	numRat1 = Integer.parseInt (paidGame1 [size1 - 3]);
	price1 = Double.parseDouble (paidGame1 [size1 - 2]);
	rat1 = Double.parseDouble (paidGame1 [size1 - 1]);

	for (int output = 0 ; output < size1 - 3 ; output++)
	    Stdout.println (paidGame1 [output]);
	Stdout.println ("Number of Ratings: " + numRat1);
	Stdout.println ("Price: $" + price1);
	Stdout.println ("Rating: " + rat1);

	infile = new BufferedReader (new FileReader (fileName2));

	size2 = 0;
	for (int lines = 0 ; lines < maxSize ; lines++)
	{
	    paidGame2 [lines] = infile.readLine ();
	    if (paidGame2 [lines] == null)
		break;
	    size2++;
	}
	numRat2 = Integer.parseInt (paidGame2 [size2 - 3]);
	price2 = Double.parseDouble (paidGame2 [size2 - 2]);
	rat2 = Double.parseDouble (paidGame2 [size2 - 1]);

	for (int output = 0 ; output < size2 - 3 ; output++)
	    Stdout.println (paidGame2 [output]);
	Stdout.println ("Number of Ratings: " + numRat2);
	Stdout.println ("Price: $" + price2);
	Stdout.println ("Rating: " + rat2);

	infile = new BufferedReader (new FileReader (fileName3));

	size3 = 0;
	for (int lines = 0 ; lines < maxSize ; lines++)
	{
	    paidGame3 [lines] = infile.readLine ();
	    if (paidGame3 [lines] == null)
		break;
	    size3++;
	}
	numRat3 = Integer.parseInt (paidGame3 [size3 - 3]);
	price3 = Double.parseDouble (paidGame3 [size3 - 2]);
	rat3 = Double.parseDouble (paidGame3 [size3 - 1]);

	for (int output = 0 ; output < size3 - 3 ; output++)
	    Stdout.println (paidGame3 [output]);
	Stdout.println ("Number of Ratings: " + numRat3);
	Stdout.println ("Price: $" + price3);
	Stdout.println ("Rating: " + rat3);

	infile = new BufferedReader (new FileReader (fileName4));

	size4 = 0;
	for (int lines = 0 ; lines < maxSize ; lines++)
	{
	    paidGame4 [lines] = infile.readLine ();
	    if (paidGame4 [lines] == null)
		break;
	    size4++;
	}
	numRat4 = Integer.parseInt (paidGame4 [size4 - 3]);
	price4 = Double.parseDouble (paidGame4 [size4 - 2]);
	rat4 = Double.parseDouble (paidGame4 [size4 - 1]);

	for (int output = 0 ; output < size4 - 3 ; output++)
	    Stdout.println (paidGame4 [output]);
	Stdout.println ("Number of Ratings: " + numRat4);
	Stdout.println ("Price: $" + price4);
	Stdout.println ("Rating: " + rat4);

	infile = new BufferedReader (new FileReader (fileName5));

	size5 = 0;
	for (int lines = 0 ; lines < maxSize ; lines++)
	{
	    paidGame5 [lines] = infile.readLine ();
	    if (paidGame5 [lines] == null)
		break;
	    size5++;
	}
	numRat5 = Integer.parseInt (paidGame5 [size5 - 3]);
	price5 = Double.parseDouble (paidGame5 [size5 - 2]);
	rat5 = Double.parseDouble (paidGame5 [size5 - 1]);

	for (int output = 0 ; output < size5 - 3 ; output++)
	    Stdout.println (paidGame5 [output]);
	Stdout.println ("Number of Ratings: " + numRat5);
	Stdout.println ("Price: $" + price5);
	Stdout.println ("Rating: " + rat5);

	infile.close ();

	while (true)
	{
	    Stdout.println ("\n\n\n");
	    Stdout.println ("\t\t********Operating Menu********\n");
	    Stdout.println ("\t\t1. Add to Wish List");
	    Stdout.println ("\t\t2. Download now");
	    Stdout.println ("\t\t3. Rate now");
	    Stdout.println ("\t\t4. Back to Game List");
	    Stdout.println ("\t\t0. Back to Main Menu");

	    Stdout.print ("\n\n\nEnter your choice ---> ");
	    choice = Stdin.readInt ();

	    if (choice == 0)
	    {
		mainMenu ();
	    }
	    else if (choice == 1)
	    {
		Stdout.print ("\n\nEnter the location of the game ---> ");
		loc = Stdin.readInt ();
		while (loc < 1 || loc > 5)
		{
		    Stdout.print ("\nThe location is not valid, please enter again ---> ");
		    loc = Stdin.readInt ();
		}
		if (loc == 1)
		{
		    addToWishList (paidGame1 [4], price1);
		}
		else if (loc == 2)
		{
		    addToWishList (paidGame2 [4], price2);
		}
		else if (loc == 3)
		{
		    addToWishList (paidGame3 [4], price3);
		}
		else if (loc == 4)
		{
		    addToWishList (paidGame4 [4], price4);
		}
		else if (loc == 5)
		{
		    addToWishList (paidGame5 [4], price5);
		}
	    }

	    else if (choice == 2)
	    {
		Stdout.print ("\n\nEnter the location of the game ---> ");
		loc = Stdin.readInt ();
		while (loc < 1 || loc > 5)
		{
		    Stdout.print ("\nThe location is not valid, please enter again ---> ");
		    loc = Stdin.readInt ();
		}
		if (loc == 1)
		{
		    downloadNowSinglePaid (paidGame1 [4], price1);
		}
		else if (loc == 2)
		{
		    downloadNowSinglePaid (paidGame2 [4], price2);
		}
		else if (loc == 3)
		{
		    downloadNowSinglePaid (paidGame3 [4], price3);
		}
		else if (loc == 4)
		{
		    downloadNowSinglePaid (paidGame4 [4], price4);
		}
		else if (loc == 5)
		{
		    downloadNowSinglePaid (paidGame5 [4], price5);
		}
	    }

	    else if (choice == 3)
	    {
		Stdout.print ("\n\nEnter the location of the game ---> ");
		loc = Stdin.readInt ();
		while (loc < 1 || loc > 5)
		{
		    Stdout.print ("\nThe location is not valid, please enter again ---> ");
		    loc = Stdin.readInt ();
		}

		Stdout.print ("\n\nEnter the mark you want to give (out of 5) ---> ");
		double mark = Stdin.readDouble ();
		while (mark < 0 || mark > 5)
		{
		    Stdout.print ("\nThe rating is not valid, please enter again ---> ");
		    mark = Stdin.readDouble ();
		}

		if (loc == 1)
		{
		    ratePaidGames (loc, rat1, numRat1, mark, paidGame1, size1);
		}
		else if (loc == 2)
		{
		    ratePaidGames (loc, rat2, numRat2, mark, paidGame2, size2);
		}
		else if (loc == 3)
		{
		    ratePaidGames (loc, rat3, numRat3, mark, paidGame3, size3);
		}
		else if (loc == 4)
		{
		    ratePaidGames (loc, rat4, numRat4, mark, paidGame4, size4);
		}
		else if (loc == 5)
		{
		    ratePaidGames (loc, rat5, numRat5, mark, paidGame5, size5);
		}
	    }

	    else if (choice == 4)
	    {
		showGameList ();
	    }
	}
    }


    private static void showFreeOtherApps () throws IOException
    {
	int choice, loc;
	int size1, size2, size3, size4, size5;
	int numRat1, numRat2, numRat3, numRat4, numRat5;
	String[] freeOtherApp1 = new String [maxSize];
	String[] freeOtherApp2 = new String [maxSize];
	String[] freeOtherApp3 = new String [maxSize];
	String[] freeOtherApp4 = new String [maxSize];
	String[] freeOtherApp5 = new String [maxSize];
	double rat1, rat2, rat3, rat4, rat5;
	String fileName1 = "free other app 1.txt";
	String fileName2 = "free other app 2.txt";
	String fileName3 = "free other app 3.txt";
	String fileName4 = "free other app 4.txt";
	String fileName5 = "free other app 5.txt";

	BufferedReader infile;
	infile = new BufferedReader (new FileReader (fileName1));

	size1 = 0;
	for (int lines = 0 ; lines < maxSize ; lines++)
	{
	    freeOtherApp1 [lines] = infile.readLine ();
	    if (freeOtherApp1 [lines] == null)
		break;
	    size1++;
	}
	numRat1 = Integer.parseInt (freeOtherApp1 [size1 - 2]);
	rat1 = Double.parseDouble (freeOtherApp1 [size1 - 1]);

	for (int output = 0 ; output < size1 - 2 ; output++)
	    Stdout.println (freeOtherApp1 [output]);
	Stdout.println ("Number of Ratings: " + numRat1);
	Stdout.println ("Rating: " + rat1);

	infile = new BufferedReader (new FileReader (fileName2));

	size2 = 0;
	for (int lines = 0 ; lines < maxSize ; lines++)
	{
	    freeOtherApp2 [lines] = infile.readLine ();
	    if (freeOtherApp2 [lines] == null)
		break;
	    size2++;
	}
	numRat2 = Integer.parseInt (freeOtherApp2 [size2 - 2]);
	rat2 = Double.parseDouble (freeOtherApp2 [size2 - 1]);

	for (int output = 0 ; output < size2 - 2 ; output++)
	    Stdout.println (freeOtherApp2 [output]);
	Stdout.println ("Number of Ratings: " + numRat2);
	Stdout.println ("Rating: " + rat2);

	infile = new BufferedReader (new FileReader (fileName3));

	size3 = 0;
	for (int lines = 0 ; lines < maxSize ; lines++)
	{
	    freeOtherApp3 [lines] = infile.readLine ();
	    if (freeOtherApp3 [lines] == null)
		break;
	    size3++;
	}
	numRat3 = Integer.parseInt (freeOtherApp3 [size3 - 2]);
	rat3 = Double.parseDouble (freeOtherApp3 [size3 - 1]);

	for (int output = 0 ; output < size3 - 2 ; output++)
	    Stdout.println (freeOtherApp3 [output]);
	Stdout.println ("Number of Ratings: " + numRat3);
	Stdout.println ("Rating: " + rat3);

	infile = new BufferedReader (new FileReader (fileName4));

	size4 = 0;
	for (int lines = 0 ; lines < maxSize ; lines++)
	{
	    freeOtherApp4 [lines] = infile.readLine ();
	    if (freeOtherApp4 [lines] == null)
		break;
	    size4++;
	}
	numRat4 = Integer.parseInt (freeOtherApp4 [size4 - 2]);
	rat4 = Double.parseDouble (freeOtherApp4 [size4 - 1]);

	for (int output = 0 ; output < size4 - 2 ; output++)
	    Stdout.println (freeOtherApp4 [output]);
	Stdout.println ("Number of Ratings: " + numRat4);
	Stdout.println ("Rating: " + rat4);

	infile = new BufferedReader (new FileReader (fileName5));

	size5 = 0;
	for (int lines = 0 ; lines < maxSize ; lines++)
	{
	    freeOtherApp5 [lines] = infile.readLine ();
	    if (freeOtherApp5 [lines] == null)
		break;
	    size5++;
	}
	numRat5 = Integer.parseInt (freeOtherApp5 [size5 - 2]);
	rat5 = Double.parseDouble (freeOtherApp5 [size5 - 1]);

	for (int output = 0 ; output < size5 - 2 ; output++)
	    Stdout.println (freeOtherApp5 [output]);
	Stdout.println ("Number of Ratings: " + numRat5);
	Stdout.println ("Rating: " + rat5);

	infile.close ();

	while (true)
	{
	    Stdout.println ("\n\n\n");
	    Stdout.println ("\t\t********Operating Menu********\n");
	    Stdout.println ("\t\t1. Add to Wish List");
	    Stdout.println ("\t\t2. Download now");
	    Stdout.println ("\t\t3. Rate now");
	    Stdout.println ("\t\t4. Back to Other App List");
	    Stdout.println ("\t\t0. Back to Main Menu");

	    Stdout.print ("\n\n\nEnter your choice ---> ");
	    choice = Stdin.readInt ();

	    if (choice == 0)
	    {
		mainMenu ();
	    }
	    else if (choice == 1)
	    {
		Stdout.print ("\n\nEnter the location of the app ---> ");
		loc = Stdin.readInt ();
		while (loc < 1 || loc > 5)
		{
		    Stdout.print ("\nThe location is not valid, please enter again ---> ");
		    loc = Stdin.readInt ();
		}
		if (loc == 1)
		{
		    addToWishList (freeOtherApp1 [4], 0);
		}
		else if (loc == 2)
		{
		    addToWishList (freeOtherApp2 [4], 0);
		}
		else if (loc == 3)
		{
		    addToWishList (freeOtherApp3 [4], 0);
		}
		else if (loc == 4)
		{
		    addToWishList (freeOtherApp4 [4], 0);
		}
		else if (loc == 5)
		{
		    addToWishList (freeOtherApp5 [4], 0);
		}
	    }

	    else if (choice == 2)
	    {
		Stdout.print ("\n\nEnter the location of the app ---> ");
		loc = Stdin.readInt ();
		while (loc < 1 || loc > 5)
		{
		    Stdout.print ("\nThe location is not valid, please enter again ---> ");
		    loc = Stdin.readInt ();
		}
		if (loc == 1)
		{
		    downloadNowSingleFree (freeOtherApp1 [4]);
		}
		else if (loc == 2)
		{
		    downloadNowSingleFree (freeOtherApp2 [4]);
		}
		else if (loc == 3)
		{
		    downloadNowSingleFree (freeOtherApp3 [4]);
		}
		else if (loc == 4)
		{
		    downloadNowSingleFree (freeOtherApp4 [4]);
		}
		else if (loc == 5)
		{
		    downloadNowSingleFree (freeOtherApp5 [4]);
		}
	    }

	    else if (choice == 3)
	    {
		Stdout.print ("\n\nEnter the location of the game ---> ");
		loc = Stdin.readInt ();
		while (loc < 1 || loc > 5)
		{
		    Stdout.print ("\nThe location is not valid, please enter again ---> ");
		    loc = Stdin.readInt ();
		}

		Stdout.print ("\n\nEnter the mark you want to give (out of 5) ---> ");
		double mark = Stdin.readDouble ();
		while (mark < 0 || mark > 5)
		{
		    Stdout.print ("\nThe rating is not valid, please enter again ---> ");
		    mark = Stdin.readDouble ();
		}

		if (loc == 1)
		{
		    rateFreeOtherApps (loc, rat1, numRat1, mark, freeOtherApp1, size1);
		}
		else if (loc == 2)
		{
		    rateFreeOtherApps (loc, rat2, numRat2, mark, freeOtherApp2, size2);
		}
		else if (loc == 3)
		{
		    rateFreeOtherApps (loc, rat3, numRat3, mark, freeOtherApp3, size3);
		}
		else if (loc == 4)
		{
		    rateFreeOtherApps (loc, rat4, numRat4, mark, freeOtherApp4, size4);
		}
		else if (loc == 5)
		{
		    rateFreeOtherApps (loc, rat5, numRat5, mark, freeOtherApp5, size5);
		}
	    }

	    else if (choice == 4)
	    {
		showOtherAppList ();
	    }
	}
    }


    private static void showPaidOtherApps () throws IOException
    {
	int choice, loc;
	int size1, size2, size3, size4, size5;
	int numRat1, numRat2, numRat3, numRat4, numRat5;
	String[] paidOtherApp1 = new String [maxSize];
	String[] paidOtherApp2 = new String [maxSize];
	String[] paidOtherApp3 = new String [maxSize];
	String[] paidOtherApp4 = new String [maxSize];
	String[] paidOtherApp5 = new String [maxSize];
	double rat1, rat2, rat3, rat4, rat5;
	double price1, price2, price3, price4, price5;
	String fileName1 = "paid other app 1.txt";
	String fileName2 = "paid other app 2.txt";
	String fileName3 = "paid other app 3.txt";
	String fileName4 = "paid other app 4.txt";
	String fileName5 = "paid other app 5.txt";

	BufferedReader infile;
	infile = new BufferedReader (new FileReader (fileName1));

	size1 = 0;
	for (int lines = 0 ; lines < maxSize ; lines++)
	{
	    paidOtherApp1 [lines] = infile.readLine ();
	    if (paidOtherApp1 [lines] == null)
		break;
	    size1++;
	}
	numRat1 = Integer.parseInt (paidOtherApp1 [size1 - 3]);
	price1 = Double.parseDouble (paidOtherApp1 [size1 - 2]);
	rat1 = Double.parseDouble (paidOtherApp1 [size1 - 1]);

	for (int output = 0 ; output < size1 - 3 ; output++)
	    Stdout.println (paidOtherApp1 [output]);
	Stdout.println ("Number of Ratings: " + numRat1);
	Stdout.println ("Price: $" + price1);
	Stdout.println ("Rating: " + rat1);

	infile = new BufferedReader (new FileReader (fileName2));

	size2 = 0;
	for (int lines = 0 ; lines < maxSize ; lines++)
	{
	    paidOtherApp2 [lines] = infile.readLine ();
	    if (paidOtherApp2 [lines] == null)
		break;
	    size2++;
	}
	numRat2 = Integer.parseInt (paidOtherApp2 [size2 - 3]);
	price2 = Double.parseDouble (paidOtherApp2 [size2 - 2]);
	rat2 = Double.parseDouble (paidOtherApp2 [size2 - 1]);

	for (int output = 0 ; output < size2 - 3 ; output++)
	    Stdout.println (paidOtherApp2 [output]);
	Stdout.println ("Number of Ratings: " + numRat2);
	Stdout.println ("Price: $" + price2);
	Stdout.println ("Rating: " + rat2);

	infile = new BufferedReader (new FileReader (fileName3));

	size3 = 0;
	for (int lines = 0 ; lines < maxSize ; lines++)
	{
	    paidOtherApp3 [lines] = infile.readLine ();
	    if (paidOtherApp3 [lines] == null)
		break;
	    size3++;
	}
	numRat3 = Integer.parseInt (paidOtherApp3 [size3 - 3]);
	price3 = Double.parseDouble (paidOtherApp3 [size3 - 2]);
	rat3 = Double.parseDouble (paidOtherApp3 [size3 - 1]);

	for (int output = 0 ; output < size3 - 3 ; output++)
	    Stdout.println (paidOtherApp3 [output]);
	Stdout.println ("Number of Ratings: " + numRat3);
	Stdout.println ("Price: $" + price3);
	Stdout.println ("Rating: " + rat3);

	infile = new BufferedReader (new FileReader (fileName4));

	size4 = 0;
	for (int lines = 0 ; lines < maxSize ; lines++)
	{
	    paidOtherApp4 [lines] = infile.readLine ();
	    if (paidOtherApp4 [lines] == null)
		break;
	    size4++;
	}
	numRat4 = Integer.parseInt (paidOtherApp4 [size4 - 3]);
	price4 = Double.parseDouble (paidOtherApp4 [size4 - 2]);
	rat4 = Double.parseDouble (paidOtherApp4 [size4 - 1]);

	for (int output = 0 ; output < size4 - 3 ; output++)
	    Stdout.println (paidOtherApp4 [output]);
	Stdout.println ("Number of Ratings: " + numRat4);
	Stdout.println ("Price: $" + price4);
	Stdout.println ("Rating: " + rat4);

	infile = new BufferedReader (new FileReader (fileName5));

	size5 = 0;
	for (int lines = 0 ; lines < maxSize ; lines++)
	{
	    paidOtherApp5 [lines] = infile.readLine ();
	    if (paidOtherApp5 [lines] == null)
		break;
	    size5++;
	}
	numRat5 = Integer.parseInt (paidOtherApp5 [size5 - 3]);
	price5 = Double.parseDouble (paidOtherApp5 [size5 - 2]);
	rat5 = Double.parseDouble (paidOtherApp5 [size5 - 1]);

	for (int output = 0 ; output < size5 - 3 ; output++)
	    Stdout.println (paidOtherApp5 [output]);
	Stdout.println ("Number of Ratings: " + numRat5);
	Stdout.println ("Price: $" + price5);
	Stdout.println ("Rating: " + rat5);

	infile.close ();

	while (true)
	{
	    Stdout.println ("\n\n\n");
	    Stdout.println ("\t\t********Operating Menu********\n");
	    Stdout.println ("\t\t1. Add to Wish List");
	    Stdout.println ("\t\t2. Download now");
	    Stdout.println ("\t\t3. Rate now");
	    Stdout.println ("\t\t4. Back to Other App List");
	    Stdout.println ("\t\t0. Back to Main Menu");

	    Stdout.print ("\n\n\nEnter your choice ---> ");
	    choice = Stdin.readInt ();

	    if (choice == 0)
	    {
		mainMenu ();
	    }
	    else if (choice == 1)
	    {
		Stdout.print ("\n\nEnter the location of the app ---> ");
		loc = Stdin.readInt ();
		while (loc < 1 || loc > 5)
		{
		    Stdout.print ("\nThe location is not valid, please enter again ---> ");
		    loc = Stdin.readInt ();
		}
		if (loc == 1)
		{
		    addToWishList (paidOtherApp1 [4], price1);
		}
		else if (loc == 2)
		{
		    addToWishList (paidOtherApp2 [4], price2);
		}
		else if (loc == 3)
		{
		    addToWishList (paidOtherApp3 [4], price3);
		}
		else if (loc == 4)
		{
		    addToWishList (paidOtherApp4 [4], price4);
		}
		else if (loc == 5)
		{
		    addToWishList (paidOtherApp5 [4], price5);
		}
	    }

	    else if (choice == 2)
	    {
		Stdout.print ("\n\nEnter the location of the app ---> ");
		loc = Stdin.readInt ();
		while (loc < 1 || loc > 5)
		{
		    Stdout.print ("\nThe location is not valid, please enter again ---> ");
		    loc = Stdin.readInt ();
		}
		if (loc == 1)
		{
		    downloadNowSinglePaid (paidOtherApp1 [4], price1);
		}
		else if (loc == 2)
		{
		    downloadNowSinglePaid (paidOtherApp2 [4], price2);
		}
		else if (loc == 3)
		{
		    downloadNowSinglePaid (paidOtherApp3 [4], price3);
		}
		else if (loc == 4)
		{
		    downloadNowSinglePaid (paidOtherApp4 [4], price4);
		}
		else if (loc == 5)
		{
		    downloadNowSinglePaid (paidOtherApp5 [4], price5);
		}
	    }

	    else if (choice == 3)
	    {

		Stdout.print ("\n\nEnter the location of the game ---> ");
		loc = Stdin.readInt ();
		while (loc < 1 || loc > 5)
		{
		    Stdout.print ("\nThe location is not valid, please enter again ---> ");
		    loc = Stdin.readInt ();
		}

		Stdout.print ("\n\nEnter the mark you want to give (out of 5) ---> ");
		double mark = Stdin.readDouble ();
		while (mark < 0 || mark > 5)
		{
		    Stdout.print ("\nThe rating is not valid, please enter again ---> ");
		    mark = Stdin.readDouble ();
		}

		if (loc == 1)
		{
		    ratePaidOtherApps (loc, rat1, numRat1, mark, paidOtherApp1, size1);
		}
		else if (loc == 2)
		{
		    ratePaidOtherApps (loc, rat2, numRat2, mark, paidOtherApp2, size2);
		}
		else if (loc == 3)
		{
		    ratePaidOtherApps (loc, rat3, numRat3, mark, paidOtherApp3, size3);
		}
		else if (loc == 4)
		{
		    ratePaidOtherApps (loc, rat4, numRat4, mark, paidOtherApp4, size4);
		}
		else if (loc == 5)
		{
		    ratePaidOtherApps (loc, rat5, numRat5, mark, paidOtherApp5, size5);
		}
	    }

	    else if (choice == 4)
	    {
		showOtherAppList ();
	    }
	}
    }


    private static void addToWishList (String name, double price) throws IOException
    {
	String outputFileLoc = "wish list.txt";
	String fileName = "wish list.txt";
	int num;
	String[] wishList = new String [maxSize];
	int sizeW = 0;
	String[] downloads = new String [maxSize];
	int sizeD = 0;
	String addPrice = "" + price;

	BufferedReader infileW;
	infileW = new BufferedReader (new FileReader (fileName));
	for (int lines = 0 ; lines < maxSize ; lines++)
	{
	    wishList [lines] = infileW.readLine ();
	    if (wishList [lines] == null)
		break;
	    sizeW++;
	}
	infileW.close ();

	CheckWishList boxW = new CheckWishList (name, wishList, sizeW);

	fileName = "downloads.txt";

	BufferedReader infileD;
	infileD = new BufferedReader (new FileReader (fileName));
	for (int lines = 0 ; lines < maxSize ; lines++)
	{
	    downloads [lines] = infileD.readLine ();
	    if (downloads [lines] == null)
		break;
	    sizeD++;
	}
	infileD.close ();

	CheckDownloads boxD = new CheckDownloads (name, downloads, sizeD);


	if (boxW.whetherAdded () == false && boxD.whetherDownloaded () == false)
	{
	    num = sizeW / 7;

	    AddTo[] finalWishList = new AddTo [num + 1];
	    for (int index = 0 ; index < num ; index++)
		finalWishList [index] = new AddTo (wishList [index * 7 + 3], wishList [index * 7 + 6]);
	    finalWishList [num] = new AddTo (name, addPrice);

	    PrintWriter output;
	    output = new PrintWriter (new FileWriter (outputFileLoc));

	    int order = 1;
	    for (int print = 0 ; print < num ; print++)
	    {
		output.println ();
		output.println (order);
		output.println ();
		output.println (finalWishList [print].getName ());
		output.println ();
		output.println ("  price($):");
		output.println (finalWishList [print].getPrice ());
		order++;
	    }
	    output.println ();
	    output.println (order);
	    output.println ();
	    output.println (finalWishList [num].getName ());
	    output.println ();
	    output.println ("  price($):");
	    output.print ("  ");
	    output.println (finalWishList [num].getPrice ());

	    output.close ();
	}
	else if (boxW.whetherAdded ())
	    Stdout.println ("\n\nYou have already added it to your wish list");
	else
	    Stdout.println ("\n\nYou have already downloaded it");
    }


    private static void downloadNowSingleFree (String name) throws IOException
    {
	String outputFileLoc = "downloads.txt";
	String fileName = "wish list.txt";
	int num;
	String[] wishList = new String [maxSize];
	int sizeW = 0;
	String[] downloads = new String [maxSize];
	int sizeD = 0;

	BufferedReader infileW;
	infileW = new BufferedReader (new FileReader (fileName));
	for (int lines = 0 ; lines < maxSize ; lines++)
	{
	    wishList [lines] = infileW.readLine ();
	    if (wishList [lines] == null)
		break;
	    sizeW++;
	}
	infileW.close ();

	CheckWishList boxW = new CheckWishList (name, wishList, sizeW);

	fileName = "downloads.txt";

	BufferedReader infileD;
	infileD = new BufferedReader (new FileReader (fileName));
	for (int lines = 0 ; lines < maxSize ; lines++)
	{
	    downloads [lines] = infileD.readLine ();
	    if (downloads [lines] == null)
		break;
	    sizeD++;
	}
	infileD.close ();

	CheckDownloads boxD = new CheckDownloads (name, downloads, sizeD);

	if (boxW.whetherAdded () == false && boxD.whetherDownloaded () == false)
	{
	    num = sizeD / 7;

	    AddTo[] finalDownloads = new AddTo [num + 1];
	    for (int index = 0 ; index < num ; index++)
		finalDownloads [index] = new AddTo (downloads [index * 7 + 3], downloads [index * 7 + 6]);
	    finalDownloads [num] = new AddTo (name, "0.0");

	    PrintWriter output;
	    output = new PrintWriter (new FileWriter (outputFileLoc));

	    int order = 1;
	    for (int print = 0 ; print < num ; print++)
	    {
		output.println ();
		output.println (order);
		output.println ();
		output.println (finalDownloads [print].getName ());
		output.println ();
		output.println ("  price($):");
		output.println (finalDownloads [print].getPrice ());
		order++;
	    }
	    output.println ();
	    output.println (order);
	    output.println ();
	    output.println (finalDownloads [num].getName ());
	    output.println ();
	    output.println ("  price($):");
	    output.print ("  ");
	    output.println (finalDownloads [num].getPrice ());

	    output.close ();
	}
	else if (boxW.whetherAdded ())
	{
	    Stdout.println ("\n\nYou have already added it to your wish list.");
	    Stdout.println ("If you still want to download it now,");
	    Stdout.println ("please delete it from your wish list first");
	}
	else
	    Stdout.println ("\n\nYou have already downloaded it");
    }


    private static void downloadNowSinglePaid (String name, double price) throws IOException
    {
	String outputFileLoc = "downloads.txt";
	String fileName = "wish list.txt";
	int num;
	String[] wishList = new String [maxSize];
	int sizeW = 0;
	String[] downloads = new String [maxSize];
	int sizeD = 0;
	String addPrice = "" + price;
	double currentBal = getCurrentBalance ();
	double finalBal = currentBal - price;

	BufferedReader infileW;
	infileW = new BufferedReader (new FileReader (fileName));
	for (int lines = 0 ; lines < maxSize ; lines++)
	{
	    wishList [lines] = infileW.readLine ();
	    if (wishList [lines] == null)
		break;
	    sizeW++;
	}
	infileW.close ();

	CheckWishList boxW = new CheckWishList (name, wishList, sizeW);

	fileName = "downloads.txt";

	BufferedReader infileD;
	infileD = new BufferedReader (new FileReader (fileName));
	for (int lines = 0 ; lines < maxSize ; lines++)
	{
	    downloads [lines] = infileD.readLine ();
	    if (downloads [lines] == null)
		break;
	    sizeD++;
	}
	infileD.close ();

	CheckDownloads boxD = new CheckDownloads (name, downloads, sizeD);

	if (boxW.whetherAdded () == false && boxD.whetherDownloaded () == false)
	{
	    Stdout.print ("\nCost: $");
	    Stdout.println (price, 0, 2);

	    if (finalBal >= 0)
	    {
		Stdout.print ("\nYour Current Balance: $");
		Stdout.println (currentBal, 0, 2);
		Stdout.print ("\nAre you sure you want to download it? ('y' or 'n') ---> ");
		char confirmation = Stdin.readChar ();
		while (confirmation != 'y' && confirmation != 'n' && confirmation != 'Y' && confirmation != 'N')
		{
		    Stdout.println ("What you've entered is not valid, please enter again");
		    confirmation = Stdin.readChar ();
		}

		if (confirmation == 'y' || confirmation == 'Y')
		{
		    num = sizeD / 7;

		    AddTo[] finalDownloads = new AddTo [num + 1];
		    for (int index = 0 ; index < num ; index++)
			finalDownloads [index] = new AddTo (downloads [index * 7 + 3], downloads [index * 7 + 6]);
		    finalDownloads [num] = new AddTo (name, addPrice);

		    PrintWriter output;
		    output = new PrintWriter (new FileWriter (outputFileLoc));

		    int order = 1;
		    for (int print = 0 ; print < num ; print++)
		    {
			output.println ();
			output.println (order);
			output.println ();
			output.println (finalDownloads [print].getName ());
			output.println ();
			output.println ("  price($):");
			output.println (finalDownloads [print].getPrice ());
			order++;
		    }
		    output.println ();
		    output.println (order);
		    output.println ();
		    output.println (finalDownloads [num].getName ());
		    output.println ();
		    output.println ("  price($):");
		    output.print ("  ");
		    output.println (finalDownloads [num].getPrice ());
		    output.close ();

		    outputFileLoc = "current balance.txt";

		    PrintWriter bal;
		    bal = new PrintWriter (new FileWriter (outputFileLoc));

		    BigDecimal outputBal = new BigDecimal ("" + finalBal);
		    outputBal = outputBal.setScale (2, BigDecimal.ROUND_HALF_UP);

		    bal.println (outputBal);
		    bal.close ();
		}
	    }

	    else
	    {
		Stdout.println ("\nYour current balance is less than the price of the app, please add more money");
		showCurrentBalance ();
	    }
	}
	else if (boxW.whetherAdded ())
	{
	    Stdout.println ("\n\nYou have already added it to your wish list.");
	    Stdout.println ("If you still want to download it now,");
	    Stdout.println ("please delete it from your wish list first");
	}
	else
	    Stdout.println ("\n\nYou have already downloaded it");
    }


    private static void rateFreeGames (int location, double currentRating, int numRating, double rating, String[] info, int size) throws IOException
    {
	double finalRating = (currentRating * numRating + rating) / (numRating + 1);
	numRating++;
	info [size - 2] = "" + numRating;
	String fileName = "downloads.txt";
	int sizeD = 0;
	String[] downloads = new String [maxSize];

	BufferedReader infile;
	infile = new BufferedReader (new FileReader (fileName));
	for (int lines = 0 ; lines < maxSize ; lines++)
	{
	    downloads [lines] = infile.readLine ();
	    if (downloads [lines] == null)
		break;
	    sizeD++;
	}
	infile.close ();

	CheckDownloads box = new CheckDownloads (info [4], downloads, sizeD);

	if (box.whetherDownloaded ())
	{
	    BigDecimal outputRating = new BigDecimal ("" + finalRating);
	    outputRating = outputRating.setScale (1, BigDecimal.ROUND_HALF_UP);

	    String outputFileLoc = "free game " + ("" + location) + ".txt";

	    PrintWriter output;
	    output = new PrintWriter (new FileWriter (outputFileLoc));

	    for (int i = 0 ; i < size - 1 ; i++)
		output.println (info [i]);
	    output.println (outputRating);
	    output.close ();

	    showFreeGames ();
	}
	else
	    Stdout.println ("\n\nSorry, you have to download the game first");
    }


    private static void ratePaidGames (int location, double currentRating, int numRating, double rating, String[] info, int size) throws IOException
    {
	double finalRating = (currentRating * numRating + rating) / (numRating + 1);
	numRating++;
	info [size - 3] = "" + numRating;
	String fileName = "downloads.txt";
	int sizeD = 0;
	String[] downloads = new String [maxSize];

	BufferedReader infile;
	infile = new BufferedReader (new FileReader (fileName));
	for (int lines = 0 ; lines < maxSize ; lines++)
	{
	    downloads [lines] = infile.readLine ();
	    if (downloads [lines] == null)
		break;
	    sizeD++;
	}
	infile.close ();

	CheckDownloads box = new CheckDownloads (info [4], downloads, sizeD);

	if (box.whetherDownloaded ())
	{
	    BigDecimal outputRating = new BigDecimal ("" + finalRating);
	    outputRating = outputRating.setScale (1, BigDecimal.ROUND_HALF_UP);

	    String outputFileLoc = "paid game " + ("" + location) + ".txt";

	    PrintWriter output;
	    output = new PrintWriter (new FileWriter (outputFileLoc));

	    for (int i = 0 ; i < size - 1 ; i++)
		output.println (info [i]);
	    output.println (outputRating);
	    output.close ();

	    showPaidGames ();
	}
	else
	    Stdout.println ("\n\nSorry, you have to download the game first");
    }


    private static void rateFreeOtherApps (int location, double currentRating, int numRating, double rating, String[] info, int size) throws IOException
    {
	double finalRating = (currentRating * numRating + rating) / (numRating + 1);
	numRating++;
	info [size - 2] = "" + numRating;
	String fileName = "downloads.txt";
	int sizeD = 0;
	String[] downloads = new String [maxSize];

	BufferedReader infile;
	infile = new BufferedReader (new FileReader (fileName));
	for (int lines = 0 ; lines < maxSize ; lines++)
	{
	    downloads [lines] = infile.readLine ();
	    if (downloads [lines] == null)
		break;
	    sizeD++;
	}
	infile.close ();

	CheckDownloads box = new CheckDownloads (info [4], downloads, sizeD);

	if (box.whetherDownloaded ())
	{
	    BigDecimal outputRating = new BigDecimal ("" + finalRating);
	    outputRating = outputRating.setScale (1, BigDecimal.ROUND_HALF_UP);

	    String outputFileLoc = "free other app " + ("" + location) + ".txt";

	    PrintWriter output;
	    output = new PrintWriter (new FileWriter (outputFileLoc));

	    for (int i = 0 ; i < size - 1 ; i++)
		output.println (info [i]);
	    output.println (outputRating);
	    output.close ();

	    showFreeOtherApps ();
	}
	else
	    Stdout.println ("\n\nSorry, you have to download the game first");
    }


    private static void ratePaidOtherApps (int location, double currentRating, int numRating, double rating, String[] info, int size) throws IOException
    {
	double finalRating = (currentRating * numRating + rating) / (numRating + 1);
	numRating++;
	info [size - 3] = "" + numRating;
	String fileName = "downloads.txt";
	int sizeD = 0;
	String[] downloads = new String [maxSize];

	BufferedReader infile;
	infile = new BufferedReader (new FileReader (fileName));
	for (int lines = 0 ; lines < maxSize ; lines++)
	{
	    downloads [lines] = infile.readLine ();
	    if (downloads [lines] == null)
		break;
	    sizeD++;
	}
	infile.close ();

	CheckDownloads box = new CheckDownloads (info [4], downloads, sizeD);

	if (box.whetherDownloaded ())
	{
	    BigDecimal outputRating = new BigDecimal ("" + finalRating);
	    outputRating = outputRating.setScale (1, BigDecimal.ROUND_HALF_UP);

	    String outputFileLoc = "paid other app " + ("" + location) + ".txt";

	    PrintWriter output;
	    output = new PrintWriter (new FileWriter (outputFileLoc));

	    for (int i = 0 ; i < size - 1 ; i++)
		output.println (info [i]);
	    output.println (outputRating);
	    output.close ();

	    showPaidOtherApps ();
	}
	else
	    Stdout.println ("\n\nSorry, you have to download the game first");
    }



    private static void deleteAppsFromWishList (String[] wishList, int currentSize, int location) throws IOException
    {
	currentSize = currentSize - 7;
	int num = currentSize / 7;
	int order = 0;
	int details;
	String outputFileLoc = "wish list.txt";
	int lines = (location - 1) * 7;

	for (int move = lines ; move < currentSize ; move++)
	    wishList [move] = wishList [move + 7];


	PrintWriter output;
	output = new PrintWriter (new FileWriter (outputFileLoc));

	for (int index = 0 ; index < num ; index++)
	{
	    order++;

	    output.println ();
	    output.println (order);
	    output.println ();

	    details = index * 7 + 3;

	    for (int i = 0 ; i < 4 ; i++)
	    {
		output.println (wishList [details]);
		details++;
	    }
	}
	output.close ();
	showYourWishList ();
    }


    private static void addMoreAppsToWishList () throws IOException
    {
	int choice;
	while (true)
	{
	    Stdout.println ("\n\n\n");
	    Stdout.println ("\t\t************************************");
	    Stdout.println ("\t\t1. Add more games");
	    Stdout.println ("\t\t2. Add more other apps");
	    Stdout.println ("\t\t3. Back to Your Wish List");
	    Stdout.println ("\t\t0. Back to Main Menu");
	    Stdout.println ("\t\t************************************");

	    Stdout.print ("\n\n\nEnter your choice ---> ");
	    choice = Stdin.readInt ();

	    if (choice == 0)
	    {
		mainMenu ();
	    }
	    else if (choice == 1)
	    {
		showGameList ();
	    }

	    else if (choice == 2)
	    {
		showOtherAppList ();
	    }

	    else if (choice == 3)
	    {
		showYourWishList ();
	    }
	}
    }


    private static void downloadNowFromWishList (String[] wishList, int currentSize) throws IOException
    {
	if (currentSize == 0)
	{
	    Stdout.println ("You wish list is empty");
	    addMoreAppsToWishList ();
	}
	else
	{
	    int num = currentSize / 7;
	    int price = 6;
	    double totalCost = 0;
	    double[] cost = new double [num];

	    for (int i = 0 ; i < num ; i++)
	    {
		cost [i] = Double.parseDouble (wishList [price]);
		price = price + 7;
	    }

	    for (int i = 0 ; i < num ; i++)
		totalCost = totalCost + cost [i];

	    Stdout.print ("\nTotal Cost: $");
	    Stdout.println (totalCost, 0, 2);

	    double currentBal = getCurrentBalance ();
	    double finalBal = currentBal - totalCost;

	    if (finalBal >= 0)
	    {
		Stdout.print ("\nYour Current Balance: $");
		Stdout.println (currentBal, 0, 2);
		Stdout.print ("\nAre you sure you want to download it? ('y' or 'n') ---> ");
		char confirmation = Stdin.readChar ();
		while (confirmation != 'y' && confirmation != 'n' && confirmation != 'Y' && confirmation != 'N')
		{
		    Stdout.println ("What you've entered is not valid, please enter again");
		    confirmation = Stdin.readChar ();
		}

		if (confirmation == 'y' || confirmation == 'Y')
		{
		    String outputFileLoc = "wish list.txt";

		    PrintWriter output;
		    output = new PrintWriter (new FileWriter (outputFileLoc));

		    output.println ("");
		    output.close ();


		    outputFileLoc = "current balance.txt";

		    PrintWriter bal;
		    bal = new PrintWriter (new FileWriter (outputFileLoc));

		    BigDecimal outputBal = new BigDecimal ("" + finalBal);
		    outputBal = outputBal.setScale (2, BigDecimal.ROUND_HALF_UP);

		    bal.println ("" + outputBal);
		    bal.close ();

		    addToDownloads (wishList, currentSize);

		    showYourWishList ();
		}
	    }
	    else
	    {
		Stdout.println ("\nYour current balance is less than the price of the app, please add more money");
		showCurrentBalance ();
	    }
	}
    }


    private static void deleteAppsFromYourDownloads (String[] downloads, int currentSize, int location) throws IOException
    {
	currentSize = currentSize - 7;
	int num = currentSize / 7;
	int order = 0;
	int details;
	String outputFileLoc = "downloads.txt";
	int lines = (location - 1) * 7;

	for (int move = lines ; move < currentSize ; move++)
	    downloads [move] = downloads [move + 7];


	PrintWriter output;
	output = new PrintWriter (new FileWriter (outputFileLoc));

	for (int index = 0 ; index < num ; index++)
	{
	    order++;

	    output.println ();
	    output.println (order);
	    output.println ();

	    details = index * 7 + 3;

	    for (int i = 0 ; i < 4 ; i++)
	    {
		output.println (downloads [details]);
		details++;
	    }
	}
	output.close ();
	showYourDownloads ();
    }


    private static void downloadMoreYourDownloads () throws IOException
    {
	int choice;
	while (true)
	{
	    Stdout.println ("\n\n\n");
	    Stdout.println ("\t\t************************************");
	    Stdout.println ("\t\t1. Download more games");
	    Stdout.println ("\t\t2. Download more other apps");
	    Stdout.println ("\t\t3. Back to Your Downloads");
	    Stdout.println ("\t\t0. Back to Main Menu");
	    Stdout.println ("\t\t************************************");

	    Stdout.print ("\n\n\nEnter your choice ---> ");
	    choice = Stdin.readInt ();

	    if (choice == 0)
	    {
		mainMenu ();
	    }
	    else if (choice == 1)
	    {
		showGameList ();
	    }

	    else if (choice == 2)
	    {
		showOtherAppList ();

	    }

	    else if (choice == 3)
	    {
		showYourDownloads ();
	    }
	}
    }



    private static void addMoney (double currentBal, double addMoney) throws IOException
    {
	String outputFileLoc = "current balance.txt";

	PrintWriter output;
	output = new PrintWriter (new FileWriter (outputFileLoc));

	BigDecimal outputBal = new BigDecimal ("" + (currentBal + addMoney));
	outputBal = outputBal.setScale (2, BigDecimal.ROUND_HALF_UP);

	output.println (outputBal);
	output.close ();

	showCurrentBalance ();
    }


    private static double getCurrentBalance () throws IOException
    {
	String fileName = "current balance.txt";
	String str;
	double balance;

	BufferedReader infile;
	infile = new BufferedReader (new FileReader (fileName));

	str = infile.readLine ();
	infile.close ();

	balance = Double.parseDouble (str);

	return balance;
    }


    private static void addToDownloads (String[] wishList, int addSize) throws IOException
    {
	String outputFileLoc = "downloads.txt";
	String fileName = "downloads.txt";
	String[] downloads = new String [maxSize];
	int size = 0;

	BufferedReader infile;
	infile = new BufferedReader (new FileReader (fileName));
	for (int lines = 0 ; lines < maxSize ; lines++)
	{
	    downloads [lines] = infile.readLine ();
	    if (downloads [lines] == null)
		break;
	    size++;
	}
	infile.close ();

	int num = addSize / 7;

	AddTo[] finalDownloads = new AddTo [num];
	for (int index = 0 ; index < num ; index++)
	    finalDownloads [index] = new AddTo (wishList [index * 7 + 3], wishList [index * 7 + 6]);

	PrintWriter output;
	output = new PrintWriter (new FileWriter (outputFileLoc));

	for (int print = 0 ; print < size ; print++)
	    output.println (downloads [print]);

	int order = size / 7 + 1;
	for (int print = 0 ; print < num ; print++)
	{
	    output.println ();
	    output.println (order);
	    output.println ();
	    output.println (finalDownloads [print].getName ());
	    output.println ();
	    output.println ("  price($):");
	    output.println (finalDownloads [print].getPrice ());
	    order++;
	}
	output.close ();
    }
} // AppStore class


