public class Lesson {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static void explore(String assumption, boolean result) {
        StringBuilder sb = new StringBuilder();
        if (result) {
            sb.append(String.format("%sYAY!%s", ANSI_GREEN, ANSI_RESET));
            sb.append("  ");
            sb.append(assumption);
        } else {
            sb.append(String.format("%sWAT??%s", ANSI_RED, ANSI_RESET));
        }
        if (!result) {
            sb.append(" (Your assumption is incorrect)");
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        int firstNumber = 12;
        int secondNumber = 12;
        explore("Primitives user double equals", firstNumber == secondNumber);
        Object firstObject = new Object();
        Object secondObject = new Object();
        explore("Objects references use double equals to check if they refer to the same object in memory, seemingly equal objects are not equal", firstObject == secondObject);
        Object sameObject = firstObject;
        explore("Object references must refer to the  same object to use double equals", firstObject == sameObject);
        String firstString = "Hara";
        String secondString = "Hara";
        explore("String literals are actually referring to the same object", firstString == secondString);
        String differentString = new String("Hara");
        explore("String objects that contain  the same characters but point to different objects cannot use double equals", firstString != differentString);

        String anotherString = new String("Hara");
        explore("String interning adds to the same string pool where literals live, so you get back to the same reference", anotherString.intern() == firstString);
        explore("All objects should use equals to check equality", firstString.equals(differentString));

    }
}
