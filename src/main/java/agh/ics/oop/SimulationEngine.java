package agh.ics.oop;

public class SimulationEngine implements IEngine {
    private final MoveDirection[] moves;
    private final Vector2d[] positions;
    private final Animal[] animals;

    public SimulationEngine (MoveDirection[] moves, IWorldMap map, Vector2d[] positions) {
        this.moves= moves;
        this.positions= positions;

        animals= new Animal[positions.length];
        for (int i=0; i < positions.length; i++) {
            animals[i]= new Animal(map, positions[i]);
            animals[i].addObserver((IPositionChangeObserver) map);
            map.place(animals[i]);
        }
    }

    @Override
    public void run () {
        for (int itMove=0; itMove < moves.length; itMove++) {
            int itAnimal= itMove % animals.length;
            animals[itAnimal].move(moves[itMove]);
        }

        for (int i=0; i < animals.length; i++)
            positions[i]= animals[i].getMyLocation();
    }
}
