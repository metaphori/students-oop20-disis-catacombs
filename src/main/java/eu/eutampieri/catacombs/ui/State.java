package eu.eutampieri.catacombs.ui;

import java.awt.Graphics2D;

public abstract class State {

    protected final DungeonGame game;

    public State(final DungeonGame game) {
        this.game = game;
    }

    public abstract void update(float delta);
    public abstract void render(Graphics2D g2);

    public DungeonGame getGame() {
        return this.game;
    }

}
