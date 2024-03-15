package Static;

public class Week {
    static int daysOfTheWeek = 7; //static variable
    int dayOfTheWeek; //instance variable

    public static int getDaysLeftInWeek(){
        return Week.daysOfTheWeek - dayOfTheWeek;
    } //static method - won't work because using non-static variable in static context

    public int getDaysLeftInWeek2(){
        return Week.daysOfTheWeek - dayOfTheWeek;
    } //instance method - will work because using non-static variable in instance context

    public int getDaysLeftInWeek3(int dayOfTheWeek){ //local variable
        return Week.daysOfTheWeek - this.dayOfTheWeek;
    } //local method - will work because using non-static variable in local context
}
