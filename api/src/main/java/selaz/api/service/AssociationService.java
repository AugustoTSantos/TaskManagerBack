package selaz.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import selaz.api.dto.AssociationDTO;
import selaz.api.entity.association.Association;
import selaz.api.repository.AssociationRepository;

import java.util.List;

@Service
public class AssociationService {
    @Autowired
    private AssociationRepository associationRepository;

    //Crud Start
    public List<Association> getAllAssociations() {
        return this.associationRepository.findAll();
    }

    // Auxiliary Method
    public void saveAssociation(Association association) {
        this.associationRepository.save(association);
    }

    public Association createAssociation(AssociationDTO associationDTO) {
        Association newAssociation = new Association(associationDTO);

        this.saveAssociation(newAssociation);

        return newAssociation;
    }

    public Association getAssociationById(Long assId) throws Exception{
        return this.associationRepository.findByAssId(assId).orElseThrow(() -> new Exception(
                "Task ou User não encontrado"
        ));
    }

    public Association updateAssociation(Long assId, AssociationDTO associationDTO) throws Exception {
        Association association = this.getAssociationById(assId);

        association.setAssUseId(associationDTO.assUseId());
        association.setAssTasId(associationDTO.assTasId());

        return this.associationRepository.save(association);
    }

    public void deleteAssociation(Long AssId) throws Exception{
        Association association = this.getAssociationById(AssId);

        this.associationRepository.delete(association);
    }
    //Crud End
}
