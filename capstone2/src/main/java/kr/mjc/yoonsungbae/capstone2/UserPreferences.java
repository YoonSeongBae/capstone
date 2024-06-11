package kr.mjc.yoonsungbae.capstone2;

public class UserPreferences {
    private static String level;

    public static void setLevel(String level) {
        UserPreferences.level = level;
    }

    public static String getLevel() {
        return level;
    }
}
