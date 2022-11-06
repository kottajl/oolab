package agh.ics.oop;

import java.util.Objects;

public class Vector2d {
    public final int x, y;

    public Vector2d (int x, int y) {
        this.x= x;
        this.y= y;
    }

    public String toString () {
        return "(" + String.valueOf(this.x) + "," + String.valueOf(this.y) + ")";
    }

    public boolean precedes (Vector2d other) {
        if (this.x <= other.x && this.y <= other.y)
            return true;
        return false;
    }

    public boolean follows (Vector2d other) {
        if (this.x >= other.x && this.y >= other.y)
            return true;
        return false;
    }

    public Vector2d upperRight (Vector2d other) {
        Vector2d newPoint= new Vector2d(Math.max(this.x, other.x), Math.max(this.y, other.y));
        return newPoint;
    }

    public Vector2d lowerLeft (Vector2d other) {
        Vector2d newPoint= new Vector2d(Math.min(this.x, other.x), Math.min(this.y, other.y));
        return newPoint;
    }

    public Vector2d add (Vector2d other) {
        Vector2d newPoint= new Vector2d(this.x + other.x, this.y + other.y);
        return newPoint;
    }

    public Vector2d subtract (Vector2d other) {
        Vector2d newPoint= new Vector2d(this.x - other.x, this.y - other.y);
        return newPoint;
    }

    public Vector2d opposite () {
        Vector2d newPoint= new Vector2d(-this.x, -this.y);
        return newPoint;
    }

    @Override
    public boolean equals (Object other) {
        if (this == other)
            return true;
        if (!(other instanceof Vector2d))
            return false;
        Vector2d that = (Vector2d) other;

        if (this.x == that.x && this.y == that.y)
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

}
