import java.util.Random;
public class Obstacle {
    private String name;
    private int maxNumber,damage,award,healthy;

    public Obstacle(String name,int maxNumber,int damage,int award,int healthy)
    {
        this.name = name;
        this.maxNumber = maxNumber;
        this.damage = damage;
        this.award = award;
        this.healthy = healthy;
    }
    public int count()
    {
        Random r = new Random();
        return r.nextInt(this.maxNumber)+1;
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public int getMaxNumber() {return maxNumber;}
    public void setMaxNumber(int maxNumber) {this.maxNumber = maxNumber;}
    public int getDamage() {return damage;}
    public void setDamage(int damage) {this.damage = damage;}
    public int getAward() {return award;}
    public void setAward(int award) {this.award = award;}
    public int getHealthy() {return healthy;}
    public void setHealthy(int healthy) {this.healthy = healthy;}
}
