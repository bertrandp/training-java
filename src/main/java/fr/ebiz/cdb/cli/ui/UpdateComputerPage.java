package fr.ebiz.cdb.cli.ui;


import fr.ebiz.cdb.dao.mapper.ComputerMapper;
import fr.ebiz.cdb.dto.ComputerDTO;
import fr.ebiz.cdb.model.Computer;
import fr.ebiz.cdb.service.IComputerService;
import fr.ebiz.cdb.service.exception.CompanyException;
import fr.ebiz.cdb.service.exception.ComputerException;
import fr.ebiz.cdb.service.exception.InputValidationException;
import fr.ebiz.cdb.service.impl.ComputerService;
import fr.ebiz.cdb.service.validation.ComputerValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

/**
 * Created by ebiz on 16/02/17.
 */
public class UpdateComputerPage {

    private static Logger logger = LoggerFactory.getLogger(UpdateComputerPage.class);

    /**
     * Display the page to update a computer.
     */
    static void display() {
        Scanner sc = new Scanner(System.in);
        System.out.println("* Specify the computer's id :");
        String id = sc.nextLine();

        if (!id.trim().isEmpty()) {
            IComputerService computerService = ComputerService.INSTANCE;
            ComputerDTO computer;
            try {

                computer = computerService.getDTO(Integer.valueOf(id));

                System.out.println("* Update computer : " + computer.getName());
                String name = updateName(computer);
                String introduced = updateIntroducedDate(computer);
                String discontinued = updateDiscontinuedDate(computer);
                String companyId = updateCompany(computer);
                ComputerDTO computerDTO = new ComputerDTO.Builder()
                        .id(Integer.valueOf(id))
                        .name(name)
                        .introduced(introduced)
                        .discontinued(discontinued)
                        .companyId(Integer.valueOf(companyId))
                        .build();

                ComputerValidator.validate(computerDTO);

                Computer computerToAdd = ComputerMapper.mapToComputer(computerDTO);

                computerService.update(computerToAdd);

                MenuPage.display();

            } catch (ComputerException | InputValidationException e) {
                logger.error("*** Error : " + e.getMessage());
                MenuPage.display();
            }
        } else {
            logger.error(" *** Error : Invalid id");
            display();
        }

    }

    /**
     * Display the current company name of the given computer and ask for an update.
     *
     * @param computer the computer to update
     * @return the input
     */
    private static String updateCompany(ComputerDTO computer) {
        if (computer.getCompanyName() != null) {
            System.out.println("* Company Name : " + computer.getCompanyName());
        } else {
            System.out.println("* Company Name : undefined");
        }
        System.out.println("* Specify the new id of the company company or press Enter ");
        return InputUtils.inputCompanyId(computer);
    }

    /**
     * Display the current discontinued date of the given computer and ask for an update.
     *
     * @param computer the computer to update
     * @return the input
     */
    private static String updateDiscontinuedDate(ComputerDTO computer) {
        System.out.println("* Discontinued Date : " + computer.getDiscontinued());
        System.out.println("* Specify the new discontinued date or press Enter ");
        return InputUtils.inputDiscontinuedDate(computer);
    }

    /**
     * Display the current introduced date of the given computer and ask for an update.
     *
     * @param computer the computer to update
     * @return the input
     */
    private static String updateIntroducedDate(ComputerDTO computer) {
        System.out.println("* Introduced Date : " + computer.getIntroduced());
        System.out.println("* Specify the new introduced date or press Enter ");
        return InputUtils.inputIntroducedDate(computer);
    }

    /**
     * Display the current name of the given computer and ask for an update.
     *
     * @param computer the computer to update
     * @return the input
     */
    private static String updateName(ComputerDTO computer) {
        System.out.println("* Name : " + computer.getName());
        System.out.println("* Specify the new name or press Enter to keep this name ");
        return InputUtils.inputName(computer);
    }

}
