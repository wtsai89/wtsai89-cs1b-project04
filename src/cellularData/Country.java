package cellularData;

/**
 * Stores the entire subscription data for a single country
 */
public class Country {
    private String name;
    private SubscriptionYear[] subscriptionsPerYear;
    private int index, startingYear, endingYear;

    /**
     *
     * @param n sets the country name
     * @param years sets the length of the subscriptionsPerYear array
     */
    public Country(String n, int years)
    {
        name = n;
        subscriptionsPerYear = new SubscriptionYear[years];
        index = 0;
    }

    /**
     * Creates a new SubscriptionYear object and saves it in subscriptions array
     * @param year
     * @param subscriptions
     */
    public void addSubscriptionYear(int year, double subscriptions)
    {
        subscriptionsPerYear[index] = new SubscriptionYear(year, subscriptions);
        if(index == 0)
            startingYear = year;
        if(index == subscriptionsPerYear.length - 1)
            endingYear = year;
        index++;
    }

    /**
     * accessor method for name
     * @return
     */
    public String getName() { return name; }

    /**
     * returns the total number of subscriptions between start and end years
     * @param start
     * @param end
     * @return
     */
    public double getNumSubscriptionsForPeriod(int start, int end)
    {
        if(start > end)
            throw new IllegalArgumentException("Error: Starting year and ending year are inverted.\n");
        if((start < startingYear || start > endingYear) && (end > endingYear || end < startingYear))
            throw new IllegalArgumentException("Error: Both starting year and ending year are out of range.\n");
        if(start < startingYear)
        {
            System.out.printf("Illegal Argument Request of year range %d-%d. Valid period for %s is %d to %d\n", start, end, name, startingYear, end);
            start = startingYear;
        }
        if(end > endingYear)
        {
            System.out.printf("Illegal Argument Request of year range %d-%d. Valid period for %s is %d to %d\n", start, end, name, start, endingYear);
            end = endingYear;
        }

        double sum = 0;
        for(int i = start - startingYear; i <= end - startingYear; i++)
            sum += subscriptionsPerYear[i].getSubscriptions();

        return sum;
    }

    /**
     * displays the country name and all of the subscriptions in a single formatted line
     * @return
     */
    public String toString()
    {
        String s = String.format("%-20s", name);
        for(int i = 0; i < subscriptionsPerYear.length; i++)
            s += String.format("%7.2f", subscriptionsPerYear[i].getSubscriptions());

        s += "\n";
        return s;
    }
}
