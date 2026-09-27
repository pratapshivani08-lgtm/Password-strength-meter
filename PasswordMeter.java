import java.util.Scanner;

public class PasswordMeter{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("==================================================");
        System.out.println("🔒 Welcome to the Digital Password Strength Meter");
        System.out.println("==================================================");

        while (true) {
            System.out.print("\nEnter a password to test (or type 'exit' to quit): ");
            String password = scanner.nextLine();

            // Exit condition
            if (password.equalsIgnoreCase("exit")) {
                System.out.println("Thank you for using the Password Strength Meter. Stay secure!");
                break;
            }

            // Flags to track criteria
            boolean hasMinimumLength = false;
            boolean hasUppercase = false;
            boolean hasLowercase = false;
            boolean hasDigit = false;
            boolean hasSpecialChar = false;

            // 1. Check length
            if (password.length() >= 8) {
                hasMinimumLength = true;
            }

            // 2. Loop through each character to check types
            for (int i = 0; i < password.length(); i++) {
                char ch = password.charAt(i);

                if (Character.isUpperCase(ch)) {
                    hasUppercase = true;
                } else if (Character.isLowerCase(ch)) {
                    hasLowercase = true;
                } else if (Character.isDigit(ch)) {
                    hasDigit = true;
                } else {
                    // If it is not a letter or digit, treat it as a special character
                    // (Avoids checking spaces by skipping them if needed, or including them)
                    if (ch != ' ') {
                        hasSpecialChar = true;
                    }
                }
            }

            // 3. Calculate score based on met criteria
            int score = 0;
            if (hasMinimumLength) score++;
            if (hasUppercase) score++;
            if (hasLowercase) score++;
            if (hasDigit) score++;
            if (hasSpecialChar) score++;

            // 4. Output the results and dynamic feedback
            System.out.println("\n--- Analysis Report ---");
            System.out.println("⭐ Total Security Score: " + score + "/5");

            // Evaluate structural strength description
            if (score <= 2) {
                System.out.println("🔴 Strength Level: WEAK");
            } else if (score == 3 || score == 4) {
                System.out.println("🟡 Strength Level: MEDIUM");
            } else {
                System.out.println("🟢 Strength Level: STRONG");
            }

            // Give helpful tips if requirements are missing
            System.out.println("\n💡 Improvement Tips:");
            if (!hasMinimumLength) {
                System.out.println("   - Make your password at least 8 characters long.");
            }
            if (!hasUppercase) {
                System.out.println("   - Add at least one UPPERCASE letter (A-Z).");
            }
            if (!hasLowercase) {
                System.out.println("   - Add at least one lowercase letter (a-z).");
            }
            if (!hasDigit) {
                System.out.println("   - Mix in at least one number (0-9).");
            }
            if (!hasSpecialChar) {
                System.out.println("   - Include a special symbol (like @, #, $, %, etc.).");
            }
            
            if (score == 5) {
                System.out.println("   - Excellent job! Your password meets all security rules.");
            }
            System.out.println("--------------------------------------------------");
        }

        scanner.close();
    }
} 

