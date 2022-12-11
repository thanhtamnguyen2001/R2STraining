package service;

import entity.Certification;
import repository.CertificationRepository;

import java.util.List;

public class CertificationService {
    private CertificationRepository certificationRepository = new CertificationRepository();

    public List<Certification> getCertificationList() throws Exception {
        return this.certificationRepository.getAllCertification();
    }
}
