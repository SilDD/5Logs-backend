package backend._Logs.repo;

import backend._Logs.modal.SuccessLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuccessLogRepo extends JpaRepository<SuccessLog, Long> {

    void deleteSuccessLogById(Long id);
}
