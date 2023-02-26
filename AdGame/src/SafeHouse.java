public class SafeHouse extends NormalLoc
{
    SafeHouse(Player player) {super(player,"Safe House");}
    public boolean getLocation()
    {
        player.setHealthy(player.getrHealthy());
        System.out.println("Currently,you are in Safe House.Your healthy has been increased!");
        return true;
    }

}
