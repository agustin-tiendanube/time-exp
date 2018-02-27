import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.MonthDay;
import java.time.YearMonth;

public class TimeExpression {

    public static TimeExpression on(LocalDate aDate) {
        return null;
    }

    public static TimeExpression dailyEveryFromTo(int anAmountOfDays, LocalDate aDate, LocalDate anotherDatet) {
        return null;
    }

    public static TimeExpression monthlyEveryOnFromTo(int anAmountOfMonths, int aDayInMonth, YearMonth anYear, YearMonth anotherYear) {
        return null;
    }

    public static TimeExpression monthlyEveryOnOfFromTo(int anAmountOfMonths, DayOfWeek aDayOfWeek, int aWeekInMonth, YearMonth anYear, YearMonth anotherYear) {
        return null;
    }

    public static TimeExpression yearlyEveryOnFromTo(int anAmountOfYears, MonthDay aMonthDay, int anYear, int anotherYear) {
        return null;
    }
}
