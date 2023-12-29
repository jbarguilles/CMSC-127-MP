package cs127.springappbe.Entities.Request;

import com.fasterxml.jackson.annotation.JsonProperty;
import cs127.springappbe.Entities.*;
import cs127.springappbe.Service.PGuestService;
import cs127.springappbe.Service.RoomService;
import cs127.springappbe.Service.SGuestService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Getter
@Setter
public class AddBookingRequest {

    @JsonProperty("primary_guest")
    private AddGuestRequest primaryGuest;

    @JsonProperty("guest_names")
    private List<AddGuestRequest> secondaryGuestList;

    @JsonProperty("booking_date")
    private String booking_date;

    @JsonProperty("check_in_date")
    private String checkin_date;

    @JsonProperty("check_out_date")
    private String checkout_date;

    @JsonProperty("rooms")
    private List<AddBookedRoomRequest> roomsToBeBooked;

    public BRN mapToBooking(PGuestService pGuestService, SGuestService sGuestService, RoomService roomService){

        Optional<PrimaryGuest> optionalPrimaryGuest = pGuestService.findPrimaryGuest(this.primaryGuest.getFirstName(), this.primaryGuest.getLastName(), Date.valueOf(this.primaryGuest.getBirthday()));
        PrimaryGuest primaryGuest;

        if(optionalPrimaryGuest.isEmpty()){
            primaryGuest = new PrimaryGuest(
                    this.primaryGuest.getFirstName(),
                    this.primaryGuest.getLastName(),
                    Date.valueOf(this.primaryGuest.getBirthday()),
                    this.primaryGuest.getAddress(),
                    this.primaryGuest.getContactNumber(),
                    this.primaryGuest.getEmailAddress()
            );
        }
        else{
            primaryGuest = optionalPrimaryGuest.get();
        }

        Optional<SecondaryGuest> optionalSecondaryGuest;
        SecondaryGuest secondaryGuest;

        List<BRN_SGUEST> guestList = new ArrayList<>();
        for(AddGuestRequest guest : secondaryGuestList){

            optionalSecondaryGuest = sGuestService.findSecondaryGuest(guest.getFirstName(), guest.getLastName(), Date.valueOf(guest.getBirthday()));

            if(optionalSecondaryGuest.isEmpty()){
                secondaryGuest = new SecondaryGuest(
                        guest.getFirstName(),
                        guest.getLastName(),
                        Date.valueOf(guest.getBirthday()),
                        guest.getAddress(),
                        guest.getContactNumber(),
                        guest.getEmailAddress()
                );
            }
            else{
                secondaryGuest = optionalSecondaryGuest.get();
            }

            BRN_SGUEST brnSguest = new BRN_SGUEST();
            brnSguest.setSecondaryGuest(secondaryGuest);
            guestList.add(brnSguest);
        }

        List<BookedRoom> bookedRooms = new ArrayList<>();
        for(AddBookedRoomRequest roomToBeBooked : roomsToBeBooked){

            Room room = roomService.findRoomByID(roomToBeBooked.getRoomId()).get();

            BookedRoom bookedRoom = new BookedRoom();
            bookedRoom.setRoom(room);
            bookedRooms.add(bookedRoom);

            roomService.toggleRoomAvailability(room.getRoomID());
        }

        BRN booking = new BRN();
        booking.setPrimaryGuest(primaryGuest);
        booking.setBooking_date(Date.valueOf(this.booking_date));
        booking.setCheckin_date(Date.valueOf(this.checkin_date));
        booking.setCheckout_date(Date.valueOf(this.checkout_date));
        booking.setGuests(guestList);
        booking.setBookedRooms(bookedRooms);


        // Set the BRN entity as the owner of the relationship
        for (BRN_SGUEST brnSguest : guestList) {
            brnSguest.setBrn(booking);
        }

        for (BookedRoom bookedRoom : bookedRooms) {
            bookedRoom.setBrn(booking);
        }

        primaryGuest.getBrns().add(booking);

        return booking;
    }

}
