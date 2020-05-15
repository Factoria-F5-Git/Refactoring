import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SoldierTest {
    private Soldier soldier;

    @BeforeEach
    public void beforeEach() {
        soldier = new Soldier(10, 2, 1);
    }

    @Test
    public void shouldHaveDamageIfWeaponIsReady() {
        assertEquals(2, soldier.getDamage());
    }

    @Test
    public void shouldNotDoDamageIfWeaponIsBroken() {
        soldier.weaponStatus = 0;
        assertEquals(0, soldier.getDamage());
    }

    @Test
    public void shouldAttackAnotherSoldierIfCanDoDamage() {
        Soldier anotherSoldier = new Soldier(12, 1, 1);
        soldier.attack(anotherSoldier);

        assertEquals(10, anotherSoldier.health);
    }

    @Test
    public void shouldNotDoDamageWhenAttackingWithBrokenWeapon() {
        Soldier anotherSoldier = new Soldier(12, 1, 1);
        soldier.weaponStatus = 0;
        soldier.attack(anotherSoldier);

        assertEquals(12, anotherSoldier.health);
    }
}
