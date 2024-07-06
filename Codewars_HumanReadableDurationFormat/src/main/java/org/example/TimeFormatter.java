package org.example;

import java.util.ArrayList;
import java.util.List;

public class TimeFormatter {

    public static String formatDuration(int seconds) {
        if (seconds == 0) {
            return "now";
        }

        long totalSeconds = (long) seconds;

        long years = totalSeconds / (365 * 24 * 3600);
        long remainderAfterYears = totalSeconds % (365 * 24 * 3600);

        long days = remainderAfterYears / (24 * 3600);
        long remainderAfterDays = remainderAfterYears % (24 * 3600);

        long hours = remainderAfterDays / 3600;
        long remainderAfterHours = remainderAfterDays % 3600;

        long minutes = remainderAfterHours / 60;
        long restSeconds = remainderAfterHours % 60;

        List<String> parts = new ArrayList<>();

        if (years == 1) {
            parts.add(years + " year");
        } else if (years > 1) {
            parts.add(years + " years");
        }

        if (days == 1) {
            parts.add(days + " day");
        } else if (days > 1) {
            parts.add(days + " days");
        }

        if (hours == 1) {
            parts.add(hours + " hour");
        } else if (hours > 1) {
            parts.add(hours + " hours");
        }

        if (minutes == 1) {
            parts.add(minutes + " minute");
        } else if (minutes > 1) {
            parts.add(minutes + " minutes");
        }

        if (restSeconds == 1) {
            parts.add(restSeconds + " second");
        } else if (restSeconds > 1) {
            parts.add(restSeconds + " seconds");
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < parts.size(); i++) {
            result.append(parts.get(i));
            if (i < parts.size() - 2) {
                result.append(", ");
            } else if (i == parts.size() - 2) {
                result.append(" and ");
            }
        }

        return result.toString();
    }
}


/*
TESTING

import org.junit.Test;
import static org.junit.Assert.*;

public class TimeFormatterTest {
    @Test
    public void exampleTests() {
        assertEquals("1 second", TimeFormatter.formatDuration(1));
        assertEquals("1 minute and 2 seconds", TimeFormatter.formatDuration(62));
        assertEquals("2 minutes", TimeFormatter.formatDuration(120));
        assertEquals("1 hour", TimeFormatter.formatDuration(3600));
        assertEquals("1 hour, 1 minute and 2 seconds", TimeFormatter.formatDuration(3662));
    }
}
 */