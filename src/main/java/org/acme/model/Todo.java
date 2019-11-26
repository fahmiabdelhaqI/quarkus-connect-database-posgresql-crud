package org.acme.model;


import javax.persistence.Column;
import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
// import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

/**
 * Todo
 */
@Entity
public class Todo extends PanacheEntity {

    public String title;
    public boolean completed;
    @Column(name = "ordering")
    public int order;

    public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


    public static Todo findByName(String title) {
        return find("title", title).firstResult();
    }
    
}
