package agh.ics.oop;

import java.util.Objects;

public class Grass implements IMapElement {
    /**
     * W mojej opinii dodawanie tu klasy abstrakcyjnej AbstractWorldMapElement jest bez sensu, bo klasy
     * Animal oraz Grass mają stosunkowo mało cech wspólnych - praktycznie tylko coś takiego jak "pozycja",
     * lecz musiałbym pozmieniać nazwy w kodzie, a uważam, że trawa ma mieć "pozycję", a zwierzę ma mieć
     * aktualną "lokalizację". Ponadto nazw metod też bym nie mógł zmienić, gdyż w sporej części dostałem
     * w poleceniu jasny opis tych nazw dla konkretnych metod.
     *
     * Analogicznie z interfejsem IMapElement - oprócz tego "getPosition" (gdzie chcę zachować indywidualne
     * nazewnictwo) wszystko jest praktycznie inne. Dla samego toString nie ma raczej sensu.
     */

    private final Vector2d position;

    public Grass (Vector2d position) {
        this.position= position;
    }

    public Vector2d getPosition () {
        return position;
    }

    @Override
    public String toString () {
        return "*";
    }

    @Override
    public boolean equals (Object other) {
        if (this == other)
            return true;
        if (!(other instanceof Grass))
            return false;
        Grass that = (Grass) other;

        return this.position.equals(that.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

}
