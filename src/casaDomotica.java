import java.util.Scanner;
import java.util.InputMismatchException;

public class casaDomotica {

    private static Scanner sc = new Scanner(System.in);

    // Variables Globals // Es guarden
    private static double temperature = 21.0;   // Temperatura actual de la casa
    private static boolean lightsOn = false;    // Estat de les llums (enceses o apagades)
    private static String laundryMode = "none"; // Mode actual de la rentadora
    private static boolean doorLocked = false;  // Estat del pany de les portes
    
    public static void main(String[] args) {
        
        // Variables Locals // Es reinicien
        int lightIntensity = 50;        // Intensitat de les llums en percentatge
        String lightColor = "White";    // Color actual de les llums
        boolean laundryRunning = false; // Si la rentadora està en marxa
        boolean doorsOpen = false;      // Si les portes estan obertes

        boolean exitProgram = false;

        // Fins que l'usuari vol sortir del programa
        while (!exitProgram) {
            
            mainMenu();                 // Mostra el menú principal
            int choice = userChoice();  // Llegeix l'opció de l'usuari

            // Switch per cridar funcions
            switch (choice) {
                case 1:
                    // Control del termostat
                    thermostatControl();
                    break;

                case 2:
                    // Control de llums
                    lightIntensity = lightControl(lightIntensity, lightColor);
                    break;

                case 3:
                    // laundryRunning = laundryMachineControl(); - Per implementar
                    break;
                
                case 4:
                    // doorsOpen = doorControl(); - Per implementar
                    break;
                
                case 5:
                    // Sortir del programa
                    exitProgram = true;
                    System.out.println("Exiting Domotic House Control. See you soon!");
                    break;
                
                default:
                    System.out.println("Invalid choice. Please choose again.");
                    break;
            }
        }
    }

    // Funció que mostra el menú principal amb les opcions disponibles
    public static void mainMenu() {
        System.out.println("\n---DOMOTIC HOUSE---");
        System.out.println("1. Thermostat Control");
        System.out.println("2. Light Control");
        System.out.println("3. Laundry Machine");
        System.out.println("4. Door Control");
        System.out.println("5. Exit");
    }

    // Funció que llegeix i valida l'opció de l'usuari
    public static int userChoice() {
        while (true) {
            try {
                System.out.print("Choose an option: ");
                return sc.nextInt();    // Torna el número que l'usuari ha introduït
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter a valid number.");
                sc.nextLine();
            }
        }
    }

    // Funció que gestiona tot el menú del termostat
    public static void thermostatControl() {
        boolean exitThermostat = false;

        // Bucle del menú del termostat
        while (!exitThermostat) {
            System.out.println("\n---Thermostat Control Menu---");
            System.out.println("Current temperature: " + temperature + "°C");
            System.out.println("1. Change temperature: Specific room");
            System.out.println("2. Change temperature: All rooms");
            System.out.println("3. Return to main menu");
            System.out.print("Choose an option: ");

            int choice = userChoice();

            switch (choice) {
                case 1:
                    specificRoom(); // Canvia temperatura d'una habitació específica
                    break;
                
                case 2:
                    allRooms(); // Canvia temperatura de totes les habitacions
                    break;

                case 3:
                    exitThermostat = true;  // Torna al menú principal
                    break;
            
                default:
                    System.out.println("Invalid choice. Please choose again.");
                    break;
            }
        }
    }

    // Funció per canviar temperatura d'una habitació específica
    public static void specificRoom() {
        System.out.println("\n---Change temperature: Specific room---");
        System.out.println("1. Set manual temperature");
        System.out.println("2. Increase temperature (+1 °C)");
        System.out.println("3. Decrease temperature (-1 °C)");

        int choice = userChoice();

        switch (choice) {
            case 1:
                try {
                    System.out.print("Enter temperature: ");
                    temperature = sc.nextDouble();  // Llegeix la nova temperatura
                    System.out.println("Temperature set to: " + temperature + "°C");
                } catch (InputMismatchException e) {
                    System.out.println("Error: Please enter a valid number.");
                    sc.nextLine(); // Neteja el buffer
                }
                break;

            case 2:
                temperature += 1;   // Augmenta la temperatura en 1 grau
                System.out.println("Temperature increased to: " + temperature + "°C");
                break;

            case 3:
                temperature -= 1;   // Disminueix la temperatura en 1 grau
                System.out.println("Temperature decreased to: " + temperature + "°C");
                break;

            default:
                System.out.println("Invalid choice. Please choose again.");
                break;
        }
    }

    // Funció per canviar temperatura de totes les habitacions
    public static void allRooms() {
        System.out.println("\n---Change temperature: All rooms---");
        System.out.println("1. Set manual temperature");
        System.out.println("2. Increase temperature (+1 °C)");
        System.out.println("3. Decrease temperature (-1 °C)");

        int choice = userChoice();

        switch (choice) {
            case 1:
                try {
                    System.out.print("Enter temperature: ");
                    temperature = sc.nextDouble();
                    System.out.println("Temperature set to: " + temperature + "°C");
                } catch (InputMismatchException e) {
                    System.out.println("Error: Please enter a valid number.");
                    sc.nextLine(); // Neteja el buffer
                }
                break;

            case 2:
                temperature += 1;
                System.out.println("All rooms temperature increased to: " + temperature + "°C");
                break;

            case 3:
                temperature -= 1;
                System.out.println("All rooms temperature decreased to: " + temperature + "°C");
                break;

            default:
                System.out.println("Invalid choice. Please choose again.");
                break;
        }
    }

