package model.powerup;

public enum PowerUpT {

    HEALTH(false,0),

    FIRE_BOOST(false,(int) PowerUpImpl.LIFETIME_P),

    FREEZE(false,PowerUpImpl.LIFETIME_P);

    private final boolean requiringUpdate;
    private final int lifetime;

    PowerUpT(final boolean requiringUpdate, final int lifetime){
        this.requiringUpdate = requiringUpdate;
        this.lifetime = lifetime;
    }

    public final boolean isRequiringUpdate() {
        return this.requiringUpdate;
    }

    public final int getLifetime() {
        return this.lifetime;
    }

}
