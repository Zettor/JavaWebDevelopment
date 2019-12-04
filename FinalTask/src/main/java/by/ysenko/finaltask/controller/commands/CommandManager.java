package by.ysenko.finaltask.controller.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommandManager {

//    private String command;
    private Command command;


//    public void setCommand(String command) {
//        this.command = command;
//
//    }

    public Command getCommand() {
        return command;
    }

    public CommandManager(String strCommand) {

        switch (strCommand) {
            case "/":
                command = new FindLastOffers();
                break;
            case"/sign_up":
                command =new SignUp();
                break;
            case"/sign_in":
                command =new SignIn();
                break;
            case"/profile":
                command =new Profile();
                break;
            case"/logout":
                command =new Logout();
                break;
            case"/edit_profile":
                command =new EditProfile();
                break;
            case"/settings":
               command =new ToSettings();
                break;
            case"/users":
                command=new FindAllUsers();
                break;
            case"/genres":
                command=new FindGenres();
                break;
            case"/add_genre":
                command=new AddGenre();
                break;
            case"/delete_genre":
                command=new DeleteGenre();
                break;
            case"/delete_category":
                command=new DeleteCategory();
                break;
            case"/add_category":
                command=new AddCategory();
                break;
            case"/categories":
                command=new FindCategories();
                break;
            case"/games":
                command=new FindGames();
                break;
            case"/add_game":
                command=new AddGame();
                break;
            case"/delete_game":
                command=new DeleteGame();
                break;
            case"/choose_game":
                command=new ChooseGame();
                break;
            case"/to_adding_game_offer":
                command=new ToAddingGameOffer();
                break;
            case"/currencies":
                command=new FindCurrencies();
                break;
            case"/delete_currency":
                command=new DeleteCurrency();
                break;
            case"/add_currency":
                command=new AddCurrency();
                break;
            case"/add_game_offer":
                command=new AddGameOffer();
                break;

            default:
        }

    }
}