import java.util.ArrayList;
import java.util.Scanner;

public class TodoApplication {
    public static void main(String[] args) {
        ArrayList<String> todoItems = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        /*
          1. add a new todo item
          2. remove a todo item
          3. see all todo items
          4. exit
        */

        while(true){
            System.out.println("What would you like to do: ");
            System.out.println("1. Add a new Todo Item");
            System.out.println("2. Remove a Todo Item");
            System.out.println("3. Show All Todo Items ");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();


//        3. Show all Todo Items
            if(choice ==3){
                for(int i =0; i<todoItems.size();i++){
                    System.out.println(i + 1 + ". " + todoItems.get(i));
                }
//                System.out.println(todoItems);
            }
//        1. Add a new Todo Item
            else if(choice == 1){
                scanner.nextLine();
                System.out.println("What would you like to add: ");
                String newTodo = scanner.nextLine();
                todoItems.add(newTodo);
            }
            else if(choice == 2){
//            give the number of the todo you want to delete
                System.out.println("Which number item do you want to delete");
                int removedItem = scanner.nextInt();
                todoItems.remove(removedItem - 1);
            }
            else if(choice == 4){
                System.out.println("Thank you for coming");
                break;
            }
            else{
                System.out.println("Please enter a number between 1-4");
            }
        }





    }
}
