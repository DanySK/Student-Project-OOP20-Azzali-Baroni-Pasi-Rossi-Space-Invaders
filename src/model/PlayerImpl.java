package model;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;

public class PlayerImpl implements Entity{
	
	Point2D position;
    float scale = 1;
    double width;
    double height;
    Image playerImage;
    
    
    public PlayerImpl(Image playerImage) {
        this.playerImage = playerImage;
        this.width = playerImage.getWidth();
        this.height = playerImage.getHeight();
    }
    
     /* **********************************************************
     *                           POSITION                                     *
     ************************************************************ */
    
    @Override
	public Point2D getDrawPosition() {
        return position;
    }
    
    
    @Override
	public void move(Point2D vector) {
        this.position = this.position.add(vector);
    }

    @Override
	public void setDrawPosition(float x, float y) {
        this.position = new Point2D(x, y);
    }

    @Override
	public float getScale() {
        return scale;
    }
    
    @Override
	public Point2D getCenter() {
        Point2D pos = getDrawPosition();
        return new Point2D(pos.getX() + width / 2, pos.getY() + height / 2);
    }
    
     /* **********************************************************
     *                           IMAGE                                          *
     ************************************************************ */
    
    @Override
	public Image getImage() {
        return playerImage;
    }
    
    @Override
	public void setScale(float scale) {
        this.scale = scale;
    }
    
    @Override
	public double getWidth() {
        return this.width * getScale();
    }
    
    @Override
	public double getHeight() {
        return this.height * getScale();
    }
    
    /* *************************************************************
     *                           MOVEMENT                                                 *
     ************************************************************ */
    private float MAX_SPEED = 5f;
    private Point2D currentThrustVector = new Point2D(0, 0);
    
    
    public void addThrust(double scalar) {
        calculateThrust(scalar);
    }
    
    private void calculateThrust(double scalar) {
        Point2D thrustVector = calculateNewThrustVector(scalar);
        currentThrustVector = currentThrustVector.add(thrustVector);
        currentThrustVector = clampToMaxSpeed(currentThrustVector);
    }
    
    private Point2D calculateNewThrustVector(double scalar) {
        return new Point2D((float) (scalar), 0);
    }
    
    private Point2D clampToMaxSpeed(Point2D thrustVector) {
        if (thrustVector.magnitude() > MAX_SPEED) {
            return currentThrustVector = thrustVector.normalize().multiply(MAX_SPEED);
        } else {
            return currentThrustVector = thrustVector;
        }
    }
    
    private void applyDrag() {
        float movementDrag = currentThrustVector.magnitude() < 0.5 ? 0.01f : 0.07f;
        currentThrustVector = new Point2D(reduceTowardsZero((float) currentThrustVector.getX(), movementDrag), reduceTowardsZero((float) currentThrustVector.getY(), movementDrag));
    }
    
    private float reduceTowardsZero(float value, float modifier) {
        float newValue = 0;
        if (value > modifier) {
            newValue = value - modifier;
        } else if (value < -modifier) {
            newValue = value + modifier;
        }
        return newValue;
    }
    
    public void stop() {
    	currentThrustVector = new Point2D(0, 0);
    }
	 
    @Override
	public void update() {
        applyDrag();
        move(currentThrustVector);
    }

}
