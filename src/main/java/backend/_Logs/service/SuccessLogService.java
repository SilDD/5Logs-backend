package backend._Logs.service;


import backend._Logs.modal.SuccessLog;
import backend._Logs.repo.SuccessLogRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class SuccessLogService {
    private final SuccessLogRepo successLogRepo;

    @Autowired
    public SuccessLogService(SuccessLogRepo successLogRepo) {
        this.successLogRepo = successLogRepo;
    }

    public SuccessLog addSuccessLog(SuccessLog slog) {
        slog.setDate(LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        return successLogRepo.save(slog);
    }

    public List<SuccessLog> findAllSuccessLogs() {
        return successLogRepo.findAll();
    }

    @Transactional
    public void deleteSuccessLog(Long id) {
        successLogRepo.deleteSuccessLogById(id);
    }
}
