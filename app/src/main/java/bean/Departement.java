/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.util.List;


/**
 *
 * @author
 */
public class Departement{

    private List<User> users;
    private List<DepartementCriteria> departementCriterias;
    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;

    public Departement() {

    }

    public Departement(Long id, String name) {
        this.id = id;
        this.name = name;
    }



    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<DepartementCriteria> getDepartementCriterias() {
        return departementCriterias;
    }

    public void setDepartementCriterias(List<DepartementCriteria> departementCriterias) {
        this.departementCriterias = departementCriterias;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departement)) {
            return false;
        }
        Departement other = (Departement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name;
    }

}
