import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        List<Person> persoane = new ArrayList<>();
        File fisier = new File("C:\\Users\\Lenovo\\OneDrive\\Desktop\\Java Learning\\lab5\\src\\input.txt");
        persoane = extracted(fisier);

        System.out.println("Lista initiala: ");
        afisare(persoane);
        System.out.println();

        persoane.sort(Comparator.comparing(p -> p.nume));


        System.out.println("Lista sortata dupa nume:");
        afisare(persoane);
        System.out.println();

        persoane.sort(Comparator.comparing(p -> p.varsta));

        System.out.println("Lista sortata dupa nume:");
        afisare(persoane);

    }

    private static void afisare(List<Person> persoane) {
        for (Person persoana : persoane) {
            System.out.println(persoana);
        }
    }

    public static List<Person> extracted(File fisier) {
        List<Person> persoane = new ArrayList<>();

        try (Scanner scanner = new Scanner(fisier)) {
            while (scanner.hasNextLine()) {
                String linie = scanner.nextLine().trim();
                String[] bucati = linie.split("\\s+");

                if (bucati.length == 3) {
                    try {
                        String prenume = bucati[0].trim();
                        String nume = bucati[1].trim();
                        int varsta = Integer.parseInt(bucati[2].trim());
                        persoane.add(new Person(prenume, nume, varsta));
                    } catch (NumberFormatException e) {
                        System.out.println("Eroare la citirea varstei pentru linia: " + linie);
                    }
                } else {
                    System.out.println("Format invalid: " + linie);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Fisierul nu a fost gasit: " + fisier.getAbsolutePath());
            e.printStackTrace();
        }

        return persoane;
    }
}
