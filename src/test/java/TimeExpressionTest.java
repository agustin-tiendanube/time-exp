
import junit.framework.TestCase;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.MonthDay;
import java.time.YearMonth;
import java.util.Iterator;

public class TimeExpressionTest extends TestCase {

    public void testOnDate() {
        LocalDate today = LocalDate.now();
        TimeExpression todayTimeExp = TimeExpression.on(today);

        assertTrue(todayTimeExp.isRecurringOn(today));
    }

    public void testRecursEveryDay() {
        int oneDay = 1;
        LocalDate today = LocalDate.now();
        LocalDate theNextSixDays = today.plusDays(6);

        TimeExpression everyDayFromTodayToTheNextSixDaysTimeExp =
            TimeExpression
                .dailyEveryFromTo(
                    oneDay,
                    today,
                    theNextSixDays);

        assertTrue(everyDayFromTodayToTheNextSixDaysTimeExp.isRecurringOn(today));
        assertTrue(everyDayFromTodayToTheNextSixDaysTimeExp.isRecurringOn(today.plusDays(1)));
        assertTrue(everyDayFromTodayToTheNextSixDaysTimeExp.isRecurringOn(today.plusDays(2)));
        assertTrue(everyDayFromTodayToTheNextSixDaysTimeExp.isRecurringOn(today.plusDays(3)));
        assertTrue(everyDayFromTodayToTheNextSixDaysTimeExp.isRecurringOn(today.plusDays(4)));
        assertTrue(everyDayFromTodayToTheNextSixDaysTimeExp.isRecurringOn(today.plusDays(5)));
        assertTrue(everyDayFromTodayToTheNextSixDaysTimeExp.isRecurringOn(today.plusDays(6)));
        assertFalse(everyDayFromTodayToTheNextSixDaysTimeExp.isRecurringOn(today.plusDays(7)));
    }

    public void testRecursEveryTwoDays() {
        int twoDays = 2;
        LocalDate today = LocalDate.now();
        LocalDate theNextSevenDays = today.plusDays(7);

        TimeExpression everyTwoDaysFromTodayToTheNextSevenDaysTimeExp =
            TimeExpression
                .dailyEveryFromTo(
                    twoDays,
                    today,
                    theNextSevenDays);

        assertTrue(everyTwoDaysFromTodayToTheNextSevenDaysTimeExp.isRecurringOn(today));
        assertFalse(everyTwoDaysFromTodayToTheNextSevenDaysTimeExp.isRecurringOn(today.plusDays(1)));
        assertTrue(everyTwoDaysFromTodayToTheNextSevenDaysTimeExp.isRecurringOn(today.plusDays(2)));
        assertFalse(everyTwoDaysFromTodayToTheNextSevenDaysTimeExp.isRecurringOn(today.plusDays(3)));
        assertTrue(everyTwoDaysFromTodayToTheNextSevenDaysTimeExp.isRecurringOn(today.plusDays(4)));
        assertFalse(everyTwoDaysFromTodayToTheNextSevenDaysTimeExp.isRecurringOn(today.plusDays(5)));
        assertTrue(everyTwoDaysFromTodayToTheNextSevenDaysTimeExp.isRecurringOn(today.plusDays(6)));
        assertFalse(everyTwoDaysFromTodayToTheNextSevenDaysTimeExp.isRecurringOn(today.plusDays(7)));
    }

    public void testRecursEveryMonthTheSecondDay() {
        int oneMonth = 1;
        int theSecondDay = 2;
        YearMonth januaryOf2012 = YearMonth.of(2012, 1);
        YearMonth mayOf2012 = YearMonth.of(2012, 5);

        TimeExpression everyMonthTheSeconthDayFromJanuary2012ToMay2012 =
            TimeExpression
                .monthlyEveryOnFromTo(
                    oneMonth,
                    theSecondDay,
                    januaryOf2012,
                    mayOf2012);

        LocalDate januaryTheSeconthOf2012 = LocalDate.of(2012, 1, 2);
        assertTrue(everyMonthTheSeconthDayFromJanuary2012ToMay2012.isRecurringOn(januaryTheSeconthOf2012));
        assertTrue(everyMonthTheSeconthDayFromJanuary2012ToMay2012.isRecurringOn(januaryTheSeconthOf2012.plusMonths(1)));
        assertTrue(everyMonthTheSeconthDayFromJanuary2012ToMay2012.isRecurringOn(januaryTheSeconthOf2012.plusMonths(2)));
        assertTrue(everyMonthTheSeconthDayFromJanuary2012ToMay2012.isRecurringOn(januaryTheSeconthOf2012.plusMonths(3)));
        assertTrue(everyMonthTheSeconthDayFromJanuary2012ToMay2012.isRecurringOn(januaryTheSeconthOf2012.plusMonths(4)));
        assertFalse(everyMonthTheSeconthDayFromJanuary2012ToMay2012.isRecurringOn(januaryTheSeconthOf2012.plusMonths(5)));
    }

