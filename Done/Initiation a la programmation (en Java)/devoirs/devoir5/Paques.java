/**
 * @author Hernani Costa
 *
 * @version 0.1/2014
 */

import java.util.Scanner;

public class Paques
{
	private final static Scanner CLAVIER = new Scanner(System.in);

	public static int demanderAnnee()
	{
		int year = 0;
		while (year < 1583 || year > 4000)
		{
			System.out.println("Entrez une annee (1583-4000) : ");
			year = CLAVIER.nextInt();
		}
		return year;
	}

	public static void afficheDate(int year, int ndays)
	{
		// System.out.println(ndays);
		if (ndays <= 31)
		{
			System.out.println("Date de Paques en " + year + " : " + ndays + " mars");
		} else
		{
			System.out.println("Date de Paques en " + year + " : " + (ndays - 31) + " avril");
			// System.out.println("Date de Paques en " + year + " : " + (ndays-31) + " avril");
		}
	}

	public static int datePaques2(int year)
	{
		int y = year;
		// Divide y by 19 and call the remainder a. Ignore the quotient.
		int a = y % 19;

		// [DONE] Divide y by 100 to get a quotient b and a remainder c.
		int b = y / 100;
		int c = y % 100;

		// Divide b by 4 to get a quotient d and a remainder e.
		int d = b / 4;
		int e = b % 4;

		// [DONE] Divide 8 * b + 13 by 25 to get a quotient g. Ignore the remainder.
		int g = (8 * b + 13) / 25;

		// Divide 19 * a + b - d - g + 15 by 30 to get a remainder h. Ignore the quotient.
		int h = (19 * a + b - d - g + 15) % 30;

		// Divide c by 4 to get a quotient j and a remainder k.
		int j = c / 4; // [DONE]
		int k = c % 4;

		// Divide a + 11 * h by 319 to get a quotient m. Ignore the remainder.
		int m = (a + 11 * h) / 319;

		// Divide 2 * e + 2 * j - k - h + m + 32 by 7 to get a remainder r. Ignore the quotient.
		int r = (2 * e + 2 * j - k - h + m + 32) % 7;

		// Divide h - m + r + 90 by 25 to get a quotient n. Ignore the remainder.
		int n = (h - m + r + 90) / 25;

		// Divide h - m + r + n + 19 by 32 to get a remainder p.
		int p = (h - m + r + n + 19) % 32;

		return p;
	}

	public static int datePaques(int year)
	{
		int y = year;

		// the century. It is sufficient to divide the year by 100 ;
		int century = y / 100;
		// int c = y % 100;

		// a value p that is 13 plus 8 times the century, the whole divided by 25 ;
		int p = (13 + 8 * century) / 25;

		// a value q, division of the century by 4 ;
		int q = century / 4;

		// a value m that is (15 - p + century - q) modulo 30 ;
		int m = (15 - p + century - q) % 30;

		// a value n that is (4 + century - q) modulo 7 ;
		int n = (4 + century - q) % 7;

		// a value d that is m plus 19 times « the year modulo 19 », the whole modulo 30 ;
		int d = (m + 19 * (year % 19)) % 30;

		// a value e which would be too complicated to describe in english and that we give you directly :
		int e = (2 * (year % 4) + 4 * (year % 7) + 6 * d + n) % 7;

		// if e is 6
		// –
		// and : ((d is 29 or d is 28) and (11*(m+1) modulo 30 is less than 19)),
		//
		// 7 should be subtracted from the day.
		int day = e + d + 22;
		// if ((e == 6))
		// {
		// if (((d == 26) || (d == 28)) && ((11 * (m + 1)) % 30 < 19))
		if (e == 6 && ( (d == 29 || d == 28) && ( ( (11 * (m + 1)) % 30) < 19) ))
		{
			day -= 7;
		}

		return day;
	}

	public static void main(String args[])
	{
		// afficheDate(3050, 53);
		int year = demanderAnnee();
		int day = datePaques(year);
		afficheDate(year, day);
	}

}
