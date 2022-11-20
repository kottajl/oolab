package agh.ics.oop;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class MapBoundary implements IPositionChangeObserver {
    /**
     * Przepraszam za poniższy algorytm Copy'ego-Paste'a, ale zupełnie nie wiem jak
     * by to zrobić sensownie inaczej (działanie na Object) bez zmieniania
     */

    public Set <Object> xElements= new TreeSet<>(new Comparator<Object>() {
        @Override
        public int compare (Object o1, Object o2) {
            boolean iso1Grass= false;
            boolean iso2Grass= false;
            if (o1 instanceof Grass)
                iso1Grass= true;
            if (o2 instanceof Grass)
                iso2Grass= true;

            if (iso1Grass && iso2Grass) {   ///obie trawy
                if (((Grass) o1).getPosition().x < ((Grass) o2).getPosition().x)
                    return -1;
                else if (((Grass) o1).getPosition().x > ((Grass) o2).getPosition().x)
                    return 1;

                if (((Grass) o1).getPosition().y < ((Grass) o2).getPosition().y)
                    return -1;
                else if (((Grass) o1).getPosition().y > ((Grass) o2).getPosition().y)
                    return 1;

                return 0;
            }

            if (!iso1Grass && !iso2Grass) {   ///oba zwierzęta
                if (((Animal) o1).getMyLocation().x < ((Animal) o2).getMyLocation().x)
                    return -1;
                else if (((Animal) o1).getMyLocation().x > ((Animal) o2).getMyLocation().x)
                    return 1;

                if (((Animal) o1).getMyLocation().y < ((Animal) o2).getMyLocation().y)
                    return -1;
                else if (((Animal) o1).getMyLocation().y > ((Animal) o2).getMyLocation().y)
                    return 1;

                return 0;
            }

            if (!iso1Grass && iso2Grass) {   ///zwierze-trawa
                if (((Animal) o1).getMyLocation().x < ((Grass) o2).getPosition().x)
                    return -1;
                else if (((Animal) o1).getMyLocation().x > ((Grass) o2).getPosition().x)
                    return 1;

                if (((Animal) o1).getMyLocation().y < ((Grass) o2).getPosition().y)
                    return -1;
                else if (((Animal) o1).getMyLocation().y > ((Grass) o2).getPosition().y)
                    return 1;

                return -1;
            }

            else {   ///trawa-zwierze
                if (((Grass) o1).getPosition().x < ((Animal) o2).getMyLocation().x)
                    return -1;
                else if (((Grass) o1).getPosition().x > ((Animal) o2).getMyLocation().x)
                    return 1;

                if (((Grass) o1).getPosition().y < ((Animal) o2).getMyLocation().y)
                    return -1;
                else if (((Grass) o1).getPosition().y > ((Animal) o2).getMyLocation().y)
                    return 1;

                return 1;
            }
        }
    });

    public Set <Object> yElements= new TreeSet<>(new Comparator<Object>() {
        @Override
        public int compare (Object o1, Object o2) {
            boolean iso1Grass= false;
            boolean iso2Grass= false;
            if (o1 instanceof Grass)
                iso1Grass= true;
            if (o2 instanceof Grass)
                iso2Grass= true;

            if (iso1Grass && iso2Grass) {   ///obie trawy
                if (((Grass) o1).getPosition().y < ((Grass) o2).getPosition().y)
                    return -1;
                else if (((Grass) o1).getPosition().y > ((Grass) o2).getPosition().y)
                    return 1;

                if (((Grass) o1).getPosition().x < ((Grass) o2).getPosition().x)
                    return -1;
                else if (((Grass) o1).getPosition().x > ((Grass) o2).getPosition().x)
                    return 1;

                return 0;
            }

            if (!iso1Grass && !iso2Grass) {   ///oba zwierzęta
                if (((Animal) o1).getMyLocation().y < ((Animal) o2).getMyLocation().y)
                    return -1;
                else if (((Animal) o1).getMyLocation().y > ((Animal) o2).getMyLocation().y)
                    return 1;

                if (((Animal) o1).getMyLocation().x < ((Animal) o2).getMyLocation().x)
                    return -1;
                else if (((Animal) o1).getMyLocation().x > ((Animal) o2).getMyLocation().x)
                    return 1;

                return 0;
            }

            if (!iso1Grass && iso2Grass) {   ///zwierze-trawa
                if (((Animal) o1).getMyLocation().y < ((Grass) o2).getPosition().y)
                    return -1;
                else if (((Animal) o1).getMyLocation().y > ((Grass) o2).getPosition().y)
                    return 1;

                if (((Animal) o1).getMyLocation().x < ((Grass) o2).getPosition().x)
                    return -1;
                else if (((Animal) o1).getMyLocation().x > ((Grass) o2).getPosition().x)
                    return 1;

                return -1;
            }

            else {   ///trawa-zwierze
                if (((Grass) o1).getPosition().y < ((Animal) o2).getMyLocation().y)
                    return -1;
                else if (((Grass) o1).getPosition().y > ((Animal) o2).getMyLocation().y)
                    return 1;

                if (((Grass) o1).getPosition().x < ((Animal) o2).getMyLocation().x)
                    return -1;
                else if (((Grass) o1).getPosition().x > ((Animal) o2).getMyLocation().x)
                    return 1;

                return 1;
            }
        }
    });

    // Gdy zwierzę zmieni pozycję, to mam problem. Dlatego muszę je najpierw usunąć z obu zbiorów,
    // potem dopiero zmienić im pozycję i dodać do oby na nowo.

    @Override
    public void positionChanged (Vector2d oldPosition, Vector2d newPosition) {

    }
}
