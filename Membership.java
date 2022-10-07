/**
 * Store details of a club membership.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 */
public class Membership
{
    // The name of the member.
    private String name;
    // The month in which the membership was taken out.
    private int month;
    // The year in which the membership was taken out.
    private int year;
    // Assignment 10, for the really bored
    private int bdayMonth;
    private int bdayYear;

    /**
     * Constructor for objects of class Membership.
     * @param name The name of the member.
     * @param month The month in which they joined. (1 ... 12)
     * @param year The year in which they joined.
     */
    public Membership(String name, int month, int year)
        throws IllegalArgumentException
    {
        this(name, month, year, 1, 2000);
    }
    
    /**
     * Assigment 10
     * Overload constructor for objects of class Membership.
     * @param name The name of the member.
     * @param month The month in which they joined. (1 ... 12)
     * @param year The year in which they joined.
     * @param bdayMonth The month of the birthday.
     * @param bdayYear The month of the birthday.
     */
    public Membership(String name, int month, int year,
        int bdayMonth, int bdayYear) throws IllegalArgumentException
    {
        if(month < 1 || month > 12 || bdayMonth < 1 || bdayMonth > 12) {
            throw new IllegalArgumentException(
                "Month " + month + " out of range. Must be in the range 1 ... 12");
        }
        this.name = name;
        this.month = month;
        this.year = year;
        this.bdayMonth = bdayMonth;
        this.bdayYear = bdayYear;
    }
    
    /**
     * @return The member's name.
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * @return The month in which the member joined.
     *         A value in the range 1 ... 12
     */
    public int getMonth()
    {
        return month;
    }

    /**
     * @return The year in which the member joined.
     */
    public int getYear()
    {
        return year;
    }

    /**
     * @return A string representation of this membership.
     */
    public String toString()
    {
        return "Name: " + name +
               " joined in month " +
               month + " of " + year;
    }
    
    /**
     * @return The month in which the member has birthday.
     *         A value in the range 1 ... 12
     */
    public int getBdayMonth()
    {
        return bdayMonth;
    }

    /**
     * @return The year in which the member has birthday.
     */
    public int getBdayYear()
    {
        return bdayYear;
    }
    
    /**
     * Sets the members birthday to the given month and year.
     * @param month The month of the birthday.
     * @param year  The year of the birthday.
     */
    public void setBday(int month, int year) {
        bdayMonth = month;
        bdayYear = year;
    }
}
