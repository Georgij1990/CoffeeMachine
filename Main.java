import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CoffeeMachine cofMachine1 = new CoffeeMachine(400, 540, 120, 9, 550);
        boolean[] stopper = {true};
        while (stopper[0]) {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            CoffeeMachine.selectAction(cofMachine1, stopper);
        }
    }
}

class CoffeeMachine {
    public static Scanner scanner = new Scanner(System.in);
    int water;
    int milk;
    int coffeeBeans;
    int cups;
    int money;

    CoffeeMachine (int water, int milk, int coffeeBeans, int cups, int money) {
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.cups = cups;
        this.money = money;
    }

    public void has () {
        System.out.println("The coffee machine has:");
        System.out.printf("%d ml of water\n", this.water);
        System.out.printf("%d ml of milk\n", this.milk);
        System.out.printf("%d g of coffee beans\n", this.coffeeBeans);
        System.out.printf("%d disposable cups\n", this.cups);
        System.out.printf("%d of money\n", this.money);
    }

    public static void selectAction (CoffeeMachine cofMachine1, boolean[] stopper) {
        String request = scanner.next();
        switch (request) {
            case "buy" -> {
                cofMachine1.buy();
            }
            case "fill" -> {
                cofMachine1.fill();
            }
            case "take" -> {
                cofMachine1.take();
            }
            case "remaining" -> {
                cofMachine1.has();
            }
            case "exit" -> {
                stopper[0] = false;
            }
            default -> {
            }
        }
    }

    public void fill () {
        System.out.println("Write how many ml of water you want to add: ");
        this.water += scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add: ");
        this.milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add: ");
        this.coffeeBeans += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add: ");
        this.cups += scanner.nextInt();
    }

    public void take () {
        System.out.printf("I gave you $%d\n", this.money);
        this.money = 0;
    }

    public void buy () {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String choseCoffee = scanner.next();
        switch (choseCoffee) {
            case "1" -> {
                if (this.water < 250) {
                    System.out.println("Sorry, not enough water!");
                } else if (this.coffeeBeans < 16) {
                    System.out.println("Sorry, not enough coffee beans");
                } else if (this.cups < 1) {
                    System.out.println("Sorry, not enough cups!");
                } else {
                    System.out.println("I have enough resources, making you a coffee!");
                    this.water = this.water - 250;
                    this.coffeeBeans = this.coffeeBeans - 16;
                    this.cups = this.cups - 1;
                    this.money = this.money + 4;
                }
            }
            case "2" -> {
                if (this.water < 350) {
                    System.out.println("Sorry, not enough water!");
                } else if (this.milk < 75) {
                    System.out.println("Sorry, not enough milk!");
                } else if (this.coffeeBeans < 20) {
                    System.out.println("Sorry, not enough coffee beans");
                } else if (this.cups < 1) {
                    System.out.println("Sorry, not enough cups!");
                } else {
                    System.out.println("I have enough resources, making you a coffee!");
                    this.water -= 350;
                    this.milk -= 75;
                    this.coffeeBeans -= 20;
                    this.cups -= 1;
                    this.money = this.money + 7;
                }
            }
            case "3" -> {
                if (this.water < 200) {
                    System.out.println("Sorry, not enough water!");
                } else if (this.milk < 100) {
                    System.out.println("Sorry, not enough milk!");
                } else if (this.coffeeBeans < 12) {
                    System.out.println("Sorry, not enough coffee beans");
                } else if (this.cups < 1) {
                    System.out.println("Sorry, not enough cups!");
                } else {
                    System.out.println("I have enough resources, making you a coffee!");
                    this.water -= 200;
                    this.milk -= 100;
                    this.coffeeBeans -= 12;
                    this.cups -= 1;
                    this.money = this.money + 6;
                }
            }
            default -> {
            }
        }
    }
}

 enum Actions {
    BUY, FILL, TAKE, REMAINING, BACK
 }