package book.iterator;

import java.util.Arrays;

public class MenuTestDrive {
    public static void main(String[] args) {
        PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
        DinerMenu dinerMenu = new DinerMenu();

        Waitress waitress = new Waitress(Arrays.asList(pancakeHouseMenu,dinerMenu));
        waitress.printMenu();
    }
}
