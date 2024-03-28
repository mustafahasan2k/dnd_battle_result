/*
 *  TO DO
 *  Add different weapon types?
 *  Add skills?
 * 
 */

// Object class for the dnd Enemys
public class enemy {
    private String name;
    private int ac;
    private int hp;
    private int prof;
    private int attBonus;
    private int weapDamage;
    private int weapDamageBonus;

    // Enemy Constructor 
    public enemy(String name, int ac, int hp, int prof, int attBonus, int weapDamage, int weapDamageBonus) {
        this.name = name;
        this.ac = ac;
        this.hp = hp;
        this.prof = prof;
        this.attBonus = attBonus;
        this.weapDamage = weapDamage;
        this.weapDamageBonus = weapDamageBonus;
    }

    // Getters
    public String getName() {
        return name;
    }
    public int getAc() {
        return ac;
    }
    public int getHp() {
        return hp;
    }
    public int getProf() {
        return prof;
    }
    public int getAttBonus() {
        return attBonus;
    }
    public int getWeapDamage() {
        return weapDamage;
    }
    public int getWeapDamageBonus() {
        return weapDamageBonus;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setAc(int ac) {
        this.ac = ac;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
    public void setProf(int proficiency) {
        this.prof = proficiency;
    }
    public void setAttBonus(int attackBonus) {
        this.attBonus = attackBonus;
    }
    public void setWeapDamagee(int weaponDamage) {
        this.weapDamage = weaponDamage;
    }
    public void setWeapDamageBonus(int weaponBonus) {
        this.weapDamageBonus = weaponBonus;
    }
}
