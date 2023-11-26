package com.models;

import com.models.Administrador;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-11-26T09:59:34", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Cliente.class)
public class Cliente_ { 

    public static volatile SingularAttribute<Cliente, String> tipoDocumento;
    public static volatile SingularAttribute<Cliente, Administrador> administrador;
    public static volatile SingularAttribute<Cliente, Integer> contacto;
    public static volatile SingularAttribute<Cliente, String> fechaNacimiento;
    public static volatile SingularAttribute<Cliente, String> apellido;
    public static volatile SingularAttribute<Cliente, Long> id;
    public static volatile SingularAttribute<Cliente, String> numeroDocumento;
    public static volatile SingularAttribute<Cliente, String> nombre;

}