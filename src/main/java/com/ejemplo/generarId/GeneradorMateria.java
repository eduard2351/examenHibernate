package com.ejemplo.generarId;

import java.io.Serializable;
import java.text.SimpleDateFormat;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class GeneradorMateria implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
////		usando la fecha  si fuera id cadena
//		SimpleDateFormat sdf=new SimpleDateFormat("yyy-MM-dd-hh-mm-ss");
//		return sdf.format(new Date());

		return System.currentTimeMillis();
	}

}
