package agh.ics.oop;

import java.util.Objects;

public class Animal {
    private MapDirection myDirection= MapDirection.NORTH;
    private Vector2d myLocation= new Vector2d(2, 2);

    @Override
    public String toString () {
        return "Skierowany na: " + myDirection.toString() + ", lokalizacja: " + myLocation.toString();
    }

    public boolean isAt (Vector2d position) {
        return myLocation.equals(position);
    }

    public void move (MoveDirection direction) {
        Vector2d tempLocation= myLocation;

        switch (direction) {
            case LEFT -> myDirection= myDirection.previous();
            case RIGHT -> myDirection= myDirection.next();
            case FORWARD -> tempLocation= myLocation.add(myDirection.toUnitVector());
            case BACKWARD -> tempLocation= myLocation.subtract(myDirection.toUnitVector());
        }

        if (tempLocation.precedes(new Vector2d (4, 4)) && tempLocation.follows(new Vector2d(0, 0)))
            myLocation= tempLocation;
    }

    public boolean equals (Object other) {
        if (this == other)
            return true;
        if (!(other instanceof Animal))
            return false;
        Animal that = (Animal) other;

        if (this.myDirection.equals(that.myDirection) && this.myLocation.equals(that.myLocation))
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(myDirection, myLocation);
    }

    // Odpowiedź na pytanie 10:
    /*
    Myślę, że najlepiej byłoby zrobić tak, aby klasa Animal dziedziczyła
    z jakiejś innej klasy (np. o nazwie PlaceHolder), w której znajdowałaby
    się dwuwymiarowa macierz typu boolean określająca czy miejsce
    o danych współrzędnych nie jest już zajęte. Przy przemieszczaniu się
    trzeba by było w takim wypadku jeszcze sprawdzać, czy czasami nie próbuję
    się przemieścić na miejsce już zajęte, a jeśli tak to zaniechać ruchu. No
    i oczywiście poruszające się zwierze musiałoby na bieżąco aktualizować tę
    macierz.

    (macierz mogłaby być typu int, jeśli chcielibyśmy też tam zapisywać coś
    w rodzaju ID zwierzęcia)
    */

}