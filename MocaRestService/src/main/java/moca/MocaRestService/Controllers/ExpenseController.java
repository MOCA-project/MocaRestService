package moca.MocaRestService.Controllers;

import lombok.AllArgsConstructor;
import moca.MocaRestService.Domain.Models.Requests.ExpenseRequest;
import moca.MocaRestService.Domain.Models.Responses.ExpenseResponse;
import moca.MocaRestService.Domain.Services.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/expenses/")
public class ExpenseController {

    @Autowired
    private ExpenseService service;

    @PostMapping
    public ExpenseResponse add(@RequestBody ExpenseRequest request){
       return service.add(request);
    }
}
