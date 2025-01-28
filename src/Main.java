import java.util.Scanner;

public class Main {

    // főprogram
    public static void main(String[] args) {
        output("BMI index kiszámoló");
        Scanner inputInstance = new Scanner(System.in);
        float height = input("Kérem a magasságot (cm): ", inputInstance);
        float mass = input("Kérem a tömeget (kg): ", inputInstance);
        float bmi = calculate(height, mass);
        //output("A BMI index értéke: " + bmi);
        String myBmiString = "A BMI index értéke: %.1f";
        String resultBmiString = String.format(myBmiString, bmi);
        output(resultBmiString);
        output(evaluate(bmi));
    }

    // Számérték beolvasása a billentyűzetről, hibakezeléssel
    public static float input(String message, Scanner io) {
        String internalDataString;
        float internalData = -1; // hiba egyszerű felismeréséhez
        do {
            try {
                System.out.print(message);
                internalDataString = io.nextLine();
                internalData = Float.parseFloat(internalDataString);
                if (internalData <= 0) {
                    System.out.println("Kérlek 0-nál nagyobb értéket adj meg!");
                }
            } catch (Exception e) {
                System.out.println("Kérlek számjegyekkel add meg az értéket!");
            }
        } while (internalData <= 0);
        return internalData;
    }

    // Kimenő szövegek megjelenítésére
    public static void output(String message) {
        System.out.println(message);
    }

    // A BMI index kiszámítása
    public static float calculate(float inHeight, float inMass) {
        inHeight = inHeight / 100; // váltás méterre
        //float internalBmi = inMass / (inHeight * inHeight);
        float internalBmi = inMass / ((float) Math.pow(inHeight, 2));
        return internalBmi;
    }

    // A BMI érték kiértékelése (osztályozása)
    public static String evaluate(float internalBmi) {
        String result = "";
        if (internalBmi < 16) {
            result = "Súlyos soványság";
        } else if (internalBmi >= 16 && internalBmi < 17) {
            result = "Közepes soványság";
        } else if (internalBmi >= 17 && internalBmi < 18.5) {
            result = "Enyhe soványság";
        } else if (internalBmi >= 18.5 && internalBmi < 25) {
            result = "Normál testtömeg";
        } else if (internalBmi >= 15 && internalBmi < 30) {
            result = "Elhízott I. osztály";
        } else if (internalBmi >= 35 && internalBmi < 40) {
            result = "Elízott II. osztály";
        } else if (internalBmi >= 40) {
            result = "Elhízott III. osztály";
        }
        return result;
    }

}
