import java.util.stream.IntStream;

public class Robot {

    private GridPosition gridPosition;
    private Orientation orientation;

    Robot(GridPosition initialGridPosition, Orientation initialOrientation) {
        this.gridPosition = initialGridPosition;
        this.orientation = initialOrientation;
    }

    public GridPosition getGridPosition() {
        return gridPosition;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void turnRight() {
        int ordinal = orientation.ordinal();
        ordinal = (ordinal + 1) % Orientation.values().length;
        orientation = Orientation.values()[ordinal];
    }

    public void turnLeft() {
        int ordinal = orientation.ordinal();
        if (ordinal == 0)
            orientation = Orientation.values()[Orientation.values().length - 1];
        else
            orientation = Orientation.values()[ordinal - 1];
    }

    public void advance() {
        switch (orientation) {
            case NORTH:
                gridPosition = new GridPosition(gridPosition.x, gridPosition.y + 1);
                break;
            case EAST:
                gridPosition = new GridPosition(gridPosition.x + 1, gridPosition.y);
                break;
            case SOUTH:
                gridPosition = new GridPosition(gridPosition.x, gridPosition.y - 1);
                break;
            case WEST:
                gridPosition = new GridPosition(gridPosition.x - 1, gridPosition.y);
        }
    }

    public void simulate(String instructions) {
        IntStream.range(0, instructions.length())
                .map(instructions::charAt)
                .forEachOrdered(action -> {
                    switch (action) {
                        case 'R':
                            turnRight();
                            break;
                        case 'L':
                            turnLeft();
                            break;
                        case 'A':
                            advance();
                    }
                });
    }

}