    // Funció principal del control de llums
    // Rep la intensitat i color actuals i retorna la nova intensitat
    public static int lightControl(int currentLightIntensity, String currentColor) {
        
        int lightIntensity = currentLightIntensity;
        String lightColor = currentColor;
        boolean exitLights = false;

        // Bucle del menú de llums
        while (!exitLights) {
            System.out.println("\n---Lights Menu Control---");
                
            // Mostra l'estat actual de les llums
            if (lightsOn) {
                System.out.println("Lights: ON");
                System.out.println("Intensity: " + lightIntensity + "%");
                System.out.println("Color: " + lightColor);
            } else {
                System.out.println("Lights: OFF");
            }

            System.out.println("1. Control specific room");
            System.out.println("2. Control all rooms");
            System.out.println("3. Check real state of lights");
            System.out.println("4. Back to main menu");

            int choice = userChoice();

            switch (choice) {
                case 1: 
                    // Control d'una habitació específica
                    lightIntensity = specificRoomLights(lightIntensity, lightColor);
                    break;

                case 2:
                    // Control de totes les habitacions
                    lightIntensity = allRoomsLights(lightIntensity, lightColor);
                    break;

                case 3:
                    // Mostra l'estat real de totes les llums
                    checkStateLights(lightIntensity, lightColor);
                    break;

                case 4:
                     // Torna al menú principal
                    exitLights = true;
                    break;

                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }
        return lightIntensity;   // Retorna la nova intensitat per actualitzar-la
    }

    // Funció per controlar les llums d'una habitació específica
    public static int specificRoomLights(int currentLightIntensity, String currentColor) {
        System.out.println("\n--- Control Specific Room Lights ---");
        System.out.println("1. Turn on");
        System.out.println("2. Set intensity");
        System.out.println("3. Set color");

        int lightIntensity = currentLightIntensity;
        String lightColor = currentColor;

        int choice = userChoice();

        switch (choice) {
            case 1:
                lightsOn = true;
                System.out.println("Lights turned ON: Specific room");
                break;

            case 2:
                try {
                    System.out.print("Enter intensity (0-100): ");
                    lightIntensity = sc.nextInt();
                    
                    // Validar rang d'intensitat - assegurar que està entre 0 i 100
                    if (lightIntensity < 0) {
                        lightIntensity = 0;     // Mínim 0%
                    } else if (lightIntensity > 100) {
                        lightIntensity = 100;   // Màxim 100%
                    }
                    
                    System.out.println("Intensity set to: " + lightIntensity + "%");
                } catch (InputMismatchException e) {
                    System.out.println("Error: Please enter a valid number.");
                    sc.nextLine(); // Neteja el buffer
                }
                break;

            case 3:
                try {
                    System.out.print("Enter color: ");
                    sc.nextLine(); // Neteja el buffer del scanner
                    lightColor = sc.nextLine(); // Llegeix el nou color
                    System.out.println("Color set to: " + lightColor);
                } catch (Exception e) {
                    System.out.println("Error reading color.");
                }
                break;

            default:
                System.out.println("Invalid choice.");
        }
        return lightIntensity;   // Retorna la nova intensitat
    }

    // Funció per controlar les llums de totes les habitacions
    public static int allRoomsLights(int currentLightIntensity, String currentColor) {
        System.out.println("\n--- Control All Rooms Lights ---");
        System.out.println("1. Turn on all");
        System.out.println("2. Set intensity for all");
        System.out.println("3. Set color for all");

        int lightIntensity = currentLightIntensity;
        String lightColor = currentColor;

        int choice = userChoice();

        switch (choice) {
            case 1:
                lightsOn = true; 
                System.out.println("Lights turned ON: All rooms");
                break;

            case 2:
                try {
                    System.out.print("Enter intensity for all rooms (0-100): ");
                    lightIntensity = sc.nextInt();
                    
                    // Validar rang d'intensitat
                    if (lightIntensity < 0) {
                        lightIntensity = 0;     // Mínim 0%
                    } else if (lightIntensity > 100) {
                        lightIntensity = 100;   // Màxim 100%
                    }
                    
                    System.out.println("All rooms intensity set to: " + lightIntensity + "%");
                } catch (InputMismatchException e) {
                    System.out.println("Error: Please enter a valid number.");
                    sc.nextLine(); // Neteja el buffer
                }
                break;

            case 3:
                try {
                    System.out.print("Enter color for all rooms: ");
                    sc.nextLine(); // Neteja el buffer
                    lightColor = sc.nextLine();
                    System.out.println("All rooms color set to: " + lightColor);
                } catch (Exception e) {
                    System.out.println("Error reading color.");
                }
                break;

            default:
                System.out.println("Invalid choice.");
        }
        return lightIntensity;   // Retorna la nova intensitat
    }

    // Funció que mostra l'estat real de totes les llums
    public static void checkStateLights(int lightIntensity, String lightColor) {
        System.out.println("\n--- REAL STATE OF LIGHTS ---");
        System.out.println("Power: " + (lightsOn ? "ON" : "OFF"));
        System.out.println("Intensity: " + lightIntensity + "%");
        System.out.println("Color: " + lightColor);
    }

    // Control de la rentadora (pendent d'implementar)
    public static void laundryMachineControl() {
        // Per implementar
    }

    // Control de les portes (pendent d'implementar)
    public static void doorControl() {
        // Per implementar
    }
}