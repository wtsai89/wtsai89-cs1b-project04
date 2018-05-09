package cellularData;

public class SubscriptionYear {
    private int year;
    private double subscriptions;

    public SubscriptionYear(int y, double s)
    {
        year = y;
        subscriptions = s;
    }

    public int getYear() { return year; }
    public double getSubscriptions() { return subscriptions; }
    public void setYear(int y) { year = y; }
    public void setSubscriptions(double s) { subscriptions = s; }
    public String toString() { return "" + subscriptions; }
}
