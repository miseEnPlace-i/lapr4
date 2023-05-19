package eapli.ecourse.persistence.impl.jpa;

import java.util.HashMap;
import java.util.Map;

import eapli.ecourse.coursemanagement.domain.CourseCode;
import eapli.ecourse.eventsmanagement.classmanagement.domain.Class;
import eapli.ecourse.eventsmanagement.classmanagement.domain.ClassID;
import eapli.ecourse.eventsmanagement.classmanagement.repositories.ClassRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

public class JpaClassRepository extends JpaAutoTxRepository<Class, ClassID, ClassID>
    implements ClassRepository {

  JpaClassRepository(final TransactionalContext autoTx) {
    super(autoTx, "id");
  }

  JpaClassRepository(final String puName) {
    super(puName, "id");
  }

  @Override
  public Iterable<Class> findAllByCourseCode(CourseCode code) {
    final Map<String, Object> params = new HashMap<>();
    params.put("code", code);
    return match("e.code=:code", params);
  }

}
