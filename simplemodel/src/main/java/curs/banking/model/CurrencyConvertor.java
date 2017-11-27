package curs.banking.model;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class CurrencyConvertor implements AttributeConverter<Currency, Long> {

  @Override
  public Long convertToDatabaseColumn(Currency attribute) {
    return attribute.getId();
  }

  @Override
  public Currency convertToEntityAttribute(Long dbData) {
    return Currency.getById(dbData);
  }

}
