package backend._Logs;


import backend._Logs.modal.SuccessLog;
import backend._Logs.service.SuccessLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/5logs/api")
public class SuccessLogResource {

    @Autowired
    private final SuccessLogService slogService;

    public SuccessLogResource(SuccessLogService slogService) {
        this.slogService = slogService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<SuccessLog>> getAllSuccessLogs() {
        List<SuccessLog> slogs = slogService.findAllSuccessLogs();
        return new ResponseEntity<>(slogs, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<SuccessLog> addSuccessLog(@RequestBody SuccessLog slog) {
        SuccessLog newSuccessLog = slogService.addSuccessLog(slog);
        return new ResponseEntity<>(newSuccessLog, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
        slogService.deleteSuccessLog(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
