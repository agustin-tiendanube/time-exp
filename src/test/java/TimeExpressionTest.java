
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

        Iterator<LocalDate> iterator = todayTimeExp.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(today, iterator.next());
        assertFalse(iterator.hasNext());
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

        Iterator<LocalDate> iterator = everyDayFromTodayToTheNextSixDaysTimeExp.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(today, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(today.plusDays(1), iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(today.plusDays(2), iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(today.plusDays(3), iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(today.plusDays(4), iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(today.plusDays(5), iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(today.plusDays(6), iterator.next());
        assertFalse(iterator.hasNext());
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

        Iterator<LocalDate> iterator = everyTwoDaysFromTodayToTheNextSevenDaysTimeExp.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(today, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(today.plusDays(2), iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(today.plusDays(4), iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(today.plusDays(6), iterator.next());
        assertFalse(iterator.hasNext());
    }

    public void testRecursEveryMonthTheSecondDay() {
        int oneMonth = 1;
        int theSecondDay = 2;
        YearMonth januaryOf2012 = YearMonth.of(2012, 1);
        YearMonth mayOf2012 = YearMonth.of(2012, 5);

        TimeExpression everyMonthTheSeconthDayFromJanuary2012ToMay2012TimeExp =
            TimeExpression
                .monthlyEveryOnFromTo(
                    oneMonth,
                    theSecondDay,
                    januaryOf2012,
                    mayOf2012);

        LocalDate januaryTheSeconthOf2012 = LocalDate.of(2012, 1, 2);
        Iterator<LocalDate> iterator = everyMonthTheSeconthDayFromJanuary2012ToMay2012TimeExp.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(januaryTheSeconthOf2012, iterator.next());

        assertTrue(iterator.hasNext());
        assertEquals(januaryTheSeconthOf2012.plusMonths(1), iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(januaryTheSeconthOf2012.plusMonths(2), iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(januaryTheSeconthOf2012.plusMonths(3), iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(januaryTheSeconthOf2012.plusMonths(4), iterator.next());
        assertFalse(iterator.hasNext());
    }

    public void testRecursEveryTwoMonthsTheSeconthDay() {
        int twoMonth = 1;
        int theSecondDay = 2;
        YearMonth january2012 = YearMonth.of(2012, 1);
        YearMonth may2012 = YearMonth.of(2012, 5);

        TimeExpression everyTwoMonthsTheSeconthDayFromJanuary2012ToMay2012TimeExp =
            TimeExpression
                .monthlyEveryOnFromTo(
                    twoMonth,
                    theSecondDay,
                    january2012,
                    may2012);

        LocalDate januaryTheSeconthOf2012 = LocalDate.of(2012, 1, 2);
        Iterator<LocalDate> iterator = everyTwoMonthsTheSeconthDayFromJanuary2012ToMay2012TimeExp.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(januaryTheSeconthOf2012, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(januaryTheSeconthOf2012.plusMonths(2), iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(januaryTheSeconthOf2012.plusMonths(4), iterator.next());
        assertFalse(iterator.hasNext());
    }

    public void testRecursEveryMonthTheFirstFriday() {
        int oneMonth = 1;
        int theFirstWeekOfTheMonth = 1;
        YearMonth januaryOf2012 = YearMonth.of(2012, 1);
        YearMonth mayOf2012 = YearMonth.of(2012, 5);

        TimeExpression everyMonthTheFirstFridayFromJanuary2012ToMay2012TimeExp =
            TimeExpression
                .monthlyEveryOnOfFromTo(
                    oneMonth,
                    DayOfWeek.FRIDAY,
                    theFirstWeekOfTheMonth,
                    januaryOf2012,
                    mayOf2012);

        LocalDate january2012TheFirstFriday = LocalDate.of(2012, 1, 6);
        Iterator<LocalDate> iterator = everyMonthTheFirstFridayFromJanuary2012ToMay2012TimeExp.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(january2012TheFirstFriday, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(january2012TheFirstFriday.plusWeeks(4), iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(january2012TheFirstFriday.plusWeeks(8), iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(january2012TheFirstFriday.plusWeeks(13), iterator.next());
        assertFalse(iterator.hasNext());
    }

    public void testRecursEveryAugustTheEight() {
        int oneYear = 1;
        MonthDay augustTheEight = MonthDay.of(8, 8);
        TimeExpression everyAugustTheEightFrom2012To2015TimeExp =
            TimeExpression
                .yearlyEveryOnFromTo(
                    oneYear,
                    augustTheEight,
                    2012,
                    2015);

        LocalDate januaryTheSeconthOf2012 = LocalDate.of(2012, 8, 8);
        Iterator<LocalDate> iterator = everyAugustTheEightFrom2012To2015TimeExp.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(januaryTheSeconthOf2012, iterator.next());

        assertTrue(iterator.hasNext());
        assertEquals(january2012TheFirstFriday.plusYears(1), iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(january2012TheFirstFriday.plusYears(2), iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(january2012TheFirstFriday.plusYears(3), iterator.next());
        assertFalse(iterator.hasNext());
    }
}
