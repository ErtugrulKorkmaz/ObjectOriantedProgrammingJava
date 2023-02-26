import java.util.Scanner;
public class Player {
    Scanner scan = new Scanner(System.in);
    private int damage;
    private int healthy;
    private int money;
    private int rHealthy;
    private String name,cName;
    private Inventory inv;

    public Player(String name)
    {
        this.name=name;
        this.inv=new Inventory();
    }

    public Inventory getInv() {return inv;}
    public int getDamage() {return damage;}
    public int getHealthy() {return healthy;}
    public int getMoney() {return money;}
    public String getName() {return name;}
    public String getcName() {return cName;}
    public int getrHealthy() {return rHealthy;}

    public void setInv(Inventory inv) {this.inv = inv;}
    public void setrHealthy(int rHealthy) {this.rHealthy = rHealthy;}
    public void setDamage(int damage) {this.damage = damage;}
    public void setHealthy(int healthy) {this.healthy = healthy;}
    public void setMoney(int money) {this.money = money;}
    public void setName(String name) {this.name = name;}
    public void setcName(String cName) {this.cName = cName;}
    public void selectChar()
    {
        //System.out.println(chaMenu());
        switch(chaMenu())
        {
            case 1:
                setcName("Samurai");
                setDamage(5);
                setHealthy(21);
                setMoney(15);
                break;
            case 2:
                setcName("Archer");
                setDamage(7);
                setHealthy(18);
                setMoney(20);
                break;
            case 3:
                setcName("Chivalry");
                setDamage(8);
                setHealthy(24);
                setMoney(5);
                break;
        }
        System.out.println("Character:"+getcName()
                +"-->"+"Damage:"+getDamage()+"-->"
                +"Healthy:"+getHealthy()+"-->"
                +"Money:"+getMoney());
    }
    public int chaMenu()
    {
        System.out.println("Choose a Character");
        System.out.println("1-Samurai  --> Damage:5 --> Healty:21 --> Money:15");
        System.out.println("2-Archer   --> Damage:7 --> Healty:18 --> Money:20");
        System.out.println("3-Chivalry --> Damage:8 --> Healty:24 --> Money:5");
        System.out.print("Your chooice:");
        int chaId = scan.nextInt();
        while(chaId<1||chaId>3)
        {
            System.out.print("Character must be valid,Select your Character again");
            chaId = scan.nextInt();
        }
        return chaId;
    }

    public int getTotalDamage() {return this.getDamage()+this.getInv().getwDamage();}






}
