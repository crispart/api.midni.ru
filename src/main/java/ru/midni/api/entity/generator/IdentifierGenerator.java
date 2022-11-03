package ru.midni.api.entity.generator;

import io.azam.ulidj.ULID;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;

import java.io.Serializable;

public class IdentifierGenerator implements org.hibernate.id.IdentifierGenerator {

  @Override
  public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
    return ULID.random().toLowerCase();
  }
}
