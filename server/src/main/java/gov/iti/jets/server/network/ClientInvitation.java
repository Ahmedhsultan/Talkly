package gov.iti.jets.server.network;


import gov.iti.jets.common.dto.InvitationDto;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientInvitation extends Remote {

    void receiveInvitation(InvitationDto invitationDto) throws RemoteException;
}