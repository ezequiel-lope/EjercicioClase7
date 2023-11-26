package com.models;

import com.models.Cliente;
import com.models.Profesional;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-11-26T09:59:34", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Administrador.class)
public class Administrador_ { 

    public static volatile SingularAttribute<Administrador, Long> id;
    public static volatile ListAttribute<Administrador, Cliente> clientes;
    public static volatile ListAttribute<Administrador, Profesional> profesionales;
    public static volatile SingularAttribute<Administrador, String> nombre;

}