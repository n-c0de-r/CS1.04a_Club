import java.util.ArrayList;
import java.util.Iterator;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Collections;

/**
 * Store details of club memberships.
 * 
 * @author n-c0de-r 
 * @version 22-10-04
 */
public class Club
{
    // Assignment 1
    ArrayList<Membership> memberships; 
    /**
     * Constructor for objects of class Club
     */
    public Club()
    {
        //  Assignment 1
        memberships = new ArrayList<Membership>();
        // Helper method, fills club with members for testing
        addTestMembers();
    }

    /**
     * Add a new member to the club's list of members.
     * @param member The member object to be added.
     */
    public void join(Membership member)
    {
        // Assignment 6
        String searchName = member.getName();
        Membership found = search(searchName);
        if (found != null) {
            System.out.println(searchName + " is already a member!");
            return; // Breaks out of the function immediately.   
        }
        memberships.add(member);
    }

    /**
     * Returns the number of members in this club.
     * @return The number of members (Membership objects) in
     *         the club.
     */
    public int numberOfMembers()
    {
        return memberships.size(); //  Assignment 2
    }

    /**
     *  Assignment 4
     *  Returns a Member who joined in a specific month and year.
     *  @params month   Month to look up.
     *  @params year    Year to look up.
     *  @return Persons who joined at that time.
     */
    public int joinedInMonthOfYear(int month, int year) {
        int result = 0;
        for (Membership member : memberships) {
            if (member.getMonth() == month) {
                if (member.getYear() == year) {
                    result++;
                }
            }
        }
        return result;
    }

    /**
     *  Assignment 5
     *  Returns a list of Members who joined in a given month & year.
     *  @params month   Month to look up.
     *  @params year    Year to look up.
     *  @return List of persons who joined at that time.
     */
    public ArrayList listJoinedInMonthOfYear(int month, int year) {
        ArrayList<Membership> result = new ArrayList<Membership>();
        for (Membership member : memberships) {
            if (member.getMonth() == month) {
                if (member.getYear() == year) {
                    result.add(member);
                }
            }
        }
        // Sort by name in the end. For the bored
        Collections.sort(result, new NameComparator());
        return result;
    }

    /**
     *  Assignment 6
     *  Returns a Members with the given name.
     *  @params name    Name of Member to look up.
     *  @return Membership with the name.
     */
    public Membership search(String name) {
        name = name.toLowerCase(); // Makes comparison easier here
        for (Membership member : memberships) {
            String memberName = member.getName().toLowerCase();
            if (memberName.equals(name)) {
                return member;
            }
        }
        return null;
    }

    /**
     *  Assignment 8, for the bored;
     *  Removes members who joined in a given month & year.
     *  Returns a list of the removed Members.
     *  @params month   Month to look up.
     *  @params year    Year to look up.
     *  @return List of persons who were removed.
     */
    public ArrayList removeAllOfMonthAndYear(int month, int year) {
        ArrayList<Membership> result = new ArrayList<Membership>();
        // To remove from lists safely, an iterator is best to use
        Iterator<Membership> it = memberships.iterator();
        Membership checkMember;
        while (it.hasNext()) {
            checkMember = it.next();
            if (checkMember.getMonth() == month) {
                if (checkMember.getYear() == year) {
                    result.add(checkMember);
                    it.remove();                   
                }
            }
        }
        return result;
    }

    /**
     *  Assignment 9; for the bored
     *  Returns a list sorted year, then month, and finally name.
     *  @return Sorted list.
     */
    public ArrayList sortList() {
        ArrayList<Membership> result;
        // Copies the original list first
        result = new ArrayList<Membership>(memberships);
        // Sort fully by year first, we will this further
        Collections.sort(result, new YearComparator());
        Collections.sort(result, new YearMonthNameComparator());
        return result;
    }

    /**
     *  Assignment 10
     *  Returns a list of Members who have birthday in a given month.
     *  @params month   Month to look up.
     *  @return List of persons who have birthday at that time.
     */
    public ArrayList listBirthdaysInMonth(int month) {
        ArrayList<Membership> result = new ArrayList<Membership>();
        for (Membership member : memberships) {
            if (member.getBdayMonth() == month) {
                result.add(member);
            }
        }
        return result;
    }

    /**
     *  Assignment 10; for the bored
     *  Returns a list of Members who have round birthdays.
     *  @return List of persons who have birthday at that time.
     */
    public ArrayList listRoundBirthdays() {
        ArrayList<Membership> result = new ArrayList<Membership>();
        // Gets the current system's year
        int thisYear = LocalDateTime.now().getYear();
        for (Membership member : memberships) {
            int difference = thisYear - member.getBdayYear();
            if (difference % 5 == 0 || difference % 10 == 10) {
                result.add(member);
            }
        }
        return result;
    }

