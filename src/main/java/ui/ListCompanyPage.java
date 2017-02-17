package ui;


import model.Company;
import service.ICompanyService;
import service.impl.CompanyService;

import java.util.List;

/**
 * Created by ebiz on 16/02/17.
 */
public class ListCompanyPage {


    static void display() {
        System.out.println("");
        System.out.println("*********************");
        System.out.println("*     Companies     *");
        System.out.println("*********************");
        System.out.println("");

        ICompanyService companyService = new CompanyService();
        List<Company> listCompany = companyService.fetchAll();

        System.out.println("---------------------------------------------------------");
        System.out.println("|\t" + "n°" + "\t\tName");
        System.out.println("---------------------------------------------------------");
        for (Company company : listCompany) {
            System.out.println("|\t" + company.getId() + "\t\t" + company.getName());
        }

        MenuPage.display();
    }


}
