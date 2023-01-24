package sadowski.wojciech.srcodingexercise;

import sadowski.wojciech.srcodingexercise.model.Event;
import sadowski.wojciech.srcodingexercise.service.EventPrinter;
import sadowski.wojciech.srcodingexercise.service.EventReader;
import sadowski.wojciech.srcodingexercise.service.EventSorter;

import java.io.File;
import java.util.List;

public class App {
    private static final EventReader reader = new EventReader();
    private static final EventSorter sorter = new EventSorter();
    private static final EventPrinter printer = new EventPrinter();

    public static void main(String[] args) {
        List<Event> events = reader.getEvents();
        List<Event> sortedEvents = sorter.sortByMostProbableResults(events);

        if (args.length == 0) {
            printer.printResults(sortedEvents, 10);
            System.out.println("Printed from default url");
        }
        if (args.length == 1) {
            if (args[0].equals("-c")) {
                printer.printAllCompetitors(events);
                System.out.println("Printed all competitors from default url");
            } else {
                System.out.println("Wrong input parameter");
            }
        }
        if (args.length == 2) {
            if (args[0].equals("-url") || args[1] != null) {
                File file = new File(args[1]);
                if (file.exists()) {
                    events = reader.getEvents(file);
                    sortedEvents = sorter.sortByMostProbableResults(events);
                    printer.printResults(sortedEvents, 10);
                    System.out.println("Printed from url");
                } else if (!args[0].equals("-url")) {
                    System.out.println("Wrong input parameter");
                } else {
                    System.out.println("File does not exist");
                }
            }
        }
        if (args.length == 3) {
            if (args[0].equals("-url") || args[1] != null) {
                File file = new File(args[1]);
                int amount = Integer.parseInt(args[2]);
                if (file.exists()) {
                    events = reader.getEvents(file);
                    sortedEvents = sorter.sortByMostProbableResults(events);
                    if (amount > sortedEvents.size()) {
                        System.out.println("There are not that many results. Try less");
                    }
                    if (amount <= sortedEvents.size()) {
                        printer.printResults(sortedEvents, amount);
                        System.out.printf("Printed from inputted url with given quantity %d", amount);
                    }
                } else if (!args[0].equals("-url")) {
                    System.out.println("Wrong input parameter");
                } else {
                    System.out.println("File does not exist");
                }
            }
        }

    }

}
