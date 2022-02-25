import org.junit.*;
import org.testng.annotations.Test;

import static org.junit.Assert.*;

public class Tests
{

    @Test
    public void test1()
    {
        Calendar solution = new Calendar();

        assertArrayEquals(new String[] { "2021/10/14", "2021/10/17", "2021/10/20", "2021/10/23" }, solution.get_repeating_event("2021/10/14", "every 3 days"));
    }

    @Test
    public void test2()
    {
        Calendar solution = new Calendar();

        assertArrayEquals(new String[] { "2021/04/04", "2021/04/11", "2021/04/18", "2021/04/25" }, solution.get_repeating_event("2021/04/04", "every 1 week"));
    }

    @Test
    public void test3()
    {
        Calendar solution = new Calendar();

        assertArrayEquals(new String[] { "2021/12/21", "2022/08/21", "2023/04/21", "2023/12/21" }, solution.get_repeating_event("2021/12/21", "every 8 months"));
    }

    @Test
    public void test4()
    {
        Calendar solution = new Calendar();

        assertArrayEquals(new String[] { "2021/07/09", "2031/07/09", "2041/07/09", "2051/07/09" }, solution.get_repeating_event("2021/07/09", "every 10 years"));
    }

    @Test
    public void test5()
    {
        Calendar solution = new Calendar();

        assertArrayEquals(new String[] {  }, solution.get_repeating_event("2021/01/01", "every foo bar"));
    }
}