    /**
     *  Assignment 10; for the bored
     *  Returns a list of Members who have prime birthdays.
     *  @return List of persons who have birthday at that time.
     */
    public ArrayList listPrimeBirthdays() {
        ArrayList<Membership> result = new ArrayList<Membership>();
        int thisYear = LocalDateTime.now().getYear();
        for (Membership member : memberships) {
            int difference = thisYear - member.getBdayYear();
            if (isPrime(difference)) {
                result.add(member);
            }
        }
        return result;
    }

    /**
     *  Assignment 10; for the bored
     *  Returns a list of Members who have computing birthdays.
     *  @return List of persons who have birthday at that time.
     */
    public ArrayList listComputingBirthdays() {
        ArrayList<Membership> result = new ArrayList<Membership>();
        int thisYear = LocalDateTime.now().getYear();
        for (Membership member : memberships) {
            int difference = thisYear - member.getBdayYear();
            // No idea what "cumputing" numbers are
        }
        return result;
    }

    /**
     * Assignment 3; 
     * Extended for Assigment 10; 
     * Adds some Members for testing.
     */
    private void addTestMembers() {
        join(new Membership("Ryu", 2, 2017, 5, 1985));
        join(new Membership("Rei", 3, 2007, 7, 1987));
        join(new Membership("Teepo", 5, 2009, 10, 1990));
        join(new Membership("Garr", 7, 2011, 12, 1992));
        join(new Membership("Nina", 9, 2013, 1, 1994));
        join(new Membership("Momo", 11, 2015, 4, 1997));
        join(new Membership("Honey", 3, 2017, 9, 2000));
        join(new Membership("Deis", 3, 2019, 3, 1999));
        join(new Membership("Myria", 1, 2017, 3, 1999));
        join(new Membership("Ladon", 2, 2017, 12, 1000));
        join(new Membership("Alice", 2, 2017, 12, 1000));
    }

    /**
     * Assignment 10; Helper Method
     * Checks, if an given number is a prime.
     * @param  a The number to be checked.
     * @return true if it' is a prime.
     */
    private boolean isPrime(int num) {
        // 2 is the only even prime...
        if (num == 2)
        {
            return true;
        }
        //... all other evens are not primes.
        if (num % 2 == 0)
        {
            return false;
        }
        // Calculate the limit once, saves cpu time!
        double limit = Math.sqrt(num);
        // Check until the square root of the number
        // after that the factors flip anyway.
        // Check only every second number (odds), left ones.
        for (int i = 3; i <= limit; i+=2) {
            // if this is true, it's not a prime
            if (num % i == 0) {
                return false;
            }
        }
        return true; // if all are checked
    }

    // Inner classes of Comparator to compare and sort objects
    class NameComparator implements Comparator<Membership>{
        @Override
        public int compare(Membership m1, Membership m2) {
            String name1 = m1.getName();
            String name2 = m2.getName();
            return name1.compareTo(name2);
        }
    }

    class MonthComparator implements Comparator<Membership>{
        @Override
        public int compare(Membership m1, Membership m2) {
            Integer month1 = m1.getMonth(); // Autoboxing
            Integer month2 = m2.getMonth();
            return month1.compareTo(month2);
        }
    }

    class YearComparator implements Comparator<Membership>{
        @Override
        public int compare(Membership m1, Membership m2) {
            Integer year1 = m1.getYear(); // Autoboxing
            Integer year2 = m2.getYear();
            return year1.compareTo(year2);
        }
    }
    // Assignment 9, for the bored
    class YearMonthNameComparator implements Comparator<Membership>{
        @Override
        public int compare(Membership m1, Membership m2) {
            int result;
            // Sort by year fist
            Integer year1 = m1.getYear(); // Autoboxing
            Integer year2 = m2.getYear();
            int years = year1.compareTo(year2);
            if ((result = years) != 0) {
                return result;
            }
            // If years are same, sort by months
            Integer month1 = m1.getMonth(); // Autoboxing
            Integer month2 = m2.getMonth();
            int months = month1.compareTo(month2);
            if ((result = months) != 0) {
                return result;
            }
            // If months are same, sort the names finally
            String name1 = m1.getName();
            String name2 = m2.getName();
            int names = name1.compareTo(name2);
            if ((result = names) != 0) {
                return result;
            }
            return result;
        }
        /*
         * With Lambda expressions something like this could
         * be also possible. It's just an example. Not tested!
         * Comparator<Employee> COMPARE_BY_NAME =
         * Comparator.comparing(Membership::getYear)
         *           .thenComparing(Membership::getMonth)
         *           .thenComparing(Membership::getName);
         */
    }
}
