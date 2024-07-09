
import java.io.*;
import java.util.*;

public class Ui {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<PhysicalMedia> mediaCollection = new ArrayList<>();

    public static void main(String[] args) {
        // Welcome Screen
        System.out.println("Welcome to the Physical Media Indexer, The Simple Indexer for all Media such as Blueray, Dvd and 4k discs");
        System.out.println("Continue on with instructions to add more media or type quit in the console at any time to leave");
        System.out.println("Welcome to the media indexing Menu: Type the number corresponding to the option you wish to choose");
        System.out.println("You must choose the exit option to save correctly!");

        LoadMediaCollection();

        boolean MenuOpen = true;

        while (MenuOpen) {

            System.out.println("Add new Media = 1 ");
            System.out.println("View Stored Media = 2");
            System.out.println("Exit = 3");
            System.out.println("Delete Media = 4");

            // Users choice.

            int userChoice = 0;
            try {
                userChoice = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Input Incorrect please enter as instructed.");

            }

            switch (userChoice) {
                case 1:
                    addNewMedia();
                    break;
                case 2:
                    viewStoredMedia();
                    break;
                case 3:
                    System.out.println("Exiting Media indexer");
                    saveMediaCollection();
                    MenuOpen = false;
                    break;
                case 4:
                    deleteMedia();
                    break;
                default:
                    System.out.println("Invalid choice please choose a valid one ");

            }
        }


    }

    public static void addNewMedia() {

        // Process to start adding Media
        boolean addPhysicalMedia = true;
        while (addPhysicalMedia) {
            System.out.println("Please fill out all of the information below:");
            System.out.println("Enter the Disktype choose between the options choose the number next to the option you wish to select ");
            System.out.println("1 = BlueRay");
            System.out.println("2 = DVD");
            System.out.println("3 = CD");/// type 1 choice
            PhysicalMedia.DiskType diskType = null;
            int disktypeOption;
            try {
                disktypeOption = scanner.nextInt();
                scanner.nextLine();
                switch (disktypeOption) {
                    case 1:
                        diskType = PhysicalMedia.DiskType.BLUERAY;
                        break;
                    case 2:
                        diskType = PhysicalMedia.DiskType.DVD;
                        break;
                    case 3:
                        diskType = PhysicalMedia.DiskType.CD;
                        break;
                    default:
                        System.out.println("invalid disk selection please try again");
                        continue;
                }


            } catch (InputMismatchException e) {
                System.out.println("Invalid input type selection. Please choose fro the values listed.");
                scanner.nextLine();
                continue;

            }
            System.out.println("Enter the MediaName:");
            String mediaName = scanner.nextLine();
            System.out.println("Enter the Director of this media;");
            String director = scanner.nextLine();
            System.out.println("Enter the release year of this media eg, 2001 :");
            int releaseDate = scanner.nextInt();
            System.out.println("Finally enter the rottenTomatoesRating:");
            int rottenTomatoesRating = scanner.nextInt();

            scanner.nextLine();


            //add new media to a list

            PhysicalMedia newMedia = new PhysicalMedia(diskType, mediaName, director, releaseDate, rottenTomatoesRating);
            mediaCollection.add(newMedia);

            System.out.println("Media has been saved");
            break;


        }
    }   //Display Currently added media

    public static void viewStoredMedia() {
        if (mediaCollection.isEmpty()) {
            System.out.println("nothing has been stored yet.");


        } else {
            for (PhysicalMedia media : mediaCollection) {
                System.out.print("MediaName = " + media.getMediaName() + " ");
                System.out.print("DiskType = " + media.getdiskType()  + " ");
                System.out.print("Director = " + media.getDirector()  + " ");
                System.out.print("RottenTomatoesRating = " + media.getRottenTomatoesRating()  + " ");
                System.out.print("ReleaseDate = " + media.getReleaseDate() + " ");
                System.out.println();

            }

        }

    }
            // load media collection

            public static void LoadMediaCollection () {

                try (
                        FileInputStream fileInputStream = new FileInputStream("SavedMediaCollection.dat");
                        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
                    mediaCollection.addAll((ArrayList<PhysicalMedia>) objectInputStream.readObject());

                } catch (IOException e) {
                    System.out.println("Error loading data from disk");

                } catch (ClassNotFoundException e) {
                    System.out.println("Error loading data from disk");
                }


            }

                // save media collection
                public static void saveMediaCollection() {



                try (FileOutputStream fileOutputStream = new FileOutputStream("SavedMediaCollection.dat");
                     ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
                    objectOutputStream.writeObject(mediaCollection);
                } catch (IOException e) {
                    System.out.println("Error writing the data to the disk try again or reboot the program.");
                }
                }
                public static void deleteMedia() {
        if (mediaCollection.isEmpty()) {
            System.out.println("There is nothing in the collection to delete.");
            return;
        }
        System.out.println("Enter The Required Information to Remove the correct file from the collection.");
        System.out.println("Media Name:");
        String mediadelete = scanner.nextLine();
        System.out.println("Director:");
        String directordelete = scanner.nextLine();
        boolean found = false;

        Iterator<PhysicalMedia> iterator = mediaCollection.iterator();
                    while (iterator.hasNext()) {
                        PhysicalMedia mediaminus = iterator.next(); if (mediaminus.getMediaName().equals(mediadelete) && mediaminus.getDirector().equals(directordelete)) {
                            iterator.remove();
                            found = true;
                            System.out.println("Your media you specified has been deleted for you. ");
                            break;
                        }
                    } if (!found) {
                        System.out.println("Couldnt find your media ensure that the director and media name you have inputed is correct. Returning to main menu");


                    }



                }










                }






// output needs to be all on one line



