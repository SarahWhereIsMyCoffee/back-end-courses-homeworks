package it.sevenbits;
import java.lang.NullPointerException;
import java.util.ArrayList;
import java.util.HashMap;


public class Formatter {
    public Formatter(StringBuilder stringBuilder) {
        finalListIterator = 0;
        this.stringBuilder = stringBuilder;
        createInitialList();
        functions.put('{', this::toFixWithOpeningBracket);
        functions.put('}', this::toFixWithClosingingBracket);
        functions.put(';', this::toFixWithSemicolon);
    }
    public void createInitialList() {
        try {
            line = stringBuilder.toString();
        }
        catch (NullPointerException e) {
            System.out.println("NullPointer");
        }

        for (char a : line.toCharArray()){
            initialList.add(a);
        }
        System.out.println("Изначальный файл: ");
        initialListOutput();
        fixFinalList();
    }
    public void fixFinalList() {
        for (int i = 0; i < initialList.size(); i++) {
            if (i != 0 && ((initialList.get(i) == ' ' && initialList.get(i-1) == ' ') || initialList.get(i) == '\n')) {
                continue;
            } else {
                finalList.add(initialList.get(i));
            }
        }
    }

    HashMap <Character, Runnable> functions = new HashMap<>();
    private ArrayList<Character> initialList = new ArrayList<>();
    private ArrayList<Character> finalList = new ArrayList<>();
    private StringBuilder stringBuilder;
    private String line;
    private int finalListIterator;
    private int levelOfBranches = 0;

    public void shiftToTheLeft(int currentIterator, int iterationsCount) {
        for (int i = 0; i < iterationsCount; i++) {
            int shiftsCount = finalList.size() - currentIterator;
            int currentSymbolPositionFromTheEnd = 0;
            while (shiftsCount != 0) {
                int positionForTheShift = currentIterator + currentSymbolPositionFromTheEnd - 1;
                int posFromWhereWeShift = currentIterator + currentSymbolPositionFromTheEnd;
                finalList.set(positionForTheShift, finalList.get(posFromWhereWeShift));
                currentSymbolPositionFromTheEnd++;
                shiftsCount--;
            }
        }
        finalList.remove(finalList.get(finalList.size() - 1));
    }
    public void shiftToTheRight(int currentIterator, int iterationsCount) {
        int currentSymbolPositionFromTheEnd = 1;
        for (int i = 0; i < iterationsCount; i++) {
            finalList.add(finalList.get(finalList.size() - (i+1)));
            int shiftsCount = finalList.size() - currentIterator - (i+1);
            while (shiftsCount != 0) {
                int positionForTheShift = finalList.size() - currentSymbolPositionFromTheEnd;
                int posFromWhereWeShift = finalList.size() - currentSymbolPositionFromTheEnd - 1;
                finalList.set(positionForTheShift, finalList.get(posFromWhereWeShift));
                finalList.set(posFromWhereWeShift, ' ');
                shiftsCount--;
                currentSymbolPositionFromTheEnd++;
            }
        }
    }

    public void toFixWithOpeningBracket() {
        if (finalList.get(finalListIterator - 1) != ' ') {
           shiftToTheRight(finalListIterator, 1);
           if (finalList.get(finalListIterator - 1) == '}')
               finalList.set(finalListIterator, '\n');
           else {
               finalList.set(finalListIterator, ' ');
           }
           finalListIterator+=1;
        }

        if (finalListIterator == finalList.size()- 1) {
            return;
        }

        if (finalList.get(finalListIterator + 1) == ' ') {
            finalList.set(finalListIterator + 1, '\n');
        } else {
            if (finalList.get(finalListIterator + 1) != '}') {
                shiftToTheRight(finalListIterator + 1, 1);
                finalList.set(finalListIterator + 1, '\n');
                finalListIterator+=1;
                finalListIterator--;
            }
        }
    }
    public void toFixWithClosingingBracket() {
        if (finalList.get(finalListIterator - 1) != ' ' && finalList.get(finalListIterator - 1) != '\n') {
                shiftToTheRight(finalListIterator, 1);
                finalList.set(finalListIterator, '\n');
                finalListIterator+=1;

        } else {
                finalList.set(finalListIterator - 1, '\n');
        }

        if (finalListIterator == finalList.size() - 1) {
            return;
        }

        if (finalList.get(finalListIterator + 1) == ' ') {
            finalList.set(finalListIterator + 1, '\n');
        } else {
            if (finalList.get(finalListIterator + 1) != '{' && finalList.get(finalListIterator + 1) != '}') {
                shiftToTheRight(finalListIterator + 1, 1);
                finalList.set(finalListIterator + levelOfBranches, '\n');
                finalListIterator+=1;
            }
        }

    }
    public void toFixWithSemicolon() {
        if (finalList.get(finalListIterator - 1) == ' ') {
            shiftToTheLeft(finalListIterator, 1);
        }

        if (finalListIterator == finalList.size() - 1)
        {
            return;
        }

        if (finalList.get(finalListIterator + 1) == ' ') {
            finalList.set(finalListIterator + 1, '\n');
        } else {
            shiftToTheRight(finalListIterator + 1, 1);
            finalList.set(finalListIterator + 1, '\n');
        }
    }
    public void format() {
        while (finalListIterator < finalList.size()) {
            char currentSymbol = finalList.get(finalListIterator);
            if (currentSymbol == '{' || currentSymbol == ';' || currentSymbol == '}') {
                if (currentSymbol == '{')
                {
                    levelOfBranches++;
                }
                if (currentSymbol == '}')
                {
                    levelOfBranches--;
                }
                functions.get(currentSymbol).run();
            }
            if (levelOfBranches != 0 && currentSymbol == '\n') {
                shiftToTheRight(finalListIterator, 1);
                finalListIterator++;
            }
            /*
            if (levelOfBranches != 0 && currentSymbol == '\n') {
                finalListIterator++;
                for (int i = 0; i < levelOfBranches; i++) {
                    for (int j = 0; j < 4 * (i + 1) - 1; j++) {
                        shiftToTheRight(finalListIterator, 1);
                        finalListIterator++;
                    }
                }
            }
*/
            finalListIterator++;
        }

        finalListIterator = 0;
        while ((finalListIterator < finalList.size())) {
            char currentSymbol = finalList.get(finalListIterator);
            if (currentSymbol == '{')
            {
                levelOfBranches++;
            }
            if (currentSymbol == '}')
            {
                levelOfBranches--;
            }

            if (levelOfBranches != 0 && currentSymbol == '\n') {
                finalListIterator++;
                for (int i = 0; i < levelOfBranches; i++) {
                    for (int j = 0; j < 4 * (i + 1) - 1; j++) {
                        shiftToTheRight(finalListIterator, 1);
                        finalListIterator++;
                    }
                }
            }
            finalListIterator++;
        }

    }

    public void finalListOutput() {
        finalList.forEach(System.out::print);
        System.out.println();
    }
    public void initialListOutput() {
        initialList.forEach(System.out::print);
        System.out.println();
    }
}
