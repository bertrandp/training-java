package fr.ebiz.cdb.console.ui;

import fr.ebiz.cdb.service.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

/**
 * Created by bpestre on 02/03/17.
 */
@Component
public class DeleteCompanyPage {

    @Autowired
    private ICompanyService companyService;

    @Autowired
    private ListCompanyPage listCompanyPage;

    /**
     *
     */
    public void display() {

        listCompanyPage.display(false);

        System.out.println("Specify the id of the computer to delete :");
        Scanner sc = new Scanner(System.in);
        String id = sc.nextLine();

        if (!id.trim().isEmpty()) {

            System.out.println("Are you sure you want to delete this company :" + id);
            sc = new Scanner(System.in);
            String input = sc.nextLine();

            switch (input) {
                case "yes":
                    companyService.delete(Integer.valueOf(id.trim()));

            }

        }

    }

}
