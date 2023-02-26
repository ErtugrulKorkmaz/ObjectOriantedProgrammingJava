public abstract class BattleLoc extends Location
{
    protected Obstacle obstacle;
    protected String award;
    BattleLoc(Player player,String name,Obstacle obstacle,String award)
    {
        super(player);
        this.name=name;
        this.obstacle=obstacle;
        this.award=award;
    }
    public boolean getLocation()
    {
        int obsCount = obstacle.count();
        System.out.println("Currently you are at "+this.getName());
        System.out.println("BE careful!There is "+obsCount+obstacle.getName()+" lives here");
        System.out.print("<F>ight <--> <E>scape :");
        String selCase= scan.nextLine();
        selCase = selCase.toUpperCase();
        if(selCase.equals("F"))
        {
            if(combat(obsCount))
            {
            System.out.println("You defeated all the enemies in "+this.getName()+" area.");
            if(this.award.equals("Food") && player.getInv().isFood()== false)
            {
                System.out.println("You won "+this.award);
                player.getInv().setFood(true);
            }
            else if(this.award.equals("Water") && player.getInv().isWater()== false)
            {
                System.out.println("You won "+this.award);
                player.getInv().setWater(true);
            }
            else if(this.award.equals("Firewood") && player.getInv().isFirewood()== false)
            {
                System.out.println("You won "+this.award);
                player.getInv().setFirewood(true);
            }
            return true;
            }
            else
            {
                System.out.println("You have been defeated.");
                return false;
            }
        }
        return true;
    }

    public boolean combat(int obsCount)
    {
        int defObstacleHealthy = obstacle.getHealthy();
        for(int i=0;i<obsCount;i++)
        {
            playerStats();
            enemyStats();
            while(player.getHealthy()>0 && obstacle.getHealthy()>0)
            {
                System.out.print("<H>it or <R>un :");
                String selCase = scan.nextLine();
                selCase = selCase.toUpperCase();
                if (selCase.equals("H")) {
                    System.out.println("Hitted the enemy.");
                    obstacle.setHealthy(obstacle.getHealthy() - player.getTotalDamage());
                    afterHit();
                    if(obstacle.getHealthy()>0)
                    {
                        System.out.println("Obstacle hitted to you.");
                        player.setHealthy(player.getHealthy() - (obstacle.getDamage() - player.getInv().getArmor()));
                        afterHit();
                    }
                } else {break;}
                if(obstacle.getHealthy()< player.getHealthy())
                {
                    System.out.println("You have defeated enemy.");
                    player.setMoney(player.getMoney()+obstacle.getAward());
                    System.out.println("Currently Money: "+player.getMoney());
                    obstacle.setHealthy(defObstacleHealthy);
                }
                else{return false;}
                System.out.println("-------------------");
            }
        }
        return true;
    }

    public void playerStats() {
        System.out.println("\nPlayer Stats\n===================");
        System.out.println("Healthy:" + player.getHealthy());
        System.out.println("Damage:" + player.getTotalDamage());
        System.out.println("Money:" + player.getMoney());
        if (player.getInv().getwDamage() > 0) {System.out.println("Weapon:" + player.getInv().getwName());}
        if (player.getInv().getArmor() > 0) {System.out.println("Armor" + player.getInv().getaName());}
    }
    public void enemyStats()
    {
        System.out.println("\n"+obstacle.getName()+" Stats\n====================");
        System.out.println("Healthy"+obstacle.getHealthy());
        System.out.println("Damage:"+obstacle.getDamage());
        System.out.println("Award:"+obstacle.getAward());
    }

    public void afterHit()
    {
        System.out.println("Player Healthy: "+player.getHealthy());
        System.out.println(obstacle.getName()+" Healthy: "+obstacle.getHealthy()+"\n");
    }


}
