package by.yasenko.task2.controller.command;

/**
 * Enum of different requests.
 *
 * @author Alexander Ysenko
 * @version 1.0
 */
public enum CommandName {

    /**
     * CreateMatrix request.
     */
    INIT_MATRIX,

    /**
     * Wrong request.
     */
    WRONG_REQUEST,

    /**
     * ShowMatrix request.
     */
    SHOW_MATRIX,

    FILL_LOCK,

    FILL_SEM,

    FILL_BARRIER,

    FILL_LATCH

}
