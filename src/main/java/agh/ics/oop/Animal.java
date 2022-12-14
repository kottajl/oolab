package agh.ics.oop;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Animal {
    private MapDirection myDirection= MapDirection.NORTH;
    private Vector2d myLocation;
    private final IWorldMap map;
    private final List <IPositionChangeObserver> observerList= new LinkedList<>();

    public Animal (IWorldMap map) {
        this(map, new Vector2d(2, 2));
    }

    public Animal (IWorldMap map, Vector2d initialPosition) {
        this.map= map;
        this.myLocation= initialPosition;
    }

    public Vector2d getMyLocation() {
        return myLocation;
    }

    public String toText () {
        return "Skierowany na: " + myDirection.toString() + ", lokalizacja: " + myLocation.toString();
    }

    @Override
    public String toString () {
        String s= switch (myDirection) {
            case NORTH -> "^";
            case SOUTH -> "v";
            case WEST -> "<";
            case EAST -> ">";
        };

        return s;
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

        if (map.canMoveTo(tempLocation)) {
            this.positionChanged(this.myLocation, tempLocation);
            myLocation= tempLocation;
            map.movedTo(myLocation);
        }
    }

    public void addObserver (IPositionChangeObserver observer) {
        if (!observerList.contains(observer))
            observerList.add(observer);
    }

    public void removeObserver (IPositionChangeObserver observer) {
        observerList.remove(observer);
    }

    private void positionChanged (Vector2d oldPosition, Vector2d newPosition) {
        for (IPositionChangeObserver observer: observerList)
            observer.positionChanged(oldPosition, newPosition);
    }

    @Override
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

    // (lab3) Odpowied?? na pytanie 10:
    /**
    My??l??, ??e najlepiej by??oby zrobi?? tak, aby klasa Animal dziedziczy??a
    z jakiej?? innej klasy (np. o nazwie PlaceHolder), w kt??rej znajdowa??aby
    si?? dwuwymiarowa macierz typu boolean okre??laj??ca czy miejsce
    o danych wsp????rz??dnych nie jest ju?? zaj??te. Przy przemieszczaniu si??
    trzeba by by??o w takim wypadku jeszcze sprawdza??, czy czasami nie pr??buj??
    si?? przemie??ci?? na miejsce ju?? zaj??te, a je??li tak to zaniecha?? ruchu. No
    i oczywi??cie poruszaj??ce si?? zwierze musia??oby na bie????co aktualizowa?? t??
    macierz.

    (macierz mog??aby by?? typu int, je??li chcieliby??my te?? tam zapisywa?? co??
    w rodzaju ID zwierz??cia)
    */

}
