public class Shop extends NormalLoc
{
    Shop(Player player) {super(player,"Store");}
    public boolean getLocation()
    {
        System.out.println("1-Weapons");
        System.out.println("2-Armors");
        System.out.println("3-Exit");
        System.out.print("Your choice:");
        int selTool = scan.nextInt();
        int selItemID;
        switch(selTool)
        {
            case 1:
                selItemID= weaponMenu();
                buyWeapon(selItemID);
                break;
            case 2:
                selItemID = armorMenu();
                buyArmor(selItemID);
                break;
            case 3:
                break;
        }
        return true;
    }

    public int armorMenu()
    {
        System.out.println("Money:"+ getPlayer().getMoney());
        System.out.println("1-Light Weight-->Money:15-->Avoid:1");
        System.out.println("2-Middleweight-->Money:25 -->Avoid:3");
        System.out.println("3-Heavy Weight-->Money:40 -->Avoid:5");
        System.out.println("4-Exit");
        System.out.print("Select Weapon:");
        int selArmorID= scan.nextInt();
        return selArmorID;
    }
    public void buyArmor(int itemID)
    {
        int avoid=0,price=0;
        String aName=null;
        if(itemID>0 || itemID<5)
        {
            switch (itemID)
            {
                case 1:
                    avoid = 1;
                    aName= "Light Weight";
                    price= 15;
                    break;
                case 2:
                    avoid = 3;
                    price =25;
                    aName= "Middleweight";
                    break;
                case 3:
                    avoid= 5;
                    aName="Heavy Weight";
                    price=40;
                    break;
                default:
                    System.out.println("Proccess isn't valid.");
                    break;
            }
            if(player.getMoney()>=price)
            {
                player.getInv().setArmor(avoid);
                player.getInv().setaName(aName);
                player.setMoney(player.getMoney()-price);
                System.out.println("You bought a weapon!Avoided Damage:"+player.getInv().getArmor());
                System.out.println("Your Money:"+player.getMoney());
            }
            else {System.out.println("Your balance isn't enough.");}
        }
        else
        {
            System.out.println("Select a valid number!");
            int selArmorID= scan.nextInt();
        }
    }

    public int weaponMenu()
    {
        System.out.println("Money:"+ getPlayer().getMoney());
        System.out.println("1-Glock-->Money:25-->Damage:2");
        System.out.println("2-Sword-->Money:35 -->Damage:3");
        System.out.println("3-Rifle-->Money:45 -->Damage:7");
        System.out.println("4-Exit");
        System.out.print("Select Weapon:");
        int selWeaponID= scan.nextInt();
        return selWeaponID;
    }
    public void buyWeapon(int itemID)
    {
         int damage=0,price=0;
         String wName=null;
        if(itemID>0 || itemID<5)
        {
            switch (itemID)
            {
                case 1:
                    damage = 2;
                    wName= "Glock";
                    price= 25;
                    break;
                case 2:
                    damage = 3;
                    price =35;
                    wName= "Sword";
                    break;
                case 3:
                    damage= 7;
                    wName="Rifle";
                    price=45;
                    break;
                default:
                    System.out.println("Proccess isn't valid.");
                    break;
            }
            if(player.getMoney()>=price)
            {
                player.getInv().setwDamage(damage);
                player.getInv().setwName(wName);
                player.setMoney(player.getMoney()-price);
                System.out.println("You bought a weapon!");
                System.out.println("Previous Damage:"+player.getDamage());
                System.out.println("Currently Damage:"+(player.getDamage()+player.getInv().getwDamage()));
                System.out.println("Your Money:"+player.getMoney());
            }
            else {System.out.println("Your balance isn't enough.");}

        }
        else
        {
            System.out.println("Select a valid number!");
            int selWeaponID= scan.nextInt();
        }
    }
}
