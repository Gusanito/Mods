package grim3212.calendar;

public class DateHandler
{
    private static String dateFormat = "%md %mm, %yyyy";
    private static String dayNames[] =
    {
        "Sunday", "Monday", "Tuesday", "Wednesday", "Thurday", "Friday", "Saturday"
    };
    private static String shortDays[] =
    {
        "Sun", "Mon", "Tues", "Wed", "Thur", "Fri", "Sat"
    };
    private static String monthNames[] =
    {
        "January", "February", "March", "April", "May", "June", "July", "August", "September", "October",
        "November", "December"
    };
    private static String shortMonths[] =
    {
        "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct",
        "Nov", "Dec"
    };
    private static int monthLengths[] =
    {
        31, 28, 31, 30, 31, 30, 31, 31, 30, 31,
        30, 31
    };
    private static int yearLength = 365;

    public DateHandler()
    {
    }

    public String GetDateFormat()
    {
        return dateFormat;
    }

    public String GetDayNames()
    {
        StringBuffer stringbuffer = new StringBuffer();
        if (dayNames != null)
        {
            stringbuffer.append(dayNames[0]);
            for (int i = 1; i < dayNames.length; i++)
            {
                stringbuffer.append(",");
                stringbuffer.append(dayNames[i]);
            }
        }
        return stringbuffer.toString();
    }

    public String GetMonthNames()
    {
        StringBuffer stringbuffer = new StringBuffer();
        if (monthNames != null)
        {
            stringbuffer.append(monthNames[0]);
            for (int i = 1; i < monthNames.length; i++)
            {
                stringbuffer.append(",");
                stringbuffer.append(monthNames[i]);
            }
        }
        return stringbuffer.toString();
    }

    public String GetMonthLengths()
    {
        StringBuffer stringbuffer = new StringBuffer();
        if (monthLengths != null)
        {
            stringbuffer.append(monthLengths[0]);
            for (int i = 1; i < monthLengths.length; i++)
            {
                stringbuffer.append(",");
                stringbuffer.append(monthLengths[i]);
            }
        }
        return stringbuffer.toString();
    }

    public void CalculateConstants()
    {
        DateHandler datehandler = this;
        yearLength = 0;
        for (int i = 0; i < monthLengths.length; i++)
        {
            DateHandler datehandler1 = this;
            yearLength += monthLengths[i];
        }
    }

    public static String ordinalNo(int i)
    {
        int j = i % 100;
        int k = i % 10;
        if (j - k == 10)
        {
            return "th";
        }
        switch (k)
        {
            case 1:
                return "st";

            case 2:
                return "nd";

            case 3:
                return "rd";
        }
        return "th";
    }

    public static String CalculateDate(Long long1, int i)
    {
        long l = (long1.longValue() + 24000L) / 24000L;
        long l1 = (long1.longValue() + 6000L) % 24000L;
        long l2 = l;
        int j = 0;
        int k = 0;
        boolean flag = false;
        do
        {
            if (flag)
            {
                break;
            }
            if (l2 > (long)monthLengths[j])
            {
                l2 -= monthLengths[j];
                if (++j == monthLengths.length)
                {
                    j = 0;
                    k++;
                }
            }
            else
            {
                flag = true;
            }
        }
        while (true);
        int i1 = (int)(l % (long)dayNames.length);
        int j1 = (int)l2;
        int k1 = (int)(l % (long)yearLength);
        String s = String.valueOf(l);
        String s1 = String.valueOf(i1 + 1);
        String s2 = dayNames[i1];
        String s3 = shortDays[i1];
        String s4 = String.valueOf(l / (long)dayNames.length + 1L);
        String s5 = String.valueOf(l2);
        String s6 = monthNames[j];
        String s7 = shortMonths[j];
        String s8 = String.valueOf(k + 1);
        if (k + 1 < 10)
        {
            s8 = (new StringBuilder()).append("Year ").append(String.valueOf(k + 1)).toString();
        }
        String s9 = dateFormat;
        s9 = s9.replace("%dddd", s2);
        s9 = s9.replace("%dd", s);
        s9 = s9.replace("%wd", s1);
        s9 = s9.replace("%ww", s4);
        s9 = s9.replace("%md", (new StringBuilder()).append(s5).append(ordinalNo((int)l2)).toString());
        s9 = s9.replace("%mm", s6);
        if (k < 10)
        {
            s9 = s9.replace("%yyyy", (new StringBuilder()).append("Year ").append(s8).toString());
        }
        else
        {
            s9 = s9.replace("%yyyy", s8);
        }
        if (i == 1)
        {
            return (new StringBuilder()).append(s8).append(",").append(s7).append(" ").append(s5).append(",").append(s3).toString();
        }
        else
        {
            return s9;
        }
    }
}
