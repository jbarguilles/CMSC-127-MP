package cs127.springappbe.Service;

import cs127.springappbe.Entities.*;
import cs127.springappbe.Entities.Request.AddBookingRequest;
import cs127.springappbe.Entities.Request.AvailServiceRequest;
import cs127.springappbe.Entities.Request.ChargeServicesRequest;
import cs127.springappbe.Repository.AvailedServiceRepository;
import cs127.springappbe.Repository.BRNRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@RequiredArgsConstructor
@Service
public class BRNServiceImpl implements BRNService{
    final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    final int STRING_LENGTH = 6;
    Set<String> generatedStrings = new HashSet<>();
    Random random = new Random();

    private final BRNRepository brnRepository;

    @Qualifier("PGuestServiceImpl")
    private final PGuestService pGuestService;

    @Qualifier("SGuestServiceImpl")
    private final SGuestService sGuestService;

    private final RoomService roomService;

    private final ServiceEntityService serviceEntityService;

    private final AvailedServiceRepository availedServiceRepository;

    private final EmployeeService employeeService;

    @Override
    public BRN addBooking(AddBookingRequest bookingRequest) {
        BRN toAdd = bookingRequest.mapToBooking(pGuestService, sGuestService, roomService);
        toAdd.setStatus("BOOKING");
        toAdd.setBRNCode(generateBRNCODE());
        return brnRepository.save(toAdd);
    }

    @Override
    public Optional<BRN> findBRNByBRNID(Long BRNID) {
        return brnRepository.findBRNByBRNID(BRNID);
    }
    @Override
    public Optional<BRN> findBRNByBRNCode(String BRNCode) {
        return brnRepository.findBRNByBRNCode(BRNCode);
    }

    @Override
    public BRN changeBRNStatus(Long BRNID, String status) {
        BRN toChange = brnRepository.findBRNByBRNID(BRNID).get();
        toChange.setStatus(status);
        return brnRepository.save(toChange);
    }

    @Override
    public BRN changeBRNStatus(String BRNCode, String status) {
        BRN toChange = brnRepository.findBRNByBRNCode(BRNCode).get();
        toChange.setStatus(status);
        return brnRepository.save(toChange);
    }

    @Override
    public BRN addServices(ChargeServicesRequest servicesToAvail) {
        BRN clientBRN = null;
        Optional<BRN> optionalBRN = brnRepository.findBRNByBRNCode(servicesToAvail.getBRNCode());

        if(optionalBRN.isPresent()){
            clientBRN = optionalBRN.get();

            List<AvailedService> services = new ArrayList<>();

            for(AvailServiceRequest availServiceRequest : servicesToAvail.getAvailedServices()){

                AvailedService availedService = new AvailedService();
                ServiceEntity serviceToAvail = serviceEntityService.findServiceByID(availServiceRequest.getServiceID());

                availedService.setServiceEntity(serviceToAvail);

                Employee employee = null;
                Optional<Employee> optionalEmployee = employeeService.findByEmployeeID(servicesToAvail.getEmployeeID());

                if(optionalEmployee.isPresent()){
                    employee = optionalEmployee.get();
                    availedService.setEmployee(employee);
                }

                availedService.setBrn(clientBRN);

                availedServiceRepository.save(availedService);

                services.add(availedService);
            }

            clientBRN.setAvailedServices(services);
        }

        return clientBRN;
    }

    @Override
    public List<BRN> findAllBRN() {
        return brnRepository.findAll();
    }


//    @Override
//    public List<SecondaryGuest> findSecondaryGuests(Long BRNID){
//        return brnRepository.findSecondaryGuests(BRNID);
//    }

    private String generateBRNCODE(){
        String str;
        do {
            StringBuilder builder = new StringBuilder(STRING_LENGTH);
            for (int i = 0; i < STRING_LENGTH; i++) {
                int randomIndex = random.nextInt(CHARACTERS.length());
                builder.append(CHARACTERS.charAt(randomIndex));
            }
            str = builder.toString();
        } while (generatedStrings.contains(str));

        generatedStrings.add(str);
        return str;

    }
}
