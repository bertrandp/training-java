package fr.ebiz.cdb.cli.ui;


import fr.ebiz.cdb.model.dto.ComputerDTO;
import fr.ebiz.cdb.persistence.utils.DAOException;
import fr.ebiz.cdb.service.IComputerService;
import fr.ebiz.cdb.service.impl.ComputerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by ebiz on 16/02/17.
 */
@Component
public class DeleteComputerPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(DeleteComputerPage.class);

    @Autowired
    private IComputerService computerService;

    @Autowired
    private MenuPage menuPage;

    /**
     * Display the page to delete a computer.
     */
    void display() {
        Scanner sc = new Scanner(System.in);
        System.out.println("* Specify the computer's id :");
        String id = sc.nextLine();

        if (!id.trim().isEmpty()) {
            ComputerDTO computer;
            try {
                computer = computerService.getDTO(Integer.valueOf(id));
                System.out.println("* Do you really want to delete this computer : " + computer.getName());
                sc = new Scanner(System.in);
                System.out.println("* yes/no :");
                String input = sc.nextLine();
                switch (input) {
                    case "yes":

                        computerService.delete(new ArrayList<>(computer.getId()));
                        menuPage.display();
                        break;
                    default:
                        menuPage.display();
                        break;
                }
            } catch (DAOException e) {
                LOGGER.error(e.getMessage());
                // TODO handle exception
            }
        } else {
            LOGGER.error(" *** Error : Invalid id");
            display();
        }

    }

}
