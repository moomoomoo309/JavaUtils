public class SimpleMenu {

    public int NumberedMenu(String Title, String... Options) {
        System.out.println(Title);
        for (int i = 0; i < Options.length; i++)
            System.out.println(i + ". " + Options[i]);
        int choice;
        choice = In.getIntInput(new Range(0, Options.length - 1), "Your Choice: ")[0];
        return choice;
    }

    public boolean boolMenu(String... Options) {
        for (int i = 0; i < Options.length; i++)
            System.out.println(i + ". " + Options[i]);
        return In.getBooleanInput("Your Choice: ")[0];
    }
    //There will be more later...
}
