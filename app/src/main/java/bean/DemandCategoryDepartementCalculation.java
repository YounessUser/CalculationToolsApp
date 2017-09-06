/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.math.BigDecimal;

/**
 *
 * @author
 */

public class DemandCategoryDepartementCalculation {

    private Long id;
    private BigDecimal summe;
    private BigDecimal summeGlobal;
   
    private DemandCategory demandCategory;
   
    private Departement departement;


    public DemandCategoryDepartementCalculation() {
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }


    public BigDecimal getSumme() {
        return summe;
    }

    public void setSumme(BigDecimal summe) {
        this.summe = summe;
    }

    public BigDecimal getSummeGlobal() {
        return summeGlobal;
    }

    public void setSummeGlobal(BigDecimal summeGlobal) {
        this.summeGlobal = summeGlobal;
    }
    
    public DemandCategory getDemandCategory() {
        return demandCategory;
    }

    public void setDemandCategory(DemandCategory demandCategory) {
        this.demandCategory = demandCategory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    @Override
    public String toString() {
        return id + " - " + departement.getName();
    }

}
