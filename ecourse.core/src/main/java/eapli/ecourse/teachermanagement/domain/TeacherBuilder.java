package eapli.ecourse.teachermanagement.domain;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import eapli.framework.domain.model.DomainFactory;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

public class TeacherBuilder implements DomainFactory<Teacher> {
  private SystemUser systemUser;
  private TaxPayerNumber taxPayerNumber;
  private BirthDate birthDate;
  private Acronym acronym;

  public TeacherBuilder withSystemUser(final SystemUser systemUser) {
    this.systemUser = systemUser;
    return this;
  }

  public TeacherBuilder withTaxPayerNumber(final TaxPayerNumber taxPayerNumber) {
    this.taxPayerNumber = taxPayerNumber;
    return this;
  }

  public TeacherBuilder withTaxPayerNumber(final String taxPayerNumber) {
    this.taxPayerNumber = new TaxPayerNumber(taxPayerNumber);
    return this;
  }

  public TeacherBuilder withBirthDate(final BirthDate birthDate) {
    this.birthDate = birthDate;
    return this;
  }

  public TeacherBuilder withBirthDate(final Calendar birthDate) {
    this.birthDate = BirthDate.valueOf(birthDate);
    return this;
  }

  public TeacherBuilder withBirthDate(final String birthDate) {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    Date date = sdf.parse(birthDate, new ParsePosition(0));
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    this.birthDate = BirthDate.valueOf(cal);

    return this;
  }

  public TeacherBuilder withAcronym(final Acronym acronym) {
    this.acronym = acronym;
    return this;
  }

  public TeacherBuilder withAcronym(final String acronym) {
    this.acronym = Acronym.valueOf(acronym);
    return this;
  }

  @Override
  public Teacher build() {
    return new Teacher(this.systemUser, this.taxPayerNumber, this.acronym, this.birthDate);
  }
}
