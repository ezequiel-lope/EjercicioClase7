package com.models;

import com.models.Administrador;
import com.models.Contacto;
import com.models.Contrato;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-11-26T09:59:34", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Profesional.class)
public class Profesional_ { 

    public static volatile SingularAttribute<Profesional, String> tipoDocumento;
    public static volatile SingularAttribute<Profesional, Administrador> administrador;
    public static volatile SingularAttribute<Profesional, Integer> reputacion;
    public static volatile SingularAttribute<Profesional, String> fechaNacimiento;
    public static volatile SingularAttribute<Profesional, String> apellido;
    public static volatile ListAttribute<Profesional, Contacto> contactos;
    public static volatile ListAttribute<Profesional, Contrato> contratos;
    public static volatile SingularAttribute<Profesional, Long> id;
    public static volatile SingularAttribute<Profesional, String> numeroDocumento;
    public static volatile SingularAttribute<Profesional, String> nombre;
    public static volatile SingularAttribute<Profesional, String> cuitCuil;

}