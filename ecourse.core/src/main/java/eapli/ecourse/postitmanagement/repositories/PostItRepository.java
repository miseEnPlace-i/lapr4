package eapli.ecourse.postitmanagement.repositories;

import eapli.ecourse.boardmanagement.domain.BoardID;
import eapli.ecourse.postitmanagement.domain.PostIt;
import eapli.ecourse.postitmanagement.domain.PostItID;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.infrastructure.authz.domain.model.Username;

public interface PostItRepository extends DomainRepository<PostItID, PostIt> {

  public Iterable<PostIt> findAllByBoardId(BoardID boardId);

  public Iterable<PostIt> findLatestByBoardId(BoardID boardId);

  public Iterable<PostIt> findLatestFromUserByBoardId(BoardID boardId, Username username);

  public Iterable<PostIt> findAllPostItsOrderedByDate(BoardID boardId);

}
