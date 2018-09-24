import java.util.*;

public class RpgGame {
    public static void main(String[] args) {
        Random rn = new Random();
        Scanner sc = new Scanner(System.in);
        int choice, counter = 0;
        Player guy = new Player();
        Player magicenemy = new Player();
        System.out.println("An enemy magician appeared!");
        while (guy.health > 0 && magicenemy.health > 0)  {
            counter++;
            System.out.println("Clash "+counter+":\n");
            if (guy.SpeedChecker(magicenemy) == 1) //If you win
            {

                System.out.println("You are faster, so you get the first strike!");
                System.out.println("Would you like to:\n1) Attack\n(or)\n2) Attack with magic");
                choice = sc.nextInt();
                switch(choice) //choice for magic or normal attack
                {
                    case 1:
                        System.out.println("You attacked the enemy for 2 damage!");
                        magicenemy.gothit();
                        break;
                    case 2:
                        System.out.println("You attacked the enemy for "+magicenemy.GotHitMagic()+" damage!");
                        break;
                    default:
                        continue;
                }
            }
            else //If the enemy wins
            {
                System.out.println("The enemy was faster, so they got the first strike!");
                choice = rn.nextInt(2);  //here, choice is whether they choose attack or magic attack
                if (choice == 0) {
                    guy.gothit();
                    System.out.println("The enemy attacked you for 2 damage!");
                }
                else {
                    System.out.println("The enemy attacked you with magic for "+guy.GotHitMagic()+" damage!");

                }
            }
            if (magicenemy.health < 0)  //sets negative health to 0
                magicenemy.health = 0;

            else if (guy.health < 0)  //sets negative health to 0
                guy.health = 0;

            System.out.println("\nEnemy Health: "+magicenemy.health);
            System.out.println("Your Health: "+guy.health+"\n");
        }
        if (guy.health > 0)  {
            System.out.println("YOU WIN!");
        }
        else
            System.out.println("You lose.");
        sc.close();
    }  //main method
}

class Player {
    int health;
    private int attack;
    private int magic;
    private int speed;
    Player(){
        health = 10;
        attack = 5;
        magic = 3;
        speed = 15;
    }
    void gothit() {
        health = health - 2;
    }
    int GotHitMagic() {
        Random rn = new Random();
        int randy = rn.nextInt(magic)+1;
        health = health - randy;
        return randy;
    }
    int SpeedChecker(Player enemy) {
        Random rn = new Random();
        int randy = rn.nextInt(2);
        if (speed > enemy.speed)
            return 1;
        else if (speed == enemy.speed)
            return randy;
        else
            return 0;
    }

}