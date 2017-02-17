package service;


import model.Computer;
import service.impl.ComputerValidationException;

import java.util.List;

/**
 * Created by ebiz on 14/02/17.
 */
public interface IComputerService {

    /**
     * Retrieve the list of computer.
     *
     * @return the list of computer
     */
    List<Computer> fetchAll();

    /**
     * Retrieve the computer for the given id.
     *
     * @param id the id of the computer
     * @return the computer for the given id
     * @throws ComputerValidationException exception raised when id is not valid
     */
    Computer get(String id) throws ComputerValidationException;

    /**
     * Add the given computer.
     *
     * @param computer the computer to add
     * @return true if the computer is added
     * @throws ComputerValidationException exception raised if computer is not valid
     */
    boolean add(Computer computer) throws ComputerValidationException;

    /**
     * Update the given computer.
     *
     * @param computer the computer to update
     * @return true if the computer is updated
     * @throws ComputerValidationException exception raised if computer is not valid
     */
    boolean update(Computer computer) throws ComputerValidationException;

    /**
     * Delete the given computer.
     *
     * @param computer the computer to delete
     * @return true if the computer is deleted
     */
    boolean delete(Computer computer);
}
