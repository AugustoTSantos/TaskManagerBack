package selaz.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import selaz.api.dto.AssociationDTO;
import selaz.api.entity.association.Association;
import selaz.api.service.AssociationService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/Association")
public class AssociationController {
    @Autowired
    private AssociationService associationService;

    @GetMapping("getAllAssociations")
    public ResponseEntity<List<Association>> getAllAssociations() {
        List<Association> associations = associationService.getAllAssociations();
        return new ResponseEntity<>(associations, HttpStatus.OK);
    }

    @PostMapping("createAssociation")
    public ResponseEntity<Association> createAssociation(@RequestBody AssociationDTO associationDTO) {
        Association association = associationService.createAssociation(associationDTO);

        return new ResponseEntity<>(association, HttpStatus.CREATED);
    }

    @PutMapping("/updateAssociation/{assId}")
    public ResponseEntity<Association> updateAssociation(
            @PathVariable("assId") Long assId, @RequestBody AssociationDTO associationDTO
    ) throws Exception {
        Association attAssociation = associationService.updateAssociation(assId, associationDTO);

        return new ResponseEntity<>(attAssociation, HttpStatus.OK);
    }

    @DeleteMapping("/deleteAssociation/{assId}")
    public ResponseEntity<Association> deleteAssociation(@PathVariable("assId") Long assId) throws Exception {
        associationService.deleteAssociation(assId);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}