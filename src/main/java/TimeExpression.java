import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.MonthDay;
import java.time.YearMonth;

public class TimeExpression {

    public static TimeExpression on(LocalDate aDate) {
        throw new RuntimeException("Must implement method: on");
    }

    public static TimeExpression dailyEveryFromTo(int anAmountOfDays, LocalDate aDate, LocalDate anotherDatet) {
        throw new RuntimeException("Must implement method: dailyEveryFromTo");
    }

    public static TimeExpression monthlyEveryOnFromTo(int anAmountOfMonths, int aDayInMonth, YearMonth anYear, YearMonth anotherYear) {
        throw new RuntimeException("Must implement method: monthlyEveryOnFromTo");
    }

    public static TimeExpression monthlyEveryOnOfFromTo(int anAmountOfMonths, DayOfWeek aDayOfWeek, int aWeekInMonth, YearMonth anYear, YearMonth anotherYear) {
        throw new RuntimeException("Must implement method: monthlyEveryOnOfFromTo");
    }

    public static TimeExpression yearlyEveryOnFromTo(int anAmountOfYears, MonthDay aMonthDay, int anYear, int anotherYear) {
        throw new RuntimeException("Must implement method: yearlyEveryOnFromTo");
    }

    public boolean isRecurringOn(LocalDate aDate) {
        return false;
    }
}
