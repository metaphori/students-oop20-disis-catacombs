package eu.eutampieri.catacombs.model;

import eu.eutampieri.catacombs.model.map.TileMap;

/**
 * Slime class - the slime is an enemy that walks toward the targeted character and deals damage on contact (through hit boxes).
 */
public final class Slime extends Entity {

	private static final int HEIGHT = 32;
	private static final int WIDTH = 32;
	private static final int MOVEMENT_SPEED = 1;
	private static final int HEALTH = 10;
	private static final String NAME = "Slime";
	private static final int CB_POS_MOD = 4;
	private static final int CB_DIM_MOD = 8;

	/**
	 * Character followed by the slime.
	 */
	private Entity characterToFollow;
	/**
	 * Slime aggro box.
	 */
	private final CollisionBox radarBox;

	/**
	 * Slime constructor.
	 * @param x X spawn position
	 * @param y Y spawn position
	 * @param tileMap Tile map in which Slime is spawned
	 */
	public Slime(final int x, final int y, final TileMap tileMap) {
		super(x, y, tileMap);
		setHeight(HEIGHT);
		setWidth(WIDTH);
		setSpeed(MOVEMENT_SPEED);
		setHealth(HEALTH);
		setAlive(true);
		face = Face.FACE_RIGHT;
		hitBox = new CollisionBox(posX, posY, width, height);
		radarBox = new CollisionBox(posX - (width * CB_POS_MOD), posY - (height * CB_POS_MOD), width * CB_DIM_MOD, height * CB_POS_MOD);

		// TODO Animations
	}

	@Override
	public void update(final int delta) {
		resetMovement();
		follow();
		super.update(delta);
		updateRadarBoxLocation();
	}

	@Override
	public void render() {
		// TODO Auto-generated method stub
	}

	@Override
	public int getHealth() {
		return this.hp;
	}

	@Override
	public void setHealth(final int health) {
		this.hp = health;
	}

	/**
	 * Utility method useful and used in GameState to make the Slime follow an Entity (most likely the Player).
	 * 		With this method Slimes can follow every entity.
	 * @param e Entity to follow
	 */
	public void follow(final Entity e) {
		if (radarBox.overlaps(e.getHitBox())) {
			characterToFollow = e;
		}
	}

	/**
	 * Makes Slime path towards the Character(Entity) to follow.
	 */
	private void follow() {
		if (characterToFollow == null) {
			return;
		}
		if (characterToFollow.getPosX() < posX) {
			left = true;
		} else if (characterToFollow.getPosX() > posX) {
			right = true;
		}
		if (characterToFollow.getPosX() < posY) {
			up = true;
		} else if (characterToFollow.getPosX() > posY) {
			down = true;
		}
	}

	/**
	 * Updates the aggro radar's Slime box.
	 */
	public void updateRadarBoxLocation() {
		radarBox.setLocation(posX - width * 2, posY - height * 2);
	}

	public String getName() {
		return this.NAME;
	}
	
}
