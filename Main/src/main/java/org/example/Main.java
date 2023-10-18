package org.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main
{
    Scanner userInput = new Scanner(System.in);

    public static void main(String[] args)
    {
        Main main = new Main();
        main.run();
    }

    public void run()
    {
        while (true)
        {

            try
            {
                printMainMenu();
                int menuOption = Integer.parseInt(userInput.nextLine());
                if (menuOption == 1)
                {
                    String binaryNumber = "";
                    binaryNumber = makeBinaryNumber();
                    while (true)
                    {
                        printBinaryMenu();
                        menuOption = Integer.parseInt(userInput.nextLine());
                        if (menuOption == 1)
                        {
                            String hexadecimalNumber = String.valueOf(binaryToHexadecimal(binaryNumber));
                            System.out.println("Your Binary number was: " + binaryNumber + "\n" + "The converted number in Hexadecimal is: " + hexadecimalNumber);
                            break;
                        } else if (menuOption == 2)
                        {
                            String octalNumber = String.valueOf(binaryToOctal(binaryNumber));
                            System.out.println("Your Binary number was: " + binaryNumber + "\n" + "The converted number in Octal is: " + octalNumber);
                            break;
                        } else if (menuOption == 3)
                        {
                            binaryToDecimal(binaryNumber);
                            break;
                        } else if (menuOption == 0)
                        {
                            break;
                        }

                    }
                } else if (menuOption == 2)
                {
                    String hexadecimalNumber = "";
                    try
                    {
                        hexadecimalNumber = makeHexadecimalNumber();
                        while (true)
                        {
                            printHexadecimalMenu();
                            menuOption = Integer.parseInt(userInput.nextLine());
                            if (menuOption == 1)
                            {
                                String binaryFromHexadecimal = String.valueOf(hexadecimalToBinary(hexadecimalNumber));
                                System.out.println("Your Hexadecimal number was: " + hexadecimalNumber + "\n" + "The converted number in Binary is: " + binaryFromHexadecimal);
                                break;
                            } else if (menuOption == 2)
                            {
                                String binaryNumber = String.valueOf(hexadecimalToBinary(hexadecimalNumber));
                                String octalNumber = String.valueOf(binaryToOctal(binaryNumber));
                                System.out.println("Your Hexadecimal number was: " + hexadecimalNumber + "\n" + "The converted number in Octal is: " + octalNumber);
                                break;
                            } else if (menuOption == 3)
                            {
                                hexadecimalToDecimal(hexadecimalNumber);
                                break;

                            } else if (menuOption == 0)
                            {
                                break;
                            }
                        }
                    } catch (NumberFormatException e)
                    {
                        System.out.println("Please enter a number.");
                    }
                } else if (menuOption == 3)
                {
                    String octalNumber = makeNumber();

                    while (true)
                    {
                        printOctalMenu();
                        menuOption = Integer.parseInt(userInput.nextLine());
                        if (menuOption == 1)
                        {
                            String binaryNumber = octalToBinary(octalNumber);
                            System.out.println("Your Octal number was: " + octalNumber + "\n" + "The converted number in Binary is: " + binaryNumber);
                            break;
                        } else if (menuOption == 2)
                        {
                            String binaryNumber = octalToBinary(octalNumber);
                            String hexadecimalNumber = String.valueOf(binaryToHexadecimal(binaryNumber));
                            System.out.println("Your Octal number was: " + octalNumber + "\n" + "The converted number in Hexadecimal is: " + hexadecimalNumber);
                            break;
                        } else if (menuOption == 3)
                        {
                            octalToDecimal(octalNumber);
                            break;
                        } else if (menuOption == 0)
                        {
                            break;
                        }
                    }
                }else if (menuOption == 4)
                {
                    String decimal = makeNumber();
                    while (true)
                    {
                        printDecimalMenu();
                        menuOption = Integer.parseInt(userInput.nextLine());
                        if (menuOption == 1)
                        {
                            String binary = String.valueOf(decimalToBinary(decimal));

                            System.out.println("Your Decimal number was: " + decimal + "\n" + "The converted number in binary is: " + binary);
                            break;
                        }else if(menuOption == 2)
                        {
                            BigDecimal decimalDivision = new BigDecimal(decimal);
                            String wholeAndRemainder = "";
                            BigDecimal dividerAndMultiplier = new BigDecimal("16");
                            List<String> remainders = new ArrayList<>();
                            while(!wholeAndRemainder.startsWith("0"))
                            {
                                decimalDivision = decimalDivision.divide(dividerAndMultiplier);
                                wholeAndRemainder = String.valueOf(decimalDivision);
                                int dotPoint = wholeAndRemainder.indexOf(".");
                                remainders.add(wholeAndRemainder.substring(dotPoint));
                                decimalDivision = new BigDecimal("0." +wholeAndRemainder.substring(0, dotPoint));
                            }
                            for(String remainder : remainders)
                            {
                                BigDecimal toMultiply = new BigDecimal(remainder);
                                toMultiply = toMultiply.multiply(dividerAndMultiplier);
                            }
                        }else if(menuOption == 0)
                        {
                            break;
                        }
                    }
                } else if (menuOption == 0)
                {
                    break;
                }
            } catch (NumberFormatException e)
            {
                System.out.println("Please enter a number. ");
            }
        }
    }

    public void printMainMenu()
    {
        System.out.println("******Welcome to the converter program!******");
        System.out.println("What would you like to convert?");
        System.out.println("1. Binary");
        System.out.println("2. Hexadecimal");
        System.out.println("3. Octal");
        System.out.println("4. Decimal");
        System.out.println("0.Exit");
        System.out.println("Please pick an option. ");
    }

    public void printBinaryMenu()
    {
        System.out.println("What would you like to convert the Binary number to? ");
        System.out.println("1. Hexadecimal");
        System.out.println("2. Octal");
        System.out.println("3. Decimal");
        System.out.println("0. Exit");
        System.out.println("Please pick an option. ");
    }

    public void printHexadecimalMenu()
    {
        System.out.println("What would you like to convert the Hexadecimal number to? ");
        System.out.println("1. Binary");
        System.out.println("2. Octal");
        System.out.println("3. Decimal");
        System.out.println("0. Exit");
        System.out.println("Please pick an option. ");
    }

    public void printOctalMenu()
    {
        System.out.println("What would you like to convert the Octal number to? ");
        System.out.println("1. Binary");
        System.out.println("2. Hexadecimal");
        System.out.println("3. Decimal");
        System.out.println("0. Exit");
        System.out.println("Please pick an option");
    }

    public void printDecimalMenu()
    {
        System.out.println("What would you like to convert the Decimal number to? ");
        System.out.println("1. Binary");
        System.out.println("2. Hexadecimal");
        System.out.println("0. Exit");
    }

    public String makeBinaryNumber()
    {
        String binaryNumber = "";
        boolean isBinary = false;
        while (!isBinary)
        {
            try
            {
                System.out.println("Please enter the number in binary form: ");
                binaryNumber = userInput.nextLine();
                BigDecimal checkIfNumber = new BigDecimal(binaryNumber);
                String[] binaryElements = binaryNumber.split("");
                for (String binaryElement : binaryElements)
                {
                    isBinary = binaryElement.equals("1") || binaryElement.equals("0");
                }
            } catch (NumberFormatException e)
            {
                System.out.println("Please enter a number with no spaces.");
            }
        }
        return binaryNumber;
    }

    public String makeHexadecimalNumber()
    {
        String hexadecimalNumber = "";
        boolean isHexadecimal = false;
        while (!isHexadecimal)
        {
            System.out.println("Please enter the number in Hexadecimal form: ");
            hexadecimalNumber = userInput.nextLine();
            String[] hexadecimalElements = hexadecimalNumber.split("");
            hexadecimalNumber = "";
            for (int i = 0; i < hexadecimalElements.length; i++)
            {
                if (hexadecimalElements[i].equalsIgnoreCase("A") || hexadecimalElements[i].equalsIgnoreCase("B")
                        || hexadecimalElements[i].equalsIgnoreCase("C") || hexadecimalElements[i].equalsIgnoreCase("D")
                        || hexadecimalElements[i].equalsIgnoreCase("E") || hexadecimalElements[i].equalsIgnoreCase("F")
                        || hexadecimalElements[i].equalsIgnoreCase("0") || hexadecimalElements[i].equalsIgnoreCase("1")
                        || hexadecimalElements[i].equalsIgnoreCase("2") || hexadecimalElements[i].equalsIgnoreCase("3")
                        || hexadecimalElements[i].equalsIgnoreCase("4") || hexadecimalElements[i].equalsIgnoreCase("5")
                        || hexadecimalElements[i].equalsIgnoreCase("6") || hexadecimalElements[i].equalsIgnoreCase("7")
                        || hexadecimalElements[i].equalsIgnoreCase("8") || hexadecimalElements[i].equalsIgnoreCase("9"))
                {
                    if (hexadecimalElements[i].equals("a") || hexadecimalElements[i].equals("b")
                            || hexadecimalElements[i].equals("c") || hexadecimalElements[i].equals("d")
                            || hexadecimalElements[i].equals("e") || hexadecimalElements[i].equals("f"))
                    {
                        hexadecimalElements[i] = hexadecimalElements[i].toUpperCase();
                    }
                    hexadecimalNumber += hexadecimalElements[i];
                    isHexadecimal = true;
                } else
                {
                    System.out.println("'" + hexadecimalElements[i] + "'" + " is not a character in the Hexadeciml system.\n" +
                            "Hexadecimal accepts 0 - 9 and A - F.");
                    break;
                }
            }
        }
        return hexadecimalNumber;
    }

    public String makeNumber()
    {
        String number = "";
        boolean isNumber = false;
        System.out.println("Please enter a number: ");
        while (!isNumber)
        {
            number = userInput.nextLine();
            try
            {
                BigDecimal checkIfNumber = new BigDecimal(number);
                isNumber = true;
            } catch (NumberFormatException e)
            {
                System.out.println("Please enter a number: ");
            }
        }
        return number;
    }

    public int[] changeHexadecimalCharactersToNumbers(String hexadecimalNumber)
    {
        String[] hexadecimalCharacters = hexadecimalNumber.split("");
        int[] hexadecimalDigits = new int[hexadecimalCharacters.length];
        for (int i = 0; i < hexadecimalCharacters.length; i++)
        {
            switch (hexadecimalCharacters[i])
            {
                case "A" -> hexadecimalCharacters[i] = "10";
                case "B" -> hexadecimalCharacters[i] = "11";
                case "C" -> hexadecimalCharacters[i] = "12";
                case "D" -> hexadecimalCharacters[i] = "13";
                case "E" -> hexadecimalCharacters[i] = "14";
                case "F" -> hexadecimalCharacters[i] = "15";
            }
            hexadecimalDigits[i] = Integer.parseInt(hexadecimalCharacters[i]);
        }
        return hexadecimalDigits;
    }

    public StringBuilder hexOrOctalToBinary(int[] digits, boolean isHexadecimal)
    {
        StringBuilder binary = new StringBuilder();
        for (int i = 0; i < digits.length; i++)
        {
            if (digits[i] - 8 >= 0 && isHexadecimal)
            {
                binary.append("1");
                digits[i] -= 8;
            } else if (isHexadecimal)
            {
                binary.append("0");
            }
            if (digits[i] - 4 >= 0)
            {
                binary.append("1");
                digits[i] -= 4;
            } else
            {
                binary.append("0");
            }
            if (digits[i] - 2 >= 0)
            {
                binary.append("1");
                digits[i] -= 2;
            } else
            {
                binary.append("0");
            }
            if (digits[i] - 1 >= 0)
            {
                binary.append("1");
            } else
            {
                binary.append("0");
            }
        }
        int startingPoint = binary.indexOf("1");
        binary = new StringBuilder(binary.substring(startingPoint));
        return binary;
    }

    public int anythingToDecimalFinishingStep(int[] digits, int multiplerFactor)
    {
        int decimal = 0;
        for (int i = digits.length - 2; i >= 0; i--)
        {
            digits[i] = digits[i] * multiplerFactor;
            multiplerFactor = multiplerFactor * 8;
            decimal += digits[i];
        }
        return decimal;
    }

    public StringBuilder binaryToHexadecimal(String binaryNumber)
    {
        if (binaryNumber.length() % 4 != 0)
        {
            if (binaryNumber.length() % 4 == 3)
            {
                binaryNumber = "0" + binaryNumber;
            } else if (binaryNumber.length() % 4 == 2)
            {
                binaryNumber = "00" + binaryNumber;
            } else
            {
                binaryNumber = "000" + binaryNumber;
            }
        }
        List<String> setsOfFourBinary = new ArrayList<>();
        for (int i = 0; i < binaryNumber.length() - 3; i += 4)
        {
            setsOfFourBinary.add(binaryNumber.substring(i, i + 4));
        }
        List<Integer> decimalNumbers = new ArrayList<>();
        for (String binarySet : setsOfFourBinary)
        {
            String[] binaryCharacters = binarySet.split("");
            int[] binaryDigits = new int[binaryCharacters.length];
            for (int i = 0; i < binaryCharacters.length; i++)
            {
                binaryDigits[i] = Integer.parseInt(binaryCharacters[i]);
            }
            binaryDigits[0] = binaryDigits[0] * 8;
            binaryDigits[1] = binaryDigits[1] * 4;
            binaryDigits[2] = binaryDigits[2] * 2;
            decimalNumbers.add(binaryDigits[0] + binaryDigits[1] + binaryDigits[2] + binaryDigits[3]);
        }
        StringBuilder hexaDecimal = new StringBuilder();
        for (int decimalNumber : decimalNumbers)
        {
            switch (decimalNumber)
            {
                case 10 -> hexaDecimal.append('A');
                case 11 -> hexaDecimal.append('B');
                case 12 -> hexaDecimal.append('C');
                case 13 -> hexaDecimal.append('D');
                case 14 -> hexaDecimal.append('E');
                case 15 -> hexaDecimal.append('F');
                default -> hexaDecimal.append(decimalNumber);
            }
        }
        return hexaDecimal;
    }

    public StringBuilder binaryToOctal(String binaryNumber)
    {
        if (binaryNumber.length() % 3 != 0)
        {
            if (binaryNumber.length() % 3 == 2)
            {
                binaryNumber = "0" + binaryNumber;
            } else
            {
                binaryNumber = "00" + binaryNumber;
            }
        }
        List<String> setsOfThreeBinary = new ArrayList<>();
        for (int i = 0; i < binaryNumber.length() - 2; i += 3)
        {
            setsOfThreeBinary.add(binaryNumber.substring(i, i + 3));
        }
        List<Integer> decimalNumbers = new ArrayList<>();
        for (String binarySet : setsOfThreeBinary)
        {
            String[] binaryCharacters = binarySet.split("");
            int[] binaryDigits = new int[binaryCharacters.length];
            for (int i = 0; i < binaryCharacters.length; i++)
            {
                binaryDigits[i] = Integer.parseInt(binaryCharacters[i]);
            }
            binaryDigits[0] = binaryDigits[0] * 4;
            binaryDigits[1] = binaryDigits[1] * 2;
            decimalNumbers.add(binaryDigits[0] + binaryDigits[1] + binaryDigits[2]);
        }
        StringBuilder octalNumber = new StringBuilder();
        for (int decimalNumber : decimalNumbers)
        {
            octalNumber.append(decimalNumber);
        }
        return octalNumber;
    }

    public void binaryToDecimal(String binaryNumber)
    {
        String[] binaryCharacters = binaryNumber.split("");
        int[] binaryDigits = new int[binaryCharacters.length];
        for (int i = 0; i < binaryCharacters.length; i++)
        {
            binaryDigits[i] = Integer.parseInt(binaryCharacters[i]);
        }
        int decimalNumber = anythingToDecimalFinishingStep(binaryDigits, 2);
        System.out.println("Your Binary number was: " + binaryNumber + "\n" + "The converted number in Decimal is: " + decimalNumber);
    }

    public StringBuilder hexadecimalToBinary(String hexadecimalNumber)
    {
        int[] hexadecimalDigits = changeHexadecimalCharactersToNumbers(hexadecimalNumber);
        StringBuilder binaryFromHexadecimal = hexOrOctalToBinary(hexadecimalDigits, true);
        return binaryFromHexadecimal;
    }

    public void hexadecimalToDecimal(String hexadecimalNumber)
    {
        int[] hexaDecimalNumbers = changeHexadecimalCharactersToNumbers(hexadecimalNumber);
        int decimalNumber = anythingToDecimalFinishingStep(hexaDecimalNumbers, 16);
        System.out.println("Your Hexadecimal number was: " + hexadecimalNumber + "\n" + "The converted number in Decimal is: " + decimalNumber);
    }

    public String octalToBinary(String octalNumber)
    {
        String[] octalCharacters = octalNumber.split("");
        int[] octalNumbers = new int[octalCharacters.length];
        for (int i = 0; i < octalCharacters.length; i++)
        {
            octalNumbers[i] = Integer.parseInt(octalCharacters[i]);
        }
        String binaryNumber = String.valueOf(hexOrOctalToBinary(octalNumbers, false));
        return binaryNumber;
    }

    public void octalToDecimal(String octalNumber)
    {
        String[] octalCharacters = octalNumber.split("");
        int[] octalDigits = new int[octalCharacters.length];
        for (int i = 0; i < octalCharacters.length; i++)
        {
            octalDigits[i] = Integer.parseInt(octalCharacters[i]);
        }
        int decimalNumber = anythingToDecimalFinishingStep(octalDigits, 8);
        System.out.println("Your Octal number was: " + octalNumber + "\n" + "The converted number in Decimal is: " + decimalNumber);

    }

    public StringBuilder decimalToBinary(String decimal)
    {
        BigDecimal decimalNumber = new BigDecimal(decimal);
        List<BigDecimal> numbersToSubtract = new ArrayList<>();
        BigDecimal multiplier = new BigDecimal("2");
        for (BigDecimal i = new BigDecimal("1"); decimalNumber.compareTo(i) >= 0; i = i.multiply(multiplier))
        {
            numbersToSubtract.add(i);
        }
        System.out.println(numbersToSubtract);
        BigDecimal zero = new BigDecimal("0");
        StringBuilder binaryNumber = new StringBuilder();
        for (int i = numbersToSubtract.size() -1; i >=0;  i--)
        {
            if (zero.compareTo(decimalNumber.subtract(numbersToSubtract.get(i))) <= 0)
            {
                binaryNumber.append("1");
                decimalNumber = decimalNumber.subtract(numbersToSubtract.get(i));
            } else
            {
                binaryNumber.append("0");
            }
        }
        return binaryNumber;
    }
}

