package eu.eutampieri.catacombs.model;

import eu.eutampieri.catacombs.model.map.TileMap;

public abstract class Entity extends GameObject implements LivingCharacter{

    public static final int FACE_RIGHT = 0;
    public static final int FACE_LEFT = 1;
    public static final int FACE_DOWN = 2;
    public static final int FACE_UP = 3;
    protected boolean up, down, right, left;
    protected int face;

    protected int hp;
    protected boolean isAlive;
    protected int width, height;

    protected TileMap tileMap;
    //protected CollisionBox box;

    public Entity(int x, int y, TileMap tileMap) {
        super(x, y, ID.Enemy);
        this.tileMap = tileMap;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public void update(float delta) {
        move();
        updateSpriteLocation();
    }

    @Override
    public void render() {

    }

    protected void move() {
        if (up) {
            if (!isUpCollision(velY)) {
                //box.y -= velY;
            }
            face = FACE_UP;
        }
        if (down) {
            if (!isDownCollision(velY)) {
                //box.y += velY;
            }
            face = FACE_DOWN;
        }
        if (left) {
            if (!isLeftCollision(velX)) {
                //box.x -= velX;
            }
            face = FACE_LEFT;
        }
        if (right) {
            if (!isRightCollision(velX)) {
                //box.x += velX;
            }
            face = FACE_RIGHT;
        }
    }

    protected boolean isUpCollision(float dy) {
        return false;
    }

    protected boolean isRightCollision(float dx) {
        return false;
    }

    protected boolean isDownCollision(float dy) {
        return false;
    }

    protected boolean isLeftCollision(float dx) {
        return false;
    }

    protected void updateSpriteLocation() {
        //this.posX = box.x;
        //this.posY = box.y;
    }

    protected void resetMovement() {
        up = false;
        down = false;
        right = false;
        left = false;
    }

}
