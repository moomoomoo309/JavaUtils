import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class In {

    public double[] getDoubleInput(String... Names) {
        double[] Input = new double[Names.length];
        Scanner UserInput = new Scanner(System.in);
        for (int i = 0; i < Names.length; i++) {
            System.out.print(Names[i]);
            while (true) {
                if (UserInput.hasNextDouble()) {
                    Input[i] = UserInput.nextDouble();
                    break;
                } else
                    System.out.println("That is not a number, try again.");
                UserInput.next();
            }
        }
        return Input;
    }

    public double[] getDoubleInput(Range range, String... Names) {
        double[] Input = new double[Names.length];
        double temp;
        Scanner UserInput = new Scanner(System.in);
        for (int i = 0; i < Names.length; i++) {
            System.out.print(Names[i]);
            while (true) {
                if (UserInput.hasNextDouble()) {
                    temp = UserInput.nextDouble();
                    if (range.inRange(temp)) {
                        Input[i] = temp;
                        break;
                    } else
                        System.out.println("That number is not " + range.toString() + ".");
                } else
                    System.out.println("That is not a number, try again.");
                UserInput.next();
            }
        }
        return Input;
    }

    public double[] getFrameDoubleInput(JFrame frame, String... Names) {
        double[] InputArray = new double[Names.length];
        for (int i = 0; i < Names.length; i++)
            while (true) {
                String Data = JOptionPane.showInputDialog(Names[i]);
                if (Data == null)
                    System.exit(0);
                try {
                    InputArray[i] = Double.valueOf(Data);
                    break;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(frame, "It must be a number.");
                }
            }
        return InputArray;
    }

    public double[] getFrameDoubleInput(JFrame frame, Range range, String... Names) {
        double[] InputArray = new double[Names.length];
        for (int i = 0; i < Names.length; i++)
            while (true) {
                String Data = JOptionPane.showInputDialog(Names[i]);
                if (Data == null)
                    System.exit(0);
                try {
                    InputArray[i] = Double.valueOf(Data);
                    if (range.inRange(InputArray[i]))
                        break;
                    else
                        JOptionPane.showMessageDialog(frame, "That number is not " + range.toString() + ".");
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(frame, "It must be a number.");
                }
            }
        return InputArray;
    }

    public boolean[] getBooleanInput(String... Names) {
        boolean[] Input = new boolean[Names.length];
        Scanner UserInput = new Scanner(System.in);
        for (int i = 0; i < Names.length; i++) {
            System.out.print(Names[i]);
            while (true) {
                if (UserInput.hasNextBoolean()) {
                    Input[i] = UserInput.nextBoolean();
                    break;
                } else
                    System.out
                            .println("Enter \"true\" or \"false\" and try again.");
                UserInput.next();
            }
        }
        return Input;
    }

    public int[] getIntInput(Range range, String... Names) {
        int[] Input = new int[Names.length];
        int temp;
        Scanner UserInput = new Scanner(System.in);
        for (int i = 0; i < Names.length; i++) {
            System.out.print(Names[i]);
            while (true) {
                if (UserInput.hasNextInt()) {
                    temp = UserInput.nextInt();
                    if (range.inRange((double) temp)) {
                        Input[i] = temp;
                        break;
                    } else
                        System.out.println("That number is not " + range.toString() + ".");
                } else
                    System.out.println("That is not an integer, try again.");
                UserInput.next();
            }
        }
        return Input;
    }

    public int[] getIntInput(String... Names) {
        int[] Input = new int[Names.length];
        Scanner UserInput = new Scanner(System.in);
        for (int i = 0; i < Names.length; i++) {
            System.out.print(Names[i]);
            while (true) {
                if (UserInput.hasNextInt()) {
                    Input[i] = UserInput.nextInt();
                    break;
                } else
                    System.out.println("That is not an integer, try again.");
                UserInput.next();
            }
        }
        return Input;
    }

    public int[] getFrameIntInput(JFrame frame, String[] Names) {
        int[] InputArray = new int[Names.length];
        for (int i = 0; i < Names.length; i++)
            while (true) {
                String Data = JOptionPane.showInputDialog(Names[i]);
                if (Data == null)
                    System.exit(0);
                try {
                    InputArray[i] = Integer.valueOf(Data);
                    break;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(frame, "It must be an integer.");
                }
            }
        return InputArray;
    }

    public int[] getFrameIntInput(JFrame frame, Range range, String... Names) {
        int[] InputArray = new int[Names.length];
        for (int i = 0; i < Names.length; i++)
            while (true) {
                String Data = JOptionPane.showInputDialog(Names[i]);
                if (Data == null)
                    System.exit(0);
                try {
                    InputArray[i] = Integer.valueOf(Data);
                    if (range.inRange(InputArray[i]))
                        break;
                    else
                        JOptionPane.showMessageDialog(frame, "It must be an integer " + range.toString());
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(frame, "It must be an integer.");
                }
            }
        return InputArray;
    }

    public float[] getFloatInput(String... Names) {
        float[] Input = new float[Names.length];
        Scanner UserInput = new Scanner(System.in);
        for (int i = 0; i < Names.length; i++) {
            System.out.print(Names[i]);
            while (true) {
                if (UserInput.hasNextFloat()) {
                    Input[i] = UserInput.nextFloat();
                    break;
                } else
                    System.out
                            .println("That is not a floating point number, remember "
                                     + "to add the F and try again.");
                UserInput.next();
            }
        }
        return Input;
    }

    public String[] getStringInput(String... Names) {
        String[] Input = new String[Names.length];
        Scanner UserInput = new Scanner(System.in);
        for (int i = 0; i < Names.length; i++) {
            System.out.print(Names[i]);
            while (true) {
                if (UserInput.hasNextLine()) {
                    Input[i] = UserInput.nextLine();
                    break;
                } else
                    System.out.println("That is not a string, try again.");
                UserInput.next();
            }
        }
        return Input;
    }

    public String[] getFrameStringInput(String... Names) {
        String[] InputArray = new String[Names.length];
        String Data;
        for (int i = 0; i < Names.length; i++) {
            Data = JOptionPane.showInputDialog(Names[i]);
            if (Data == null)
                return null;
            InputArray[i] = Data;
        }
        return InputArray;
    }

    public String getMultilineInput() {
        Scanner UserInput = new Scanner(System.in);
        System.out.println("Enter your input, then hit enter twice.");
        StringBuilder finalInputString = new StringBuilder();
        String Cache;
        while (true) {
            Cache = UserInput.nextLine();
            if (Cache.length() != 0)
                finalInputString.append(Cache);
            else
                break;

        }
        return finalInputString.toString();
    }

    public String[] getMultilineInput(boolean array) {
        // Seriously, why would you put it as false if you can just not put the boolean there?
        if (!array)
            return new String[]{getMultilineInput()};
        // It'll return an array with length 1 with the string in it anyway.
        List<String> Input = new ArrayList<>();
        Scanner UserInput = new Scanner(System.in);
        System.out.println("Enter the input, then hit enter twice.");
        String Cache;
        while (true) {
            Cache = UserInput.nextLine();
            if (Cache.length() != 0)
                Input.add(Cache);
            else
                break;

        }
        return Input.toArray(new String[Input.size()]);
    }
}