    public void testRecursEveryTwoMonthsTheSeconthDay() {
        int twoMonth = 1;
        int theSecondDay = 2;
        YearMonth january2012 = YearMonth.of(2012, 1);
        YearMonth may2012 = YearMonth.of(2012, 5);

        TimeExpression everyTwoMonthsTheSeconthDayFromJanuary2012ToMay2012 =
            TimeExpression
                .monthlyEveryOnFromTo(
                    twoMonth,
                    theSecondDay,
                    january2012,
                    may2012);

        LocalDate januaryTheSeconthOf2012 = LocalDate.of(2012, 1, 2);
        assertTrue(everyTwoMonthsTheSeconthDayFromJanuary2012ToMay2012.isRecurringOn(januaryTheSeconthOf2012));
        assertFalse(everyTwoMonthsTheSeconthDayFromJanuary2012ToMay2012.isRecurringOn(januaryTheSeconthOf2012.plusMonths(1)));
        assertTrue(everyTwoMonthsTheSeconthDayFromJanuary2012ToMay2012.isRecurringOn(januaryTheSeconthOf2012.plusMonths(2)));
        assertFalse(everyTwoMonthsTheSeconthDayFromJanuary2012ToMay2012.isRecurringOn(januaryTheSeconthOf2012.plusMonths(3)));
        assertTrue(everyTwoMonthsTheSeconthDayFromJanuary2012ToMay2012.isRecurringOn(januaryTheSeconthOf2012.plusMonths(4)));
        assertFalse(everyTwoMonthsTheSeconthDayFromJanuary2012ToMay2012.isRecurringOn(januaryTheSeconthOf2012.plusMonths(5)));
    }

    public void testRecursEveryMonthTheFirstFriday() {
        int oneMonth = 1;
        int theFirstWeekOfTheMonth = 1;
        YearMonth januaryOf2012 = YearMonth.of(2012, 1);
        YearMonth mayOf2012 = YearMonth.of(2012, 5);

        TimeExpression everyMonthTheFirstFridayFromJanuary2012ToMay2012 =
            TimeExpression
                .monthlyEveryOnOfFromTo(
                    oneMonth,
                    DayOfWeek.FRIDAY,
                    theFirstWeekOfTheMonth,
                    januaryOf2012,
                    mayOf2012);

        LocalDate firstFridayOfJanuary2012 = LocalDate.of(2012, 1, 6);
        assertTrue(everyMonthTheFirstFridayFromJanuary2012ToMay2012.isRecurringOn(firstFridayOfJanuary2012)); // first friday of january
        assertFalse(everyMonthTheFirstFridayFromJanuary2012ToMay2012.isRecurringOn(firstFridayOfJanuary2012.plusWeeks(1)));
        assertFalse(everyMonthTheFirstFridayFromJanuary2012ToMay2012.isRecurringOn(firstFridayOfJanuary2012.plusWeeks(2)));
        assertFalse(everyMonthTheFirstFridayFromJanuary2012ToMay2012.isRecurringOn(firstFridayOfJanuary2012.plusWeeks(3)));
        assertTrue(everyMonthTheFirstFridayFromJanuary2012ToMay2012.isRecurringOn(firstFridayOfJanuary2012.plusWeeks(4))); // first friday of february
        assertFalse(everyMonthTheFirstFridayFromJanuary2012ToMay2012.isRecurringOn(firstFridayOfJanuary2012.plusWeeks(5)));
        assertFalse(everyMonthTheFirstFridayFromJanuary2012ToMay2012.isRecurringOn(firstFridayOfJanuary2012.plusWeeks(6)));
        assertFalse(everyMonthTheFirstFridayFromJanuary2012ToMay2012.isRecurringOn(firstFridayOfJanuary2012.plusWeeks(7)));
        assertTrue(everyMonthTheFirstFridayFromJanuary2012ToMay2012.isRecurringOn(firstFridayOfJanuary2012.plusWeeks(8))); // first friday of march
        assertFalse(everyMonthTheFirstFridayFromJanuary2012ToMay2012.isRecurringOn(firstFridayOfJanuary2012.plusWeeks(9)));
        assertFalse(everyMonthTheFirstFridayFromJanuary2012ToMay2012.isRecurringOn(firstFridayOfJanuary2012.plusWeeks(10)));
        assertFalse(everyMonthTheFirstFridayFromJanuary2012ToMay2012.isRecurringOn(firstFridayOfJanuary2012.plusWeeks(11)));
        assertFalse(everyMonthTheFirstFridayFromJanuary2012ToMay2012.isRecurringOn(firstFridayOfJanuary2012.plusWeeks(12)));
        assertTrue(everyMonthTheFirstFridayFromJanuary2012ToMay2012.isRecurringOn(firstFridayOfJanuary2012.plusWeeks(13))); // first friday of april
    }

    public void testRecursEveryAugustTheEight() {
        int oneYear = 1;
        MonthDay augustTheEight = MonthDay.of(8, 8);
        TimeExpression everyAugustTheEightFrom2012To2015 =
            TimeExpression
                .yearlyEveryOnFromTo(
                    oneYear,
                    augustTheEight,
                    2012,
                    2015);

        LocalDate firstEightOfAugust = LocalDate.of(2012, 8, 8);
        assertTrue(everyAugustTheEightFrom2012To2015.isRecurringOn(firstEightOfAugust));
        assertTrue(everyAugustTheEightFrom2012To2015.isRecurringOn(firstEightOfAugust.plusYears(1)));
        assertTrue(everyAugustTheEightFrom2012To2015.isRecurringOn(firstEightOfAugust.plusYears(2)));
        assertTrue(everyAugustTheEightFrom2012To2015.isRecurringOn(firstEightOfAugust.plusYears(3)));
        assertFalse(everyAugustTheEightFrom2012To2015.isRecurringOn(firstEightOfAugust.plusYears(4)));
    }
}
