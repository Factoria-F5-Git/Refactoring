class Soldier {

    private static final int WEAPON_READY = 1;
    private static final int WEAPON_BROKEN = 0;

    public int health;
    public int damage;
    public int weaponStatus;

    public Soldier(int health, int damage, int weaponStatus) {
        this.health = health;
        this.damage = damage;
        this.weaponStatus = weaponStatus;
    }

    public int getDamage() {
        if (this.weaponStatus == WEAPON_READY) {
            return damage;
        } else {
            return 0;
        }
    }

    public void attack(Soldier soldier) {
        if (this.weaponStatus == WEAPON_READY) {
            soldier.health -= damage;
        }
    }
}
