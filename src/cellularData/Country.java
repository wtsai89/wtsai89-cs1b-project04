package cellularData;

public class Country {
    private String name;
    private SubscriptionYear[] subscriptionsPerYear;
    private int index, startingYear, endingYear;

    public Country(String n, int years)
    {
        name = n;
        subscriptionsPerYear = new SubscriptionYear[years];
        index = 0;
    }

    public void addSubscriptionYear(int year, double subscriptions)
    {
        subscriptionsPerYear[index] = new SubscriptionYear(year, subscriptions);
        if(index == 0)
            startingYear = year;
        if(index == subscriptionsPerYear.length - 1)
            endingYear = year;
        index++;
    }

    public String getName() { return name; }

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

    public String toString()
    {
        String s = String.format("%-20s", name);
        for(int i = 0; i < subscriptionsPerYear.length; i++)
            s += String.format("%7.2f", subscriptionsPerYear[i].getSubscriptions());

        s += "\n";
        return s;
    }
}
