package at.nacs.rockpaper.model;

public interface Move {
    String getName();
    Boolean defeats(Move move);
}
