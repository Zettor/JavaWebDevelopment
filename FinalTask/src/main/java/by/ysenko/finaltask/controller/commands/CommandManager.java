package by.ysenko.finaltask.controller.commands;

import by.ysenko.finaltask.controller.commands.admin.*;
import by.ysenko.finaltask.controller.commands.guest.*;
import by.ysenko.finaltask.controller.commands.user.*;

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
                command =new ToProfile();
                break;
            case"/logout":
                command =new Logout();
                break;
            case"/to_edit_profile":
                command =new Profile();
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
            case"/game_offers":
                command=new FindGameOffers();
                break;
            case"/game_offer":
                command=new ToGameOffer();
                break;
            case "/countries":
                command=new FindCountries();
                break;
            case"/add_country":
                command=new AddCountry();
                break;
            case"/delete_country":
                command=new DeleteCountry();
                break;
            case"/cities":
                command=new FindCity();
                break;
            case"/add_city":
                System.out.println("KVD");
                command=new AddCity();
                break;
            case"/delete_city":
                command=new DeleteCity();
                break;
            case"/set_user_role":
                command=new SetUserRole();
                break;
            case"/set_user_status":
                command=new SetUserStatus();
                break;
            default:
        }

    }
}