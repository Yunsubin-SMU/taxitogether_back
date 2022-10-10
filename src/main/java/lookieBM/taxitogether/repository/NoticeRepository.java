package lookieBM.taxitogether.repository;

import lookieBM.taxitogether.domain.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<Notice, Long> {
}
