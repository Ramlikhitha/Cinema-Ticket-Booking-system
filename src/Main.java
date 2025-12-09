import model.Movie;
import service.MovieService;

import model.Show;
import service.ShowService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MovieService ms = new MovieService();
        ShowService ss = new ShowService();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== CINEMA TICKET BOOKING ====");
            System.out.println("Select User Type");
            System.out.println("1️⃣ Admin");
            System.out.println("2️⃣ Customer");
            System.out.println("3️⃣ Exit");
            System.out.print("Choose User Type: ");
            int userType = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (userType) {
                case 1: // Admin
                    while (true) {
                        System.out.println("\n==== ADMIN MENU ====");
                        System.out.println("1️⃣ Add Movie");
                        System.out.println("2️⃣ Create Show");
                        System.out.println("3️⃣ Exit");
                        System.out.print("Choose Option: ");
                        int adminChoice = sc.nextInt();
                        sc.nextLine();

                        switch (adminChoice) {
                            case 1: // Add Movie
                                System.out.print("Enter Movie Title: ");
                                String title = sc.nextLine();

                                System.out.print("Enter Language: ");
                                String language = sc.nextLine();

                                System.out.print("Enter Duration (minutes): ");
                                int duration = sc.nextInt();
                                sc.nextLine();

                                System.out.print("Enter Certification: ");
                                String cert = sc.nextLine();

                                Movie movie = new Movie(title, language, duration, cert);
                                ms.addMovie(movie);
                                break;

                            case 2: // Create Show
                                System.out.print("Enter Movie ID: ");
                                int movieId = sc.nextInt();

                                System.out.print("Enter Auditorium ID: ");
                                int auditoriumId = sc.nextInt();
                                sc.nextLine();

                                System.out.print("Enter Show Start Time (YYYY-MM-DD HH:MM): ");
                                String showTime = sc.nextLine();

                                System.out.print("Enter Show End Time (YYYY-MM-DD HH:MM): ");
                                String endTime = sc.nextLine();

                                Show show = new Show(movieId, auditoriumId, showTime, endTime);
                                ss.createShow(show);
                                break;

                            case 3: // Exit Admin Menu
                                System.out.println("Exiting Admin menu...");
                                break;

                            default:
                                System.out.println("Invalid option! Try again.");
                                System.err.println("Error while choosing option");
                        }

                        if (adminChoice == 3) {
                            System.out.println("Exiting ADMIN Inner Looping");
                            break; // exit inner admin loop
                        }
                    }
                    break;

                case 2: // Customer (you can add later)
                    System.out.println("Customer menu coming soon...");
                    break;

                case 3: // Exit Program
                    System.out.println("Exiting system...");

                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! Try again.");
                    System.out.println("CTBS_Branch code..");
            }
        }
    }
}
