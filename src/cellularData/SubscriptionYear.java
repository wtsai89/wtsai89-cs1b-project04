package cellularData;

/**
 * Stores the subscription data for a country during a single year
 */
public class SubscriptionYear {
    private int year;
    private double subscriptions;

    /**
     *
     * @param y year
     * @param s subscriptions
     */
    public SubscriptionYear(int y, double s)
    {
        year = y;
        subscriptions = s;
    }

    /**
     * accessor method for year
     * @return year
     */
    public int getYear() { return year; }

    /**
     * accessor method for subscriptions
     * @return subscriptions
     */
    public double getSubscriptions() { return subscriptions; }

    /**
     *
     * @param y sets year to y
     */
    public void setYear(int y) { year = y; }

    /**
     *
     * @param s sets subscription to s
     */
    public void setSubscriptions(double s) { subscriptions = s; }

    /**
     *
     * @return displays subscriptions as a String
     */
    public String toString() { return "" + subscriptions; }
}
